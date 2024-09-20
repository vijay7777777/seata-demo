package dgy.obvcloud.seata.storage.domain.mapper;

import dgy.obvcloud.seata.storage.domain.entity.StorageTbl;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
* @author liwenjie
* @description 针对表【storage_tbl】的数据库操作Mapper
* @createDate 2024-09-05 09:41:45
* @Entity dgy.obvcloud.seata.storage.domain.entity.StorageTbl
*/
@Mapper
public interface StorageTblMapper extends BaseMapper<StorageTbl> {

    @Update("update storage_tbl set `count` = `count` - #{count} where commodity_code = #{code}")
    int deduct(@Param("code") String commodityCode, @Param("count") int count);
}




