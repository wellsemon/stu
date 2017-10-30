package com.welleys.stu.basic.java.a02.ifelse;

public class IfElseMain {
	public static void main(String[] args) {
		ifnotexec();

		System.out.println(ifconditionspecial());
	}

	private static boolean ifconditionspecial() {
		boolean a = true;
		boolean b = false;
		boolean c;

		if (a = b)//if(a=b) set false value to a, so a is false, a=b is false
			c = false;
		else//exec code below, so c is false
			c = a;

		return c;
	}

	private static void ifnotexec() {
		int i = 10;

		if(i> 11) {
			System.out.println(11);
		}else if(i <=10) {
			System.out.println(10);//output
		}else if(i < 9) {
			System.out.println(9);//not output
		}
	}
}
