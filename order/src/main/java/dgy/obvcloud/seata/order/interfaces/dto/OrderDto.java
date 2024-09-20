package dgy.obvcloud.seata.order.interfaces.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import dgy.obvcloud.seata.order.domain.entity.OrderTbl;
import lombok.Data;

/**
 * @Author: lwj
 * @Description: TODO
 * @Date: 2024/9/5 09:54
 * @Version: 1.0
 */
@Data
public class OrderDto {

    /**
     *
     */
    private Integer userId;

    /**
     *
     */
    private String commodityCode;

    /**
     *
     */
    private Integer count;

    /**
     *
     */
    private Integer money;



    public <T extends OrderDto> OrderTbl getDo(T dto){
        OrderTbl order = new OrderTbl();
        order.setCount(dto.getCount());
        order.setMoney(dto.getMoney());
        order.setCommodityCode(dto.getCommodityCode());
        order.setUserId(dto.getUserId());
        return order;
    }
}
