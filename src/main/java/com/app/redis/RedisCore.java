package com.app.redis;

import java.util.Properties;

import redis.clients.jedis.Jedis;

import com.app.Main;

public class RedisCore {
	private Jedis jedis; 
	private RedisHelper redisHelper; 
	
	private Properties p = new Properties();
	public void loadProperties() throws Exception{
		//加载配置文件
		p = new Properties();
		ClassLoader classLoader = Main.class.getClassLoader();
		p.load(classLoader.getResourceAsStream("redis.properties"));
	}
	
	public RedisCore() throws Exception{
		loadProperties();
		jedis = new Jedis(p.getProperty("redis1_host"), Integer.valueOf(p.getProperty("redis1_port")));
		jedis.auth(p.getProperty("redis1_auth"));
		redisHelper = new RedisHelper(jedis);
	}

	public void get(String[] args){
		redisHelper.get(args);
	}
	
	public void setnx(String[] args){
		redisHelper.setnx(args);
	}
	
	public void set(String[] args){
		redisHelper.set(args);
	}
	
	public void getSet(String[] args){
		redisHelper.getSet(args);
	}
	
	public void keys(String[] args){
		redisHelper.keys(args);
	}
	
	public void del(String[] args){
		redisHelper.del(args);
	}
	
	public void dels(String[] args){
		redisHelper.dels(args);
	}
	
}
