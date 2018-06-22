package com.jedis;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisTest {

    @Test
    /**
     * jedis单实例操作
     */
    public void jtest() {
        Jedis jedis = new Jedis("119.29.115.175", 6379);
        jedis.set("host", "119.29.115.175");
        jedis.set("name", "Nidaye");
        String name = jedis.get("host");
        System.out.println(name);
        //释放资源
        jedis.close();
    }

    /**
     * 使用连接池的方式
     */
    @Test
    public void demo2() {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(30);//最大连接数
        config.setMaxIdle(10);//最大空闲连接数
        JedisPool jedisPool = new JedisPool(config, "119.29.115.175", 6379);
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.set("port", "6379");
            String prot = jedis.get("port");
            System.out.println(prot);
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            jedis.close();
            jedisPool.close();
        }

    }
}
