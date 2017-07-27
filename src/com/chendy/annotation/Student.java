package com.chendy.annotation;

@TableAnnotation("student")
public class Student {
	@FiledAnnotation(column="id", length=10, type="int")
	private int id;
	@FiledAnnotation(column="name", length=10, type="String")
	private String name;
	@FiledAnnotation(column="age", length=10, type="int")
	private int age;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
