/*
 * [299] Bulls and Cows
 *
 * https://leetcode.com/problems/bulls-and-cows/description/
 *
 * algorithms
 * Medium (36.08%)
 * Total Accepted:    67.8K
 * Total Submissions: 187.9K
 * Testcase Example:  '"1807"\n"7810"'
 *
 * You are playing the following Bulls and Cows game with your friend: You
 * write down a number and ask your friend to guess what the number is. Each
 * time your friend makes a guess, you provide a hint that indicates how many
 * digits in said guess match your secret number exactly in both digit and
 * position (called "bulls") and how many digits match the secret number but
 * locate in the wrong position (called "cows"). Your friend will use
 * successive guesses and hints to eventually derive the secret number.
 * 
 * 
 * For example:
 * 
 * Secret number:  "1807"
 * Friend's guess: "7810"
 * 
 * Hint: 1 bull and 3 cows. (The bull is 8, the cows are 0, 1 and 7.)
 * 
 * 
 * Write a function to return a hint according to the secret number and
 * friend's guess, use A to indicate the bulls and B to indicate the cows. In
 * the above example, your function should return "1A3B". 
 * 
 * Please note that both secret number and friend's guess may contain duplicate
 * digits, for example:
 * 
 * Secret number:  "1123"
 * Friend's guess: "0111"
 * 
 * In this case, the 1st 1 in friend's guess is a bull, the 2nd or 3rd 1 is a
 * cow, and your function should return "1A1B".
 * 
 * 
 * You may assume that the secret number and your friend's guess only contain
 * digits, and their lengths are always equal.
 * 
 * Credits:Special thanks to @jeantimex for adding this problem and creating
 * all test cases.
 */
public class Solution {
    public String getHint(String secret, String guess) {
        int[] tmp = new int[10];
        int bull=0;
        int cow=0;
        for(int i=0; i<secret.length(); i++)
        {
            //if same, it is a bull
            if(secret.charAt(i) == guess.charAt(i)) bull++;
            else
            {
                //Assume if s has, but g does not, s+1 and g-1
                //If s value in previous g value, g was negative, so ++ it, and ++cow
                //If g value in previous s value, s was positive, so -- it, and ++cow
                if(tmp[secret.charAt(i)-'0']<0) cow++;
                if(tmp[guess.charAt(i)-'0']>0) cow++;
                tmp[secret.charAt(i)-'0']++;
                tmp[guess.charAt(i)-'0']--;
            }
        }
        return bull+"A"+cow+"B";
    }
}
