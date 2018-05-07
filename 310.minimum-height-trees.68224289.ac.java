/*
 * [310] Minimum Height Trees
 *
 * https://leetcode.com/problems/minimum-height-trees/description/
 *
 * algorithms
 * Medium (28.97%)
 * Total Accepted:    44.1K
 * Total Submissions: 152.3K
 * Testcase Example:  '4\n[[1,0],[1,2],[1,3]]'
 *
 * 
 * ⁠   For a undirected graph with tree characteristics, we can choose any node
 * as the root. The result graph is then a rooted tree. Among all possible
 * rooted trees, those with minimum height are called minimum height trees
 * (MHTs).
 * ⁠   Given such a graph, write a function to find all the MHTs and return a
 * list of their root labels.
 * 
 * 
 * 
 * ⁠   Format
 * ⁠   The graph contains n nodes which are labeled from 0 to n - 1.
 * ⁠   You will be given the number n and a list of undirected edges (each edge
 * is a pair of labels).
 * 
 * ⁠
 * You can assume that no duplicate edges will appear in edges. Since all edges
 * are
 * ⁠   undirected, [0, 1] is the same as [1, 0] and thus will not appear
 * together in
 * ⁠   edges.
 * 
 * 
 * ⁠   Example 1:
 * 
 * 
 * ⁠   Given n = 4, edges = [[1, 0], [1, 2], [1, 3]]
 * 
 * 
 * 
 * ⁠       0
 * ⁠       |
 * ⁠       1
 * ⁠      / \
 * ⁠     2   3
 * 
 * 
 * ⁠   return  [1]
 * 
 * 
 * 
 * ⁠   Example 2:
 * 
 * 
 * ⁠   Given n = 6, edges = [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]
 * 
 * 
 * ⁠    0  1  2
 * ⁠     \ | /
 * ⁠       3
 * ⁠       |
 * ⁠       4
 * ⁠       |
 * ⁠       5
 * 
 * 
 * ⁠   return  [3, 4]
 * 
 * 
 * 
 * ⁠   Note:
 * 
 * 
 * ⁠   (1) According to the definition
 * ⁠   of tree on Wikipedia: “a tree is an undirected graph in which any two
 * vertices are connected by
 * ⁠   exactly one path. In other words, any connected graph without simple
 * cycles is a tree.”
 * 
 * 
 * ⁠   (2) The height of a rooted tree is the number of edges on the longest
 * downward path between the root and a
 * ⁠   leaf.
 * 
 * 
 * Credits:Special thanks to @dietpepsi for adding this problem and creating
 * all test cases.
 */
public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        //If only 1 node, then return a arryalist with only element 0
        if (n == 1) return Collections.singletonList(0);
        
        List<Set<Integer>> adj = new ArrayList<>(n);
        //intialize the list with n hashSet
        for (int i = 0; i < n; ++i) adj.add(new HashSet<>());
        //Initilaize list with where each element can go, provide all the possible answers
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        
        //If node can only go to 1 place, it is a leave
        //Take all leaves 1 by 1, this will be the answer
        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n; ++i)
            if (adj.get(i).size() == 1) 
                leaves.add(i);
                
        //Answer is only good if n=1 or n=2, otherwise can be reduce further
        while (n > 2) {
            //Remove all current know leaves
            n -= leaves.size();
            //Create new leaves and replace the old one
            List<Integer> newLeaves = new ArrayList<>();
            for (int i : leaves) {
                //Set can only use this way to get next element
                int j = adj.get(i).iterator().next();
                //Remove its previous connection with leaves
                adj.get(j).remove(i);
                //If it has size also =1, then it is the new leaves
                if (adj.get(j).size() == 1) newLeaves.add(j);
            }
            leaves = newLeaves;
        }
        return leaves;
    }
}