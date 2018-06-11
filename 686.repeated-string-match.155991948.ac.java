/*
 * [686] Repeated String Match
 *
 * https://leetcode.com/problems/repeated-string-match/description/
 *
 * algorithms
 * Easy (31.69%)
 * Total Accepted:    31.8K
 * Total Submissions: 100.3K
 * Testcase Example:  '"abcd"\n"cdabcdab"'
 *
 * Given two strings A and B, find the minimum number of times A has to be
 * repeated such that B is a substring of it. If no such solution, return -1.
 * 
 * 
 * For example, with A = "abcd" and B = "cdabcdab". 
 * 
 * 
 * Return 3, because by repeating A three times (“abcdabcdabcd”), B is a
 * substring of it; and B is not a substring of A repeated two times
 * ("abcdabcd").
 * 
 * 
 * Note:
 * The length of A and B will be between 1 and 10000.
 * 
 */
class Solution {
    //Tag:Google
    //Tag:String
    public int repeatedStringMatch(String A, String B) {
        //Create a really long stringbuilder contains multiple A
        int count=0;
        StringBuilder sb = new StringBuilder();
        //After this loop, two possible: exact match or with extra characters smaller than one A world
        while(sb.length()<B.length()){
            sb.append(A);
            count++;
        }
        //check if already got one
        if(sb.toString().contains(B)) return count;
        //if extra characters more than one character(has to be less than 2 characters), then return count+1
        if(sb.append(A).toString().contains(B)) return ++count;
        return -1;
    }
}
