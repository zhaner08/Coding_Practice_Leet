/*
 * [283] Move Zeroes
 *
 * https://leetcode.com/problems/move-zeroes/description/
 *
 * algorithms
 * Easy (51.64%)
 * Total Accepted:    289K
 * Total Submissions: 559.5K
 * Testcase Example:  '[0,1,0,3,12]'
 *
 * 
 * Given an array nums, write a function to move all 0's to the end of it while
 * maintaining the relative order of the non-zero elements.
 * 
 * 
 * 
 * For example, given nums  = [0, 1, 0, 3, 12], after calling your function,
 * nums should be [1, 3, 12, 0, 0].
 * 
 * 
 * 
 * Note:
 * 
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 * 
 * 
 * 
 * Credits:Special thanks to @jianchao.li.fighter for adding this problem and
 * creating all test cases.
 */
class Solution {
    public void moveZeroes(int[] nums) {
        int head = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]!=0) {
                nums[head] = nums[i];
                head++;
            }
        }
        for(int i = head; i<nums.length; i++){
            nums[i]=0;
        }
    }
}

// 代码只需要返回最后有效数组的长度，有效长度之外的数字是什么无所谓，原先input里面的数字不一定要保持原来的相对顺序。
// 1.不用保持非零元素的相对顺序
// 2.不用把0移到右边
// 思路：把右边的非0元素移动到左边的0元素位置。这样就可以minimize writes.

// public int moveZeroesWithMinWrites(int[] nums) {
//     int left = 0, right = nums.length - 1;
//     while (left < right) {
//         while (left < right && nums[left] != 0)		left++;
//         while (left < right && nums[right] == 0)	right--;
//         if (left < right)	nums[left++] = nums[right--];
//     }
//     return left;
// }
