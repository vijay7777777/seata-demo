package dgy.obvcloud.seata.order.domain.service;

import dgy.obvcloud.seata.order.domain.entity.OrderTbl;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author liwenjie
* @description 针对表【order_tbl】的数据库操作Service
* @createDate 2024-09-05 09:41:04
*/
public interface OrderTblService extends IService<OrderTbl> {


    Long create(OrderTbl orderTbl);
}
