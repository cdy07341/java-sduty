package com.chendy.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 调用方法、构造方法、属性等
 * @author baidu
 *
 */
@SuppressWarnings("all")
public class Demo03 {
	public static void main(String[] args) {
		//动态操作构造器
		String path = "com.chendy.reflection.User";
		try {
			Class<User> c = (Class<User>) Class.forName(path);
			User user = c.newInstance();//调用了User无参构造
//			System.out.println(user);

			Constructor<User> constructor = c.getDeclaredConstructor(int.class, int.class, String.class);
			User user2 = constructor.newInstance(100, 14, "daoyan");
//			System.out.println(user2.getAge());

			//调用普通方法
			User user3 = c.newInstance();
			user3.setAge(100);
			Method age = c.getMethod("setAge", int.class);
			age.invoke(user3, 200);
//			System.out.println(user3.getAge());
			
			//操作属性
			User user4 = c.newInstance();
			Field f = c.getDeclaredField("uname");
			f.setAccessible(true);//不用做安全检查，可以直接访问
			f.set(user4, "chendaoyan");
//			System.out.println(user4.getUname());
			System.out.println(f.get(user4));
		} catch (Exception e) {
			
		}
		
	}
}
