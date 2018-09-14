/*
 * [788] Minimize Max Distance to Gas Station
 *
 * https://leetcode.com/problems/minimize-max-distance-to-gas-station/description/
 *
 * algorithms
 * Hard (34.93%)
 * Total Accepted:    4.8K
 * Total Submissions: 13.6K
 * Testcase Example:  '[1,2,3,4,5,6,7,8,9,10]\n9'
 *
 * On a horizontal number line, we have gas stations at positions stations[0],
 * stations[1], ..., stations[N-1], where N = stations.length.
 * 
 * Now, we add K more gas stations so that D, the maximum distance between
 * adjacent gas stations, is minimized.
 * 
 * Return the smallest possible value of D.
 * 
 * Example:
 * 
 * 
 * Input: stations = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], K = 9
 * Output: 0.500000
 * 
 * 
 * Note:
 * 
 * 
 * stations.length will be an integer in range [10, 2000].
 * stations[i] will be an integer in range [0, 10^8].
 * K will be an integer in range [1, 10^6].
 * Answers within 10^-6 of the true value will be accepted as correct.
 * 
 */
class Solution {
    //Tag:Google
    //Tag:BinarySearch
    public double minmaxGasDist(int[] stations, int K) {
        int length = stations.length;
        double left = 0;
        double right = stations[length-1]-stations[0];
        double mid = 0;
        //use binary search, left to right represent the minimum distance that can be reached/
        //start from maximum, which is distance between left most and right most, then try to decrease
        //O(NlogM), M is length of max distance, N is length
        while(left+1e-6 < right){
            mid = (left+right)/2;
            //measure how many extra station needed by divide each by current distance, if dont need, then is 0;
            int count = 0;
            for(int i=0; i<length-1; i++){
                //ceil is equal or large integer
                count += Math.ceil((stations[i+1]-stations[i])/mid -1);
            }
            if(count>K){
                //not possible, increase distance
                left = mid;
            }else{
                right = mid;
            }
        }
        return right;
    }
}
