package com.jincou.service.produce.controller;


import com.alibaba.fastjson.JSON;
import com.jincou.service.produce.service.ProduceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * @Description: 商品服务对外提供接口
 *
 * @author xub
 * @date 2019/7/12 下午12:43
 */
@RestController
@RequestMapping("/api/v1/produce")
public class ProduceController {

    @Autowired
    private ProduceService produceService;

    /**
     * 获取所有商品列表
     * @return
     */
    @RequestMapping("list")
    public Object list(){
        return produceService.listProduce();
    }

    /**
     * t
     * @return
     */
    @GetMapping("/find")
   public String findById(@RequestParam(value = "produceId") int produceId){
        return JSON.toJSONString(produceService.findById(produceId));

    }

}
