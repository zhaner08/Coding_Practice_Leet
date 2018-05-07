/*
 * [395] Longest Substring with At Least K Repeating Characters
 *
 * https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/description/
 *
 * algorithms
 * Medium (35.72%)
 * Total Accepted:    25.6K
 * Total Submissions: 71.6K
 * Testcase Example:  '"aaabb"\n3'
 *
 * 
 * Find the length of the longest substring T of a given string (consists of
 * lowercase letters only) such that every character in T appears no less than
 * k times.
 * 
 * 
 * Example 1:
 * 
 * Input:
 * s = "aaabb", k = 3
 * 
 * Output:
 * 3
 * 
 * The longest substring is "aaa", as 'a' is repeated 3 times.
 * 
 * 
 * 
 * Example 2:
 * 
 * Input:
 * s = "ababbc", k = 2
 * 
 * Output:
 * 5
 * 
 * The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is
 * repeated 3 times.
 * 
 * 
 */
class Solution {
    public int longestSubstring(String s, int k) {
        char[] input = s.toCharArray();
        return helper(input, k, 0, input.length);
    }
    
    public int helper(char[] input, int k, int start, int end){
        //when less than k letters left
        if(end-start<k) return 0;
        //count the total number of each
        int[] counters = new int[26];
        for(int i=start; i<end; i++){
            counters[input[i]-'a']++;
        }
        
        //if any letter has count less than k, meaning we need ti split at possible every that letter
        // for(int i = start; i<end; i++){
        //     if(counters[input[i]-'a']<k){
        //         int left = helper(input, k, start, i);
        //         int right = helper(input, k, i+1, end);
        //         return Math.max(left, right);
        //     }
        // }
        
        //divide by letter instead
        for(int i=0; i<26; i++){
            //if less than k
            if(counters[i]<k && counters[i]>0){
                for(int j=start; j<end; j++){
                    //if find the letter
                    if(input[j]== i+'a'){
                        int left = helper(input, k, start, j);
                        int right = helper(input, k, j+1, end);
                        return Math.max(left, right);
                    }
                }
            }
        }
        return end-start;
    }
}

//ON solution

//     public int longestSubstring(String s, int k) {
//         char[] str = s.toCharArray();
//         int[] counts = new int[26];
//         int h, i, j, idx, max = 0, unique, noLessThanK;
        
//         for (h = 1; h <= 26; h++) {
//             Arrays.fill(counts, 0);
//             i = 0; 
//             j = 0;
//             unique = 0;
//             noLessThanK = 0;
//             while (j < str.length) {
//                 if (unique <= h) {
//                     idx = str[j] - 'a';
//                     if (counts[idx] == 0)
//                         unique++;
//                     counts[idx]++;
//                     if (counts[idx] == k)
//                         noLessThanK++;
//                     j++;
//                 }
//                 else {
//                     idx = str[i] - 'a';
//                     if (counts[idx] == k)
//                         noLessThanK--;
//                     counts[idx]--;
//                     if (counts[idx] == 0)
//                         unique--;
//                     i++;
//                 }
//                 if (unique == h && unique == noLessThanK)
//                     max = Math.max(j - i, max);
//             }
//         }
        
//         return max;
//     }
