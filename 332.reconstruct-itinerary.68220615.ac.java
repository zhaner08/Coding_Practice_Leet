/*
 * [332] Reconstruct Itinerary
 *
 * https://leetcode.com/problems/reconstruct-itinerary/description/
 *
 * algorithms
 * Medium (30.01%)
 * Total Accepted:    48.7K
 * Total Submissions: 162.1K
 * Testcase Example:  '[["MUC","LHR"],["JFK","MUC"],["SFO","SJC"],["LHR","SFO"]]'
 *
 * Given a list of airline tickets represented by pairs of departure and
 * arrival airports [from, to], reconstruct the itinerary in order. All of the
 * tickets belong to a man who departs from JFK. Thus, the itinerary must begin
 * with JFK.
 * 
 * 
 * Note:
 * 
 * If there are multiple valid itineraries, you should return the itinerary
 * that has the smallest lexical order when read as a single string. For
 * example, the itinerary ["JFK", "LGA"] has a smaller lexical order than
 * ["JFK", "LGB"].
 * All airports are represented by three capital letters (IATA code).
 * You may assume all tickets form at least one valid itinerary.
 * 
 * 
 * 
 * 
 * ⁠   Example 1:
 * ⁠   tickets = [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR",
 * "SFO"]]
 * ⁠   Return ["JFK", "MUC", "LHR", "SFO", "SJC"].
 * 
 * 
 * ⁠   Example 2:
 * ⁠   tickets =
 * [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
 * ⁠   Return ["JFK","ATL","JFK","SFO","ATL","SFO"].
 * ⁠   Another possible reconstruction is
 * ["JFK","SFO","ATL","JFK","ATL","SFO"]. But it is larger in lexical order.
 * 
 * 
 * Credits:Special thanks to @dietpepsi for adding this problem and creating
 * all test cases.
 */
public class Solution {
    public List<String> findItinerary(String[][] tickets) {
        //Store the result
        List<String> r = new ArrayList<String>();
        
        //Store how to get to the destination, and sort the end point by alphabet
        Map<String, PriorityQueue<String>> m = new HashMap<String, PriorityQueue<String>>();
        for(int i=0; i<tickets.length; i++)
        {
            //Get the pQueue, if not exist, create 1 and add value
            m.computeIfAbsent(tickets[i][0], k->new PriorityQueue<String>()).add(tickets[i][1]);
        }
        
        Stack<String> stack = new Stack<>();
        //Since always start with JFK,
        stack.push("JFK");
        while(!stack.isEmpty())
        {
            //If is valid path, then add to stack, finally pop one by one at the begining, so first will contain the departure
            while(m.containsKey(stack.peek()) && !m.get(stack.peek()).isEmpty())
            {
                //take 1st element from the queue to stack
                //Always take the a than b, since always have a answer connect from to end, so take first one, then take second one in the next time
                stack.push(m.get(stack.peek()).poll());
            }
            r.add(0,stack.pop());
        }
        return r;
    }
}
