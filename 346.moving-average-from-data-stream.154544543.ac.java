/*
 * [346] Moving Average from Data Stream
 *
 * https://leetcode.com/problems/moving-average-from-data-stream/description/
 *
 * algorithms
 * Easy (60.56%)
 * Total Accepted:    40.1K
 * Total Submissions: 66.3K
 * Testcase Example:  '["MovingAverage","next","next","next","next"]\n[[3],[1],[10],[3],[5]]'
 *
 * Given a stream of integers and a window size, calculate the moving average
 * of all integers in the sliding window.
 * 
 * For example,
 * 
 * MovingAverage m = new MovingAverage(3);
 * m.next(1) = 1
 * m.next(10) = (1 + 10) / 2
 * m.next(3) = (1 + 10 + 3) / 3
 * m.next(5) = (10 + 3 + 5) / 3
 * 
 * 
 */
class MovingAverage {
    //Tag:Google
    //Tag:Design
    //Tag:Queue
    int size;
    Queue<Integer> q;
    long sum;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.size = size;
        q=new LinkedList<Integer>();
    }
    
    public double next(int val) {
        //keep update the queue
        if(size==0) return 0;
        q.add(val);
        sum+=val;
        if(q.size()>size){
            sum-=q.poll();
        }
        //notice to covert size
        return sum/(double)q.size();
    }
}



//Also can miminc a circular buffer, same complexity as queue, but maybe faster since q is slow
// public class MovingAverage {
//     private int [] window;
//     private int n, insert;
//     private long sum;
    
//     /** Initialize your data structure here. */
//     public MovingAverage(int size) {
//         window = new int[size];
//         insert = 0;
//         sum = 0;
//     }
    
//     public double next(int val) {
//         if (n < window.length)  n++;
//         sum -= window[insert];
//         sum += val;
//         window[insert] = val;
//         insert = (insert + 1) % window.length;
        
//         return (double)sum / n;
//     }
// }
// 
/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
