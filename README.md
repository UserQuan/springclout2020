# springclout2020
springcloud练习搭建

1 搭建支付模块8001
2 搭建订单模块80
3 搭建eureka注册中心 7001
4 整合重构 commons通用模块
5 搭建eureka集群 7002
6 搭建服务提供者支付payment集群
7 搭建payment zk提供者，zk是临时借点，服务提供者一段时间没法连接，zk会保留短暂时间后移除
8 搭建consumer zk消费者
9 搭建consul 提供者和消费者
小结: eureka AP zookeeper CP  consul CP  
10 hystrix服务降级，消费方和提供方，单个方法降级和全局降级 熔断
11 HystrixDashboard图形化监控页面 http://localhost:9001/hystrix  http://localhost:8001/hystrix.stream
12 gateway 动态路由配置，predicate,GlobalFilter全局过滤器
13 config配置中心3344，通过GitHub获取
14 config客户端搭建，通过3344config center中心调用github,但是客户端不支持动态刷新
15 config客户端，手动版动态获取，添加配置后，如果修改配置，需要刷新配置客户端 curl -X POST "http://localhost:3355/actuator/refresh"
16 bus消息总线配合config，实现广播刷新，修改GitHub，然后post http://localhost:3344/actuator/bus-refresh刷新3344服务中心，然后广播3355 3366 统一刷新，不用像上面手动挨个刷新
17 bus消息定点通知，比如只通知3355 http://localhost:3344/actuator/bus-refresh/config-client:3355
18 stream 消息驱动，整合多种消息中间件在系统中，搭建stream提供者和消费者，通过stream发送消息到MQ和通过stream消费消息
19 stream 分组，持久化 通过group: quanA实现多个队列分为一个组，避免重复消费
20 sleuth需要配合zipkin使用，下面docker搭建zipkin,sleuth负责监控，整理，zipkin负责展现
    docker pull openzipkin/zipkin; 
    docker run -d --restart always -p 9411:9411 --name zipkin openzipkin/zipkin ;
    http://ip:9411/zipkin/
    cunsumer80和provider8001 sleuth配置
######################  SpingCloud Alibaba start   ###########################
21 nacos
    docker 搭建nacos服务
    nacos 服务提供者9001，9002搭建  
    可选，不想搭建9002情况下，在9001基础上copy configuration快速搭建一个虚拟映射服务，添加 -DServer.port=9011 参数，  
22 nacos 服务消费者83
23  nacos config配置中心3377
    nacos分组配置 dataid group namespace




配置eureka集群，修改本地host
##################SpringCloud####### C:\Windows\System32\Drivers\etc 下的host文件
127.0.0.1       eureka7001.com
127.0.0.1       eureka7002.com
127.0.0.1       eureka7003.com
127.0.0.1       config-3344.com


######docker  环境搭建
#### rabbitmq
docker pull  rabbitmq:3.8.7-management
docker run -d -p 5672:5672 -p 15672:15672 --name rabbitmq rabbitmq:3.8.7-management
http://localhost:15672/  guest guest
#### rabbitmq