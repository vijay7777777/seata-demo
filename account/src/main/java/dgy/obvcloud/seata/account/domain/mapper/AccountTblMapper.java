package dgy.obvcloud.seata.account.domain.mapper;

import dgy.obvcloud.seata.account.domain.entity.AccountTbl;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
* @author liwenjie
* @description 针对表【account_tbl】的数据库操作Mapper
* @createDate 2024-09-05 09:36:27
* @Entity dgy.obvcloud.seata.account.domain.entity.AccountTbl
*/
@Mapper
public interface AccountTblMapper extends BaseMapper<AccountTbl> {

    @Update("update account_tbl set money = money - ${money} where user_id = #{userId}")
    int deduct(@Param("userId") String userId, @Param("money") int money);

    @Update("update account_tbl set money = money + ${money} where user_id = #{userId}")
    int refund(@Param("userId") String userId, @Param("money") int money);
}




