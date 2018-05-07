/*
 * [119] Pascal's Triangle II
 *
 * https://leetcode.com/problems/pascals-triangle-ii/description/
 *
 * algorithms
 * Easy (38.40%)
 * Total Accepted:    146.1K
 * Total Submissions: 380.5K
 * Testcase Example:  '3'
 *
 * Given a non-negative index k where k ≤ 33, return the kth index row of the
 * Pascal's triangle.
 * 
 * Note that the row index starts from 0.
 * 
 * 
 * In Pascal's triangle, each number is the sum of the two numbers directly
 * above it.
 * 
 * Example:
 * 
 * 
 * Input: 3
 * Output: [1,3,3,1]
 * 
 * 
 * Follow up:
 * 
 * Could you optimize your algorithm to use only O(k) extra space?
 * 
 */
public class Solution {
    public List<Integer> getRow(int rowIndex) {
    	ArrayList<Integer> result = new ArrayList<Integer>();
     
    	if (rowIndex < 0)
    		return result;
     
    	result.add(1);
    	for (int i = 1; i <= rowIndex; i++) {
    		for (int j = result.size() - 2; j >= 0; j--) {
    			result.set(j + 1, result.get(j) + result.get(j + 1));
    		}
    		result.add(1);
    	}
    	return result;
    }
}

// 	List<Integer> list = new ArrayList<Integer>();
// 	if (rowIndex < 0)
// 		return list;

// 	for (int i = 0; i < rowIndex + 1; i++) {
// 		list.add(0, 1);
// 		for (int j = 1; j < list.size() - 1; j++) {
// 			list.set(j, list.get(j) + list.get(j + 1));
// 		}
// 	}
// 	return list;
