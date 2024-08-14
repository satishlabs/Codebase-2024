package com.str;

//input = "Satish";
//Output = S*t*s*
public class ReplaceAlternativeWithStar {
	public static void main(String[] args) {
		String str = "Satish";
		char [] charArray = str.toCharArray();
		StringBuffer sb = new StringBuffer();
		for(int i=0; i<str.length(); i++) {
			int x = i%2;
			if(x != 0) {
				sb.append("*");
			}else {
				sb.append(charArray[i]);
			}
		}
		System.out.println(sb);
	}
}
