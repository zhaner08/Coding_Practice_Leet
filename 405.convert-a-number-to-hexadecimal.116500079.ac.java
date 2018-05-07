/*
 * [405] Convert a Number to Hexadecimal
 *
 * https://leetcode.com/problems/convert-a-number-to-hexadecimal/description/
 *
 * algorithms
 * Easy (41.07%)
 * Total Accepted:    34.4K
 * Total Submissions: 83.9K
 * Testcase Example:  '26'
 *
 * 
 * Given an integer, write an algorithm to convert it to hexadecimal. For
 * negative integer, two’s complement method is used.
 * 
 * 
 * Note:
 * 
 * All letters in hexadecimal (a-f) must be in lowercase.
 * The hexadecimal string must not contain extra leading 0s. If the number is
 * zero, it is represented by a single zero character '0'; otherwise, the first
 * character in the hexadecimal string will not be the zero character.
 * The given number is guaranteed to fit within the range of a 32-bit signed
 * integer.
 * You must not use any method provided by the library which converts/formats
 * the number to hex directly.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input:
 * 26
 * 
 * Output:
 * "1a"
 * 
 * 
 * 
 * Example 2:
 * 
 * Input:
 * -1
 * 
 * Output:
 * "ffffffff"
 * 
 * 
 */
class Solution {
    public String toHex(int num) {
        if(num==0) return "0";
        char[] l = new char[16];
        l[0] = '0';
        l[1] = '1';
        l[2] = '2';
        l[3] = '3';
        l[4] = '4';
        l[5] = '5';
        l[6] = '6';
        l[7] = '7';
        l[8] = '8';
        l[9] = '9';
        l[10] = 'a';
        l[11] = 'b';
        l[12] = 'c';
        l[13] = 'd';
        l[14] = 'e';
        l[15] = 'f';
        
        StringBuilder sb = new StringBuilder();
        while(num!=0){
            //and with 1111, to get value at that 4 bits
            sb.insert(0, l[num & 15]);
            num = (num>>>4);
        }
        return sb.toString();
    }
}
