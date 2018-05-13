/*
 * [683] K Empty Slots
 *
 * https://leetcode.com/problems/k-empty-slots/description/
 *
 * algorithms
 * Hard (34.03%)
 * Total Accepted:    14.3K
 * Total Submissions: 42.2K
 * Testcase Example:  '[1,3,2]\n1'
 *
 * 
 * There is a garden with N slots. In each slot, there is a flower. The N
 * flowers will bloom one by one in N days. In each day, there will be exactly
 * one flower blooming and it will be in the status of blooming since then.
 * 
 * 
 * 
 * Given an array flowers consists of number from 1 to N. Each number in the
 * array represents the place where the flower will open in that day.
 * 
 * 
 * 
 * For example, flowers[i] = x means that the unique flower that blooms at day
 * i will be at position x, where i and x will be in the range from 1 to N.
 * 
 * 
 * 
 * Also given an integer k, you need to output in which day there exists two
 * flowers in the status of blooming, and also the number of flowers between
 * them is k and these flowers are not blooming.
 * 
 * 
 * 
 * If there isn't such day, output -1.
 * 
 * 
 * Example 1:
 * 
 * Input: 
 * flowers: [1,3,2]
 * k: 1
 * Output: 2
 * Explanation: In the second day, the first and the third flower have become
 * blooming.
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: 
 * flowers: [1,2,3]
 * k: 1
 * Output: -1
 * 
 * 
 * 
 * 
 * Note:
 * 
 * The given array will be in the range [1, 20000].
 * 
 * 
 */
class Solution {
    //Tag:Google; Tag:Array; Tag:BinarySearch
    //O(N)  O(n/k)
    public int kEmptySlots(int[] flowers, int k) {
        //create m buckets, each bucket contains largest and smallest number so far, number means the postion
        int length = flowers.length;
        int bucketLength = k+1;
        int numOfBuckets = length/bucketLength +1 ; //always prepare another bucket
        int[] max = new int[numOfBuckets];
        int[] min = new int[numOfBuckets];
        //preset the bucket
        Arrays.fill(max, Integer.MIN_VALUE);
        Arrays.fill(min, Integer.MAX_VALUE);
        //loop through all flowers
        for(int i=0; i<length; i++){
            int position = flowers[i];
            //find which bucket
            int whichBucket = position/bucketLength;
            //compare with number in the bucket
            //if it is larger than min, dont need to do anything since a larger range did not work out
            if(position<min[whichBucket]){
                //update low
                min[whichBucket]=position;
                //if not the last bucket
                if(whichBucket>0 && max[whichBucket-1]==position-bucketLength) return i+1;
            }
            //same for larger number
            if(position>max[whichBucket]){
                //update high
                max[whichBucket]=position;
                //if not the last bucket
                //== must be exactly the k distance
                if(whichBucket<numOfBuckets-1 && min[whichBucket+1] == position+bucketLength) return i+1;
            }
        }
        return -1;
    }
}

