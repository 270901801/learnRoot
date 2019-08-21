package redis;

import redis.clients.jedis.Jedis;

/**
 * @author hsc
 * @date 2019/8/9 - 13:10
 */
public class RedisJava {
    public static void main(String[] args) {
        for(int a = 0; a<20; a++){
            Jedis jedis = RedisUtil.getJedis();
            jedis.set("aa", "aa");

            // 释放实例, 如不释放超最大实例数会报错
            RedisUtil.returnResource(jedis);

            System.out.println(jedis.get("aa"));
        }
//        //连接本地的 Redis 服务
//        Jedis jedis = new Jedis("192.168.124.33",6379);
//        System.out.println("连接成功");
//        //查看服务是否运行
//        System.out.println("服务正在运行: "+jedis.ping());
    }

}
