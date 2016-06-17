package com.app;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class AppTest {
	@BeforeClass
	public static void init(){
		System.out.println("@BeforeClass");
	}
	@AfterClass
	public static void destory(){
		System.out.println("@AfterClass");
	}
	@Before
	public void before(){
		System.out.println("@Before");
	}
	@After
	public void after(){
		System.out.println("@After");
	}
	@Test
	public void test(){
		System.out.println("@Test");
	}
	@Test
	public void test1(){
		System.out.println("@Test111");
	}
}
