package com.hrt.test;
import redis.clients.jedis.Jedis;

import redis.clients.jedis.exceptions.JedisConnectionException;
 
public class App {
    public static void main(String[] args) {
        //连接本地的 Redis 服务
    	
    	try {
        Jedis jedis = new Jedis("10.0.53.60", 6379);
        
        System.out.println("连接成功");
        System.out.println("服务正在运行: " + jedis.ping());
        jedis.set( "jaydar", "kazak");
        }catch (JedisConnectionException e)
    	{
    		System.out.println("the error is " +  e.getMessage() + " " + " error  is  " + e.getLocalizedMessage());
    	}
    }
}