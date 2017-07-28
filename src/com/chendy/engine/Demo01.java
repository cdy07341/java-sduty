package com.chendy.engine;

import java.io.FileReader;
import java.net.URL;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class Demo01 {
	public static void main(String[] args) {
		ScriptEngineManager engine = new ScriptEngineManager();
		
		ScriptEngine scriptEngine = engine.getEngineByName("javascript");
		scriptEngine.put("msg", "java");
		
		String str = "var user={name:'daoyan', age:18};";
		str += "print(user.name);";
		
		try {
			scriptEngine.eval(str);
			scriptEngine.eval("msg='test'");
			System.out.println(scriptEngine.get("msg"));
			//定义函数
			scriptEngine.eval("function add (a,b) {var sum=a + b;return sum;}");
			Invocable jsInvocable = (Invocable) scriptEngine;
			Object result = jsInvocable.invokeFunction("add", new Object[]{13,30});
			System.out.println(result);
			
			//从文件执行
			URL url = Demo01.class.getClassLoader().getResource("a.js");
			FileReader fr = new FileReader(url.getPath());
			scriptEngine.eval(fr);
			fr.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
