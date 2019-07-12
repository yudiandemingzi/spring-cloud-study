# SpringCloud学习项目

有关该SpringCloud前面写了几篇博客作为该项目的详细说明。

1、[SpringCloud(2)---SpringCloud入门篇](https://www.cnblogs.com/qdhxhz/p/9357357.html)

2、[SpringCloud(3)---Eureka服务注册与发现](https://www.cnblogs.com/qdhxhz/p/9357502.html)

3、[SpringCloud(4)---Ribbon服务调用，源码分析](https://www.cnblogs.com/qdhxhz/p/9568481.html)

4、[SpringCloud(5)---Feign服务调用](https://www.cnblogs.com/qdhxhz/p/9571600.html)

5、[SpringCloud(6)---熔断降级理解、Hystrix实战](https://www.cnblogs.com/qdhxhz/p/9581440.html)

6、[SpringCloud(7)---网关概念、Zuul项目搭建](https://www.cnblogs.com/qdhxhz/p/9594521.html)

7、[SpringCloud(8)---zuul权限校验、接口限流](https://www.cnblogs.com/qdhxhz/p/9601170.html)

8、[SpringCloud(9)---mysql实现配置中心](https://www.cnblogs.com/qdhxhz/p/9624386.html)



## 一、项目概述

#### 1、技术架构

项目总体技术选型

```
SpringBoot2.0.4 + Maven3.5.4 +spring-cloud（Finchley.RELEASE）+ mysql + Redis3.5.4 + lombok(插件)
```

#### 2、项目整体结构

```makefile
eureka          # 注册中心
config-service  # 配置中心服务
zuul-service    # 网关服务
service-produce # 商品服务
service-order   # 订单服务
```

项目的启动顺序 最好也安装上面的顺序启动。

#### 3、测试

输入：**localhost:7001**  如果上面服务都出现那恭喜你 启动成功！

![](https://img2018.cnblogs.com/blog/1090617/201907/1090617-20190712190945077-771945780.png)

<br>

