/*
 * [319] Bulb Switcher
 *
 * https://leetcode.com/problems/bulb-switcher/description/
 *
 * algorithms
 * Medium (42.96%)
 * Total Accepted:    48.2K
 * Total Submissions: 112.2K
 * Testcase Example:  '0'
 *
 * 
 * There are n bulbs that are initially off. You first turn on all the bulbs.
 * Then, you turn off every second bulb. On the third round, you toggle every
 * third bulb (turning on if it's off or turning off if it's on). For the ith
 * round, you toggle every i bulb. For the nth round, you only toggle the last
 * bulb.
 * 
 * Find how many bulbs are on after n rounds.
 * 
 * 
 * 
 * Example:
 * 
 * Given n = 3. 
 * At first, the three bulbs are [off, off, off].
 * After first round, the three bulbs are [on, on, on].
 * After second round, the three bulbs are [on, off, on].
 * After third round, the three bulbs are [on, off, off]. 
 * So you should return 1, because there is only one bulb is on.
 * 
 */
public class Solution {
    public int bulbSwitch(int n) {
        //Or use sqrt function, the same
        //every divisor come asa pair, 36: 1 36, 2 18, 3 12, 4 9, 6 6, since double 6, odd number of divisor, which make it filps to on
        if (n<=0) return 0;
        int r = 1;
        while(r*r<=n)
        {
            r++;
        }
        return r-1;
    }
}
