package dgy.obvcloud.seata.storage.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName storage_tbl
 */
@TableName(value ="storage_tbl")
@Data
public class StorageTbl implements Serializable {
    /**
     * 
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

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

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}