/*
 * [324] Wiggle Sort II
 *
 * https://leetcode.com/problems/wiggle-sort-ii/description/
 *
 * algorithms
 * Medium (26.48%)
 * Total Accepted:    39.3K
 * Total Submissions: 148.4K
 * Testcase Example:  '[1,5,1,1,6,4]'
 *
 * 
 * ⁠   Given an unsorted array nums, reorder it such that
 * ⁠   nums[0] < nums[1] > nums[2] < nums[3]....
 * 
 * 
 * 
 * ⁠   Example:
 * ⁠   (1) Given nums = [1, 5, 1, 1, 6, 4], one possible answer is [1, 4, 1, 5,
 * 1, 6]. 
 * ⁠   (2) Given nums = [1, 3, 2, 2, 3, 1], one possible answer is [2, 3, 1, 3,
 * 1, 2].
 * 
 * 
 * 
 * ⁠   Note:
 * ⁠   You may assume all input has valid answer.
 * 
 * 
 * 
 * ⁠   Follow Up:
 * ⁠   Can you do it in O(n) time and/or in-place with O(1) extra space?
 * 
 * 
 * Credits:Special thanks to @dietpepsi for adding this problem and creating
 * all test cases.
 */
public class Solution {
    public void wiggleSort(int[] nums) {
        int numsLength = nums.length;
        //Find the median, left could be same, right must be larger, so pair with small-> large. 6 items-2, 6items-3
        int med = findKthSmallestEle(nums, 0, numsLength-1, (numsLength+1)/2-1);
        //Do in place swap to rewire
        int left = 0, i = 0, right = numsLength-1;
        while(i<= right)
        {
            //left is odd number that are ready to be exchange, next place need to have a large number
            //right is even number from right need to be exchange
            //i is going through all element until meet right, which means all other elements been tested
            //if equals median, leave it there, so only increase i
            if (nums[newIndex(i,numsLength)] > med) {
                swap(nums, newIndex(left++,numsLength), newIndex(i++,numsLength));
            }
            else if (nums[newIndex(i,numsLength)] < med) {
                swap(nums, newIndex(right--,numsLength), newIndex(i,numsLength));
            }
            else {
                i++;
            }
        }
    }
    
    //To find 1-3-5-0-2-4, just remember it
    private int newIndex(int index, int n) {
        return (1 + 2*index) % (n | 1);
    }
    
    private int findKthSmallestEle(int[] nums, int left, int right, int k)
    {
        int index = partition(nums, left, right);
        
        if(index<k) return findKthSmallestEle(nums, index+1, right, k);
        else if (index>k) return findKthSmallestEle(nums, left, index-1, k);
        else return nums[index];
    }
    
    private int partition(int[] nums, int left, int right)
    {
        //pivot is left most number, which will finally be moved
        //lo keep track of number need to be move to left, which is larger than pivot
        //lo is looking for number that are smaller or equall to pivot, so can be exchanged with hi, until before pivot
        int pivot = nums[left];
        int hi = right;
        for(int lo=right; lo > left; lo--)
        {
            //since hi need to be exchanged, when lo is larger than pivot, exchange hi with lo, even when they are pointing at same node
            if(nums[lo] < pivot)
            {
                swap(nums, lo, hi);
                hi--;
            }
        }
        //swap the pivot with lo, since hi is larger than pivot
        swap(nums, left, hi);
        //return cut index
        return hi;
    }
    
    private void swap(int[] nums, int i, int j)
    {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
