package dgy.obvcloud.seata.order.domain.mapper;

import dgy.obvcloud.seata.order.domain.entity.OrderTbl;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author liwenjie
* @description 针对表【order_tbl】的数据库操作Mapper
* @createDate 2024-09-05 09:41:04
* @Entity dgy.obvcloud.seata.order.domain.entity.OrderTbl
*/
@Mapper
public interface OrderTblMapper extends BaseMapper<OrderTbl> {

}




