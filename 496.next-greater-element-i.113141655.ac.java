/*
 * [496] Next Greater Element I
 *
 * https://leetcode.com/problems/next-greater-element-i/description/
 *
 * algorithms
 * Easy (56.56%)
 * Total Accepted:    56K
 * Total Submissions: 99.1K
 * Testcase Example:  '[4,1,2]\n[1,3,4,2]'
 *
 * 
 * You are given two arrays (without duplicates) nums1 and nums2 where nums1’s
 * elements are subset of nums2. Find all the next greater numbers for nums1's
 * elements in the corresponding places of nums2. 
 * 
 * 
 * 
 * The Next Greater Number of a number x in nums1 is the first greater number
 * to its right in nums2. If it does not exist, output -1 for this number.
 * 
 * 
 * Example 1:
 * 
 * Input: nums1 = [4,1,2], nums2 = [1,3,4,2].
 * Output: [-1,3,-1]
 * Explanation:
 * ⁠   For number 4 in the first array, you cannot find the next greater number
 * for it in the second array, so output -1.
 * ⁠   For number 1 in the first array, the next greater number for it in the
 * second array is 3.
 * ⁠   For number 2 in the first array, there is no next greater number for it
 * in the second array, so output -1.
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: nums1 = [2,4], nums2 = [1,2,3,4].
 * Output: [3,-1]
 * Explanation:
 * ⁠   For number 2 in the first array, the next greater number for it in the
 * second array is 3.
 * ⁠   For number 4 in the first array, there is no next greater number for it
 * in the second array, so output -1.
 * 
 * 
 * 
 * 
 * Note:
 * 
 * All elements in nums1 and nums2 are unique.
 * The length of both nums1 and nums2 would not exceed 1000.
 * 
 * 
 */
public class Solution {
    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        //same as II, use stack, then read from hashmap to find its next biggest, since no duplicate, and subarray
        Map<Integer, Integer> m = new HashMap<Integer,Integer>();
        Stack<Integer> s = new Stack<Integer>();
        int length1 = nums.length;
        if(length1==0) return new int[0];
        int length2= findNums.length;
        if(length2==0) return new int[0];
        
        s.push(nums[0]);
        for(int i=1; i<length1; i++){
            while(!s.isEmpty() && s.peek()<nums[i])
                m.put(s.pop(), nums[i]);
            s.push(nums[i]);
        }
        
        for(int i=0; i<length2; i++){
            findNums[i] = m.getOrDefault(findNums[i], -1);
        }
        
        return findNums;
    }
}
