/*
 * [93] Restore IP Addresses
 *
 * https://leetcode.com/problems/restore-ip-addresses/description/
 *
 * algorithms
 * Medium (28.57%)
 * Total Accepted:    103.9K
 * Total Submissions: 363.6K
 * Testcase Example:  '"25525511135"'
 *
 * Given a string containing only digits, restore it by returning all possible
 * valid IP address combinations.
 * 
 * Example:
 * 
 * 
 * Input: "25525511135"
 * Output: ["255.255.11.135", "255.255.111.35"]
 * 
 * 
 */
public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<String>();
        int len = s.length();
        //start from 1 because substring not include 1
        //the shortest possible is 1111, so len-2 is shortest so leave 3 more digits to the rest
        for(int i = 1; i<4 && i<len-2; i++){
            for(int j = i+1; j<i+4 && j<len-1; j++){
                for(int k = j+1; k<j+4 && k<len; k++){
                    //Take substring, and do validation for each of them, if all good ,add to the answer.
                    String s1 = s.substring(0,i), s2 = s.substring(i,j), s3 = s.substring(j,k), s4 = s.substring(k,len);
                    if(isValid(s1) && isValid(s2) && isValid(s3) && isValid(s4)){
                        res.add(s1+"."+s2+"."+s3+"."+s4);
                    }
                }
            }
        }
        return res;
    }
    
    //Simple validation, can not be more than 3, can not be start with 0, can not be >255
    public boolean isValid(String s){
        if(s.length()>3 || s.length()==0 || (s.charAt(0)=='0' && s.length()>1) || Integer.parseInt(s)>255)
            return false;
        return true;
    }
}
