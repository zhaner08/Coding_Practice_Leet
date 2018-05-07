/*
 * [567] Permutation in String
 *
 * https://leetcode.com/problems/permutation-in-string/description/
 *
 * algorithms
 * Medium (36.24%)
 * Total Accepted:    21.3K
 * Total Submissions: 58.8K
 * Testcase Example:  '"ab"\n"eidbaooo"'
 *
 * Given two strings s1 and s2, write a function to return true if s2 contains
 * the permutation of s1. In other words, one of the first string's
 * permutations is the substring of the second string.
 * 
 * Example 1:
 * 
 * Input:s1 = "ab" s2 = "eidbaooo"
 * Output:True
 * Explanation: s2 contains one permutation of s1 ("ba").
 * 
 * 
 * 
 * Example 2:
 * 
 * Input:s1= "ab" s2 = "eidboaoo"
 * Output: False
 * 
 * 
 * 
 * Note:
 * 
 * The input strings only contain lower case letters.
 * The length of both given strings is in range [1, 10,000].
 * 
 * 
 */
public class Solution {
    public boolean checkInclusion(String s1, String s2) {
        //this is a better way, instead of m*n running time, we can take n*26, we go over character in s2 only once, and remove the one that past the length, and check if 0 every time ,which take 26
        int[] s1c = new int[26];//26 letters
        int s1Length = s1.length();
        if(s1Length>s2.length()) return false;
        for(int i=0; i<s1Length; i++){
            s1c[s1.charAt(i)-'a']++;
            s1c[s2.charAt(i)-'a']--;
        }
        if(checkIfAllZero(s1c)) return true;
        
        
        for(int i=s1Length; i<s2.length(); i++){
            s1c[s2.charAt(i)-'a']--;
            s1c[s2.charAt(i-s1Length)-'a']++;
            if(checkIfAllZero(s1c)) return true;
        }
        return false;
    }
    
    public boolean checkIfAllZero(int[] input){
        for(int i:input){
            if(i!=0){
                return false;
            }
        }
        return true;
    }
}
    
    
    
    
//     public boolean checkInclusion(String s1, String s2) {
//         //put the all characters in s1 into an array;
//         int[] s1c = new int[26];//26 letters
//         int s1Length = s1.length();
//         for(int i=0; i<s1Length; i++){
//             s1c[s1.charAt(i)-'a']++;
//         }
        
//         for(int i=0; i<s2.length()-s1Length+1; i++){
//             int[] s1cTemp = s1c.clone();
//             boolean valid = false;
//             int j = i+s1Length-1;
//             while(j>=i){
//                 if(s1cTemp[s2.charAt(j)-'a']==0){
//                     break;
//                 }else{
//                     s1cTemp[s2.charAt(j)-'a']--;
//                     j--;
//                 }
//             }
//             if(j==i-1) return true;
//         }
//         return false;
