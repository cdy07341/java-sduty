package com.chendy.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
public @interface MyAnnotation {
	String studentName() default "";
	String age();
	String[] school() default {};
}
