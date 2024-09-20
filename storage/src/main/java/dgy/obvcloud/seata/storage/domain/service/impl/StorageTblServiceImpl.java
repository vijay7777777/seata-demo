package dgy.obvcloud.seata.storage.domain.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import dgy.obvcloud.seata.storage.domain.entity.StorageTbl;
import dgy.obvcloud.seata.storage.domain.service.StorageTblService;
import dgy.obvcloud.seata.storage.domain.mapper.StorageTblMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* @author liwenjie
* @description 针对表【storage_tbl】的数据库操作Service实现
* @createDate 2024-09-05 09:41:45
*/
@Service
public class StorageTblServiceImpl extends ServiceImpl<StorageTblMapper, StorageTbl>
    implements StorageTblService{



    @Override
    @Transactional
    public void deduct(String commodityCode, int count) {
        System.out.println("开始扣减库存");
        try {
            baseMapper.deduct(commodityCode, count);
        } catch (Exception e) {
            System.out.println("扣减库存失败，可能是库存不足！");
            throw new RuntimeException("扣减库存失败，可能是库存不足！", e);
        }
        System.out.println("扣减库存成功");
    }
}




