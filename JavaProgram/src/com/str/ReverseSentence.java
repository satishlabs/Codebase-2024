package com.str;

//Input = hello how are you how is going
//Output = going is how you are how hello
public class ReverseSentence {
	public static void main(String[] args) {
		String str="hello how are you how is going";
		String str1 = reverse(str);
		System.out.println(str1);
	}
	public static String revStr ="";
	public static String reverse(String str) {
		String[] str1 = str.split(" ");
		for(int i=str1.length-1; i>=0; i--) {
			revStr = revStr+" "+str1[i];
		}
		return revStr;
	}
}
