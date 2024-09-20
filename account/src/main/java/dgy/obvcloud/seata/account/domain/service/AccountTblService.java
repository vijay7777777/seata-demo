package dgy.obvcloud.seata.account.domain.service;

import dgy.obvcloud.seata.account.domain.entity.AccountTbl;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author liwenjie
* @description 针对表【account_tbl】的数据库操作Service
* @createDate 2024-09-05 09:36:27
*/
public interface AccountTblService extends IService<AccountTbl> {


    /**
     * 扣除存储数量
     */
    void deduct(String userId, int money);
}
