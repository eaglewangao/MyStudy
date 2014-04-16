package com.ctrip.study.algorithm.leetcode;

public class ReverseWords {
	
	public String reverseWords(String s) {
		if(s == null){
			return null;
		}
		StringBuffer reverse = new StringBuffer();
		String[] sourceWords = s.split(" ");
		if(sourceWords.length == 0){
			return "";
		}
		if(sourceWords.length == 1){
			return reverse.append(sourceWords[0]).toString();
		}else{
			for (int i = sourceWords.length - 1; i >= 0; i--) {
				if(sourceWords[i].equals("")){
					reverse.append(sourceWords[i]);
				}else{
					reverse.append(sourceWords[i] + " ");
				}
			}
		}
        return reverse.substring(0, reverse.length() - 1);
    }
	
	public static void main(String[] args) {
		String sourceWords = "the sky is blue";
		String reverseWords = new ReverseWords().reverseWords(sourceWords);
		System.out.println(reverseWords);
	}

}
