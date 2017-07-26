package com.baidu.decorator;

public class Test {
	public static void main(String[] args) {
		Beverage beverage = new Mocha(new HouseBlend());
		// 如上就是一杯HouseBlend配上两份Mocha和一份Milk，博主没去星巴克喝过咖啡,这样配可以么= =
		System.out.println(beverage.getDescription() + ":" + beverage.cost());

	}
}
