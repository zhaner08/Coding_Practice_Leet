/*
 * [611] Valid Triangle Number
 *
 * https://leetcode.com/problems/valid-triangle-number/description/
 *
 * algorithms
 * Medium (42.04%)
 * Total Accepted:    17.9K
 * Total Submissions: 42.5K
 * Testcase Example:  '[2,2,3,4]'
 *
 * Given an array consists of non-negative integers,  your task is to count the
 * number of triplets chosen from the array that can make triangles if we take
 * them as side lengths of a triangle.
 * 
 * Example 1:
 * 
 * Input: [2,2,3,4]
 * Output: 3
 * Explanation:
 * Valid combinations are: 
 * 2,3,4 (using the first 2)
 * 2,3,4 (using the second 2)
 * 2,2,3
 * 
 * 
 * 
 * Note:
 * 
 * The length of the given array won't exceed 1000.
 * The integers in the given array are in the range of [0, 1000].
 * 
 * 
 * 
 */
public class Solution {
    public int triangleNumber(int[] nums) {
        if(nums.length<3) return 0;
        int count = 0;
        Arrays.sort(nums);
        //O(n^2) running time, set last same, and keep changing left
        for(int i=nums.length-1; i>1; i--){
            int pointer1=0;
            int pointer2=i-1;
            while(pointer1<pointer2){
                if(nums[pointer1]+nums[pointer2]>nums[i]){
                    //this line is the calculation
                    count+=(pointer2-pointer1);
                    pointer2--;
                    //use this to skip all same number
                    while(pointer1<pointer2 && nums[pointer2]==nums[pointer2+1]){
                        count+=(pointer2-pointer1);
                        pointer2--;
                    }
                }else{
                    pointer1++;
                    while(pointer1<pointer2 && nums[pointer1]==nums[pointer1-1])
                    pointer1++;
                }
            }
        }
        return count;
    }
}
