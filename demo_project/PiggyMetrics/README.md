# Piggy Metrics

  开源电子账单项目，使用 spring cloud，用来在 compass 上部署测试用。
  
[Original Readme](original_readme.md)

## 项目结构

* 4个微服务，使用了4个 mongodb 做存储
* 1个消息总线 `rabbitmq`
* 1个配置中心
* 1个网关
* 1个注册中心
* 1个监控中心

可以在 compass 平台上，部署**13**个应用

## 编译 && 推送

* 修改 Makefile, 更改 image 的地址
* `make` 使用 maven 编译项目，然后打包成镜像
* `make push` 推送镜像到镜像仓库

## 如何在 compass 上部署

可以参考 [docker-compose.yml](docker-compose.yml), 配置服务名、端口参照、各个应用的环境变量。

以 `auth-service` 为例：

* image 为编译出的镜像，如 `cargo.caicloudprivatetest.com/qatest/pig-auth-service:v2.0`
* 服务名为 `auth-service`
* 服务的端口为 `5000`
* 各个环境变量，应该与 mongodb，其他服务的环境变量相同，如：

    ```bash
    CONFIG_SERVICE_PASSWORD=123456
    NOTIFICATION_SERVICE_PASSWORD=123456
    STATISTICS_SERVICE_PASSWORD=123456
    ACCOUNT_SERVICE_PASSWORD=123456
    MONGODB_PASSWORD=mogo123
    ```
* 因为代码里 java 的 Xmx 为 200m , 微服务内存 request 建议 256MiB

## 如何访问

* 程序入口 - `gateway`
* 注册中心 - `registry`
* 消息总线 - `rabbitmq` 15672 端口
* 微服务监控 
    - 页面`monitoring` 8989, 地址: {host}:{port}/hystrix
    - 监控 url `monitoring` 8080, 在页面中输入 {host}:{port}/turbine.stream 

## 踩过的一些坑

* 微服务先去服务中心获取配置，所以必须要启动 config, 才能启动别的服务
* 代码里, config 的客户端没有配置 watch, 不能监控 config 的变化
* java 项目，启动很慢，微服务是否正常，可以看注册中心中，服务有没有注册上来

## TODO

* mongodb 用数据卷持久化
* 用脚本模拟不断有操作，可以用来做稳定性测试
* 多副本的高可用
* 流水线构建，及应用升级
