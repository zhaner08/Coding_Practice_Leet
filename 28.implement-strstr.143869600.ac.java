/*
 * [28] Implement strStr()
 *
 * https://leetcode.com/problems/implement-strstr/description/
 *
 * algorithms
 * Easy (29.09%)
 * Total Accepted:    270.9K
 * Total Submissions: 931.4K
 * Testcase Example:  '"hello"\n"ll"'
 *
 * Implement strStr().
 * 
 * Return the index of the first occurrence of needle in haystack, or -1 if
 * needle is not part of haystack.
 * 
 * Example 1:
 * 
 * 
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: haystack = "aaaaa", needle = "bba"
 * Output: -1
 * 
 * 
 * Clarification:
 * 
 * What should we return when needle is an empty string? This is a great
 * question to ask during an interview.
 * 
 * For the purpose of this problem, we will return 0 when needle is an empty
 * string. This is consistent to C's strstr() and Java's indexOf().
 * 
 */
class Solution {
    public int strStr(String haystack, String needle) {
        int l1 = haystack.length();
        int l2 = needle.length();
        for(int i=0; i<l1-l2+1; i++){
            for(int j=0; j<=l2; j++){
                if(j==l2) return i;
                if(haystack.charAt(i+j)!=needle.charAt(j)) break;
            }
        }
        return -1;
    }
}


// *******变种*******
// find the first index in haystack that starts with an anagram of needle
// assume only lowercase letters in strings

// O(mn) time, O(m) space

// public int strStr(String haystack, String needle) {
//     if (needle.length() == 0)    return 0;
//     int m = haystack.length(), n = needle.length();
//     HashMap<String, Integer> map = new HashMap<>();
//     for (int i = 0; i <= m - n; i++) {//we use m - n to reduce time; should be <=, not < !
//         String key = createKey(haystack, i, n);
//         if (!map.containsKey(key)) 
//             map.put(key, i);
//     }
//     String target = createKey(needle, 0, n);
//     return map.containsKey(target) ? map.get(target) : -1;
// }

// private String createKey(String s, int start, int length) {
//     int[] count = new int[26]; //see this as O(1) space
//     for (int i = 0; i < length; i++) //O(n) time
//         count[s.charAt(start + i) - 'a']++;
//     String key = "";
//     for (int j = 0; j < count.length; j++) //see this as O(1) time
//         if (count[j] != 0) 
//             key += String.valueOf(count[j]) + String.valueOf((char)('a' + j));
//     return key;
// }
