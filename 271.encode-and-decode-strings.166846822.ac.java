/*
 * [271] Encode and Decode Strings
 *
 * https://leetcode.com/problems/encode-and-decode-strings/description/
 *
 * algorithms
 * Medium (25.86%)
 * Total Accepted:    31.2K
 * Total Submissions: 120.5K
 * Testcase Example:  '[]'
 *
 * 
 * Design an algorithm to encode a list of strings to a string. The encoded
 * string is then sent over the network and is decoded back to the original
 * list of strings.
 * 
 * 
 * Machine 1 (sender) has the function:
 * 
 * string encode(vector<string> strs) {
 * ⁠ // ... your code
 * ⁠ return encoded_string;
 * }
 * 
 * Machine 2 (receiver) has the function:
 * 
 * vector<string> decode(string s) {
 * ⁠ //... your code
 * ⁠ return strs;
 * }
 * 
 * 
 * 
 * So Machine 1 does:
 * string encoded_string = encode(strs);
 * 
 * 
 * 
 * and Machine 2 does:
 * vector<string> strs2 = decode(encoded_string);
 * 
 * 
 * 
 * strs2 in Machine 2 should be the same as strs in Machine 1.
 * 
 * 
 * Implement the encode and decode methods.
 * 
 * 
 * Note:
 * 
 * The string may contain any possible characters out of 256 valid ascii
 * characters. Your algorithm should be generalized enough to work on any
 * possible characters.
 * Do not use class member/global/static variables to store states. Your encode
 * and decode algorithms should be stateless.
 * Do not rely on any library method such as eval or serialize methods. You
 * should implement your own encode/decode algorithm.
 * 
 */
public class Codec {
    //Tag:Amazon
    //Tag:Google
    //Tag:String
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb  = new StringBuilder();
        for(String s : strs){
            sb.append(s.length()).append("/").append(s);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> result = new ArrayList<String>();
        int i=0;
        while(i<s.length()){
            //add i in indexOf to make sure where to start to find "/"
            int index = s.indexOf("/", i);
            int length = Integer.valueOf(s.substring(i, index));
            i = index+length+1;
            result.add(s.substring(index+1, index+length+1));
        }
        return result;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));
