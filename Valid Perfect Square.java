/*Given a positive integer num, write a function which returns True if num is a perfect square else False.

Note: Do not use any built-in library function such as sqrt.

Example 1:

Input: 16
Output: true
Example 2:

Input: 14
Output: false*/

class Solution {
    public boolean isPerfectSquare(int n) {
   
       for (int i = 1; i * i <= n; i++) { 
  
            // If (i * i = n) 
            if ((n % i == 0) && (n / i == i)) { 
                return true; 
            } 
        } 
        return false; 
        
    }
    
}
