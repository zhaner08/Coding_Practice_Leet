/*
 * [349] Intersection of Two Arrays
 *
 * https://leetcode.com/problems/intersection-of-two-arrays/description/
 *
 * algorithms
 * Easy (48.31%)
 * Total Accepted:    132K
 * Total Submissions: 273.3K
 * Testcase Example:  '[]\n[]'
 *
 * 
 * Given two arrays, write a function to compute their intersection.
 * 
 * 
 * Example:
 * Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
 * 
 * 
 * Note:
 * 
 * Each element in the result must be unique.
 * The result can be in any order.
 * 
 * 
 */
public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        //Find which elements are in both list
        Set<Integer> n1 = new HashSet<Integer>();
        Set<Integer> n2 = new HashSet<Integer>();
        //insert all number in nums1 to n1
        for(int i=0; i<nums1.length; i++)
        {
            n1.add(nums1[i]);
        }
        for(int j=0; j<nums2.length; j++)
        {
            if(n1.contains(nums2[j]))
            n2.add(nums2[j]);
        }
        //Convert set to list
        int[] result = new int[n2.size()];
        int k=0;
        for(Integer tmp:n2)
        {
            result[k++] = tmp;
        }
        return result;
    }
}
