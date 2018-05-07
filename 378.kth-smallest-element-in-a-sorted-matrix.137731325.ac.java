/*
 * [378] Kth Smallest Element in a Sorted Matrix
 *
 * https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/description/
 *
 * algorithms
 * Medium (45.54%)
 * Total Accepted:    60.7K
 * Total Submissions: 133.3K
 * Testcase Example:  '[[1,5,9],[10,11,13],[12,13,15]]\n8'
 *
 * Given a n x n matrix where each of the rows and columns are sorted in
 * ascending order, find the kth smallest element in the matrix.
 * 
 * 
 * Note that it is the kth smallest element in the sorted order, not the kth
 * distinct element.
 * 
 * 
 * Example:
 * 
 * matrix = [
 * ⁠  [ 1,  5,  9],
 * ⁠  [10, 11, 13],
 * ⁠  [12, 13, 15]
 * ],
 * k = 8,
 * 
 * return 13.
 * 
 * 
 * 
 * Note: 
 * You may assume k is always valid, 1 ≤ k ≤ n2.
 */
public class Solution {
//     public int kthSmallest(int[][] matrix, int k) {
//         //Create a PQ to eliminate smaller number and add its next value on y, similar to twitter problem
//         int l = matrix.length;
//         PriorityQueue<tuple> pq = new PriorityQueue<tuple>();
//         //Add the first row into the queue
//         for(int i=0; i<l; i++)
//         {
//             pq.offer(new tuple(0, i, matrix[0][i]));
//         }
//         //loop through rest of it
//         for(int i=0; i<k-1; i++)
//         {
//             //take the smallest element
//             tuple tmp = pq.poll();
//             //If last row, dont add new element
//             if(tmp.x == l-1) continue;
//             pq.offer(new tuple(tmp.x+1, tmp.y, matrix[tmp.x+1][tmp.y]));
//         }
//         return pq.poll().val;
//     }
    
//     class tuple implements Comparable<tuple> {
//         int x, y, val;
//         public tuple (int x, int y, int val)
//         {
//             this.x = x;
//             this.y = y;
//             this.val = val;
//         }
        
//         @Override
//         public int compareTo(tuple t)
//         {
//             //elimnate samller number
//             return this.val-t.val;
//         }
//     }
    
    
    
    public int kthSmallest(int[][] matrix, int k) {
        //binary search
        int lo = matrix[0][0];
        int hi = matrix[matrix.length-1][matrix[0].length-1];
        while(lo<=hi){
            int mid = lo+ (hi-lo)/2;
            int result = getLessEqual(matrix, mid);
            if(k>result) lo = mid+1;
            else hi = mid-1;
        }
        return lo;
    }
    
    private int getLessEqual(int[][] matrix, int val) {
        //from left bottom
        int i = matrix.length-1;
        int j = 0;
        int result = 0;
        while(i>=0 && j<matrix[0].length){
            if(matrix[i][j]<=val){
                result+=i+1;
                j++;
            }else{
                i--;
            }
        }
        return result;
    }
    
    
}
