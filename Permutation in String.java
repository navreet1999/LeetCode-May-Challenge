/*
Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1. In other words, one of the first string's permutations is the substring of the second string.

 

Example 1:

Input: s1 = "ab" s2 = "eidbaooo"
Output: True
Explanation: s2 contains one permutation of s1 ("ba").
Example 2:

Input:s1= "ab" s2 = "eidboaoo"
Output: False
 */


class Solution {
    public boolean checkInclusion(String s1, String s2) {
        char[] p  =  s1.toCharArray();
	 char[] p1 = s2.toCharArray();
	 Arrays.sort(p);
	 
	 for(int i=0;i<(p1.length-p.length)+1;i++)
	 {
		 String str = s2.substring(i, i+p.length);
		 char[] str1 = str.toCharArray();
		 Arrays.sort(str1);
		 
		 if(Arrays.equals(str1, p))
			 return true;
		
	 }
	 return false;
    }
}