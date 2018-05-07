/*
 * [456] 132 Pattern
 *
 * https://leetcode.com/problems/132-pattern/description/
 *
 * algorithms
 * Medium (27.75%)
 * Total Accepted:    18K
 * Total Submissions: 64.8K
 * Testcase Example:  '[1,2,3,4]'
 *
 * 
 * Given a sequence of n integers a1, a2, ..., an, a 132 pattern is a
 * subsequence ai, aj, ak such
 * that i < j < k and ai < ak < aj. Design an algorithm that takes a list of n
 * numbers as input and checks whether there is a 132 pattern in the list.
 * 
 * Note: n will be less than 15,000.
 * 
 * Example 1:
 * 
 * Input: [1, 2, 3, 4]
 * 
 * Output: False
 * 
 * Explanation: There is no 132 pattern in the sequence.
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: [3, 1, 4, 2]
 * 
 * Output: True
 * 
 * Explanation: There is a 132 pattern in the sequence: [1, 4, 2].
 * 
 * 
 * 
 * Example 3:
 * 
 * Input: [-1, 3, 2, 0]
 * 
 * Output: True
 * 
 * Explanation: There are three 132 patterns in the sequence: [-1, 3, 2], [-1,
 * 3, 0] and [-1, 2, 0].
 * 
 * 
 */
public class Solution {
    class Interval {
        int min, max;
        public Interval(int min, int max){
            this.min = min;
            this.max = max;
        }
    }
    
    //if smaller than min, put new interval, if between return true, if larger, update all, since all min are larger than latest min, if not between, we just pop all, and leave the last with update max;
    public boolean find132pattern(int[] nums) {
        Stack<Interval> s = new Stack<Interval>();
        for(int n:nums){
            if(s.isEmpty() || s.peek().min>n){
                s.push(new Interval(n,n));
            } else if(s.peek().min<n){
                Interval last = s.pop();
                if(last.max>n) return true;
                else{
                    last.max = n;
                    while(!s.isEmpty() && n>=s.peek().max){
                        s.pop();
                    }
                    if(!s.isEmpty() && s.peek().min <n) return true;
                    s.push(last);
                }
            }
        }
        return false;
    }
}
