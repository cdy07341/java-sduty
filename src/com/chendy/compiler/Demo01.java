package com.chendy.compiler;

import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

public class Demo01 {
	public static void main(String[] args) {
		//通过IO流操作，将字符串保存为一个临时文件，然后调用编译方法！
		String str = "public class HelloWorld {public static void main(String[] args) {System.out.println(1223);}}";
		
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		int a = compiler.run(null, null, null, "/Users/baidu/Desktop/HelloWorld.java");
//		System.out.println(a);
		
		//runTime执行
//		Runtime runtime = Runtime.getRuntime();
//		try {
//			Process process = runtime.exec("java -cp /Users/baidu/Desktop HelloWorld");
//			InputStream inputStream = process.getInputStream();
//			BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
//			String info = "";
//			while ((info = reader.readLine()) != null) {
//				System.out.println(info);
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		//反射执行
		try {
			URL[] urls = new URL[] {new URL("file:" + "/Users/baidu/Desktop/")};
			URLClassLoader loader = new URLClassLoader(urls);
			Class c = loader.loadClass("HelloWorld");
			Method method = c.getMethod("main", String[].class);
			method.invoke(null, (Object) new String[]{});
			//由于可变参数是JDK5.0之后才有。
            //m.invoke(null, new String[]{"aa","bb"});会编译成:m.invoke(null,"aa","bb"),就发生了参数个数不匹配的问题。
            //因此，必须要加上(Object)转型，避免这个问题。
            //public static void main(String[] args)
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
