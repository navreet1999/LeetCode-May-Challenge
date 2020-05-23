/*
Given a string, sort it in decreasing order based on the frequency of characters.

Example 1:

Input:
"tree"

Output:
"eert"

Explanation:
'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
Example 2:

Input:
"cccaaa"

Output:
"cccaaa"

Explanation:
Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
Note that "cacaca" is incorrect, as the same characters must be together.
Example 3:
*/

class Solution {
   public String frequencySort(String s) {
        if(s == null || s.length() == 0) return s;
       
       Map<Character,Integer> map=new HashMap<>();
       
       //count the frequency of each character
       for(char c: s.toCharArray())
         map.put(c ,map.getOrDefault(c,0) + 1);
       
       //array of List
       List<Character>[] bucket=new List[s.length()+1];
       
       for(Character key : map.keySet())
       {
           int freq= map.get(key);
           if(bucket[freq]==null)
               bucket[freq]=new ArrayList<>();
           
           bucket[freq].add(key);
       }
       
       //iterate through this array of list in decreasing order
       StringBuilder sb=new StringBuilder();
       for(int i=bucket.length-1;i>=0;i--)
       {
           if(bucket[i]!=null)
               for(char c: bucket[i])
               {
                   for(int j=0;j<map.get(c);j++){
                       sb.append(c);
                   }
               }
       }
       return sb.toString();
        
   }
}