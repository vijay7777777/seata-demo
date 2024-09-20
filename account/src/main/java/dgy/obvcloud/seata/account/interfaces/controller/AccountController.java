package dgy.obvcloud.seata.account.interfaces.controller;

import dgy.obvcloud.seata.account.domain.service.AccountTCCService;
import dgy.obvcloud.seata.account.domain.service.AccountTblService;
import dgy.obvcloud.seata.account.interfaces.dto.AccountDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: lwj
 * @Description: TODO
 * @Date: 2024/9/5 09:38
 * @Version: 1.0
 */
@RestController
@RequestMapping("account")
public class AccountController {

    /**
     * tcc
     */
    private final AccountTCCService accountTCCService;

    private final AccountTblService accountTblService;

    public AccountController(AccountTblService accountTblService, AccountTCCService tccService) {
        this.accountTCCService = tccService;
        this.accountTblService = accountTblService;
    }


    /**
     * 减金额
     * @param dto
     * @return
     */
    @PostMapping("deduct")
    public ResponseEntity<Void> deduct(@RequestBody AccountDto.deduct dto) {
        accountTCCService.deduct(dto.getUserId(), dto.getMoney());
        return ResponseEntity.noContent().build();
    }
}
