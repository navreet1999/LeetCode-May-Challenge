/*
Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.

Example 1:
Input: [0,1]
Output: 2
Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.
Example 2:
Input: [0,1,0]
Output: 2
Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.*/


class Solution {
    public int findMaxLength(int[] nums) {
        int longest_subarray=0;
        int sum=0;
        int value=0;
        
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==0)
                sum+=-1;
            else
                sum+=1;
            
            if(sum==0)
            {
                 value=i+1;
                if(longest_subarray<value)
                longest_subarray=value;
                
            }
            else if(map.containsKey(sum))
            {
               value=i-map.get(sum);
                
                if(longest_subarray < value)
                    longest_subarray=value;
            }
            else
                map.put(sum,i);
                
        }
        
        return longest_subarray;
    }
}