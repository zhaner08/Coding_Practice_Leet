/*
 * [547] Friend Circles
 *
 * https://leetcode.com/problems/friend-circles/description/
 *
 * algorithms
 * Medium (49.15%)
 * Total Accepted:    36.7K
 * Total Submissions: 74.7K
 * Testcase Example:  '[[1,1,0],[1,1,0],[0,0,1]]'
 *
 * 
 * There are N students in a class. Some of them are friends, while some are
 * not. Their friendship is transitive in nature. For example, if A is a direct
 * friend of B, and B is a direct friend of C, then A is an indirect friend of
 * C. And we defined a friend circle is a group of students who are direct or
 * indirect friends.
 * 
 * 
 * 
 * Given a N*N matrix M representing the friend relationship between students
 * in the class. If M[i][j] = 1, then the ith and jth students are direct
 * friends with each other, otherwise not. And you have to output the total
 * number of friend circles among all the students.
 * 
 * 
 * Example 1:
 * 
 * Input: 
 * [[1,1,0],
 * ⁠[1,1,0],
 * ⁠[0,0,1]]
 * Output: 2
 * Explanation:The 0th and 1st students are direct friends, so they are in a
 * friend circle. The 2nd student himself is in a friend circle. So return
 * 2.
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: 
 * [[1,1,0],
 * ⁠[1,1,1],
 * ⁠[0,1,1]]
 * Output: 1
 * Explanation:The 0th and 1st students are direct friends, the 1st and 2nd
 * students are direct friends, so the 0th and 2nd students are indirect
 * friends. All of them are in the same friend circle, so return 1.
 * 
 * 
 * 
 * 
 * Note:
 * 
 * N is in range [1,200].
 * M[i][i] = 1 for all students.
 * If M[i][j] = 1, then M[j][i] = 1.
 * 
 * 
 */


public class Solution {
    public int findCircleNum(int[][] M) {
        int length = M.length;
        int result = 0;
        int[] visited = new int[length];
        //usd dfs so we go through each circle only once, no repeat
        for(int i=0; i<length; i++){
            if(visited[i]==0){
                helper(M, visited, i);
                result++;
            }
        }
        return result;
    }
    
    public void helper(int[][] M, int[] visited, int i){
        for(int j=0; j<M.length; j++){
            if(visited[j]==0 && M[i][j]==1){
                //dont need to go with itself, so set it to 1 first
                visited[j]=1;
                helper(M, visited, j);
            }
        }
    }
}
