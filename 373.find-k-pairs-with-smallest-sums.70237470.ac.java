/*
 * [373] Find K Pairs with Smallest Sums
 *
 * https://leetcode.com/problems/find-k-pairs-with-smallest-sums/description/
 *
 * algorithms
 * Medium (31.40%)
 * Total Accepted:    41.4K
 * Total Submissions: 131.9K
 * Testcase Example:  '[1,7,11]\n[2,4,6]\n3'
 *
 * 
 * You are given two integer arrays nums1 and nums2 sorted in ascending order
 * and an integer k. 
 * 
 * 
 * Define a pair (u,v) which consists of one element from the first array and
 * one element from the second array.
 * 
 * Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.
 * 
 * 
 * Example 1:
 * 
 * Given nums1 = [1,7,11], nums2 = [2,4,6],  k = 3
 * 
 * Return: [1,2],[1,4],[1,6]
 * 
 * The first 3 pairs are returned from the sequence:
 * [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
 * 
 * 
 * 
 * Example 2:
 * 
 * Given nums1 = [1,1,2], nums2 = [1,2,3],  k = 2
 * 
 * Return: [1,1],[1,1]
 * 
 * The first 2 pairs are returned from the sequence:
 * [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
 * 
 * 
 * 
 * Example 3:
 * 
 * Given nums1 = [1,2], nums2 = [3],  k = 3 
 * 
 * Return: [1,3],[2,3]
 * 
 * All possible pairs are returned from the sequence:
 * [1,3],[2,3]
 * 
 * 
 * 
 * Credits:Special thanks to @elmirap and @StefanPochmann for adding this
 * problem and creating all test cases.
 */
public class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        //O(k*m) 
        //Corner case
        List<int[]> r = new ArrayList<int[]>();
        int l = nums1.length;
        int l2 = nums2.length;
        if(l==0 || l2==0 || k==0) return r;
        
        //Create reference to nums[2]
        int[] index12 = new int[l];
        int counter = 0;
        //If still need to find value, or not already reach all elements in 1 and 2
        while(k>0 && counter<l)
        {
            int tmp = Integer.MAX_VALUE;
            int tmpIndex = 0;
            //Test all combination of num1, with its crossponding num2
            for (int i = counter; i<l; i++)
            {
                if((nums1[i] + nums2[index12[i]])<tmp)
                {
                   tmp =  nums1[i] + nums2[index12[i]];
                   tmpIndex = i;
                }
            }
            r.add(new int[]{nums1[tmpIndex], nums2[index12[tmpIndex]]});
            //nums2 index ++
            index12[tmpIndex]++;
            //if num1 check with all num 2, never use num 1 again
            if(index12[tmpIndex]==l2)
            counter++;
            k--;
        }
        return r;
    }
}
