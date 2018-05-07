/*
 * [599] Minimum Index Sum of Two Lists
 *
 * https://leetcode.com/problems/minimum-index-sum-of-two-lists/description/
 *
 * algorithms
 * Easy (46.40%)
 * Total Accepted:    30.5K
 * Total Submissions: 65.8K
 * Testcase Example:  '["Shogun","Tapioca Express","Burger King","KFC"]\n["Piatti","The Grill at Torrey Pines","Hungry Hunter Steakhouse","Shogun"]'
 *
 * 
 * Suppose Andy and Doris want to choose a restaurant for dinner, and they both
 * have a list of favorite restaurants represented by strings. 
 * 
 * 
 * You need to help them find out their common interest with the least list
 * index sum. If there is a choice tie between answers, output all of them with
 * no order requirement. You could assume there always exists an answer.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input:
 * ["Shogun", "Tapioca Express", "Burger King", "KFC"]
 * ["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse",
 * "Shogun"]
 * Output: ["Shogun"]
 * Explanation: The only restaurant they both like is "Shogun".
 * 
 * 
 * 
 * Example 2:
 * 
 * Input:
 * ["Shogun", "Tapioca Express", "Burger King", "KFC"]
 * ["KFC", "Shogun", "Burger King"]
 * Output: ["Shogun"]
 * Explanation: The restaurant they both like and have the least index sum is
 * "Shogun" with index sum 1 (0+1).
 * 
 * 
 * 
 * 
 * Note:
 * 
 * The length of both lists will be in the range of [1, 1000].
 * The length of strings in both lists will be in the range of [1, 30].
 * The index is starting from 0 to the list length minus 1.
 * No duplicates in both lists.
 * 
 * 
 */
public class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> m = new HashMap<String, Integer>();
        for(int i=0; i<list1.length;i++){
            m.put(list1[i], i);
        }
        int leastIndex = Integer.MAX_VALUE;
        List<String> result = new ArrayList<String>();
        for(int i=0; i<list2.length;i++){
            if(m.containsKey(list2[i]) && m.get(list2[i])+i<=leastIndex){
                int tempIndex = m.get(list2[i])+i;
                if(tempIndex!=leastIndex){
                    leastIndex=tempIndex;
                    result.clear();
                }
                result.add(list2[i]);
            }
        }
        return result.toArray(new String[result.size()]);
    }
}
