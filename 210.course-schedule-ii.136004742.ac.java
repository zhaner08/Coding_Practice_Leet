/*
 * [210] Course Schedule II
 *
 * https://leetcode.com/problems/course-schedule-ii/description/
 *
 * algorithms
 * Medium (30.40%)
 * Total Accepted:    91.1K
 * Total Submissions: 299.8K
 * Testcase Example:  '2\n[[1,0]]'
 *
 * There are a total of n courses you have to take, labeled from 0 to n-1.
 * 
 * Some courses may have prerequisites, for example to take course 0 you have
 * to first take course 1, which is expressed as a pair: [0,1]
 * 
 * Given the total number of courses and a list of prerequisite pairs, return
 * the ordering of courses you should take to finish all courses.
 * 
 * There may be multiple correct orders, you just need to return one of them.
 * If it is impossible to finish all courses, return an empty array.
 * 
 * Example 1:
 * 
 * 
 * Input: 2, [[1,0]] 
 * Output: [0,1]
 * Explanation: There are a total of 2 courses to take. To take course 1 you
 * should have finished   
 * course 0. So the correct course order is [0,1] .
 * 
 * Example 2:
 * 
 * 
 * Input: 4, [[1,0],[2,0],[3,1],[3,2]]
 * Output: [0,1,2,3] or [0,2,1,3]
 * Explanation: There are a total of 4 courses to take. To take course 3 you
 * should have finished both     
 * ⁠            courses 1 and 2. Both courses 1 and 2 should be taken after you
 * finished course 0. 
 * So one correct course order is [0,1,2,3]. Another correct ordering is
 * [0,2,1,3] .
 * 
 * Note:
 * 
 * 
 * The input prerequisites is a graph represented by a list of edges, not
 * adjacency matrices. Read more about how a graph is represented.
 * You may assume that there are no duplicate edges in the input
 * prerequisites.
 * 
 * 
 * Hints:
 * 
 * 
 * This problem is equivalent to finding the topological order in a directed
 * graph. If a cycle exists, no topological ordering exists and therefore it
 * will be impossible to take all courses.
 * Topological Sort via DFS - A great video tutorial (21 minutes) on Coursera
 * explaining the basic concepts of Topological Sort.
 * Topological sort could also be done via BFS.
 * 
 * 
 */
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        boolean[] mem = new boolean[numCourses];
        Set<Integer> goodStand = new HashSet<Integer>();
        List<Integer> result = new ArrayList<Integer>();
        HashMap<Integer, List<Integer>> m = new HashMap<Integer, List<Integer>>();
        //Set up info
        for(int i=0; i<prerequisites.length; i++){
            int[] tmp = prerequisites[i];
            if(!m.containsKey(tmp[0])){
                m.put(tmp[0], new ArrayList<Integer>());
            }
            m.get(tmp[0]).add(tmp[1]);
        }
        
        for(int i=0; i<numCourses; i++){
            if(goodStand.contains(i)) continue;
            if(!helper(mem, goodStand, m, i,result)) return new int[0];
        }
        
        int[] tmp = new int[numCourses];
        for(int i=0; i<numCourses; i++){
            tmp[i] = result.get(i);
        }
        return tmp;
    }
    
    public boolean helper(boolean[] mem, Set<Integer> goodStand, HashMap<Integer, List<Integer>> m, int j, List<Integer> result){
        //found dependency from previous
        if(mem[j] == true) return false;
        //no depency, can take right away
        if(!m.containsKey(j)){
            if(goodStand.add(j))
            result.add(j);
            return true;
        }
        List<Integer> tmp = m.get(j);
        mem[j] = true;
        for(int i=0; i<tmp.size(); i++){
            if(!helper(mem, goodStand, m, tmp.get(i), result)) return false;
        }
        if(goodStand.add(j))
        result.add(j);
        mem[j] = false;
        return true;
    }
}
