/*
 * [295] Find Median from Data Stream
 *
 * https://leetcode.com/problems/find-median-from-data-stream/description/
 *
 * algorithms
 * Hard (29.83%)
 * Total Accepted:    60.9K
 * Total Submissions: 204K
 * Testcase Example:  '["MedianFinder","addNum","addNum","findMedian","addNum","findMedian"]\n[[],[1],[2],[],[3],[]]'
 *
 * Median is the middle value in an ordered integer list. If the size of the
 * list is even, there is no middle value. So the median is the mean of the two
 * middle value.
 * Examples: 
 * [2,3,4] , the median is 3
 * [2,3], the median is (2 + 3) / 2 = 2.5 
 * 
 * 
 * Design a data structure that supports the following two operations:
 * 
 * 
 * void addNum(int num) - Add a integer number from the data stream to the data
 * structure.
 * double findMedian() - Return the median of all elements so far.
 * 
 * 
 * 
 * For example:
 * 
 * addNum(1)
 * addNum(2)
 * findMedian() -> 1.5
 * addNum(3) 
 * findMedian() -> 2
 * 
 * 
 * Credits:Special thanks to @Louis1992 for adding this problem and creating
 * all test cases.
 */
class MedianFinder {
    PriorityQueue<Integer> max;
    PriorityQueue<Integer> min;

    /** initialize your data structure here. */
    public MedianFinder() {
        max = new PriorityQueue();//max from small to large
        min = new PriorityQueue(1000, Collections.reverseOrder());//min from large to small
        
    }
    
    public void addNum(int num) {
        max.add(num);
        min.add(max.poll());
        //keep max size large or equal
        if(max.size()<min.size()){
            max.add(min.poll());//put the largest back to max's smallest
        }
    }
    
    public double findMedian() {
        return max.size()==min.size()? ((double)(max.peek()+min.peek()))/2 : max.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
