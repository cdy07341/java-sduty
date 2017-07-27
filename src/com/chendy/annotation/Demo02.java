package com.chendy.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class Demo02 {
	public static void main(String[] args) {
		try {
			Class c = Class.forName("com.chendy.annotation.Student");
			//获取类所有的注解
			Annotation[] annotation = c.getAnnotations();
			for (Annotation a : annotation) {
				System.out.println(a);
			}
			//获取注解的值
			TableAnnotation tableAnnotation = (TableAnnotation) c.getAnnotation(TableAnnotation.class);
			System.out.println(tableAnnotation.value());
			
			//获取类的属性的注解
			Field[] filed = c.getDeclaredFields();
			for (Field f : filed) {
				System.out.println(f);
			}
			
			Field f = c.getDeclaredField("id");
			FiledAnnotation filedAnnotation = f.getAnnotation(FiledAnnotation.class);
			System.out.println(filedAnnotation.column() + "====" + filedAnnotation.type() + "====" + filedAnnotation.length());


		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
