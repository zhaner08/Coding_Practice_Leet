/*
 * [551] Student Attendance Record I
 *
 * https://leetcode.com/problems/student-attendance-record-i/description/
 *
 * algorithms
 * Easy (44.61%)
 * Total Accepted:    32.4K
 * Total Submissions: 72.6K
 * Testcase Example:  '"PPALLP"'
 *
 * You are given a string representing an attendance record for a student. The
 * record only contains the following three characters:
 * 
 * 
 * 
 * 'A' : Absent. 
 * 'L' : Late.
 * ⁠'P' : Present. 
 * 
 * 
 * 
 * 
 * A student could be rewarded if his attendance record doesn't contain more
 * than one 'A' (absent) or more than two continuous 'L' (late).    
 * 
 * You need to return whether the student could be rewarded according to his
 * attendance record.
 * 
 * Example 1:
 * 
 * Input: "PPALLP"
 * Output: True
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: "PPALLL"
 * Output: False
 * 
 * 
 * 
 * 
 * 
 */
public class Solution {
    public boolean checkRecord(String s) {
        int absent = 0;
        int late = 0;
        for(int i =0; i<s.length(); i++){
            if(s.charAt(i)=='A'){
                absent++;
                late = 0;
            } 
            else if (s.charAt(i)=='L'){
                late++;
            }
            else{
                late = 0;
                continue;
            }
            if(absent>1 || late>2) return false;
        }
        return true;
    }
}
