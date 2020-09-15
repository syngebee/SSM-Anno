package cn.itcast.controller;

import cn.itcast.service.BuyGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @Autowired
    private BuyGoodsService buyGoodsService;

    @GetMapping("/buy/{id}/{number}")
    public String buy(@PathVariable String id, @PathVariable String number){
        try {
            buyGoodsService.buy(id,number);
        } catch (Exception e) {
            return e.getMessage();
        }
        return "success";
    }
}
