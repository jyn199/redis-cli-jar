package com.app.redis;

import java.util.HashSet;
import java.util.Set;

import redis.clients.jedis.Jedis;

public class RedisHelper {
	private Jedis jedis; 
	public RedisHelper(Jedis jedis){
		this.jedis = jedis;
	}
	
	public void get(String[] args){
		if(args.length < 3){
			System.out.println("参数数量不对，获取redis中数据参数为：类名，方法，key");
		}else{
			System.out.println(jedis.get(args[2]));
		}
	}
	
	public void getSet(String[] args){
		if(args.length < 5){
			System.out.println("参数数量不对，获取redis中数据参数为：类名，方法，key，startOffset，endOffset");
		}else{
			System.out.println(jedis.zrange(args[2], Long.parseLong(args[3]), Long.parseLong(args[4])));
		}
	}
	
	public void keys(String[] args){
		Set<String> keys = new HashSet<String>();
		if(args.length < 3){
			System.out.println("参数数量不对，获取redis中数据参数为：类名，方法，key");
			keys = jedis.keys("*");
		}else{
			keys = jedis.keys(args[2]);
		}
		for(String key : keys){
			System.out.println(key);
		}
	}
	
	public void del(String[] args){
		if(args.length < 3){
			System.out.println("参数数量不对，获取redis中数据参数为：类名，方法，key");
		}else{
			System.out.println(jedis.del(args[2]));
		}
	}
}
