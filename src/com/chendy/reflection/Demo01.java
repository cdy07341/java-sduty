package com.chendy.reflection;

/**
 * 获取class对象
 * @author baidu
 *
 */
//@SuppressWarnings("all")
public class Demo01 {
	public static void main(String[] args) {
		String path = "com.chendy.reflection.User";
		try {
			Class c = Class.forName(path);
			//对象是表示或者封装一些数据，一个类被加载后，JVM会创建一个对应该类的Class对象，类的整个结构信息都会放到对应的Class对象中
			//这个Class对象就像一面镜子一样，通过这面镜子看到对应类的全部信息
			System.out.println(c.hashCode());
			
			Class c2 = Class.forName(path);//一个类只对应一个Class对象
			System.out.println(c2.hashCode());
			System.out.println(User.class.hashCode());
			
			Class c3 = path.getClass();
			Class strC = String.class;
			System.out.println(c3.hashCode());
			System.out.println(strC.hashCode());
			
			Class intC = int.class;
			System.out.println(intC);
			
			//跟几维数组有关系，跟长度没关系
			int[] a = new int[10];
			int[] b = new int[30];
			int[][] d = new int[10][30];
			double[] e = new double[10];
			System.out.println(a.getClass().hashCode());
			System.out.println(b.getClass().hashCode());
			System.out.println(d.getClass().hashCode());
			System.out.println(e.getClass().hashCode());
			System.out.println("=====");
			//实例化出来的是不同的对象，反射的是同一个，见上面例子
			System.out.println(a.hashCode());
			System.out.println(b.hashCode());
			
		} catch (ClassNotFoundException e) {
			
		}
	}
}
