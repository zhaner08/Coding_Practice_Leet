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
    //Tag:Google
    //Tag:Yelp
    //Tag:Coupang
    //Tag:Stack
    //Tag:DFS
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<String> s2 = new Stack<String>();
        int tmpInt = 0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='['){
                //if [, meaning finish number and start character
                s1.push(tmpInt);
                s2.push(sb.toString());
                sb.setLength(0);
                tmpInt=0;
            }else if(Character.isDigit(s.charAt(i))){
                //if digit, update integer
                 tmpInt=tmpInt*10+s.charAt(i)-'0';
            }else if(s.charAt(i)==']'){
                //keep updating string builder, and combine with previous string which stored in stack
                int tmpNum = s1.pop();
                String tmpString = sb.toString();
                sb.setLength(0);
                for(int j=0; j<tmpNum; j++){
                    sb.append(tmpString);
                }
                sb.insert(0, s2.pop());
            }else{
                //if character, update top character on the stack
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
