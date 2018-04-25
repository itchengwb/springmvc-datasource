package org.bobo.util;

import org.apache.commons.pool.impl.GenericObjectPool;
import org.springframework.util.StringUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Created with IntelliJ IDEA.
 * User: wenbo.cheng
 * Date: 2015/7/23  19:32
 * Discribe: 
 * Jedis工具类, 通过JedisUtil.getInstance()获取实例。
 * <br>getJedis()取得Jedis实例，用完后要通过releasJedis()释放.
 *
 */
public class JedisUtil {

    /**
     * redis服务器地址
     */
    private static String redisServerHost ="127.0.0.1";
    private static int redisServerPort =6379;;
    private static String redisServerPassword;
    private static int redisServerTimeout;
    /**
     * 最大连接数
     */
    public static final int CONFIG_MAX_ACTIVE = 50;

    /**
     * 最大空闲连接数，-1 表示无限制
     */
    public static final int CONFIG_MAX_IDLE = -1;

    /**
     * 取一个连接的最长阻塞时间, milliseconds. 此处设置为10秒
     */
    public static final int CONFIG_MAX_WAITE_MILLISECOND = 10 * 1000; // 10 seconds.

    /**
     * 连接池达到最大连接数后取连接的行为:此处为阻塞等待，直到有连接返回，或达到最大阻塞时间返回失败
     */
    public static final byte CONFIG_EXHAUSTED_ACTION = GenericObjectPool.WHEN_EXHAUSTED_BLOCK;

    private static JedisPoolConfig config;
    private static JedisPool pool;
    public static Jedis jedis;

    /**
     * 私有构造器
     */
    private JedisUtil() {

    }

    /**
     * 私有构造器，初始化连接池
     *
     */
    static  {
        config = new JedisPoolConfig();
        config.setMaxActive(CONFIG_MAX_ACTIVE);
        config.setMaxIdle(CONFIG_MAX_IDLE);
        config.setMaxWait(CONFIG_MAX_WAITE_MILLISECOND);
        config.setWhenExhaustedAction(CONFIG_EXHAUSTED_ACTION);
        if(redisServerHost != null && redisServerPassword != null){
            pool = new JedisPool(config, redisServerHost,redisServerPort,redisServerTimeout, redisServerPassword);
        }
    }

    /**
     * 从连接池中获取Jedis
     * @return
     */
     static {

        if(pool == null){
            pool = new JedisPool(config, redisServerHost,redisServerPort,redisServerTimeout, redisServerPassword);
        }
        jedis = pool.getResource();
    }

    /**
     * 释放Jedis回连接池
     * @param jedis
     */
    public void releaseJedis(Jedis jedis) {
        if (jedis != null) {
            if(pool == null){
                pool = new JedisPool(config, redisServerHost,redisServerPort,redisServerTimeout, redisServerPassword);
            }
            pool.returnResource(jedis);
        }
    }

    public String getRedisServerHost() {
        return redisServerHost;
    }

    public void setRedisServerHost(String redisServerHost) {
        this.redisServerHost = redisServerHost;
    }

    public int getRedisServerPort() {
        return redisServerPort;
    }

    public void setRedisServerPort(int redisServerPort) {
        this.redisServerPort = redisServerPort;
    }

    public String getRedisServerPassword() {
        return redisServerPassword;
    }

    public void setRedisServerPassword(String redisServerPassword) {
        this.redisServerPassword = redisServerPassword;
    }

    public int getRedisServerTimeout() {
        return redisServerTimeout;
    }

    public void setRedisServerTimeout(int redisServerTimeout) {
        this.redisServerTimeout = redisServerTimeout;
    }

    public boolean setValue(String key,String value){

        boolean flag = false;
        String string = jedis.set(key,value);
        if(!StringUtils.isEmpty(string)){
            flag = true;
        }
        return flag;
    }

}


