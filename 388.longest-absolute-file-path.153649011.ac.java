/*
 * [388] Longest Absolute File Path
 *
 * https://leetcode.com/problems/longest-absolute-file-path/description/
 *
 * algorithms
 * Medium (37.46%)
 * Total Accepted:    46.9K
 * Total Submissions: 125.3K
 * Testcase Example:  '"dir\\n\\tsubdir1\\n\\tsubdir2\\n\\t\\tfile.ext"'
 *
 * Suppose we abstract our file system by a string in the following manner:
 * 
 * The string "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext" represents:
 * 
 * dir
 * ⁠   subdir1
 * ⁠   subdir2
 * ⁠       file.ext
 * 
 * 
 * The directory dir contains an empty sub-directory subdir1 and a
 * sub-directory subdir2 containing a file file.ext.
 * 
 * The string
 * "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"
 * represents:
 * 
 * dir
 * ⁠   subdir1
 * ⁠       file1.ext
 * ⁠       subsubdir1
 * ⁠   subdir2
 * ⁠       subsubdir2
 * ⁠           file2.ext
 * 
 * 
 * The directory dir contains two sub-directories subdir1 and subdir2. subdir1
 * contains a file file1.ext and an empty second-level sub-directory
 * subsubdir1. subdir2 contains a second-level sub-directory subsubdir2
 * containing a file file2.ext.
 * 
 * We are interested in finding the longest (number of characters) absolute
 * path to a file within our file system. For example, in the second example
 * above, the longest absolute path is "dir/subdir2/subsubdir2/file2.ext", and
 * its length is 32 (not including the double quotes).
 * 
 * Given a string representing the file system in the above format, return the
 * length of the longest absolute path to file in the abstracted file system.
 * If there is no file in the system, return 0.
 * 
 * Note:
 * 
 * The name of a file contains at least a . and an extension.
 * The name of a directory or sub-directory will not contain a ..
 * 
 * 
 * 
 * Time complexity required: O(n) where n is the size of the input string.
 * 
 * Notice that a/aa/aaa/file1.txt is not the longest file path, if there is
 * another path aaaaaaaaaaaaaaaaaaaaa/sth.png.
 */
class Solution {
    //Tag:Google
    public int lengthLongestPath(String input) {
        //each line is a new entry
        String[] path = input.split("\n");
        //store current max length for each level, similar like backtrack 
        int[] stack = new int[path.length+1];
        int max = 0;
        for(String s: path){
            //find level by counting number of /t
            //the return of lastIndexOf is the number of the string, 0 1 2 3....
            //+1 to handle first level
            int level = s.lastIndexOf("\t")+1;
            //alwasy use next level in case previous level is -1
            //  --\t count as 1 when using length()function
            //+1 for "/" seperator of addition level
            int curLength = stack[level+1] = stack[level]+s.length()-level+1;
            //if it is a file, then update the max length
            if(s.contains(".")){
                //minus 1 since root does not need "\"
                max = Math.max(max, curLength-1);
            }

        }
        return max;
    }
}
