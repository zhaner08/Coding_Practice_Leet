/*
 * [681] Next Closest Time
 *
 * https://leetcode.com/problems/next-closest-time/description/
 *
 * algorithms
 * Medium (41.60%)
 * Total Accepted:    16.4K
 * Total Submissions: 39.3K
 * Testcase Example:  '"19:34"'
 *
 * Given a time represented in the format "HH:MM", form the next closest time
 * by reusing the current digits. There is no limit on how many times a digit
 * can be reused.
 * 
 * You may assume the given input string is always valid. For example, "01:34",
 * "12:09" are all valid. "1:34", "12:9" are all invalid.
 * 
 * Example 1:
 * 
 * Input: "19:34"
 * Output: "19:39"
 * Explanation: The next closest time choosing from digits 1, 9, 3, 4, is
 * 19:39, which occurs 5 minutes later.  It is not 19:33, because this occurs
 * 23 hours and 59 minutes later.
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: "23:59"
 * Output: "22:22"
 * Explanation: The next closest time choosing from digits 2, 3, 5, 9, is
 * 22:22. It may be assumed that the returned time is next day's time since it
 * is smaller than the input time numerically.
 * 
 * 
 */
class Solution {
    //Tag:Google
    //Tag:String
    
    //Try all combinations, convert time to minutes for easier comparasion
    String result = "";
    int difference = Integer.MAX_VALUE;
    public String nextClosestTime(String time) {
        //get all digits
        Set<Integer> s = new HashSet<Integer>();
        s.add(Integer.parseInt(time.substring(0, 1)));
        s.add(Integer.parseInt(time.substring(1, 2)));
        s.add(Integer.parseInt(time.substring(3, 4)));
        s.add(Integer.parseInt(time.substring(4, 5)));
        //if all digits are same, cannot generate a valid output
        if(s.size()==1) return time;
        
        //covert time to minutes
        int target = calTime(time);
        List<Integer> timeList = new ArrayList<Integer>(s);
        dfs(timeList, "", 0, target);
        return result;
    }
    
    public void dfs(List<Integer> timeList, String cur, int pos, int target){
        if(pos==4){
            //have four digits
            int timeInMinutes = calTime(cur);
            //if same as previous, return
            if(timeInMinutes==target) return;
            //if larger, closer is better
            //if smaller, closer to 0 is better, for the second day, add 1day and compare and find minimum
            int newDifference = timeInMinutes-target>0 ? timeInMinutes-target : timeInMinutes+1440-target;
            if(newDifference<difference){
                difference = newDifference;
                result = cur;
            }
            return;
        }
        //handle all digit seperately
        for(int i=0; i<timeList.size(); i++){
            if(pos==0){
                if(timeList.get(i)>2) continue;//hour cannot be larger than 24
            }
            if(pos==1){
                if(cur.charAt(0)-'0'==2 && timeList.get(i)>3) continue;//hour cannot be larger than 24
            }
            if(pos==2){
                if(timeList.get(i)>5) continue;//minutes cannot be larger than 59
            }
            //valid -> dfs
            if(pos==2)
                dfs(timeList, cur+":"+timeList.get(i), pos+1, target);
            else
                dfs(timeList, cur+timeList.get(i), pos+1, target);
        }
    }
    
    public int calTime(String time){
        return Integer.parseInt(time.substring(0,2)) *60 + Integer.parseInt(time.substring(3,5));
    }
}

