/*
 * [605] Can Place Flowers
 *
 * https://leetcode.com/problems/can-place-flowers/description/
 *
 * algorithms
 * Easy (30.10%)
 * Total Accepted:    32.3K
 * Total Submissions: 107.4K
 * Testcase Example:  '[1,0,0,0,1]\n1'
 *
 * Suppose you have a long flowerbed in which some of the plots are planted and
 * some are not. However, flowers cannot be planted in adjacent plots - they
 * would compete for water and both would die.
 * 
 * Given a flowerbed (represented as an array containing 0 and 1, where 0 means
 * empty and 1 means not empty), and a number n, return if n new flowers can be
 * planted in it without violating the no-adjacent-flowers rule.
 * 
 * Example 1:
 * 
 * Input: flowerbed = [1,0,0,0,1], n = 1
 * Output: True
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: flowerbed = [1,0,0,0,1], n = 2
 * Output: False
 * 
 * 
 * 
 * Note:
 * 
 * The input array won't violate no-adjacent-flowers rule.
 * The input array size is in the range of [1, 20000].
 * n is a non-negative integer which won't exceed the input array size.
 * 
 * 
 */
public class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int length = flowerbed.length;
        
        for(int i=0; i<length && n>0; i++){
            if(flowerbed[i]==0){
                if(i==0 && i==length-1){
                    flowerbed[i]=1;
                    n--;
                }else if(i==0 && flowerbed[i+1]==0){
                    flowerbed[i]=1;
                    n--;
                }else if(i==length-1 && flowerbed[i-1]==0){
                    flowerbed[i]=1;
                    n--;
                }else if(i!=0 && i!=length-1 && flowerbed[i+1]==0 && flowerbed[i-1]==0){
                    flowerbed[i]=1;
                    n--;
                }
            }
        }
        
        return n==0;
    }
}
