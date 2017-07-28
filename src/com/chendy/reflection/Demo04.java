package com.chendy.reflection;

import java.util.List;
import java.util.Map;

/**
 * 通过反射获取泛型信息
 * @author baidu
 *
 */
public class Demo04 {
	public void test01(Map<String, User> map, List<User> list) {
		System.out.println("demo04.test01()");
	}
	
	public Map<Integer, User> test02() {
		System.out.println("demo04.test01()");
		return null;
	}
	
	public static void main(String[] args) {
		
	}
}
