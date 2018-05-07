/*
 * [575] Distribute Candies
 *
 * https://leetcode.com/problems/distribute-candies/description/
 *
 * algorithms
 * Easy (58.15%)
 * Total Accepted:    45.4K
 * Total Submissions: 78.1K
 * Testcase Example:  '[1,1,2,2,3,3]'
 *
 * Given an integer array with even length, where different numbers in this
 * array represent different kinds of candies. Each number means one candy of
 * the corresponding kind. You need to distribute these candies equally in
 * number to brother and sister. Return the maximum number of kinds of candies
 * the sister could gain. 
 * 
 * Example 1:
 * 
 * Input: candies = [1,1,2,2,3,3]
 * Output: 3
 * Explanation:
 * There are three different kinds of candies (1, 2 and 3), and two candies for
 * each kind.
 * Optimal distribution: The sister has candies [1,2,3] and the brother has
 * candies [1,2,3], too. 
 * The sister has three different kinds of candies. 
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: candies = [1,1,2,3]
 * Output: 2
 * Explanation: For example, the sister has candies [2,3] and the brother has
 * candies [1,1]. 
 * The sister has two different kinds of candies, the brother has only one kind
 * of candies. 
 * 
 * 
 * 
 * Note:
 * 
 * The length of the given array is in range [2, 10,000], and will be even.
 * The number in given array is in range [-100,000, 100,000].
 * 
 * 
 */
public class Solution {
    public int distributeCandies(int[] candies) {
        //maximum half size of the candies, so we only care how many different kinds of candies we have, we give each of them to sisters, and others to brother, we dont care which one brother get, so use a set to count the kind
        Set<Integer> m = new HashSet<Integer>();
        for(int i:candies){
            m.add(i);
        }
        return Math.min(candies.length/2, m.size());
    }
}
