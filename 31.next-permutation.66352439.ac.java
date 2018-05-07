/*
 * [31] Next Permutation
 *
 * https://leetcode.com/problems/next-permutation/description/
 *
 * algorithms
 * Medium (29.09%)
 * Total Accepted:    151.6K
 * Total Submissions: 521K
 * Testcase Example:  '[1,2,3]'
 *
 * Implement next permutation, which rearranges numbers into the
 * lexicographically next greater permutation of numbers.
 * 
 * If such arrangement is not possible, it must rearrange it as the lowest
 * possible order (ie, sorted in ascending order).
 * 
 * The replacement must be in-place and use only constant extra memory.
 * 
 * Here are some examples. Inputs are in the left-hand column and its
 * corresponding outputs are in the right-hand column.
 * 
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 * 
 */
public class Solution {
    public void nextPermutation(int[] nums) {
        //Nothing special in the code, just know how to get the minimum increase
        int length = nums.length;
        if(nums==null || length<2) return;
        //First, find the right most value which is smaller than its +1
        //This value is the value we want to change, since anything on right will make it change 10+*more
        //Every element on the right, if we change, will make it small, since they are sorted in reversed order  987>978
        int i = length-2;
        while(i>=0 && nums[i]>=nums[i+1]) i--;
        //pointer to either -1 or first smaller number by now
        if(i<0) 
        {
            reverseSort(nums, 0, length-1);
            return;
        }
        int j = i+1;
        while(j<length && nums[j]>nums[i]) j++;
        //j countians the swap position
        j--;
        swap(nums, i, j);
        //After do the swap, sort from smallest to largest, so the value increase least
        reverseSort(nums, ++i, length-1);
        
    }
    
    private void reverseSort(int[] nums, int i, int j)
    {
        //Since the nums need to be sorted are already reversed sorted
        while(i<j)
        {
            swap(nums, i++, j--);
        }
    }
    
    private void swap(int[] nums, int i, int j)
    {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
