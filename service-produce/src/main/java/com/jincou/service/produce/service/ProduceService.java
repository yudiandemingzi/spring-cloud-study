package com.jincou.service.produce.service;


import com.jincou.service.produce.model.Produce;

import java.util.List;

/**
  * @ClassName: ProduceService
  * @Description:  获取商品信息相关接口
  * @author xub
  * @date 2019/7/12 下午12:37
  */
public interface ProduceService {

    /**
      * @Description: 查找所有商品
      * @author xub
      */
    List<Produce> listProduce();


    /**
     *  根据商品ID查找商品
     */
    Produce findById(int produceId);
}
