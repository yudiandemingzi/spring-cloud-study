package com.jincou.service.produce.service.impl;



import com.jincou.service.produce.model.Produce;
import com.jincou.service.produce.service.ProduceService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProduceServiceImpl implements ProduceService {

    private static final Map<Integer, Produce> daoMap = new HashMap<>();

    /**
     * 模拟数据库商品数据
     */
    static {
        Produce p1 = new Produce(1, "苹果X", 9999, 10);
        Produce p2 = new Produce(2, "冰箱", 5342, 19);
        Produce p3 = new Produce(3, "洗衣机", 523, 90);
        Produce p4 = new Produce(4, "电话", 64345, 150);
        daoMap.put(p1.getProduceId(), p1);
        daoMap.put(p2.getProduceId(), p2);
        daoMap.put(p3.getProduceId(), p3);
        daoMap.put(p4.getProduceId(), p4);
    }


    @Override
    public List<Produce> listProduce() {
        Collection<Produce> collection = daoMap.values();
        List<Produce> list = new ArrayList<>(collection);
        return list;
    }

    @Override
    public Produce findById(int id) {
        return daoMap.get(id);
    }
}
