package dgy.obvcloud.seata.account.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName account_freeze_tbl
 */
@TableName(value ="account_freeze_tbl")
@Data
public class AccountFreezeTbl implements Serializable {
    /**
     * 
     */
    @TableId(value = "xid")
    private String xid;

    /**
     * 
     */
    @TableField(value = "user_id")
    private String userId;

    /**
     * 
     */
    @TableField(value = "freeze_money")
    private Integer freezeMoney;

    /**
     * 事务状态，0:try，1:confirm，2:cancel
     */
    @TableField(value = "state")
    private Integer state;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;


    /**
     * 状态
     */
    public static abstract class State {
        public final static int TRY = 0;
        public final static int CONFIRM = 1;
        public final static int CANCEL = 2;
    }
}