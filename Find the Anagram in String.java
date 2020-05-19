/*Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

The order of output does not matter.

Example 1:

Input:
s: "cbaebabacd" p: "abc"

Output:
[0, 6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input:
s: "abab" p: "ab"

Output:
[0, 1, 2]

Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".
*/



class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        
        List<Integer>ans = new ArrayList<>();
        if(s.length()==0 || p.length() > s.length()) return ans;
        int []smap = new int[26];
        int []pmap = new int[26];
        for(int i=0;i<p.length();i++){
            smap[s.charAt(i)-'a']++;
            pmap[p.charAt(i)-'a']++;
        }
       
        
        if(Arrays.equals(smap,pmap)){
            ans.add(0);
        }
        for(int i=p.length();i<s.length();i++){
            smap[s.charAt(i-p.length())-'a']--; //sliding window length should be p.length()
             smap[s.charAt(i)-'a']++;
          
            if(Arrays.equals(smap,pmap)){
                ans.add(i-p.length()+1);
            }
        }
        return ans;
        
    }
}