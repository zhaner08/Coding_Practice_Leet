/*
 * [88] Merge Sorted Array
 *
 * https://leetcode.com/problems/merge-sorted-array/description/
 *
 * algorithms
 * Easy (32.24%)
 * Total Accepted:    235.3K
 * Total Submissions: 729.9K
 * Testcase Example:  '[1,2,3,0,0,0]\n3\n[2,5,6]\n3'
 *
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as
 * one sorted array.
 * 
 * Note:
 * 
 * 
 * The number of elements initialized in nums1 and nums2 are m and n
 * respectively.
 * You may assume that nums1 has enough space (size that is greater or equal to
 * m + n) to hold additional elements from nums2.
 * 
 * 
 * Example:
 * 
 * 
 * Input:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * 
 * Output: [1,2,2,3,5,6]
 * 
 * 
 */
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int counter = m+n-1;
        m--;
        n--;
        while(n>=0 && m >=0){
            int n1 = nums1[m];
            int n2 = nums2[n];
            if(n1>n2){
                nums1[counter--] = n1;
                m--;
            }else{
                nums1[counter--] = n2;
                n--;
            }
        }
        
        if(n>=0){
            while(n>=0){
                nums1[n] = nums2[n];
                n--;
            }
        }
        return;
    }
}
