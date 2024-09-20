package dgy.obvcloud.seata.order.client;

import dgy.obvcloud.seata.order.client.dto.StorageDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@FeignClient(value = "storage",url = "127.0.0.1:8003")
public interface StorageClient {
    @PostMapping(value = "/storage/deduct",consumes = "application/json", produces = "application/json")
    void deduct(@RequestBody StorageDto.deduct deduct);
}
