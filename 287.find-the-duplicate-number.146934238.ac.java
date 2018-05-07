/*
 * [287] Find the Duplicate Number
 *
 * https://leetcode.com/problems/find-the-duplicate-number/description/
 *
 * algorithms
 * Medium (44.39%)
 * Total Accepted:    108.2K
 * Total Submissions: 243.6K
 * Testcase Example:  '[1,1]'
 *
 * 
 * Given an array nums containing n + 1 integers where each integer is between
 * 1 and n (inclusive), prove that at least one duplicate number must exist.
 * Assume that there is only one duplicate number, find the duplicate one.
 * 
 * 
 * 
 * Note:
 * 
 * You must not modify the array (assume the array is read only).
 * You must use only constant, O(1) extra space.
 * Your runtime complexity should be less than O(n2).
 * There is only one duplicate number in the array, but it could be repeated
 * more than once.
 * 
 * 
 * 
 * Credits:Special thanks to @jianchao.li.fighter for adding this problem and
 * creating all test cases.
 */
public class Solution {
    public int findDuplicate(int[] nums) {
        //NlogN time, but can be better, use two pointer can decrease to ON
        int length = nums.length;
        int l = 1;
        int h = length-1;
        while(l!=h)
        {
            int mid = (l+h)/2;
            int count =0;
            for(int i=0; i<length; i++)
            {
                if(nums[i]<=mid) count++;
            }
            if(count> mid) h = mid;
            else l = mid+1;
        }
        return l;
    }
}

//Same as LINKLIST II, one fast, one slow, if jump to the same spot, means there is a duplicate keep it there,
//reset fast to 0, and let the slow goes to there

// 	if (nums.size() > 1)
// 	{
// 		int slow = nums[0];
// 		int fast = nums[nums[0]];
// 		while (slow != fast)
// 		{
// 			slow = nums[slow];
// 			fast = nums[nums[fast]];
// 		}

// 		fast = 0;
// 		while (fast != slow)
// 		{
// 			fast = nums[fast];
// 			slow = nums[slow];
// 		}
// 		return slow;
// 	}
// 	return -1;
