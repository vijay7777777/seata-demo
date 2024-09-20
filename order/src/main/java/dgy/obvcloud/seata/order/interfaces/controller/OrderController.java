package dgy.obvcloud.seata.order.interfaces.controller;

import dgy.obvcloud.seata.order.domain.service.OrderTblService;
import dgy.obvcloud.seata.order.interfaces.dto.OrderDto;
//import dgy.obvcloud.utils.Result;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: lwj
 * @Description: TODO
 * @Date: 2024/9/5 09:42
 * @Version: 1.0
 */
@RestController
@RequestMapping("order")
public class OrderController {

    private final OrderTblService orderTblService;

    public OrderController(OrderTblService orderTblService) {
        this.orderTblService = orderTblService;
    }



    @RequestMapping("create")
    public ResponseEntity<Long> createOrder(@RequestBody OrderDto dto){
        Long l = orderTblService.create(dto.getDo(dto));
        return ResponseEntity.status(HttpStatus.CREATED).body(l);
//        try {
//            Long l = orderTblService.create(dto.getDo(dto));
//            return Result.ok(new HashMap<String,Long>(){
//                {put("order_id",l);}
//            });
//        }catch (Exception e){
//            throw new FailException("添加订单失败");
//        }
    }
}
