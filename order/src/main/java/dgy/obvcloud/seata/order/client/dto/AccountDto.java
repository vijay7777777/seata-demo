package dgy.obvcloud.seata.order.client.dto;

import lombok.Data;

/**
 * @Author: lwj
 * @Description: TODO
 * @Date: 2024/9/18 09:47
 * @Version: 1.0
 */
@Data
public class AccountDto {


    @Data
    public static class deduct extends AccountDto {
        private String userId;
        private Integer money;
    }



    public static AccountDto.deduct getAccountDto(Integer userId, Integer money){
        AccountDto.deduct  dto = new AccountDto.deduct();
        dto.setUserId(String.valueOf(userId));
        dto.setMoney(money);
        return dto;
    }
}
