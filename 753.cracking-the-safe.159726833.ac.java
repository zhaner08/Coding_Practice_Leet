/*
 * [754] Cracking the Safe
 *
 * https://leetcode.com/problems/cracking-the-safe/description/
 *
 * algorithms
 * Hard (40.54%)
 * Total Accepted:    5.1K
 * Total Submissions: 12.5K
 * Testcase Example:  '1\n1'
 *
 * 
 * There is a box protected by a password.  The password is n digits, where
 * each letter can be one of the first k digits 0, 1, ..., k-1.
 * 
 * You can keep inputting the password, the password will automatically be
 * matched against the last n digits entered.
 * 
 * For example, assuming the password is "345", I can open it when I type
 * "012345", but I enter a total of 6 digits.
 * 
 * Please return any string of minimum length that is guaranteed to open the
 * box after the entire string is inputted.
 * 
 * 
 * Example 1:
 * 
 * Input: n = 1, k = 2
 * Output: "01"
 * Note: "10" will be accepted too.
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: n = 2, k = 2
 * Output: "00110"
 * Note: "01100", "10011", "11001" will be accepted too.
 * 
 * 
 * 
 * Note:
 * 
 * n will be in the range [1, 4].
 * k will be in the range [1, 10].
 * k^n will be at most 4096.
 * 
 * 
 */
class Solution {
    //Tag:Google
    //Tag:Math
    //Tag:DFS
    public String crackSafe(int n, int k) {
        //can use De Debruijin Sequence, but too narrow
        //in reality, brute force works fine, back track will gurantee a answer
        
        //Total possible number of answer
        int totalNumAnswer = (int)Math.pow(k, n);
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            sb.append('0');
        }
        //set init state and use hashset to track the number that have already been went through
        Set<String> s = new HashSet<String>();
        s.add(sb.toString());
        //start from 1 since '000...' is not removable
        dfs(sb, s, totalNumAnswer, n, k);
        return sb.toString();
    }
    
    public boolean dfs(StringBuilder sb, Set<String> s, int totalNumAnswer, int n, int k){
        //if went through all possible number, return
        if(s.size() ==totalNumAnswer) return true;
        
        //loop to get the next possible string
        String newString = sb.substring(sb.length()-n+1);
        for(int i=0; i<k; i++){
            //generate new string
            String tmp =  newString + i;
            if(!s.contains(tmp)){
                s.add(tmp);
                //DFS
                sb.append(i);
                boolean gotAns = dfs(sb, s, totalNumAnswer, n, k);
                if(gotAns) return true;
                //if havent found answer, reset string
                s.remove(tmp);
                //sb.setLength(sb.length()-1);
                sb.setLength(sb.length() - 1);
            }
        }
        return false;
    }
}
