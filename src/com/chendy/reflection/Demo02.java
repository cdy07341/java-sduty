package com.chendy.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 获取类相关元素（属性、方法等）
 * @author baidu
 *
 */
public class Demo02 {
	public static void main(String[] args) {
		String path = "com.chendy.reflection.User";
		try {
			Class c = Class.forName(path);
			//获取类的名字
			System.out.println(c.getName());
			System.out.println(c.getSimpleName());//获得类名
			//获取属性
			Field[] field = c.getFields();
			System.out.println(field.length);
			Field[] fields = c.getDeclaredFields();
			System.out.println(fields.length);
			for (Field field2 : fields) {
				System.out.println(field2);
			}
			Field f = c.getDeclaredField("id");
			System.out.println(f);
			//获取方法
			Method[] methods = c.getDeclaredMethods();
			Method m = c.getDeclaredMethod("setUname", String.class);
			for (Method method : methods) {
//				System.out.println(method);
			}
//			System.out.println(m);
			//获取构造器
			Constructor[] constructors = c.getConstructors();
			for (Constructor constructor : constructors) {
				System.out.println(constructor);
			}
			System.out.println("====");
//			Constructor constructor2 = c.getConstructor(null);
			Constructor constructor2 = c.getConstructor(null);
			System.out.println(constructor2);
			
			
		} catch (Exception e) {
			
		}
	}
}
