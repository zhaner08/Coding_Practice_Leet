/*
 * [165] Compare Version Numbers
 *
 * https://leetcode.com/problems/compare-version-numbers/description/
 *
 * algorithms
 * Medium (20.90%)
 * Total Accepted:    100.4K
 * Total Submissions: 480.5K
 * Testcase Example:  '"0.1"\n"1.1"'
 *
 * Compare two version numbers version1 and version2.
 * If version1 > version2 return 1; if version1 < version2 return -1;otherwise
 * return 0.
 * 
 * You may assume that the version strings are non-empty and contain only
 * digits and the . character.
 * The . character does not represent a decimal point and is used to separate
 * number sequences.
 * For instance, 2.5 is not "two and a half" or "half way to version three", it
 * is the fifth second-level revision of the second first-level revision.
 * 
 * Example 1:
 * 
 * 
 * Input: version1 = "0.1", version2 = "1.1"
 * Output: -1
 * 
 * Example 2:
 * 
 * 
 * Input: version1 = "1.0.1", version2 = "1"
 * Output: 1
 * 
 * Example 3:
 * 
 * 
 * Input: version1 = "7.5.2.4", version2 = "7.5.3"
 * Output: -1
 * 
 */
public class Solution {
    //Tag:Amazon
    //Tag:Microsoft
    //Tag:Apple
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int v1Length = v1.length;
        int v2Length = v2.length;
        //Can not use int, since need for compareTo
        Integer ver1;
        Integer ver2;
        int result=0;
        //find the max length of two.
        //if one is shorter, pad the rest with 0 and compare
        int length = Math.max(v1Length, v2Length);
        for (int i=0; i<length; i++)
        {
            ver1 = i<v1Length ? Integer.parseInt(v1[i]) : 0;
            ver2 = i<v2Length ? Integer.parseInt(v2[i]) : 0;
            result = ver1.compareTo(ver2);
            if(result !=0) return result;
        }
        return 0;
    }
}
