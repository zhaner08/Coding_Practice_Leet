/*
 * [275] H-Index II
 *
 * https://leetcode.com/problems/h-index-ii/description/
 *
 * algorithms
 * Medium (34.92%)
 * Total Accepted:    62.4K
 * Total Submissions: 178.6K
 * Testcase Example:  '[]'
 *
 * 
 * Follow up for H-Index: What if the citations array is sorted in ascending
 * order? Could you optimize your algorithm?
 * 
 */
public class Solution {
    public int hIndex(int[] citations) {
        //Use Binary Search
        int length = citations.length;
        int left = 0; int right = length-1;
        int mid = 0;
        while(left<=right)
        {
            mid = (left+right)/2;
            //If ==, means no other H can be found, since h and array goes in opposite direction
            if(citations[mid] == length-mid) 
            {
                return length-mid;
            }
            //if mid > h, look leftward, maybe more
            else if(citations[mid] > length-mid)
            {
                right=mid-1;
            }
            else
            {
                //eventually left is the approriate value, if no, then left+1 is the right place, if same, will not come to this
                left=mid+1;
            }
        }
        return length-left;
    }
}

//Normal way, O(n) slow
        // int length = citations.length;
        // for(int i=0; i<length; i++)
        // {
        //     if(citations[i]>=length-i) return length-i;
        // }
        // return 0;
