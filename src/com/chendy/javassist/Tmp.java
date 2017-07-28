package com.chendy.javassist;

@Author(name = "chendaoyan", year = 2010)
public class Tmp {
	private int id;
	private String name;
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
	public Tmp(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Tmp() {
		
	}
	
	public void SayHello(int a) {
		System.out.println(a);
	}
	
	
}
