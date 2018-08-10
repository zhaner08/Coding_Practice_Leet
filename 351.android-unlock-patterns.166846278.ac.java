/*
 * [351] Android Unlock Patterns
 *
 * https://leetcode.com/problems/android-unlock-patterns/description/
 *
 * algorithms
 * Medium (44.67%)
 * Total Accepted:    23.1K
 * Total Submissions: 51.6K
 * Testcase Example:  '1\n1'
 *
 * 
 * Given an Android 3x3 key lock screen and two integers m and n, where  1 ≤ m
 * ≤ n ≤ 9, count the total number of unlock patterns of the Android lock
 * screen, which consist of minimum of m keys and maximum n keys.
 * 
 * Rules for a valid pattern:
 * 
 * Each pattern must connect at least m keys and at most n keys.
 * All the keys must be distinct.
 * If the line connecting two consecutive keys in the pattern passes through
 * any other keys, the other keys must have previously selected in the pattern.
 * No jumps through non selected key is allowed.
 * The order of keys used matters.
 * 
 * 
 * 
 * 
 * 
 * Explanation:
 * 
 * | 1 | 2 | 3 |
 * | 4 | 5 | 6 |
 * | 7 | 8 | 9 |
 * 
 * 
 * 
 * Invalid move: 4 - 1 - 3 - 6 
 * 
 * Line  1 - 3 passes through key 2 which had not been selected in the
 * pattern.
 * 
 * Invalid move: 4 - 1 - 9 - 2
 * 
 * Line  1 - 9 passes through key 5 which had not been selected in the
 * pattern.
 * 
 * Valid move: 2 - 4 - 1 - 3 - 6
 * 
 * Line 1 - 3 is valid because it passes through key 2, which had been selected
 * in the pattern
 * 
 * Valid move: 6 - 5 - 4 - 1 - 9 - 2
 * 
 * Line 1 - 9 is valid because it passes through key 5, which had been selected
 * in the pattern.
 * 
 * Example:
 * Given m = 1, n = 1, return 9.
 * 
 * 
 * Credits:Special thanks to @elmirap for adding this problem and creating all
 * test cases.
 */
class Solution {
    //Tag:Google
    //Tag:Apple
    //Tag:DP
    //Tag:Backtracking
    public int numberOfPatterns(int m, int n) {
        // Skip array represents number to skip between two pairs
        //which number will be skipped between two numbers, skip at most one number
        int[][] skip= new int[10][10];
        skip[1][3] = skip[3][1] = 2;
        skip[1][7] = skip[7][1] = 4;
        skip[3][9] = skip[9][3] = 6;
        skip[7][9] = skip[9][7] = 8;
        skip[1][9] = skip[9][1] = skip[2][8] = skip[8][2] = skip[3][7] = skip[7][3] = skip[4][6] = skip[6][4] = 5;
        
        boolean[] visited = new boolean[10];
        int result = 0;
        for(int i=m; i<=n; i++){
            //since symetric, only take care 3 cases and times 4
            result+=dfs(visited, skip, i-1, 1)*4;
            result+=dfs(visited, skip, i-1, 2)*4;
            result+=dfs(visited, skip, i-1, 5);
        }
        return result;
    }
    
    //dfs
    public int dfs(boolean[] visited, int[][] skip, int count, int cur){
        if(count==0) return 1;
        visited[cur] = true;
        int result = 0;
        for(int i=1; i<10; i++){
            //if not visited and not skipping middle number
            if(!visited[i] && (skip[cur][i]==0 || visited[skip[cur][i]])){
                result+=dfs(visited, skip, count-1, i);
            }
        }
        visited[cur] = false;
        return result;
    }
}
