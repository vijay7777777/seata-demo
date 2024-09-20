package dgy.obvcloud.seata.order.client;

import dgy.obvcloud.seata.order.client.dto.AccountDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@FeignClient(value = "account",url = "127.0.0.1:8001") //configuration = FeignConfig.class
public interface AccountClient {

    @PostMapping(value = "account/deduct",consumes = "application/json", produces = "application/json")
    void deduct(@RequestBody AccountDto.deduct deduct);
}
