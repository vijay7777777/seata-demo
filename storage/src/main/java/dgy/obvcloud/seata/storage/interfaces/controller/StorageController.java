package dgy.obvcloud.seata.storage.interfaces.controller;

import dgy.obvcloud.seata.storage.domain.entity.StorageTbl;
import dgy.obvcloud.seata.storage.domain.service.StorageTblService;
import dgy.obvcloud.seata.storage.interfaces.dto.StorageDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: lwj
 * @Description: TODO
 * @Date: 2024/9/5 09:43
 * @Version: 1.0
 */
@RestController
@RequestMapping("storage")
public class StorageController {

    private final StorageTblService storageTblService;


    public StorageController(StorageTblService storageTblService) {
        this.storageTblService = storageTblService;
    }


    /**
     * 扣减库存
     *
     * @param dto
     * @return
     */
    @PostMapping("deduct")
    public ResponseEntity<Void> deduct(@RequestBody StorageDto.deduct dto) {
        storageTblService.deduct(dto.getCode(), dto.getCount());
        return ResponseEntity.noContent().build();
    }
}
