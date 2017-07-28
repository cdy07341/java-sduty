package com.chendy.reflection;

import java.lang.reflect.Method;

public class Demo06 {
	public static void main(String[] args) {
		test01();
		test02();
		test03();
	}
	
	public static void test01() {
		User u = new User();
		long startTime = System.currentTimeMillis();
		
		for (int i = 0; i < 1000000000L; i++) {
			u.getUname();
		}
		long endTime = System.currentTimeMillis();
		System.out.println("普通方法执行时间：" + (endTime - startTime) + "ms");
	}
	
	public static void test02() {
		User u = new User();
		Class c = u.getClass();
		try {
			Method method = c.getDeclaredMethod("getUname", null);
			long startTime = System.currentTimeMillis();
			for (int i = 0; i < 1000000000L; i++) {
				method.invoke(u, null);
			}
			long endTime = System.currentTimeMillis();
			System.out.println("反射（设置安全检查）执行时间：" + (endTime - startTime) + "ms");
			
		} catch (Exception e) {
			
		}
		
	}
	
	public static void test03() {
		User u = new User();
		Class c = u.getClass();
		try {
			Method method = c.getDeclaredMethod("getUname", null);
			method.setAccessible(true);
			long startTime = System.currentTimeMillis();
			for (int i = 0; i < 1000000000L; i++) {
				method.invoke(u, null);
			}
			long endTime = System.currentTimeMillis();
			System.out.println("反射（不设置安全检查）执行时间：" + (endTime - startTime) + "ms");
			
		} catch (Exception e) {
			
		}
		
	}
	
}
