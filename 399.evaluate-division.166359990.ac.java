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
    //Tag:Google
    //Tag:Facebook
    //tag:Graph
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Map<String, List<Edge>> map = new HashMap<String, List<Edge>>();
        //set up graph
        for(int i=0; i<equations.length; i++){
            //create arraylist for all num/d
            if(!map.containsKey(equations[i][0])){
                map.put(equations[i][0], new ArrayList<Edge>());
            }
            if(!map.containsKey(equations[i][1])){
                map.put(equations[i][1], new ArrayList<Edge>());
            }
            map.get(equations[i][0]).add(new Edge(equations[i][1], values[i]));
            map.get(equations[i][1]).add(new Edge(equations[i][0], 1.0/values[i]));
        }
        
        //solving the queries
        double[] result = new double[queries.length];
        for(int i=0; i<queries.length; i++){
            String start = queries[i][0];
            String end = queries[i][1];
            if(!map.containsKey(start) || !map.containsKey(end)){
                result[i] = -1.0;
                continue;
            }
            result[i] = dfs(start, end, map, new HashSet(), 1.0);
            if(result[i]==0.0) result[i]=-1.0;
        }
        return result;
    }
    
    //helper dfs
    public double dfs(String start, String end, Map<String, List<Edge>> map, HashSet set, double cur){
        if(set.contains(start) || !map.containsKey(start)) return 0.0;
        //cur value already have the goal multiply
        if(start.equals(end)) return cur;
        List<Edge> tmp = map.get(start);
        set.add(start);
        double tmpResult = 0.0;
        for(Edge e: tmp){
            tmpResult = dfs(e.c, end, map, set, cur*e.value);
            //if find one, break the loop and return the value
            if(tmpResult!=0.0) break;
        }
        //remove added path
        //set.remove(start);
        return tmpResult;
    }
    
    //Edge class
    class Edge{
        String c;
        double value;
        public Edge(String c, double value){
            this.c = c;
            this.value = value;
        }
    }
}
