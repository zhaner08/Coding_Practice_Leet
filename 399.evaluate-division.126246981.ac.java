/*
 * [399] Evaluate Division
 *
 * https://leetcode.com/problems/evaluate-division/description/
 *
 * algorithms
 * Medium (42.45%)
 * Total Accepted:    30.1K
 * Total Submissions: 70.8K
 * Testcase Example:  '[ ["a","b"],["b","c"] ]\n[2.0,3.0]\n[ ["a","c"],["b","c"],["a","e"],["a","a"],["x","x"] ]'
 *
 * 
 * Equations are given in the format A / B = k, where  A and B are variables
 * represented as strings, and k is a real number (floating point number).
 * Given some queries, return the answers. If the answer does not exist, return
 * -1.0.
 * 
 * Example:
 * Given  a / b = 2.0, b / c = 3.0. queries are:  a / c = ?,  b / a = ?, a / e
 * = ?,  a / a = ?, x / x = ? . return  [6.0, 0.5, -1.0, 1.0, -1.0 ].
 * 
 * 
 * The input is:  vector<pair<string, string>> equations, vector<double>&
 * values, vector<pair<string, string>> queries , where equations.size() ==
 * values.size(), and the values are positive. This represents the equations.
 * Return  vector<double>.
 * 
 * 
 * According to the example above:
 * equations = [ ["a", "b"], ["b", "c"] ],
 * values = [2.0, 3.0],
 * queries = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"]
 * ]. 
 * 
 * 
 * 
 * The input is always valid. You may assume that evaluating the queries will
 * result in no division by zero and there is no contradiction.
 * 
 */
class Solution {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        //initial every possible path
        Map<String, List<Edge>> m = new HashMap<String, List<Edge>>();
        for(int i=0; i< equations.length; i++){
            if(!m.containsKey(equations[i][0])){
                m.put(equations[i][0], new ArrayList<Edge>());
            }
            if(!m.containsKey(equations[i][1])){
                m.put(equations[i][1], new ArrayList<Edge>());
            }
            m.get(equations[i][0]).add(new Edge(equations[i][1], values[i]));
            m.get(equations[i][1]).add(new Edge(equations[i][0], 1.0/values[i]));
        }
        
        //loop through each query
        double[] answer = new double[queries.length];
        for(int i=0; i< queries.length; i++){
            String start = queries[i][0];
            String goal = queries[i][1];
            //loop through all edges using DFS
            double tmp = helper(m, start, goal, new HashSet<String>(), 1.0);
            answer[i] = tmp==0.0? -1: tmp;
        }
        return answer;
    }
    
    //dfs, go path by path
    public double helper(Map<String, List<Edge>> m, String start, String goal, Set<String> s, double curValue){
        if(s.contains(start) || !m.containsKey(start)) return 0.0;
        if(start.equals(goal)) return curValue;
        s.add(start);
        List<Edge> candidates = m.get(start);
        double tmp = 0.0;
        for(int i=0; i<candidates.size(); i++){
            tmp = helper(m, candidates.get(i).y , goal, s, curValue * candidates.get(i).d);
            if(tmp!=0.0) break;
        }
        s.remove(start);
        return tmp;
    }
    
     class Edge{
        double d;
        String y;
        public Edge(String y, double d){
            this.y = y;
            this.d = d;
        }
    }
}
