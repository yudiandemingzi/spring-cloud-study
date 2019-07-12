package com.jincou.service.order.fallbcak;


import com.jincou.service.order.client.ProduceClient;
import org.springframework.stereotype.Component;

/**
 * @Description:  针对商品服务，错降级处理
 *  如果 productlient 一处改成@FeignClient(name = "product-service",fallback = ProduceClientFallback.class) 那就会到这里来
 * @author xub
 * @date 2019/7/12 下午1:05
 */
@Component
public class ProduceClientFallback implements ProduceClient {

    @Override
    public String findById(int productId) {
  //      System.out.println("ProductClientFallback中的降级方法");
        //这对gai该接口进行一些逻辑降级处理........
        return null;
    }
}
