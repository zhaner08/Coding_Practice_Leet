/*
 * [318] Maximum Product of Word Lengths
 *
 * https://leetcode.com/problems/maximum-product-of-word-lengths/description/
 *
 * algorithms
 * Medium (45.83%)
 * Total Accepted:    62.9K
 * Total Submissions: 137.2K
 * Testcase Example:  '["abcw","baz","foo","bar","xtfn","abcdef"]'
 *
 * 
 * ⁠   Given a string array words, find the maximum value of length(word[i]) *
 * length(word[j]) where the two words do not share common letters.
 * ⁠   You may assume that each word will contain only lower case letters.
 * ⁠   If no such two words exist, return 0.
 * 
 * 
 * 
 * ⁠   Example 1:
 * 
 * 
 * ⁠   Given ["abcw", "baz", "foo", "bar", "xtfn", "abcdef"]
 * ⁠   Return 16
 * ⁠   The two words can be "abcw", "xtfn".
 * 
 * 
 * ⁠   Example 2:
 * 
 * 
 * ⁠   Given ["a", "ab", "abc", "d", "cd", "bcd", "abcd"]
 * ⁠   Return 4
 * ⁠   The two words can be "ab", "cd".
 * 
 * 
 * ⁠   Example 3:
 * 
 * 
 * ⁠   Given ["a", "aa", "aaa", "aaaa"]
 * ⁠   Return 0
 * ⁠   No such pair of words.    
 * 
 * 
 * Credits:Special thanks to @dietpepsi for adding this problem and creating
 * all test cases.
 */
public class Solution {
    public int maxProduct(String[] words) {
        //32 bits total, 26 max needed, assign that pos to 1, so order does not matter
        if (words==null || words.length ==0) return 0;
        int l = words.length;
        int[] w = new int[l];
        for(int i=0; i<l; i++)
        {
            String tmp = words[i];
            for(int j =0; j<tmp.length(); j++)
            {
                w[i] |= 1 << tmp.charAt(j);
            }
        }
        
        //NlogN
        int r = 0;
        for(int i=0; i<l; i++)
        {
            for(int j=i+1; j<l; j++)
            {
                if((w[i]&w[j]) == 0 && words[i].length() * words[j].length()> r)
                {
                    r = words[i].length() * words[j].length();
                }
            }
        }
        return r;
    }
}
