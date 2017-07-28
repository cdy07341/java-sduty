package com.chendy.javassist;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtConstructor;
import javassist.CtField;
import javassist.CtMethod;

public class Demo01 {
	public static void main(String[] args) {
		ClassPool pool = ClassPool.getDefault();
		CtClass ctClass = pool.makeClass("com.chendy.javassist.Test");
		try {
			//创建属性
			CtField f1 = CtField.make("private int id;", ctClass);
			CtField f2 = CtField.make("private String name;", ctClass);
			ctClass.addField(f1);
			ctClass.addField(f2);
			
			//创建方法
			CtMethod m1 = CtMethod.make("public int getName(){return name;}", ctClass);
			CtMethod m2 = CtMethod.make("public void setName(String name){this.name=name;}", ctClass);
			m1.setBody("{int a = 1;return name;}");
			ctClass.addMethod(m1);
			ctClass.addMethod(m2);
			
			//添加构造器
			CtConstructor constructor = new CtConstructor(new CtClass[]{CtClass.intType, pool.get("java.lang.String")}, ctClass);
			constructor.setBody("{this.name=name; this.id=id;}");
			
			ctClass.writeFile("/Users/baidu/Desktop/");
			System.out.println("success");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
	}
}
