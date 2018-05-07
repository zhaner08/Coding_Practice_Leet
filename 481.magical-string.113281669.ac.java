/*
 * [481] Magical String
 *
 * https://leetcode.com/problems/magical-string/description/
 *
 * algorithms
 * Medium (45.81%)
 * Total Accepted:    13.8K
 * Total Submissions: 30.2K
 * Testcase Example:  '1'
 *
 * 
 * A magical string S consists of only '1' and '2' and obeys the following
 * rules:
 * 
 * 
 * The string S is magical because concatenating the number of contiguous
 * occurrences of characters '1' and '2' generates the string S itself.
 * 
 * 
 * 
 * The first few elements of string S is the following:
 * S = "1221121221221121122……"
 * 
 * 
 * 
 * If we group the consecutive '1's and '2's in S, it will be:
 * 
 * 
 * 1   22  11  2  1  22  1  22  11  2  11  22 ......
 * 
 * 
 * and the occurrences of '1's or '2's in each group are:
 * 
 * 
 * 1   2       2    1   1    2     1    2     2    1    2    2 ......
 * 
 * 
 * 
 * You can see that the occurrence sequence above is the S itself. 
 * 
 * 
 * 
 * Given an integer N as input, return the number of '1's in the first N number
 * in the magical string S.
 * 
 * 
 * Note:
 * N will not exceed 100,000.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: 6
 * Output: 3
 * Explanation: The first 6 elements of magical string S is "12211" and it
 * contains three 1's, so return 3.
 * 
 * 
 */
public class Solution {
    public int magicalString(int n) {
        //take care the initial condition
        if(n<=0) return 0;
        if(n<=3) return 1;
        int[] result = new int[n+1];// last one could be 2, so add 1 more
        result[0] = 1;
        result[1] = 2;
        result[2] = 2;
        
        int head=2, tail=3, resultInt=1, num = 1;
        while(tail<n){
            result[tail] = result[tail-1] ^3; //this trick flip number between 1 and 2
            tail++;
            if(result[head] == 2 ){
                result[tail] = result[tail-1];
                tail++;
            }else{
                resultInt++;
            }
            head++;
        }
        while(head<n){
            if(result[head]==1) resultInt++;
            head++;
        }
        return resultInt;
    }
    
    //another way, similar, but record tail instead of head
    
//     public int magicalString(int n) {
//         if (n <= 0) return 0;
//         if (n <= 3) return 1;
        
//         int[] a = new int[n + 1];
//         a[0] = 1; a[1] = 2; a[2] = 2;
//         int head = 2, tail = 3, num = 1, result = 1;
        
//         while (tail < n) {
//             for (int i = 0; i < a[head]; i++) {
//                 a[tail] = num;
//                 if (num == 1 && tail < n) result++;
//                 tail++;
//             }
//             num = num ^ 3;
//             head++;
//         }
        
//         return result;
//     }    
}
