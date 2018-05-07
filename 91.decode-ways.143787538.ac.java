/*
 * [91] Decode Ways
 *
 * https://leetcode.com/problems/decode-ways/description/
 *
 * algorithms
 * Medium (20.39%)
 * Total Accepted:    172K
 * Total Submissions: 843.3K
 * Testcase Example:  '"12"'
 *
 * A message containing letters from A-Z is being encoded to numbers using the
 * following mapping:
 * 
 * 
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 
 * 
 * Given a non-empty string containing only digits, determine the total number
 * of ways to decode it.
 * 
 * Example 1:
 * 
 * 
 * Input: "12"
 * Output: 2
 * Explanation: It could be decoded as "AB" (1 2) or "L" (12).
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "226"
 * Output: 3
 * Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2
 * 6).
 * 
 */
class Solution {
    public int numDecodings(String s) {
        if(s==null || s.length()==0) return 0;
        int[] dp = new int[s.length()+1];
        dp[s.length()] = 1;
        for(int i=s.length()-1; i>=0; i--){
            if(s.charAt(i)=='0') dp[i] = 0;
            else if(i ==s.length()-1 || Integer.parseInt(s.substring(i, i+2))>26){
                dp[i] = dp[i+1];
            }else{
                dp[i] = dp[i+1]+dp[i+2];
            }
        }
        return dp[0];
    }
}


// 这道题要求解码方法，跟之前那道 Climbing Stairs 爬梯子问题 非常的相似，但是还有一些其他的限制条件，
// 比如说一位数时不能为0，两位数不能大于26，其十位上的数也不能为0，出去这些限制条件，根爬梯子基本没啥区别，也勉强算特殊的斐波那契数列，当然需要用动态规划Dynamci Programming来解

// Test:
// "" // empty string
// "0" // invalid encoding number
// "&*^.abc" // invalid input char
// "201" -> 1 // 0 can only be at the units of a two-digit number
// "12" -> 2

// 注意： 问输入是否全为数字，若否则还需检测其他非法字符

// Solution 1: DP
// public int numDecodings(String s) {
// 	if (s.length() == 0 || s.charAt(0) == '0')    return 0; // 
// 	int[] dp = new int[s.length() + 1];
// 	dp[0] = 1;
// 	dp[1] = 1;
// 	for (int i = 1; i < s.length(); i++) {
// 		if (s.charAt(i) != '0')		dp[i + 1] = dp[i];
// 		if (s.charAt(i - 1) != '0' && Integer.valueOf(s.substring(i - 1, i + 1)) <= 26)
// 			dp[i + 1] += dp[i - 1];
// 	}
// 	return dp[s.length()];
// }

// Solution 2: DFS
// Time: O(n) time

// public int numDecodings(String s) {
//     if (s == null || s.length() == 0)    return 0;
//     return dfs(s, 0);
// }
// private int dfs(String s, int i) {
//     if (i == s.length())    return 1; //if the whole string has been decoded, return 1
//     if (s.charAt(i) == '0')    return 0;
//     if (i < s.length() - 1 && Integer.valueOf(s.substring(i, i + 2) < 26) 
//         return dfs(s, i + 1) + dfs(s, i + 2);
//     else 
//         return dfs(s, i + 1);
// }


// *************************Follow Up: constant space********************
// Follow up就问 下有没有constant space的解法。
// 这段代码非常非常容易出错！一定要好好看好好写！

// public int numDecodings(String s) {
// 	if (s.length() == 0 || s.charAt(0)=='0') return 0;
//     int dpn_2 = 1, dpn_1 = 1; 
//     for (int i = 1; i < s.length(); i++) {
//         if (s.charAt(i) == '0')    dpn_1 = 0;
//         int tmp = (Integer.valueOf(s.substring(i - 1, i + 1)) <= 26) ? dpn_1 + dpn_2 : dpn_1;
//         dpn_2 = dpn_1;
//         dpn_1 = tmp;
//     }
//     return dpn_1;
// }

// **************************Follow Up**************************
// 如果给的value不连续，比如a:78, b:539, ..., 怎么办。。我说可以 backtracking，然后简单说  下怎么搞。。




// ********变种********
// Return all decode ways

// public List<String> numDecodings(String s) {
//     List<String> res = new ArrayList<>();
//     if (s == null || s.length() == 0)    return res;
//     dfs(res, s, new StringBuilder(), 0);
//     return res;
// }
// private void dfs(List<String> res, String s, StringBuilder sb, int i) {
//     if (i == s.length()) {//if the whole string has been decoded, return 1
//         res.add(sb.toString());
//         return;
//     }
//     if (s.charAt(i) == '0')    return;
//     int length = sb.length();
//     int num1 = Integer.valueOf(s.substring(i, i + 1));
//     dfs(res, s, sb.append((char)('A' + num1 - 1)), i + 1);
//     sb.setLength(length);
//     if (i < s.length() - 1 && Integer.valueOf(s.substring(i, i + 2) <= 26) {
//         int num2 = Integer.valueOf(s.substring(i, i + 2));
//         dfs(res, s, sb.append((char)('A' + num2 - 1)), i + 2);
//         sb.setLength(length);
//     }
// }


