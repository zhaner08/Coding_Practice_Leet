/*
 * [350] Intersection of Two Arrays II
 *
 * https://leetcode.com/problems/intersection-of-two-arrays-ii/description/
 *
 * algorithms
 * Easy (44.22%)
 * Total Accepted:    108.4K
 * Total Submissions: 245.1K
 * Testcase Example:  '[]\n[]'
 *
 * 
 * Given two arrays, write a function to compute their intersection.
 * 
 * 
 * Example:
 * Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].
 * 
 * 
 * Note:
 * 
 * Each element in the result should appear as many times as it shows in both
 * arrays.
 * The result can be in any order.
 * 
 * 
 * 
 * Follow up:
 * 
 * What if the given array is already sorted? How would you optimize your
 * algorithm?
 * What if nums1's size is small compared to nums2's size? Which algorithm is
 * better?
 * What if elements of nums2 are stored on disk, and the memory is limited such
 * that you cannot load all elements into the memory at once?
 * 
 * 
 */
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> m = new HashMap<Integer, Integer>();
        for(int n:nums1){
            m.put(n, m.getOrDefault(n, 0)+1);
        }
        
        List<Integer> result = new ArrayList<Integer>();
        for(int n:nums2){
            if(m.containsKey(n) && m.get(n)>0){
                result.add(n);
                m.put(n, m.get(n)-1);
            }
        }
        int[] finalr = new int[result.size()];
        for(int i=0; i<result.size(); i++){
            finalr[i] = result.get(i);
        }
        return finalr;
    }
}
