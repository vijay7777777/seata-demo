package dgy.obvcloud.seata.order.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName order_tbl
 */
@TableName(value ="order_tbl")
@Data
public class OrderTbl implements Serializable {
    /**
     * 
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 
     */
    @TableField(value = "user_id")
    private Integer userId;

    /**
     * 
     */
    @TableField(value = "commodity_code")
    private String commodityCode;

    /**
     * 
     */
    @TableField(value = "count")
    private Integer count;

    /**
     * 
     */
    @TableField(value = "money")
    private Integer money;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}