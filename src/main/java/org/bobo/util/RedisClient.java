package org.bobo.util;

import com.alibaba.fastjson.JSON;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.ResourceBundle;

/**
 * Created with IntelliJ IDEA.
 * User: wenbo.cheng
 * Date: 2015/7/24  11:04
 * Discribe: Template
 */
public class RedisClient {

    public static JedisPool jedisPool; // 池化管理jedis链接池
    public static Jedis jedis = null;

    static {

        //读取相关的配置
        ResourceBundle resourceBundle = ResourceBundle.getBundle("redis");
        /*int maxActive = Integer.parseInt(resourceBundle.getString("redis.pool.maxActive"));
        int maxIdle = Integer.parseInt(resourceBundle.getString("redis.pool.maxIdle"));
        int maxWait = Integer.parseInt(resourceBundle.getString("redis.pool.maxWait"));*/

        String ip = resourceBundle.getString("redis.server.host");
        int port = Integer.parseInt(resourceBundle.getString("redis.server.port"));

        JedisPoolConfig config = new JedisPoolConfig();

        //设置最大连接数
        //config.setMaxTotal(maxActive);
        //设置最大空闲数
        //config.setMaxIdle(maxIdle);
        //设置超时时间
        //config.setMaxWaitMillis(maxWait);

        //初始化连接池
        jedisPool = new JedisPool(config, ip, port);

        try {
            jedis = jedisPool.getResource();
        } catch (Exception e) {
            e.printStackTrace();
            //增加日志输出
        }finally{
            jedisPool.returnResource(jedis);
        }

    }

    /**
     * 向缓存中设置字符串内容
     * @param key key
     * @param value value
     * @return
     * @throws Exception
     */
    public static boolean  set(String key,String value) throws Exception{

        try {
            jedis.set(key, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 向缓存中设置对象
     * @param key
     * @param value
     * @return
     */
    public static boolean  set(String key,Object value){
        try {
            String objectJson = JSON.toJSONString(value);
            jedis.set(key, objectJson);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 删除缓存中得对象，根据key
     * @param key
     * @return
     */
    public static boolean del(String key){
        try {
            jedis.del(key);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 根据key 获取内容
     * @param key
     * @return
     */
    public static Object get(String key){
        try {
            Object value = jedis.get(key);
            return value;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    /**
     * 根据key 获取对象
     * @param key
     * @return
     */
    public static <T> T get(String key,Class<T> clazz){
        try {
            String value = jedis.get(key);
            return JSON.parseObject(value, clazz);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


}