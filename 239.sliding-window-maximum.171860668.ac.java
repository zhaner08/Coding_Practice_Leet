/*
 * [239] Sliding Window Maximum
 *
 * https://leetcode.com/problems/sliding-window-maximum/description/
 *
 * algorithms
 * Hard (34.31%)
 * Total Accepted:    90.2K
 * Total Submissions: 262.9K
 * Testcase Example:  '[1,3,-1,-3,5,3,6,7]\n3'
 *
 * Given an array nums, there is a sliding window of size k which is moving
 * from the very left of the array to the very right. You can only see the k
 * numbers in the window. Each time the sliding window moves right by one
 * position.
 * 
 * For example,
 * Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.
 * 
 * 
 * Window position                Max
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * ⁠1 [3  -1  -3] 5  3  6  7       3
 * ⁠1  3 [-1  -3  5] 3  6  7       5
 * ⁠1  3  -1 [-3  5  3] 6  7       5
 * ⁠1  3  -1  -3 [5  3  6] 7       6
 * ⁠1  3  -1  -3  5 [3  6  7]      7
 * 
 * 
 * Therefore, return the max sliding window as [3,3,5,5,6,7].
 * 
 * Note: 
 * You may assume k is always valid, ie: 1 ≤ k ≤ input array's size for
 * non-empty array.
 * 
 * Follow up:
 * Could you solve it in linear time?
 * 
 */
class Solution {
    //Tag:Amazon
    //Tag:Facebook
    //Tag:Bloomberg
    //Tag:Heap
    public int[] maxSlidingWindow(int[] nums, int k){
        if(nums==null || nums.length==0) return new int[0];
        //if larger, eliminate all previous, since they will never be the max;
        //if keep decreasing, take the head as the max
        
        //deque has all but more(first/last) first is front（head)
        Deque<Integer> dq = new ArrayDeque<Integer>();
        int[] result = new int[nums.length-k+1];
        for(int i=0; i<nums.length; i++){
            int tmp = nums[i];
            
            while(dq.size()!=0){
                if(dq.peekLast()<tmp){
                    dq.removeLast();
                }else{
                    break;
                }
            }
            dq.add(tmp);
            //add first, then remove the earliest one depends on condition
            
            if(i>=k-1){//start to calculate max
                if(i-k>=0 && dq.peek()==nums[i-k]) //start to eliminate number
                dq.removeFirst();
                result[i-k+1]=dq.peek();
                
            }
        }
        return result;
    }
}
