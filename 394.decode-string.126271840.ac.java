/*
 * [394] Decode String
 *
 * https://leetcode.com/problems/decode-string/description/
 *
 * algorithms
 * Medium (42.09%)
 * Total Accepted:    53.3K
 * Total Submissions: 126.7K
 * Testcase Example:  '"3[a]2[bc]"'
 *
 * 
 * Given an encoded string, return it's decoded string.
 * 
 * 
 * The encoding rule is: k[encoded_string], where the encoded_string inside the
 * square brackets is being repeated exactly k times. Note that k is guaranteed
 * to be a positive integer.
 * 
 * 
 * You may assume that the input string is always valid; No extra white spaces,
 * square brackets are well-formed, etc.
 * 
 * Furthermore, you may assume that the original data does not contain any
 * digits and that digits are only for those repeat numbers, k. For example,
 * there won't be input like 3a or 2[4].
 * 
 * 
 * Examples:
 * 
 * s = "3[a]2[bc]", return "aaabcbc".
 * s = "3[a2[c]]", return "accaccacc".
 * s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
 * 
 * 
 */
class Solution {
    public String decodeString(String s) {
        int count = 0;
        StringBuilder sb = new StringBuilder();
        
        Stack<Integer> countStack = new Stack<Integer>();
        Stack<String> StringStack = new Stack<String>();
        
        int length = s.length();
        int i=0;
        while(i<length){
            if(Character.isDigit(s.charAt(i))){
                //if find number, meaning the rest will be multiplied, so take the number and put in stack
                int tmp = i;
                while(Character.isDigit(s.charAt(tmp))){
                    tmp++;
                }
                count = Integer.parseInt(s.substring(i, tmp));
                i = tmp;
                countStack.push(count);
            } else if(s.charAt(i)=='['){
                //take the previous string into stack, since we are using it later
                StringStack.push(sb.toString());
                sb.setLength(0);
                i++;
            } else if(s.charAt(i)==']'){
                //we need to take the count, and copy it multiple times
                String t = sb.toString();
                int tcount = countStack.pop();
                //take previous push string
                StringBuilder sbTemp = new StringBuilder(StringStack.pop());
                for(int h=0; h<tcount; h++){
                    sbTemp.append(t);
                }
                //set the original string back
                sb = sbTemp;
                i++;
            } else{
                sb.append(s.charAt(i++));
            }
        }
        return sb.toString();
    }
}
