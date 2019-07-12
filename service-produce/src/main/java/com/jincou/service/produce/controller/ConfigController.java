package com.jincou.service.produce.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
  * @ClassName: ConfigController
  * @Description: 去配置中心读取配置信息
  * @author xub
  * @date 2019/7/12 下午12:31
  */
@Slf4j
@RestController
@RequestMapping("/api/v1/product")
public class ConfigController {


    /**
     * 配置中心读取数据
     */
    @Value("${item_url}")
    private String url;


    @RequestMapping("url")
    public void list(){
        log.info("去配置中心读取的url为={}", url);
    }
}
