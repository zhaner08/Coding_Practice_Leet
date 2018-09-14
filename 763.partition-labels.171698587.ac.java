/*
 * [768] Partition Labels
 *
 * https://leetcode.com/problems/partition-labels/description/
 *
 * algorithms
 * Medium (65.09%)
 * Total Accepted:    22.8K
 * Total Submissions: 35.1K
 * Testcase Example:  '"ababcbacadefegdehijhklij"'
 *
 * 
 * A string S of lowercase letters is given.  We want to partition this string
 * into as many parts as possible so that each letter appears in at most one
 * part, and return a list of integers representing the size of these parts.
 * 
 * 
 * Example 1:
 * 
 * Input: S = "ababcbacadefegdehijhklij"
 * Output: [9,7,8]
 * Explanation:
 * The partition is "ababcbaca", "defegde", "hijhklij".
 * This is a partition so that each letter appears in at most one part.
 * A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it
 * splits S into less parts.
 * 
 * 
 * 
 * Note:
 * S will have length in range [1, 500].
 * S will consist of lowercase letters ('a' to 'z') only.
 * 
 */
class Solution {
    //Tag:Amazon
    //Tag:TwoPointer
    //Tag:Greedy
    public List<Integer> partitionLabels(String S) {
        //store location of last existence of each character
        int[] m = new int[26];
        for(int i =0; i<S.length(); i++){
            m[S.charAt(i)-'a'] = i;
        }
        
        List<Integer> result = new ArrayList<Integer>();
        int cur = 0;
        int future = 0;
        
        for(int i=0; i<S.length(); i++){
            future = Math.max(future, m[S.charAt(i)-'a']);
            if(i==future){
                result.add(i-cur+1);
                cur = i+1;
            }
        }
        return result;
    }
}
