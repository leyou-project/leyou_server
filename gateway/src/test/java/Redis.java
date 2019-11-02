import redis.clients.jedis.Jedis;

/**
 * 作者：刘时明
 * 时间：2019/11/2-18:42
 * 作用：
 */

public class Redis
{
    public static void main(String[] args)
    {
        // 主从测试
//        Jedis master = new Jedis("192.168.66.146", 6379);
//        master.auth("123456");
//        master.set("name","lsm");
//
//        Jedis slave1 = new Jedis("192.168.66.146", 6380);
//        slave1.auth("123456");
//        String name=slave1.get("name");
//        System.out.println(name);

        // 往从库写会报错
        Jedis slave2 = new Jedis("192.168.66.146", 6381);
        slave2.auth("123456");
        slave2.set("age","22");
        System.out.println(slave2.get("age"));
    }
}
