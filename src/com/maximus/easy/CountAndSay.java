package com.maximus.easy;

public class CountAndSay {
	 public String countAndSay(int n) {
		 String result = "";
		 String[] s = new String[31];
		 for(int i = 0;i < s.length;i++) {
			 s[i] = "";
		 }
		 s[0] = "1";
		 s[1] = "11";
		 for(int i = 2;i < n;i++) {
			 String st = s[i-1];
			 int count = 1;
			 for(int j = 0;j < st.length() - 1;j++) {
				 if(st.charAt(j) == st.charAt(j+1)) {
					 count++;
					 if(j + 1 == st.length() - 1) {
						 s[i] = s[i] + String.valueOf(count) + st.charAt(j);
						 break;
					 }
				 } 
				 else {
					 s[i] = s[i] + String.valueOf(count) + st.charAt(j);
					 count = 1;
				 }
			 }
			 if(st.charAt(st.length() - 1) != st.charAt(st.length() - 2))
				 s[i] = s[i] + "1" + st.charAt(st.length() - 1);
		 }
		 result = s[n - 1];
		 return result;
	 }
}
