/*
 * [253] Meeting Rooms II
 *
 * https://leetcode.com/problems/meeting-rooms-ii/description/
 *
 * algorithms
 * Medium (40.08%)
 * Total Accepted:    87.4K
 * Total Submissions: 218.2K
 * Testcase Example:  '[[0,30],[5,10],[15,20]]'
 *
 * Given an array of meeting time intervals consisting of start and end times
 * [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms
 * required.
 * 
 * Example 1:
 * 
 * 
 * Input: [[0, 30],[5, 10],[15, 20]]
 * Output: 2
 * 
 * Example 2:
 * 
 * 
 * Input: [[7,10],[2,4]]
 * Output: 1
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
    //Tag:Heap
    //Tag:Greedy
    //Tag:Sort
    public int minMeetingRooms(Interval[] intervals) {
        if(intervals==null || intervals.length==0) return 0;
        int result = 0;
        Arrays.sort(intervals, (a, b)->a.start-b.start);
        // Arrays.sort(intervals, new Comparator<Interval>(){
        //     @Override
        //     public int compare(Interval a, Interval b){
        //         return a.start - b.start;
        //     }
        // });
        
        PriorityQueue<Integer> pq = new PriorityQueue();
        
        for(int i=0; i<intervals.length; i++){
            if(pq.isEmpty()){
                pq.offer(intervals[i].end);
            }else{
                if(intervals[i].start>=pq.peek()){
                    pq.poll();
                }
                pq.offer(intervals[i].end);
            }
            result = Math.max(pq.size(), result);
        }
        
        return result;
    }
}
