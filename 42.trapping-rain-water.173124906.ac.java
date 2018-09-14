/*
 * [42] Trapping Rain Water
 *
 * https://leetcode.com/problems/trapping-rain-water/description/
 *
 * algorithms
 * Hard (37.74%)
 * Total Accepted:    167K
 * Total Submissions: 442.4K
 * Testcase Example:  '[0,1,0,2,1,0,1,3,2,1,2,1]'
 *
 * Given n non-negative integers representing an elevation map where the width
 * of each bar is 1, compute how much water it is able to trap after raining.
 * 
 * 
 * The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1].
 * In this case, 6 units of rain water (blue section) are being trapped. Thanks
 * Marcos for contributing this image!
 * 
 * Example:
 * 
 * 
 * Input: [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 */
class Solution {
    //Tag:All
    //Tag:Array
    //Tag:TwoPointer
    //Tag:Stack
    public int trap(int[] height) {
        if(height == null || height.length<3) return 0;
        int left = 0;
        int right = height.length-1;
        int leftMax = 0;
        int rightMax = 0;
        int total = 0;
        while(left<=right){
            //The side we dont take care will alwasy be maximum of all time so far, that is why we only handle one side's maximum at a time
            if(height[left]<height[right]){
                    if(height[left]<leftMax){
                        total+=leftMax-height[left];
                    }else{
                        leftMax=height[left];
                    }
                left++;
            }else{
                    if(height[right]<rightMax){
                        total+=rightMax-height[right];
                    }else{
                        rightMax=height[right];
                    }
                right--;
            }
        }
        return total;
    }
}
