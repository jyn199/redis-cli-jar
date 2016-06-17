package com.app.demo;

import java.util.Properties;

import com.app.Main;

public class Demo {
	public void test(String[] args){
		System.out.println(args);
		System.out.println("demo");
	}
	
	private Properties p = new Properties();
	public void loadProperties() throws Exception{
		//加载配置文件
		p = new Properties();
		ClassLoader classLoader = Main.class.getClassLoader();
		p.load(classLoader.getResourceAsStream("redis.properties"));
		System.out.println(p.get("redis1_host"));
	}
	
	public Demo() throws Exception{
		loadProperties();
	}
}
