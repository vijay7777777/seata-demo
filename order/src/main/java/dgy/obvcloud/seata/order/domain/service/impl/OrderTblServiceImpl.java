package dgy.obvcloud.seata.order.domain.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
//import dgy.obvcloud.exception.FailException;
import dgy.obvcloud.seata.order.client.AccountClient;
import dgy.obvcloud.seata.order.client.StorageClient;
import dgy.obvcloud.seata.order.client.dto.AccountDto;
import dgy.obvcloud.seata.order.client.dto.StorageDto;
import dgy.obvcloud.seata.order.domain.entity.OrderTbl;
import dgy.obvcloud.seata.order.domain.service.OrderTblService;
import dgy.obvcloud.seata.order.domain.mapper.OrderTblMapper;
//import feign.FeignException;
import feign.FeignException;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import jakarta.servlet.ServletException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

/**
* @author liwenjie
* @description 针对表【order_tbl】的数据库操作Service实现
* @createDate 2024-09-05 09:41:04
*/
@Service
public class OrderTblServiceImpl extends ServiceImpl<OrderTblMapper, OrderTbl>
    implements OrderTblService{

    @Resource
    private final AccountClient accountClient;
    @Resource
    private final StorageClient storageClient;

    @Autowired
    public OrderTblServiceImpl(AccountClient accountClient, StorageClient storageClient) {
        this.accountClient = accountClient;
        this.storageClient = storageClient;
    }

    @Override
    @GlobalTransactional
    public Long create(OrderTbl orderTbl) {
        System.out.println("purchase begin ... xid: " + RootContext.getXID());
        baseMapper.insert(orderTbl);
        try {
            AccountDto.deduct accountDto = AccountDto.getAccountDto(orderTbl.getUserId(), orderTbl.getMoney());
            // 扣用户余额
            accountClient.deduct(accountDto);

            StorageDto.deduct storage = StorageDto.getAccountDto(orderTbl.getCommodityCode(), orderTbl.getCount());
            // 扣库存
            storageClient.deduct(storage);
        } catch (FeignException e) {
            throw new RuntimeException(e.contentUTF8(), e);
        }
        return orderTbl.getId();
    }
}




