package com.welleys.stu.i18n.bundle;

import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceBundleTest {
	public static void main(String[] args) {
		new ResourceBundleTest().loadResourceBundles();
	}
	
	private void loadResourceBundles(){
		Locale le  = Locale.getDefault();
		ResourceBundle rb = ResourceBundle.getBundle("hello", le);
		System.out.println(rb.getObject("hello"));
	}
}
