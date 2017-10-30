package com.welleys.stu.datatype.string;

	public class SplitTest {
		public static void main(String[] args) {
			String str = "dafsafds123";
			String[] strArr=str.split("");
			for(String tmp:strArr){
				System.out.println(tmp);
			}
		}
}
