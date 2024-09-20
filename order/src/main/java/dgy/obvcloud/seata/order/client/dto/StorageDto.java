package dgy.obvcloud.seata.order.client.dto;

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

    public static StorageDto.deduct getAccountDto(String code, Integer count){
        StorageDto.deduct  dto = new StorageDto.deduct();
        dto.setCode(String.valueOf(code));
        dto.setCount(count);
        return dto;
    }
}

