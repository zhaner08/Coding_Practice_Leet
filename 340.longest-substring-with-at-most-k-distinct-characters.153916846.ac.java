/*
 * [340] Longest Substring with At Most K Distinct Characters
 *
 * https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/description/
 *
 * algorithms
 * Hard (38.49%)
 * Total Accepted:    40.2K
 * Total Submissions: 104.5K
 * Testcase Example:  '"eceba"\n2'
 *
 * 
 * Given a string, find the length of the longest substring T that contains at
 * most k distinct characters.
 * 
 * 
 * 
 * For example,
 * 
 * Given s = “eceba” and k = 2,
 * 
 * 
 * 
 * T is "ece" which its length is 3.
 * 
 */
class Solution {
    //Tag:Google  Tag:AppDynamics  Tag:Coupang
    //Tag:HashTable  Tag:String
    
    //Do not use hashtable, use int array instead
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int length = s.length();
        //corner cases
        if(k==0) return 0;
        if(length<k) return length;
        
        //setup paramters
        int start =0;
        int[] map = new int[256];
        int result=0;
        int count =0;
        //main loop
        for(int i=0; i<length; i++){
            if(map[s.charAt(i)]++==0) count++;
            if(count>k){
                while(count>k){
                    if(--map[s.charAt(start)]==0) count--;
                    start++;
                }
            }else{
                result = Math.max(result, i-start+1);
            }
        }
        return result;
    }
}
