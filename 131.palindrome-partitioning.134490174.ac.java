/*
 * [131] Palindrome Partitioning
 *
 * https://leetcode.com/problems/palindrome-partitioning/description/
 *
 * algorithms
 * Medium (35.89%)
 * Total Accepted:    120.8K
 * Total Submissions: 336.6K
 * Testcase Example:  '"aab"'
 *
 * Given a string s, partition s such that every substring of the partition is
 * a palindrome.
 * 
 * Return all possible palindrome partitioning of s.
 * 
 * Example:
 * 
 * 
 * Input: "aab"
 * Output:
 * [
 * ⁠ ["aa","b"],
 * ⁠ ["a","a","b"]
 * ]
 * 
 * 
 */
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<List<String>>();
        phelper( s, result, new ArrayList<String>());
        return result;
    }
    
    public void phelper(String s, List<List<String>> result, List<String> cur){
        if(s.length()==0){
            result.add(new ArrayList(cur));
            return;
        }
        
        for(int i=1; i<=s.length(); i++){
            if(helper(s.substring(0, i))){
                cur.add(s.substring(0, i));
                phelper(s.substring(i, s.length()), result, cur);
                cur.remove(cur.size()-1);
            }
        }
    }
    
    public boolean helper(String s){
        int left =0;
        int right =0;
        int mid = 0+s.length()/2;
        if(s.length()%2==0){
            left = mid-1;
            right = mid;
        }else{
            left = right = mid;
        }
        while(left>=0 && right<s.length()){
            if(s.charAt(left)!= s.charAt(right)) return false;
            left--;
            right++;
        }
        return true;
    }
}
