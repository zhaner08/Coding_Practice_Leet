/*
 * [434] Number of Segments in a String
 *
 * https://leetcode.com/problems/number-of-segments-in-a-string/description/
 *
 * algorithms
 * Easy (36.57%)
 * Total Accepted:    38.5K
 * Total Submissions: 105.2K
 * Testcase Example:  '"Hello, my name is John"'
 *
 * Count the number of segments in a string, where a segment is defined to be a
 * contiguous sequence of non-space characters.
 * 
 * Please note that the string does not contain any non-printable characters.
 * 
 * Example:
 * 
 * Input: "Hello, my name is John"
 * Output: 5
 * 
 * 
 */
class Solution {
    public int countSegments(String s) {
        s=s.trim();
        if(s.length()==0) return 0;
        int count = 0;
        boolean whitespace = false;
        for(int i =0; i<s.length(); i++){
            if(s.charAt(i)==' '){
                whitespace = true;
            }else{
                if(whitespace){
                    count++;
                    whitespace=false;
                }
            }
        }
        return count+1;
    }
}


// public int countSegments(String s) {
//     int res=0;
//     for(int i=0; i<s.length(); i++)
//         if(s.charAt(i)!=' ' && (i==0 || s.charAt(i-1)==' '))
//             res++;        
//     return res;
// }
