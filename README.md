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





配置eureka集群，修改本地host
##################SpringCloud####### C:\Windows\System32\Drivers\etc 下的host文件
127.0.0.1       eureka7001.com
127.0.0.1       eureka7002.com
127.0.0.1       eureka7003.com
127.0.0.1       config-3344.com