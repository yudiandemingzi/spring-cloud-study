package com.jincou.service.order.controller;


import com.jincou.service.order.service.ProduceOrderService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author xub
 * @Description: 订单服务相关接口
 * @date 2019/7/12 下午6:01
 */
@Slf4j
@RestController
@RequestMapping("api/v1/order")
public class OrderController {

    @Autowired
    private ProduceOrderService produceOrderService;

    //添加bean
    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * 当调用微服务出现异常会降级到saveOrderFail方法中
     */
    @RequestMapping("save")
    // @HystrixCommand(fallbackMethod = "saveOrderFail")
    public Object save(int userId, int productId, HttpServletRequest request) {

        return produceOrderService.save(userId, productId);
    }

    /**
     * @Description: 异常降级方法
     * <p>
     * 注意，方法签名一定要要和api方法一致
     * @author xub
     */
    private Object saveOrderFail(int userId, int productId, HttpServletRequest request) {
        //监控报警
        String saveOrderKye = "save-order";

        String sendValue = redisTemplate.opsForValue().get(saveOrderKye);
        final String ip = request.getRemoteAddr();

        // 新启动一个线程进行业务逻辑处理
        new Thread(() -> {
            if (StringUtils.isBlank(sendValue)) {
                System.out.println("紧急短信，用户下单失败，请离开查找原因,ip地址是=" + ip);
                //发送一个http请求，调用短信服务 TODO
                redisTemplate.opsForValue().set(saveOrderKye, "save-order-fail", 20, TimeUnit.SECONDS);

            } else {
                System.out.println("已经发送过短信，20秒内不重复发送");
            }

        }).start();

        Map<String, Object> msg = new HashMap<>();
        msg.put("code", -1);
        msg.put("msg", "抢购人数太多，您被挤出来了，稍等重试");
        return msg;
    }

}

