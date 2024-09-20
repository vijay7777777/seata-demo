package dgy.obvcloud.seata.account.domain.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import dgy.obvcloud.seata.account.domain.entity.AccountTbl;
import dgy.obvcloud.seata.account.domain.service.AccountTblService;
import dgy.obvcloud.seata.account.domain.mapper.AccountTblMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* @author liwenjie
* @description 针对表【account_tbl】的数据库操作Service实现
* @createDate 2024-09-05 09:36:27
*/
@Service
public class AccountTblServiceImpl extends ServiceImpl<AccountTblMapper, AccountTbl>
    implements AccountTblService{

    @Override
    @Transactional
    public void deduct(String userId, int money) {
        System.out.println("开始扣减金额");
        try {
            baseMapper.deduct(userId, money);
        } catch (Exception e) {
            System.out.println("扣减金额失败，可能是金额不足！");
            throw new RuntimeException("扣减金额失败，可能是金额不足！", e);
        }
        System.out.println("扣减金额成功");
    }
}




