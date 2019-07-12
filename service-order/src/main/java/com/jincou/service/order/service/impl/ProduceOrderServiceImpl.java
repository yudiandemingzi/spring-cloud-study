package com.jincou.service.order.service.impl;


import com.fasterxml.jackson.databind.JsonNode;
import com.jincou.service.order.model.ProduceOrder;
import com.jincou.service.order.client.ProduceClient;
import com.jincou.service.order.service.ProduceOrderService;
import com.jincou.service.order.untils.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Slf4j
@Service
public class ProduceOrderServiceImpl implements ProduceOrderService {

    @Autowired
    private ProduceClient produceClient;

    @Override
    public ProduceOrder save(int userId, int produceId) {

        //获取json格式的字符串数据
        String response = produceClient.findById(produceId);
        //Json字符串转换成JsonNode对象
        JsonNode jsonNode = JsonUtils.str2JsonNode(response);

        //将数据封装到订单实体中
        ProduceOrder produceOrder = new ProduceOrder();
        produceOrder.setCreateTime(new Date());
        produceOrder.setUserId(userId);
        produceOrder.setTradeNo(UUID.randomUUID().toString());
        //获取商品名称和商品价格
        produceOrder.setProduceName(jsonNode.get("produceName").toString());
        produceOrder.setPrice(Integer.parseInt(jsonNode.get("price").toString()));

        log.info("最终生成的订单信息为 = {}",produceOrder);
        return produceOrder;
    }
}
