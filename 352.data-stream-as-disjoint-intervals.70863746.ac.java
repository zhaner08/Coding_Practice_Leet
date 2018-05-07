/*
 * [352] Data Stream as Disjoint Intervals
 *
 * https://leetcode.com/problems/data-stream-as-disjoint-intervals/description/
 *
 * algorithms
 * Hard (41.12%)
 * Total Accepted:    17.3K
 * Total Submissions: 42.2K
 * Testcase Example:  '["SummaryRanges","addNum","getIntervals","addNum","getIntervals","addNum","getIntervals","addNum","getIntervals","addNum","getIntervals"]\n[[],[1],[],[3],[],[7],[],[2],[],[6],[]]'
 *
 * Given a data stream input of non-negative integers a1, a2, ..., an, ...,
 * summarize the numbers seen so far as a list of disjoint intervals.
 * 
 * For example, suppose the integers from the data stream are 1, 3, 7, 2, 6,
 * ..., then the summary will be:
 * 
 * [1, 1]
 * [1, 1], [3, 3]
 * [1, 1], [3, 3], [7, 7]
 * [1, 3], [7, 7]
 * [1, 3], [6, 7]
 * 
 * 
 * Follow up:
 * What if there are lots of merges and the number of disjoint intervals are
 * small compared to the data stream's size?
 * 
 * 
 * Credits:Special thanks to @yunhong for adding this problem and creating most
 * of the test cases.
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
public class SummaryRanges {
    TreeMap<Integer, Interval> t;

    /** Initialize your data structure here. */
    public SummaryRanges() {
        t = new TreeMap<Integer, Interval>();
    }
    
    public void addNum(int val) {
        if(t.containsKey(val)) return;
        //Return closest key value of the val, if does not exist, return null;
        //Update every node, nothing special
        Integer left = t.lowerKey(val);
        Integer right = t.higherKey(val);
        if(left != null && right != null && t.get(left).end+1 ==val && right-1==val)
        {
            t.get(left).end = t.get(right).end;
            t.remove(right);
        }
        //first condition already cover cases, so dont need to check in others, if larger than right, and in range of right, dont need to do anything
        else if(right !=null && val== right-1)
        {
            t.put(val, new Interval(val, t.get(right).end));
            t.remove(right);
        }
        else if(left !=null && t.get(left).end+1>=val)
        {
            t.get(left).end=Math.max(t.get(left).end, val);
        }
        else
        {
            t.put(val, new Interval(val, val));
        }
    }
    
    public List<Interval> getIntervals() {
        return new ArrayList<Interval>(t.values());
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * List<Interval> param_2 = obj.getIntervals();
 */
