/*
 * [621] Task Scheduler
 *
 * https://leetcode.com/problems/task-scheduler/description/
 *
 * algorithms
 * Medium (42.43%)
 * Total Accepted:    33.3K
 * Total Submissions: 78.4K
 * Testcase Example:  '["A","A","A","B","B","B"]\n2'
 *
 * Given a char array representing tasks CPU need to do. It contains capital
 * letters A to Z where different letters represent different tasks.Tasks could
 * be done without original order. Each task could be done in one interval. For
 * each interval, CPU could finish one task or just be idle.
 * 
 * However, there is a non-negative cooling interval n that means between two
 * same tasks, there must be at least n intervals that CPU are doing different
 * tasks or just be idle. 
 * 
 * You need to return the least number of intervals the CPU will take to finish
 * all the given tasks.
 * 
 * Example 1:
 * 
 * Input: tasks = ["A","A","A","B","B","B"], n = 2
 * Output: 8
 * Explanation: A -> B -> idle -> A -> B -> idle -> A -> B.
 * 
 * 
 * 
 * Note:
 * 
 * The number of tasks is in the range [1, 10000].
 * The integer n is in the range [0, 100].
 * 
 * 
 */
public class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] mem = new int[26];
        int max = 0;
        int count = 0;
        for(int i=0;i<tasks.length;i++){
            mem[tasks[i]-'A']++;
            if(mem[tasks[i]-'A']>max){
                max = mem[tasks[i]-'A'];
                count = 1;
            }else if(mem[tasks[i]-'A']==max){
                count++;
            }
        }
        return Math.max(tasks.length, (n+1)*(max-1)+count);
        
    }
}

// ->Task schedule with cool down time

// 给了一串task，不同的task可能属于不同type。这些task要放到CPU里运行，运行同一种type是要考虑一个冷却时间。。。弄了半天，过了好几个例子才搞明白，
// 类似于一个OS。给你一个单线程的scheduler，和eg. 4种thread：1，2，3，4, 冷却时间: 3，
// 在multithreading的时候同类型的thread要等上一个thread跑完冷却时间之后才能运行，求最后scheduler用了多少time slot。 

// 举个例子，thread: 1, 2, 1, 1, 3, 4; 冷却时间: 2 time slot，scheduler应该是这样的：1, 2, _, 1, _, _, 1, 3, 4，最后返回9. 


// 1，最正常的task schedule：输出的是最后的时间
// private static int taskSchedule1(int[] tasks, int cooldown) {
//   	if (tasks == null || tasks.length == 0)    return 0;
//   	HashMap<Integer, Integer> map = new HashMap<>();
//   	int slots = 0;
//   	for (int task : tasks) {
//         //if we need to wait for the cooldown of the same task, just update the slots
//   	    if (map.containsKey(task) && map.get(task) > slots) 
//   	        slots = map.get(task); 
//         //update the time slot to the time when curr task can be done again
//   	    map.put(task, slots + 1 + cooldown); 
//   	    slots++; //important!! update the used 1 slot of curr task
//   	}
//   	return slots;
// }


// 2，最正常的task schedule：输出的是字符串 '_'
//     //if we need to output a string of the task scheduling(without reordering), eg.1,2,1,1,3,4, k=2, -> 12_1__134
// public String taskSchedule2(int[] tasks, int cooldown) {
//    if (tasks == null || tasks.length == 0)   return "";
//    Map<Integer, Integer> map = new HashMap<>();//store indices, where cooldown stops, of tasks in window
//    int slots = 0;
//    StringBuilder sb = new StringBuilder();
//    for (int task : tasks) {
//        if (map.containsKey(task) && map.get(task) > slots) {
//            int waitingTime = map.get(task) - slots;
//            while (waitingTime-- > 0) 
//                sb.append("_");
//            slots = map.get(task);
//        }
//        map.put(task, slots + cooldown + 1);
//        sb.append(task);
//        slots++;
//    }
//    return sb.toString();
// }


// 3，无序的，频率统计的做法，算最后时间
// //if tasks can be reordered, output the minimum time needed: O(n) time, O(n) space
// private static int taskSchedule3(int[] tasks, int cooldown) {
//    HashMap<Integer, Integer> map = new HashMap<>();
//    for (int task : tasks) 
//        map.put(task, map.getOrDefault(task, 0) + 1);
//    int maxFrequency = 0, countOfMax = 0;
//    for (int frequency : map.values()) 
//        if (frequency > maxFrequency) {
//            maxFrequency = frequency;
//            countOfMax = 1;
//        } else if (frequency == maxFrequency) {
//            countOfMax++;
//        }
//    int minimumTime = (maxFrequency - 1) * (cooldown + 1) + countOfMax;
//    return Math.max(minimumTime, tasks.length);
// }
//        //(maxFrequency - 1) * (cooldown + 1) + countOfMax;
//        //(maxFrequency - 1): number of minimum time interval; (cooldown + 1): length of each minimum time interval;
//        //countOfMax: the number of tasks at the end (the cooldown of these tasks don't need to be filled)
//        //eg. 1113, cooldown = 0, minimumTime = (3-1)*1 + 1 = 3, task.length = 4, we should return 4
//        //eg. 1123, cooldown = 1, minimumTime = (2-1)*2 + 1 = 3, task.length = 4, we should return 4
//        //eg. 11122, cooldown = 2, minimumTime = (3-1)*3 + 1 = 7 (1 2 _ 1 2 _ 1), task.length = 5, we should return 7
// 4，无序的，统计频率的做法，输出最后字符串
// /**
//     * Find the task that appears for the most time
//     * Use a map to count the number of the times the task appears  then get the maximum count
//     * the result is decided by the maximum count and the number of tasks with maximum count
//     *
//     * two conditions:
//     * 1.  5 4 _ _ _ 5 4 _ _ _ 5 4 _ _ _ 5 4  the rest tasks cannot fill the empty slots
//     *     5 4 3 2 _ 5 4 3 2 _ 5 4 _ _ _ 5 4
//     *     the answer is (maxCount - 1) * (interval + 1) + CountOfMax
//     * 1. 5 4 _ _ _ 5 4 _ _ _ 5 4 _ _ _ 5 4  the rest tasks cannot fill the empty slots
//     *    5 4 3 2 1 6 5 4 3 2 1 6 5 4 6 _ _ 5 4
//     *    the answer is the length of the nums
//     *    the task which does not have max count first fills the empty slots and then just insert any valid place
//     * */

//    //output a sequence of tasks that takes least time:O(maxFrequency*klogk) time,O(n) space,n is number of unique tasks
//    private static String taskSchedule4(String str, int k) {
//        StringBuilder rearranged = new StringBuilder();
//        Map<Character, Integer> map = new HashMap<>();
//        for (char c : str.toCharArray()) {
//            if (!map.containsKey(c)) {
//                map.put(c, 0);
//            }
//            map.put(c, map.get(c) + 1);
//        }

//        Queue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>(new Comparator<Map.Entry<Character, Integer>>() {
//            public int compare(Map.Entry<Character, Integer> entry1, Map.Entry<Character, Integer> entry2) {
//                return entry2.getValue() - entry1.getValue();
//            }
//        });
//        maxHeap.addAll(map.entrySet());//O(nlogn) time, O(n) space
//        ArrayList<Map.Entry<Character, Integer>> temp = new ArrayList<>();//O(k) space

//        while (!maxHeap.isEmpty()) {//O(max frequency) time
//            int i = 0;
//            temp.clear();
//            while (i <= k && !maxHeap.isEmpty()) {//O(k) time
//                Map.Entry<Character, Integer> curr = maxHeap.poll();
//                rearranged.append(curr.getKey());
//                curr.setValue(curr.getValue() - 1);
//                temp.add(curr);
//                i++;
//            }

//            //add this code if we wanna add _ to show that we need to wait for cooldown, eg.AABB, 2 -> AB_AB
//            while (i <= k) {//i <= k, not i < k !!!
//                rearranged.append("_");
//                i++;//remember to add i++ !!!
//            }

//            for (Map.Entry<Character, Integer> e : temp) {//O(klogk) time
//                if (e.getValue() > 0) {
//                    maxHeap.offer(e);
//                }
//            }
//        }

//        //add this code if we add "_" to the string, we need to delete all the "_" at the tail, eg.A__A__ -> A__A
//        for (int i = rearranged.length() - 1; i >= 0 && rearranged.charAt(i) == '_'; i--) {
//            rearranged.deleteCharAt(i);
//        }

//        return rearranged.toString();
//    }
// }
// 5，//if cooldown is very small, but there are lots of tasks, how to reduce space? O(cooldown) space
//    private static int taskSchedule2(int[] tasks, int cooldown) {
//        if (tasks == null || tasks.length == 0) {
//            return 0;
//        }
//        Queue<Integer> queue = new LinkedList<>();//store tasks that are waiting for cooldown?
//        HashMap<Integer, Integer> map = new HashMap<>();//store indices, where cooldown stops, of tasks in window
//        int slots = 0;
//        for (int task : tasks) {
//            if (map.containsKey(task) && map.get(task) > slots) {
//                //add this code if our output is a string, eg.AA, 2 -> A__A
//                //int waitingTime = map.get(task) - slots;
//                //for (int i = 0; i < waitingTime; i++) {
//                //    sb.append("_");
//                //}
//                slots = map.get(task);//if we need to wait for the cooldown of the same task, just update the slots
//            }
//            if (queue.size() == cooldown + 1) {
//                map.remove(queue.poll());//we should do this after updating the slots, cuz we store indices of cooldown
//            }//stops, we don't know whether we have any idol period between these two same tasks yet, so update it first
//            map.put(task, slots + cooldown + 1);//update the time slot to the time when curr task can be done again
//            queue.offer(task);
//            slots++;//update the used 1 slot of curr task
//        }
//        return slots;
//    }
