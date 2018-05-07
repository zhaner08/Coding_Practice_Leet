/*
 * [67] Add Binary
 *
 * https://leetcode.com/problems/add-binary/description/
 *
 * algorithms
 * Easy (34.24%)
 * Total Accepted:    201.3K
 * Total Submissions: 587.9K
 * Testcase Example:  '"11"\n"1"'
 *
 * Given two binary strings, return their sum (also a binary string).
 * 
 * The input strings are both non-empty and contains only characters 1 or 0.
 * 
 * Example 1:
 * 
 * 
 * Input: a = "11", b = "1"
 * Output: "100"
 * 
 * Example 2:
 * 
 * 
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 * 
 */
public class Solution {
    public String addBinary(String s1, String s2) {
        //corner case check
        if(s1==null || s1.length()==0) return s2;
        if(s2==null || s2.length()==0) return s1;
        //main
        int aLength = s1.length()-1;
        int bLength = s2.length()-1;
        int carry = 0;
        int ss1 =0;
        int ss2 = 0;
        StringBuilder sb = new StringBuilder();
        //if carry ==1 need one more loop
        while( aLength>=0 || bLength>=0 || carry ==1){
        ss1 = aLength>=0? s1.charAt(aLength)-'0' : 0;
        ss2 = bLength>=0? s2.charAt(bLength)-'0' : 0;
        sb.append(ss1^ss2^carry);
        //update carry
        carry = (ss1+ss2+carry)>1? 1:0;
        aLength--;
        bLength--;

        }

        return sb.reverse().toString();
        
        
        
        
//  //if we need to calculate hexadecimal or k decimal, carry = sum / k; res.append(sum % k), and use hash to map 'ABCDEF' to nums
// //if we have zeros at the front of strings, and we only need one MS bit,first clear all zeros at the front, after calculaing,
// //add '0' if no overflow, add '1' if overflow (length >= 32 or carry == 1)
// Solution 1:

// public String addBinary(String a, String b) {
//     StringBuilder sb = new StringBuilder();
//     int i = a.length() - 1, j = b.length() - 1;
//     int sum = 0;
//     while (i >= 0 || j >= 0) {
//         sum /= 2;
//         if (i >= 0)     sum += a.charAt(i--) - '0';
//         if (j >= 0)     sum += b.charAt(j--) - '0';
//         sb.append(sum % 2);
//     }
//     if (sum / 2 != 0)   sb.append(sum / 2);
//     return sb.reverse().toString();
// }


// Solution 2: bit manipulation
// // not using +-*/, only use bit manipulations

// public String addBinary(String a, String b) {
//     StringBuilder res = new StringBuilder();
//     int i = a.length() - 1, j = b.length() - 1;
//     int carry = 0;
//     while (i >= 0 || j >= 0) {
//         int num1 = i >= 0 ? Integer.valueOf(String.valueOf(a.charAt(i--))) : 0;
//         int num2 = j >= 0 ? Integer.valueOf(String.valueOf(a.charAt(j--))) : 0;
//         int sum = carry ^ num1 ^ num2;//curr digit
//         carry = (num1 & num2) | (num1 & carry) | (num2 & carry);
//         res.append(sum);//if don't use StringBuilder,we can use res=String.valueOf(sum%2)+res,then no need to reverse
//     }
//     if (carry == 1)    res.append(1);
//     return res.reverse().toString();//append&reverse,instead of inserting at front cuz sb is array-based,insert will be
// }       
        
        // if(a.equals(""))
        // return b;
        // if(b.equals(""))
        // return a;
        // //dont use map, use character-'0'
        // Map<Character, Integer> map = new HashMap<Character, Integer>();
        // map.put('0',0);
        // map.put('1',1);
        // int temp= 0;
        // String result="";
        // int aLength= a.length()-1;
        // int bLength= b.length()-1;
        // while(aLength>=0 || bLength>=0)
        // {
        //     int aa=0;
        //     int bb=0;
        //     if(aLength>=0)
        //         aa= map.get(a.charAt(aLength));
        //     if(bLength>=0)
        //         bb= map.get(b.charAt(bLength));
        //         int cal = temp+ aa+bb;
        //         /////////////////////////////////
        //         //use / and %
        //         temp=cal/2;
        //         result=cal%2+result;
        //         aLength--;
        //         bLength--;
        //     }
        //     if (temp!=0)
        //     return 1+result;
        //     else
        //     return result;
            
    }
}

    // public String addBinary(String a, String b) {
    //     if(a == null || a.isEmpty()) {
    //         return b;
    //     }
    //     if(b == null || b.isEmpty()) {
    //         return a;
    //     }
    //     char[] aArray = a.toCharArray();
    //     char[] bArray = b.toCharArray();
    //     StringBuilder stb = new StringBuilder();

    //     int i = aArray.length - 1;
    //     int j = bArray.length - 1;
    //     int aByte;
    //     int bByte;
    //     int carry = 0;
    //     int result;

    //     while(i > -1 || j > -1 || carry == 1) {
    //         aByte = (i > -1) ? Character.getNumericValue(aArray[i--]) : 0;
    //         bByte = (j > -1) ? Character.getNumericValue(bArray[j--]) : 0;
    //         result = aByte ^ bByte ^ carry;
    //         carry = ((aByte + bByte + carry) >= 2) ? 1 : 0;
    //         stb.append(result);
    //     }
    //     return stb.reverse().toString();
    // }
