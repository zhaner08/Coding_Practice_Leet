/*
 * [347] Top K Frequent Elements
 *
 * https://leetcode.com/problems/top-k-frequent-elements/description/
 *
 * algorithms
 * Medium (49.71%)
 * Total Accepted:    104.9K
 * Total Submissions: 210.9K
 * Testcase Example:  '[1,1,1,2,2,3]\n2'
 *
 * 
 * Given a non-empty array of integers, return the k most frequent elements.
 * 
 * For example,
 * Given [1,1,1,2,2,3] and k = 2, return [1,2].
 * 
 * 
 * Note: 
 * 
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * Your algorithm's time complexity must be better than O(n log n), where n is
 * the array's size.
 * 
 */
class Solution {
    //Tag:All
    //Tag:HashTable
    //Tag:Heap
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> m = new HashMap<Integer, Integer>();
        for(int i=0; i<nums.length; i++){
            m.put(nums[i], m.getOrDefault(nums[i], 0)+1);
        }
        
        List[] mem = new List[nums.length+1];
        for(int key : m.keySet()){
            int tmp = m.get(key);//count of k
            if(mem[tmp]==null)  mem[tmp] = new ArrayList<Integer>();
            mem[tmp].add(key);
        }
        
        List<Integer> result = new ArrayList<Integer>();
        for(int i = mem.length-1; i>=0  && k>0 ; i--){
            if(mem[i]!=null){
                result.addAll(mem[i]);
                k-=mem[i].size();
            }
        }
        return result;
    }
}
