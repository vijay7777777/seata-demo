package dgy.obvcloud.seata.storage.interfaces.dto;

import lombok.Data;

/**
 * @Author: lwj
 * @Description: TODO
 * @Date: 2024/9/5 09:54
 * @Version: 1.0
 */
@Data
public class StorageDto {




    @Data
    public static class deduct{
        /**
         *商品编号
         */
        private String code;

        /**
         * 要扣减的数量
         */
        private Integer count;
    }
}
