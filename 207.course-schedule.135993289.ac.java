/*
 * [207] Course Schedule
 *
 * https://leetcode.com/problems/course-schedule/description/
 *
 * algorithms
 * Medium (33.88%)
 * Total Accepted:    124.3K
 * Total Submissions: 366.9K
 * Testcase Example:  '2\n[[1,0]]'
 *
 * There are a total of n courses you have to take, labeled from 0 to n-1.
 * 
 * Some courses may have prerequisites, for example to take course 0 you have
 * to first take course 1, which is expressed as a pair: [0,1]
 * 
 * Given the total number of courses and a list of prerequisite pairs, is it
 * possible for you to finish all courses?
 * 
 * Example 1:
 * 
 * 
 * Input: 2, [[1,0]] 
 * Output: true
 * Explanation: There are a total of 2 courses to take. 
 * To take course 1 you should have finished course 0. So it is possible.
 * 
 * Example 2:
 * 
 * 
 * Input: 2, [[1,0],[0,1]]
 * Output: false
 * Explanation: There are a total of 2 courses to take. 
 * To take course 1 you should have finished course 0, and to take course 0 you
 * should
 * also have finished course 1. So it is impossible.
 * 
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
 * This problem is equivalent to finding if a cycle exists in a directed graph.
 * If a cycle exists, no topological ordering exists and therefore it will be
 * impossible to take all courses.
 * Topological Sort via DFS - A great video tutorial (21 minutes) on Coursera
 * explaining the basic concepts of Topological Sort.
 * Topological sort could also be done via BFS.
 * 
 * 
 */
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean[] mem = new boolean[numCourses];
        Set<Integer> goodStand = new HashSet<Integer>();
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
            if(!helper(mem, goodStand, m, i)) return false;
        }
        
        return true;
    }
    
    public boolean helper(boolean[] mem, Set<Integer> goodStand, HashMap<Integer, List<Integer>> m, int j){
        //found dependency from previous
        if(mem[j] == true) return false;
        //no depency, can take right away
        if(!m.containsKey(j)){
            goodStand.add(j);
            return true;
        }
        List<Integer> tmp = m.get(j);
        mem[j] = true;
        for(int i=0; i<tmp.size(); i++){
            if(!helper(mem, goodStand, m, tmp.get(i))) return false;
        }
        goodStand.add(j);
        mem[j] = false;
        return true;
    }
}
