package dgy.obvcloud.seata.storage.domain.service;

import dgy.obvcloud.seata.storage.domain.entity.StorageTbl;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author liwenjie
* @description 针对表【storage_tbl】的数据库操作Service
* @createDate 2024-09-05 09:41:45
*/
public interface StorageTblService extends IService<StorageTbl> {

    /**
     * 扣除存储数量
     */
    void deduct(String commodityCode, int count);
}
