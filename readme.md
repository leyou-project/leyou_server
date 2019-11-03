## 乐优商城架构

**模块**：\
购物车 cart \
文件服务 fileserver \
商品 goods \
即使通讯 im \
订单 order \
搜索 search \
用户 user

mysql -> 数据持久化 \
redis -> 缓存中间件、秒杀 \
MQ -> 服务异步通信，调用、发布订阅 \
ES -> 数据检索 \
MongoDB -> 文件存储 

**环境搭建**
安装jdk：sudo yum install java-1.8.0-openjdk.x86_64

**ZK安装pull**
docker pull zookeeper:3.4.12

**ES pull：**
docker pull docker.elastic.co/elasticsearch/elasticsearch:6.3.2 \
**ES管理界面 pull：**
docker pull mobz/elasticsearch-head:5

**Mysql pull：**
docker pull mysql:5.7.13

**Redis pull：**
docker pull redis

**MQ pull**
docker pull rabbitmq-management

