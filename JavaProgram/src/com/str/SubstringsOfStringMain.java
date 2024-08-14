package com.str;

//input = Hello
//output = H He Hel Hell Hello e el ell ello l ll llo l lo o
public class SubstringsOfStringMain {
	public static void main(String[] args) {
		String str= "Hello";
		for(int i=0; i<str.length(); i++) {
			for(int j=i+1; j<=str.length(); j++) {
				System.out.print(str.substring(i, j)+" ");
			}
		}
	}
}
