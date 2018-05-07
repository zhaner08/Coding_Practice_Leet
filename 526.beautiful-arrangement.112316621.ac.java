/*
 * [526] Beautiful Arrangement
 *
 * https://leetcode.com/problems/beautiful-arrangement/description/
 *
 * algorithms
 * Medium (53.32%)
 * Total Accepted:    23.2K
 * Total Submissions: 43.4K
 * Testcase Example:  '2'
 *
 * 
 * Suppose you have N integers from 1 to N. We define a beautiful arrangement
 * as an array that is constructed by these N numbers successfully if one of
 * the following is true for the ith position (1 
 * The number at the ith position is divisible by i.
 * i is divisible by the number at the ith position.
 * 
 * 
 * 
 * 
 * Now given N, how many beautiful arrangements can you construct?
 * 
 * 
 * Example 1:
 * 
 * Input: 2
 * Output: 2
 * Explanation: 
 * The first beautiful arrangement is [1, 2]:
 * Number at the 1st position (i=1) is 1, and 1 is divisible by i (i=1).
 * Number at the 2nd position (i=2) is 2, and 2 is divisible by i (i=2).
 * The second beautiful arrangement is [2, 1]:
 * Number at the 1st position (i=1) is 2, and 2 is divisible by i (i=1).
 * Number at the 2nd position (i=2) is 1, and i (i=2) is divisible by 1.
 * 
 * 
 * 
 * Note:
 * 
 * N is a positive integer and will not exceed 15.
 * 
 * 
 */
public class Solution {
    
    public int count = 0;
    
    public int countArrangement(int N) {
        if(N==0) return N;
        helper(N, 1, new int[N+1]);
        return count;
    }
    
    public void helper(int N, int pos, int[] visited){
        //just lock each number, and see how many ways the others can change, if i>N, meanse already find a way, count++
        if(pos>N){
            count++;
            return;
        }
        
        //since number coule be interchange with very first number, we need to count from i for every
        for(int i=1; i<=N; i++){
            if(visited[i]==0 && (i%pos ==0 || pos%i ==0)){
                //can be change with that number
                visited[i]=1;
                //lock that number
                //if a number can be put at that position, mark that number as used, then use other numbers left to see if all of them can find their place;
                helper(N, pos+1, visited);
                visited[i]=0;
            }
        }
    }
}
