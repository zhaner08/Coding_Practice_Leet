/*
 * [383] Ransom Note
 *
 * https://leetcode.com/problems/ransom-note/description/
 *
 * algorithms
 * Easy (47.87%)
 * Total Accepted:    79.3K
 * Total Submissions: 165.7K
 * Testcase Example:  '"a"\n"b"'
 *
 * 
 * Given an arbitrary ransom note string and another string containing letters
 * from all the magazines, write a function that will return true if the
 * ransom 
 * note can be constructed from the magazines ; otherwise, it will return
 * false. 
 * 
 * 
 * Each letter in the magazine string can only be used once in your ransom
 * note.
 * 
 * 
 * Note:
 * You may assume that both strings contain only lowercase letters.
 * 
 * 
 * 
 * canConstruct("a", "b") -> false
 * canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 * 
 * 
 */
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] map = new int[26];
        int length = ransomNote.length();
        if(length==0) return true;
        for(int i=0; i<length; i++){
            map[ransomNote.charAt(i)-'a']++;
        }
        int start = 0;
        
        for(int i=0; i<magazine.length(); i++){
            if(map[magazine.charAt(i)-'a']>0){
                map[magazine.charAt(i)-'a']--;
                length--;
            }
            if(length==0) return true;
        }
        return false;
    }
}
