package dgy.obvcloud.seata.account.domain.service.impl;


import dgy.obvcloud.seata.account.domain.entity.AccountFreezeTbl;
import dgy.obvcloud.seata.account.domain.mapper.AccountFreezeTblMapper;
import dgy.obvcloud.seata.account.domain.mapper.AccountTblMapper;
import dgy.obvcloud.seata.account.domain.service.AccountTCCService;
import io.seata.core.context.RootContext;
import io.seata.rm.tcc.api.BusinessActionContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
@Slf4j
public class AccountTCCServiceImpl implements AccountTCCService {

    @Autowired
    private AccountTblMapper accountMapper;
    /**
     * 冻结
     */
    @Autowired
    private AccountFreezeTblMapper freezeMapper;

    @Override
    @Transactional
    public void deduct(String userId, int money) {
        String xid = RootContext.getXID();
        // freeze中是否有冻结记录，如果有cancel 已执行过
        AccountFreezeTbl freezeOld = freezeMapper.selectById(xid);
        if (Objects.nonNull(freezeOld)) {
            return;
        }
        // 1.扣减可用余额
        accountMapper.deduct(userId, money);
        // 2.记录冻结金额，事务状态
        AccountFreezeTbl freeze = new AccountFreezeTbl();
        freeze.setUserId(userId);
        // 冻结金额
        freeze.setFreezeMoney(money);
        freeze.setState(AccountFreezeTbl.State.TRY);
        // 事务ID
        freeze.setXid(xid);
        freezeMapper.insert(freeze);
    }

    @Override
    public boolean confirm(BusinessActionContext ctx) {
        // 2.根据id删除冻结记录
        int count = freezeMapper.deleteById(ctx.getXid());
        return count == 1;
    }


    @Override
    public boolean cancel(BusinessActionContext ctx) {
        // 0.查询冻结记录
        String xid = ctx.getXid();
        AccountFreezeTbl freeze = freezeMapper.selectById(xid);
        Object userId = ctx.getActionContext("userId");
        if (Objects.isNull(freeze)) {
            // try 没有执行需要空回滚
            freeze = new AccountFreezeTbl();
            // 用户id
            freeze.setUserId(String.valueOf(userId));
            // 冻结金额
            freeze.setFreezeMoney(0);
            freeze.setState(AccountFreezeTbl.State.CANCEL);
            return true;
        }
        // 幂等
        if (freeze.getState().equals(AccountFreezeTbl.State.CANCEL)) {
            // 已经执行过 无需执行
            return true;
        }
        // 1.恢复可用余额
        accountMapper.refund(freeze.getUserId(), freeze.getFreezeMoney());
        // 2.将冻结金额清零，状态改为CANCEL
        freeze.setFreezeMoney(0);
        freeze.setState(AccountFreezeTbl.State.CANCEL);
        int count = freezeMapper.updateById(freeze);
        return count == 1;
    }
}
