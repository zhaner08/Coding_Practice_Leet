/*
 * [297] Serialize and Deserialize Binary Tree
 *
 * https://leetcode.com/problems/serialize-and-deserialize-binary-tree/description/
 *
 * algorithms
 * Hard (35.29%)
 * Total Accepted:    103.8K
 * Total Submissions: 294.1K
 * Testcase Example:  '[1,2,3,null,null,4,5]'
 *
 * Serialization is the process of converting a data structure or object into a
 * sequence of bits so that it can be stored in a file or memory buffer, or
 * transmitted across a network connection link to be reconstructed later in
 * the same or another computer environment.
 * 
 * Design an algorithm to serialize and deserialize a binary tree. There is no
 * restriction on how your serialization/deserialization algorithm should work.
 * You just need to ensure that a binary tree can be serialized to a string and
 * this string can be deserialized to the original tree structure.
 * 
 * For example, you may serialize the following tree
 * 
 * 
 * ⁠   1
 * ⁠  / \
 * ⁠ 2   3
 * ⁠    / \
 * ⁠   4   5
 * 
 * 
 * as "[1,2,3,null,null,4,5]", just the same as how LeetCode OJ serializes a
 * binary tree. You do not necessarily need to follow this format, so please be
 * creative and come up with different approaches yourself.
 * 
 * 
 * 
 * Note: Do not use class member/global/static variables to store states. Your
 * serialize and deserialize algorithms should be stateless.
 * 
 * Credits:
 * Special thanks to @Louis1992 for adding this problem and creating all test
 * cases.
 * 
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    private static String nullstring = "null";
    private static String spliter = ",";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        //List<Integer> result = new ArrayList<Integer>();
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        while(!q.isEmpty()){
            
            TreeNode tmp = q.poll();
            if(tmp!=null){
                q.add(tmp.left);
                q.add(tmp.right);
            }
            sb.append(tmp==null? nullstring: tmp.val).append(spliter);
            //result.add(tmp==null? null: tmp.val);
        }
        //Integer[] finalresult = result.toArray(new Integer[result.size()]);
        //System.out.println(sb.toString());
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        //data = data.substring(1, data.length()-1);
        String[] dataArray = data.split(",");
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(dataArray[0].equals(nullstring) ? null: new TreeNode(Integer.parseInt(dataArray[0])));
        TreeNode root = q.peek()==null? null: q.peek();
        int counter=1;
        while(!q.isEmpty()){
            TreeNode tmp = q.poll();
            if(tmp!=null && counter<dataArray.length){
                TreeNode newNode = dataArray[counter].equals(nullstring) ? null: new TreeNode(Integer.parseInt(dataArray[counter]));
                tmp.left = newNode;
                if(newNode!=null) q.add(newNode);
                counter++;
                newNode = dataArray[counter].equals(nullstring) ? null: new TreeNode(Integer.parseInt(dataArray[counter]));
                tmp.right = newNode;
                if(newNode!=null) q.add(newNode);
                counter++;
            }
        }
        
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));


// Encodes a tree to a single string. (Better)
// public String serialize(TreeNode root) {
//     StringBuilder sb = new StringBuilder();
//     buildString(root, sb);
//     return sb.toString();
// }
// public void buildString(TreeNode root, StringBuilder sb) {
//     if (root == null)   sb.append("#").append(" ");
//     else {
//         sb.append(root.val).append(" ");
//         buildString(root.left, sb);
//         buildString(root.right, sb);
//     }
// }
// // Decodes your encoded data to tree.
// public TreeNode deserialize(String data) {
//     Queue<String> q = new LinkedList<>();
//     q.addAll(Arrays.asList(data.split(" ")));
//     return buildTree(q);
// }
// public TreeNode buildTree(Queue<String> q) {
//     String s = q.remove();
//     if (s.equals("#"))   return null;
//     TreeNode root = new TreeNode(Integer.valueOf(s));
//     root.left = buildTree(q);
//     root.right = buildTree(q);
//     return root;
// }






//     private static final String spliter = ",";
//     private static final String NN = "X";

//     // Encodes a tree to a single string.
//     public String serialize(TreeNode root) {
//         StringBuilder sb = new StringBuilder();
//         buildString(root, sb);
//         return sb.toString();
//     }

//     private void buildString(TreeNode node, StringBuilder sb) {
//         if (node == null) {
//             sb.append(NN).append(spliter);
//         } else {
//             sb.append(node.val).append(spliter);
//             buildString(node.left, sb);
//             buildString(node.right,sb);
//         }
//     }
//     // Decodes your encoded data to tree.
//     public TreeNode deserialize(String data) {
//         Deque<String> nodes = new LinkedList<>();
//         nodes.addAll(Arrays.asList(data.split(spliter)));
//         return buildTree(nodes);
//     }
    
//     private TreeNode buildTree(Deque<String> nodes) {
//         String val = nodes.remove();
//         if (val.equals(NN)) return null;
//         else {
//             TreeNode node = new TreeNode(Integer.valueOf(val));
//             node.left = buildTree(nodes);
//             node.right = buildTree(nodes);
//             return node;
//         }
//     }
