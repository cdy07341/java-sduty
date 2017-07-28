package com.chendy.javassist;

import java.lang.reflect.Method;
import java.util.Arrays;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtConstructor;
import javassist.CtField;
import javassist.CtMethod;
import javassist.CtNewMethod;
import javassist.Modifier;
import javassist.NotFoundException;

/**
 * 测试javassist API
 * 
 * @author baidu
 *
 */
public class Demo02 {
	public static void main(String[] args) {
		test05();
	}

	public static void test01() {
		ClassPool pool = ClassPool.getDefault();
		try {
			CtClass cc = pool.get("com.chendy.javassist.Tmp");
			byte[] bytes = cc.toBytecode();
			System.out.println(Arrays.toString(bytes));

			System.out.println(cc.getName());
			System.out.println(cc.getSimpleName());
			System.out.println(cc.getSuperclass());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void test02() {
		ClassPool pool = ClassPool.getDefault();
		try {
			CtClass cc = pool.get("com.chendy.javassist.Tmp");

			CtMethod method = new CtMethod(CtClass.intType, "add", new CtClass[] { CtClass.intType, CtClass.intType },
					cc);
			method.setModifiers(Modifier.PUBLIC);
			method.setBody("{System.out.println(\"chendaoyan\"); return $1+$2;}");
			cc.addMethod(method);

			// 通过反射来调用
			Class c = cc.toClass();
			Object object = c.newInstance();
			Method m = c.getDeclaredMethod("add", int.class, int.class);
			Object result = m.invoke(object, 11, 22);
			System.out.println(result);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 修改已有的方法的信息，修改方法体的内容
	 * 
	 * @throws Exception
	 */
	public static void test03() {
		ClassPool pool = ClassPool.getDefault();
		CtClass cc;
		try {
			cc = pool.get("com.chendy.javassist.Tmp");
			CtMethod cm = cc.getDeclaredMethod("SayHello", new CtClass[] { CtClass.intType });
			cm.insertBefore("System.out.println($1);System.out.println(\"start!!!\");");
			cm.insertAt(9, "int b=3;System.out.println(\"b=\"+b);");
			cm.insertAfter("System.out.println(\"end!!!\");");

			// 通过反射调用新生成的方法
			Class clazz = cc.toClass();
			Object obj = clazz.newInstance(); // 通过调用Emp无参构造器，创建新的Emp对象
			Method method = clazz.getDeclaredMethod("SayHello", int.class);
			method.invoke(obj, 300);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 属性的操作
	 * 
	 * @throws Exception
	 */
	public static void test04() {
		ClassPool pool = ClassPool.getDefault();
		CtClass cc;
		try {
			cc = pool.get("com.chendy.javassist.Tmp");
			// CtField f1 = CtField.make("private int empno;", cc);
			CtField f1 = new CtField(CtClass.intType, "salary", cc);
			f1.setModifiers(Modifier.PRIVATE);
			cc.addField(f1);

			cc.getDeclaredField("ename"); // 获取指定的属性

			// 增加相应的set和get方法
			cc.addMethod(CtNewMethod.getter("getSalary", f1));
			cc.addMethod(CtNewMethod.getter("setSalary", f1));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * 构造方法的操作
	 * 
	 * @throws Exception
	 */
	public static void test05() {
		ClassPool pool = ClassPool.getDefault();
		CtClass cc;
		try {
			cc = pool.get("com.chendy.javassist.Tmp");
			CtConstructor[] cs = cc.getConstructors();
			for (CtConstructor c : cs) {
				System.out.println(c.getLongName());
			}
		} catch (NotFoundException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 注解的操作方法
	 * @throws Exception
	 */
	public static void test06() {
		CtClass cc;
		try {
			cc = ClassPool.getDefault().get("com.chendy.javassist.Tmp");
			Object[] all = cc.getAnnotations();
			Author a = (Author) all[0];
			String name = a.name();
			int year = a.year();
			System.out.println("name: " + name + ", year: " + year);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
