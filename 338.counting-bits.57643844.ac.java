/*
 * [338] Counting Bits
 *
 * https://leetcode.com/problems/counting-bits/description/
 *
 * algorithms
 * Medium (62.32%)
 * Total Accepted:    111.8K
 * Total Submissions: 179.3K
 * Testcase Example:  '2'
 *
 * Given a non negative integer number num. For every numbers i in the range 0
 * ≤ i ≤ num calculate the number of 1's in their binary representation and
 * return them as an array.
 * 
 * 
 * Example:
 * For num = 5 you should return [0,1,1,2,1,2].
 * 
 * 
 * Follow up:
 * 
 * It is very easy to come up with a solution with run time
 * O(n*sizeof(integer)). But can you do it in linear time O(n) /possibly in a
 * single pass?
 * Space complexity should be O(n).
 * Can you do it like a boss? Do it without using any builtin function like
 * __builtin_popcount  in c++ or in any other language.
 * 
 * 
 * 
 * Credits:Special thanks to @ syedee  for adding this problem and creating all
 * test cases.
 */
public class Solution {
    public int[] countBits(int num) {
        //use Brian Kernighan’s Algorithm
        int[] res = new int[num+1];
        if(num==0) return res;
        res[1]=1;
        for (int i=2; i<= num; i++)
        {
            //bit wise, 10010&10001= 100000 => can eliminate lowest 1 bit one at a time 
            if((i & (i-1)) ==0) 
            {
                res[i] = 1;
            }
            else
            {
                //If not 1 bit, then use "highestOneBit" find largest 1 bit number. Use i - this number and get the rest of the 1s of the number, which is already available. 1010- 1000 = 10; which is 1 bit + bit 1 in "10"
                res[i] = 1 + res[i - Integer.highestOneBit(i)];
            }
        }
        return res;
    }
}
