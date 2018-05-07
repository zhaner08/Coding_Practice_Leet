/*
 * [118] Pascal's Triangle
 *
 * https://leetcode.com/problems/pascals-triangle/description/
 *
 * algorithms
 * Easy (40.31%)
 * Total Accepted:    171.8K
 * Total Submissions: 426.2K
 * Testcase Example:  '5'
 *
 * Given a non-negative integer numRows, generate the first numRows of Pascal's
 * triangle.
 * 
 * 
 * In Pascal's triangle, each number is the sum of the two numbers directly
 * above it.
 * 
 * Example:
 * 
 * 
 * Input: 5
 * Output:
 * [
 * ⁠    [1],
 * ⁠   [1,1],
 * ⁠  [1,2,1],
 * ⁠ [1,3,3,1],
 * ⁠[1,4,6,4,1]
 * ]
 * 
 * 
 */
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(numRows ==0) return result;
        result.add(new ArrayList<Integer>());
        result.get(0).add(1);
        for(int i=1; i<numRows; i++){
            List<Integer> tmp = new ArrayList(result.get(i-1));
            for(int j=0; j<tmp.size()-1; j++){
                tmp.set(j, tmp.get(j)+tmp.get(j+1));
            }
            tmp.add(0, 1);
            result.add(tmp);
        }
        return result;
    }
}
