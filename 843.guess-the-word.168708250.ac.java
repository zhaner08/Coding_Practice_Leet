/*
 * [873] Guess the Word
 *
 * https://leetcode.com/problems/guess-the-word/description/
 *
 * algorithms
 * Hard (34.54%)
 * Total Accepted:    2.6K
 * Total Submissions: 7.6K
 * Testcase Example:  '"acckzz"\n["acckzz","ccbazz","eiowzz","abcczz"]\n10'
 *
 * This problem is an interactive problem new to the LeetCode platform.
 * 
 * We are given a word list of unique words, each word is 6 letters long, and
 * one word in this list is chosen as secret.
 * 
 * You may call master.guess(word) to guess a word.  The guessed word should
 * have type string and must be from the original list with 6 lowercase
 * letters.
 * 
 * This function returns an integer type, representing the number of exact
 * matches (value and position) of your guess to the secret word.  Also, if
 * your guess is not in the given wordlist, it will return -1 instead.
 * 
 * For each test case, you have 10 guesses to guess the word. At the end of any
 * number of calls, if you have made 10 or less calls to master.guess and at
 * least one of these guesses was the secret, you pass the testcase.
 * 
 * Besides the example test case below, there will be 5 additional test cases,
 * each with 100 words in the word list.  The letters of each word in those
 * testcases were chosen independently at random from 'a' to 'z', such that
 * every word in the given word lists is unique.
 * 
 * 
 * Example 1:
 * Input: secret = "acckzz", wordlist = ["acckzz","ccbazz","eiowzz","abcczz"]
 * 
 * Explanation:
 * 
 * master.guess("aaaaaa") returns -1, because "aaaaaa" is not in wordlist.
 * master.guess("acckzz") returns 6, because "acckzz" is secret and has all 6
 * matches.
 * master.guess("ccbazz") returns 3, because "ccbazz" has 3 matches.
 * master.guess("eiowzz") returns 2, because "eiowzz" has 2 matches.
 * master.guess("abcczz") returns 4, because "abcczz" has 4 matches.
 * 
 * We made 5 calls to master.guess and one of them was the secret, so we pass
 * the test case.
 * 
 * 
 * Note:  Any solutions that attempt to circumvent the judge will result in
 * disqualification.
 * 
 */
/**
 * // This is the Master's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface Master {
 *     public int guess(String word) {}
 * }
 */
class Solution {
    //Tag:Google
    //Tag:Minimax
    public void findSecretWord(String[] wordlist, Master master) {
        //loop 10 times since we can guess 10 times, elimiate non possible word after every loop O(n^2)
        for(int i=0, x=0; i<10 && x<6; i++){
            Map<String, Integer> map = new HashMap<String, Integer>(); //map to count how many word each word has 0 common character
            for(int j=0; j<wordlist.length; j++){
                for(int k=0; k<wordlist.length; k++){
                    if(match(wordlist[j], wordlist[k])==0){
                        map.put(wordlist[j], map.getOrDefault(wordlist[j], 0)+1);
                    }
                }
            }
            
            String curString = "";
            int curCount = 101;
            //update minmax, which will contains word with minimum non relative word
            for(String w: wordlist){
                if(map.getOrDefault(w, 0) < curCount){
                    curCount = map.getOrDefault(w, 0);
                    curString = w;
                }
            }
            
            int count = master.guess(curString);
            
            List<String> newList = new ArrayList();
            for(String w: wordlist){
                if(match(w, curString)==count) newList.add(w);//if only have same number of same chars, it is possible they are answer, otherwise, if they have less, they need more, they have more, they have more wrong characters
            }
            wordlist = newList.toArray(new String[newList.size()]);
        }
    }
    
    public int match(String a, String b){
        int result = 0;
        for(int i=0; i<6; i++){
            result += (a.charAt(i) == b.charAt(i))? 1:0;
        }
        return result;
    }
}
