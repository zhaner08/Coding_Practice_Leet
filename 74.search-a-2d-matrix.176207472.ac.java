/*
 * [74] Search a 2D Matrix
 *
 * https://leetcode.com/problems/search-a-2d-matrix/description/
 *
 * algorithms
 * Medium (34.62%)
 * Total Accepted:    158.6K
 * Total Submissions: 458.2K
 * Testcase Example:  '[[1,3,5,7],[10,11,16,20],[23,30,34,50]]\n3'
 *
 * Write an efficient algorithm that searches for a value in an m x n matrix.
 * This matrix has the following properties:
 * 
 * 
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the
 * previous row.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input:
 * matrix = [
 * ⁠ [1,   3,  5,  7],
 * ⁠ [10, 11, 16, 20],
 * ⁠ [23, 30, 34, 50]
 * ]
 * target = 3
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * 
 * Input:
 * matrix = [
 * ⁠ [1,   3,  5,  7],
 * ⁠ [10, 11, 16, 20],
 * ⁠ [23, 30, 34, 50]
 * ]
 * target = 13
 * Output: false
 * 
 */
public class Solution {
    //Tag:Amazon
    //Tag:Twitter
    //Tag:Array
    //Tag:BinarySearch
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null || matrix.length == 0 || matrix[0].length==0) return false;
        int m = matrix.length;
        int n = matrix[0].length;
        //treated the matrix as an array, and use binary search. when need specfic location /m %m
        int l=0, r=m*n-1;
        
        //binary search: middle = l+r-1 /2
        while (l != r)
        {
            int middle = (l+r-1)/2;
            if(target>matrix[middle/n][middle%n]){l=middle+1;}
            else { r=middle;} //r = middle if smaller or equal
        }
        return matrix[r/n][r%n]==target;
    }
}
