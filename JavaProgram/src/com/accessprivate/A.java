package com.accessprivate;

import java.lang.reflect.Field;

class B{
	private int x=10;
}
public class A {
	public static void main(String[] args) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		// cannot be resolved to a variable
		//System.out.println(x);
		//B b = new B();
		//The field B.x is not visible
		//System.out.println(b.x);
		Field f = B.class.getDeclaredField("x");
		f.setAccessible(true);
		int a = f.getInt(new B());
		System.out.println(a);
	}
}
