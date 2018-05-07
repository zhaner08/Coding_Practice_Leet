/*
 * [89] Gray Code
 *
 * https://leetcode.com/problems/gray-code/description/
 *
 * algorithms
 * Medium (42.56%)
 * Total Accepted:    107.2K
 * Total Submissions: 251.8K
 * Testcase Example:  '2'
 *
 * The gray code is a binary numeral system where two successive values differ
 * in only one bit.
 * 
 * Given a non-negative integer n representing the total number of bits in the
 * code, print the sequence of gray code. A gray code sequence must begin with
 * 0.
 * 
 * For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
 * 
 * 
 * 00 - 0
 * 01 - 1
 * 11 - 3
 * 10 - 2
 * 
 * 
 * Note:
 * For a given n, a gray code sequence is not uniquely defined.
 * 
 * For example, [0,2,3,1] is also a valid gray code sequence according to the
 * above definition.
 * 
 * For now, the judge is able to judge based on one instance of gray code
 * sequence. Sorry about that.
 * 
 */
public class Solution {
public List<Integer> grayCode(int n) {
    //use fomula....
    //00000001, left shift n bits so 2->100->011->3, 3->1000->0111->7
    List<Integer> result = new LinkedList<>();
    //binary XOR
    //00 XOR 00=0; 01 XOR 00 = 1; 10 XOR 01 =3; 11 XOR 01 = 2;
    for (int i = 0; i < 1<<n; i++) 
    {
        result.add(i ^ i>>1);
    }
    return result;
}
}
