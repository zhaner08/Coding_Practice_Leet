/*
 * [556] Next Greater Element III
 *
 * https://leetcode.com/problems/next-greater-element-iii/description/
 *
 * algorithms
 * Medium (28.88%)
 * Total Accepted:    13.4K
 * Total Submissions: 46.5K
 * Testcase Example:  '12'
 *
 * Given a positive 32-bit integer n, you need to find the smallest 32-bit
 * integer which has exactly the same digits existing in the integer n and is
 * greater in value than n. If no such positive 32-bit integer exists, you need
 * to return -1.
 * 
 * Example 1:
 * 
 * 
 * Input: 12
 * Output: 21
 * 
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: 21
 * Output: -1
 * 
 * 
 * 
 * 
 */
public class Solution {
    public int nextGreaterElement(int n) {
        
        //Can make to char array, do a swap in the middle, then use Arrays.sort(number, i, number.length); to sort the rest of array, this way, no need to keep track of previous numbers.
        if(n <12){
            return -1;
        }
        String input = n+"";
        int[] candidates = new int[10];
        int largest = -1;
        int i;
        String result="";
        for(i = input.length()-1; i>=0; i--){
            int temp = input.charAt(i)-'0';
            candidates[temp]++;
             if(temp<largest){
                 //generate new int
                 int j = temp+1;
                 while(j<10){
                     if(candidates[j]!=0){
                        candidates[j]--;
                        break;
                     }
                     j++;
                 }
                 result = input.substring(0, i)+j;
                 for(int x=0; x<10; x++){
                     while(candidates[x]!=0){
                         result+=x;
                         candidates[x]--;
                     }
                 }
                 long d = Long.parseLong(result);
                 if(d>Integer.MAX_VALUE){
                     return -1;
                 }
                 return Integer.parseInt(result);
             }
             if(temp>largest){
                 largest = temp;
             }
        }
        return -1;
    }
}

