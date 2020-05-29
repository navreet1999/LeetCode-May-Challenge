/*
Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.

Example 1:

Input: 2
Output: [0,1,1]
Example 2:

Input: 5
Output: [0,1,1,2,1,2]*/


class Solution {
    public int[] countBits(int num) {
        
         int[] ans = new int[num + 1];
        for(int i = 1; i < num + 1; i++) 
            ans[i] = ans[i/2]+(i%2);
        return ans;
    }
}