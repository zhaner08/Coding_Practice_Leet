/*
 * [282] Expression Add Operators
 *
 * https://leetcode.com/problems/expression-add-operators/description/
 *
 * algorithms
 * Hard (30.64%)
 * Total Accepted:    47.1K
 * Total Submissions: 153.7K
 * Testcase Example:  '"123"\n6'
 *
 * 
 * Given a string that contains only digits 0-9 and a target value, return all
 * possibilities to add binary operators (not unary) +, -, or * between the
 * digits so they evaluate to the target value.
 * 
 * 
 * Examples: 
 * "123", 6 -> ["1+2+3", "1*2*3"] 
 * "232", 8 -> ["2*3+2", "2+3*2"]
 * "105", 5 -> ["1*0+5","10-5"]
 * "00", 0 -> ["0+0", "0-0", "0*0"]
 * "3456237490", 9191 -> []
 * 
 * 
 * Credits:Special thanks to @davidtan1890 for adding this problem and creating
 * all test cases.
 */
class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<String>();
        if(num==null || num.length()==0) return result;
        dfs(result, num, target, new StringBuilder(), 0, 0, 0);
        return result;
    }
    
    public void dfs(List<String> result, String num, int target, StringBuilder sb, int start, long eval, long mult){
        //if reach target, and go through all number, then add
        if(start==num.length()){
            if(eval == target) {
                result.add(sb.toString());
            }
            return;
        }
        
        for(int i=start; i<num.length(); i++){
            //if start with 0, could be 0 but could not be 02----
            if(i!=start && num.charAt(start)=='0') break;
            
            long tmp = Long.parseLong(num.substring(start, i+1));
            
            //tmp storage to set back
            int length = sb.length();
            
            //if first number, no need to do sign
            if(start==0){
                dfs(result, num, target, sb.append(tmp), i+1, eval+tmp, tmp);
            }else{
                dfs(result, num, target, sb.append("+").append(tmp), i+1, eval+tmp, tmp);
                sb.setLength(length);
                dfs(result, num, target, sb.append("-").append(tmp), i+1, eval-tmp, -tmp);
                sb.setLength(length);
                //if 42*7*7, than first subtract 42*7, than puls 42*7*7
                //if + -, then mul is just the num, if *, mul is the whole mul since the begining
                dfs(result, num, target, sb.append("*").append(tmp), i+1, eval-mult + mult*tmp, mult*tmp);
            }
            sb.setLength(length);
        }
    }
}



// *******简单版*******
// 给1个string “123456789”， 进行arithmetic oepration combination.  
// 如: 123 + 456 + 78 -9 是1种组合， -1 + 2 -3 +4 -5 - 67 + 89 也是1种(只加 + 或 -), 打印出所有结果等于 100 的组合

// Test:
// "1234567" -> ["1+2+34+56+7", "1+23+4+5+67"]

// public List<String> addOperators(String num, int target) {
//     List<String> res = new ArrayList<>();
//     dfs(res, "", num, target, 0, 0);
//     return res;
// }
// private void dfs(List<String> res, String tmp, String nums, int target, int start, long eval) {
//     if (start == nums.length()) {
//         if (eval == target)     res.add(tmp);
//         return;
//     }
//     // dfs call on all numbers starting at position 'start'
//     for (int i = start; i < nums.length(); i++) {
//         if (nums.charAt(start) == '0' && i != start)    break; // '0' cannot be leading number, so stop further dfs
//         long cur = Long.valueOf(nums.substring(start, i + 1));
//         if (start == 0)
//             dfs(res, tmp + cur, nums, target, i + 1, eval + cur);
//         else {
//             dfs(res, tmp + "+" + cur, nums, target, i + 1, eval + cur);
//             dfs(res, tmp + "-" + cur, nums, target, i + 1, eval - cur);
//         }
//     }

