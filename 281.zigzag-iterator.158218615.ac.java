/*
 * [281] Zigzag Iterator
 *
 * https://leetcode.com/problems/zigzag-iterator/description/
 *
 * algorithms
 * Medium (52.99%)
 * Total Accepted:    38.8K
 * Total Submissions: 73.2K
 * Testcase Example:  '[1,2]\n[3,4,5,6]'
 *
 * Given two 1d vectors, implement an iterator to return their elements
 * alternately.
 * 
 * Example:
 * 
 * 
 * Input:
 * v1 = [1,2]
 * v2 = [3,4,5,6] 
 * 
 * Output: [1,3,2,4,5,6]
 * 
 * Explanation: By calling next repeatedly until hasNext returns
 * false, 
 * the order of elements returned by next should be: [1,3,2,4,5,6].
 * 
 * Follow up: What if you are given k 1d vectors? How well can your code be
 * extended to such cases?
 * 
 * Clarification for the follow up question:
 * The "Zigzag" order is not clearly defined and is ambiguous for k > 2 cases.
 * If "Zigzag" does not look right to you, replace "Zigzag" with "Cyclic". For
 * example:
 * 
 * 
 * Input:
 * [1,2,3]
 * [4,5,6,7]
 * [8,9]
 * 
 * Output: [1,4,8,2,5,9,3,6,7].
 * 
 * 
 */
public class ZigzagIterator {
    //Esay Question
    //Tag:Google
    //Tag:Design
    
    List<Integer> v1;
    List<Integer> v2;
    int v1Length;
    int v2Length;
    int curV1=0;
    int curV2=0;
    boolean one = false;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        this.v1 = v1;
        this.v2 = v2;
        v1Length = v1==null? 0: v1.size();
        v2Length = v2==null? 0: v2.size();
    }

    public int next() {
        //Set boolean first
        if(curV1==v1Length){
            one = false;
        }else if(curV2==v2Length){
            one = true;
        }else{
            one = !one;
        }
        //Then get the value, to make sure corner cases handled
        if(one){
            return v1.get(curV1++);
        }else{
            return v2.get(curV2++);
        }
    }

    public boolean hasNext() {
        return curV1< v1Length || curV2<v2Length;
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */
