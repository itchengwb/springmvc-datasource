package org.bobo.mvc;

import org.bobo.util.RedisClient;
import redis.clients.jedis.Jedis;

/**
 * Created with IntelliJ IDEA.
 * User: wenbo.cheng
 * Date: 2015/7/24  0:12
 * Discribe: Template
 */
public class JedisTest {
    public static void main(String[] args){
        System.out.println("====");

       /*// JedisUtil jedisUtil = new JedisUtil();
        //jedisUtil.getJedis().set("aaa","bbbb");
       // String str = jedisUtil.getJedis().get("aaa");
        String str = JedisUtil.jedis.get("aaa");
        System.out.println(str);*/

        // JedisUtil jedisUtil = new JedisUtil();
        //jedisUtil.getJedis().set("aaa","bbbb");
        // String str = jedisUtil.getJedis().get("aaa");
        Jedis jedis  = RedisClient.jedis;
        jedis.set("aaa", "test");
        jedis.set("test", "testKey");
        //删除key=aaa的值
        jedis.del("aaa");

        String str =jedis .get("aaa");
        System.out.println(str);

        String str2 = jedis.get("test");
        System.out.println(str2);






        //删除所有数据
        jedis.flushAll();
        str2 = jedis.get("test");
        System.out.println(jedis.exists("test")+"==>"+str2);


    }
}
