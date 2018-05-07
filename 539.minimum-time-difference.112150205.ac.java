/*
 * [539] Minimum Time Difference
 *
 * https://leetcode.com/problems/minimum-time-difference/description/
 *
 * algorithms
 * Medium (46.13%)
 * Total Accepted:    16.6K
 * Total Submissions: 35.9K
 * Testcase Example:  '["23:59","00:00"]'
 *
 * Given a list of 24-hour clock time points in "Hour:Minutes" format, find the
 * minimum minutes difference between any two time points in the list. 
 * 
 * Example 1:
 * 
 * Input: ["23:59","00:00"]
 * Output: 1
 * 
 * 
 * 
 * Note:
 * 
 * The number of time points in the given list is at least 2 and won't exceed
 * 20000.
 * The input time is legal and ranges from 00:00 to 23:59.
 * 
 * 
 */
public class Solution {
    public int findMinDifference(List<String> timePoints) {
        boolean[] times = new boolean[24*60*2];
        //set up a list for each time, use their minuters to represent
        for(int i=0; i<timePoints.size(); i++){
            String time = timePoints.get(i);
            String[] timeDetails = time.split(":");
            int timeMinutes = Integer.parseInt(timeDetails[0])*60+Integer.parseInt(timeDetails[1]);
            if(times[timeMinutes]==true) return 0;
            else {
                times[timeMinutes+24*60]=true;
                times[timeMinutes]=true;
            }
        }
        
        //check distance between each time;
        int previousTime = -1;
        int result = Integer.MAX_VALUE;
        for(int i=0; i<times.length; i++){
            if(times[i]){
                if(previousTime==-1){
                    previousTime = i;
                }else{
                    result = Math.min(result, i-previousTime);
                    previousTime=i;
                }
            }
        }
        
        return result;//O(n) time
    }
}
