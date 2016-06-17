package com.app;

import java.lang.reflect.Method;
import java.util.Properties;

import com.app.demo.Demo;

public class Main {
	
	private static Properties p = new Properties();
	
	/**
	 * 参数长度大于等于2: 
	 * 第一个是类的别名，在配置文件class.properties
	 * 第二个是要执行的类的方法
	 * 第三个参数以后是执行的方法的参数，多个参数用
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		init();
		demo(args);
//		if (args.length >= 2) {
//			String cls = (String)p.get(args[0]);
//			if(cls != null){
//				Class c = Class.forName(cls);
//				Object d = c.newInstance();
//				Method m = c.getDeclaredMethod(args[1], String[].class);
//				m.invoke(d, new Object[]{args});
//			}else{
//				System.out.println("配置文件class.properties，没有配置对应的类");
//			}
//		} else {
//			System.out.println("Usage：请传入参数：\n第一个是类的别名，在配置文件class.properties;\n第二个是要执行的类的方法;\n第三个参数以后是执行的方法的参数，多个参数用");
//		}
	}
	
	public static void init() throws Exception{
		loadProperties();
	}
	
	private static void demo(String[] args) throws Exception {
		String cls = (String)p.get("Demo");
		if(cls != null){
			Class c = Class.forName(cls);
			Demo d = (Demo)c.newInstance();
			Method m = c.getDeclaredMethod("test", String[].class);
			// 参数为数组，需要用new Object[]{}包裹一层，否则报错：参数不匹配
			m.invoke(d, new Object[]{args});
		}else{
			System.out.println("配置文件class.properties，没有配置对应的类");
		}
	}
	
	public static void loadProperties() throws Exception{
		//加载配置文件
		p = new Properties();
		ClassLoader classLoader = Main.class.getClassLoader();
		p.load(classLoader.getResourceAsStream("class.properties"));
	}
	
}
