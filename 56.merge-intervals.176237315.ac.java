/*
 * [56] Merge Intervals
 *
 * https://leetcode.com/problems/merge-intervals/description/
 *
 * algorithms
 * Medium (32.11%)
 * Total Accepted:    199.3K
 * Total Submissions: 620.5K
 * Testcase Example:  '[[1,3],[2,6],[8,10],[15,18]]'
 *
 * Given a collection of intervals, merge all overlapping intervals.
 * 
 * Example 1:
 * 
 * 
 * Input: [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into
 * [1,6].
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considerred overlapping.
 * 
 */
/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    //Tag:All
    //Tag:Array
    //Tag:Sort
    public List<Interval> merge(List<Interval> intervals) {
        int length = intervals.size();
        if(length<2) return intervals;
        List<Interval> ans = new ArrayList<Interval>();
        intervals.sort((a, b)->a.start- b.start);
        Interval tmp = intervals.get(0);
        for(int i=1; i<length; i++){
            if(intervals.get(i).start<= tmp.end){
                tmp.end = Math.max(tmp.end, intervals.get(i).end);
            }else{
                ans.add(tmp);
                tmp = intervals.get(i);
            }
        }
        ans.add(tmp);
        return ans;
    }
}




// *******变种*******
// 返回总时间
// // input is unsorted and has some overlapping intervals, output is the total non-overlapping time; O(nlogn) time, O(1) space

// public int totalTime(List<Interval> intervals) {
//     //if (intervals == null || intervals.size() <= 1)    return intervals;
//     Collections.sort(intervals, new Comparator<Interval>(){
//         public int compare(Interval a, Interval b) {
//             return a.start - b.start;
//         }
//     });
//     //you can also merge intervals before calculating,which makes calculation easier,but takes some memory(new arraylist)
//     int total = 0;
//     Interval prev = new Interval(0, 0);
//     for (Interval curr : intervals) {
//         if (prev.end < curr.start) {
//             total += curr.end - curr.start;//add the whole part(non-overlapping)
//             prev = curr;
//         } else if (curr.end > prev.end) {
//             total += curr.end - prev.end;//only add the non overlapping part after prev.end
//             prev = curr;
//         }//else curr.end<=prev.end(curr inside prev),don't calculate anything,and prev isn't updated(prev.end is bigger)
//     }
//     return total;
// }



