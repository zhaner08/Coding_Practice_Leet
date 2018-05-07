/*
 * [406] Queue Reconstruction by Height
 *
 * https://leetcode.com/problems/queue-reconstruction-by-height/description/
 *
 * algorithms
 * Medium (56.42%)
 * Total Accepted:    45.2K
 * Total Submissions: 80.1K
 * Testcase Example:  '[[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]'
 *
 * Suppose you have a random list of people standing in a queue. Each person is
 * described by a pair of integers (h, k), where h is the height of the person
 * and k is the number of people in front of this person who have a height
 * greater than or equal to h. Write an algorithm to reconstruct the queue.
 * 
 * 
 * Note:
 * The number of people is less than 1,100.
 * 
 * 
 * 
 * 
 * Example
 * 
 * Input:
 * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 * 
 * Output:
 * [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 * 
 * 
 */
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        //sort people in order from tallest to shortest, there index is the index that supposed
        //move toward shorter people, since insert shorter people would not affect the index, so we 
        //dont need to worry about it
        Arrays.sort(people, new Comparator<int[]>(){
            @Override
            //from tallest to shortest, from small index to high index
            public int compare(int[] a, int[] b){
                return a[0]==b[0] ? a[1]-b[1]: b[0]-a[0];
            }
            
        });
        List<int[]> result = new ArrayList<int[]>();
        
        for(int[] n:people){
            result.add(n[1], n);
        }
        
        //remember this 
        return result.toArray(new int[people.length][2]);
    }
}
