/*
 * [187] Repeated DNA Sequences
 *
 * https://leetcode.com/problems/repeated-dna-sequences/description/
 *
 * algorithms
 * Medium (33.16%)
 * Total Accepted:    95K
 * Total Submissions: 286.6K
 * Testcase Example:  '"AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"'
 *
 * All DNA is composed of a series of nucleotides abbreviated as A, C, G, and
 * T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to
 * identify repeated sequences within the DNA.
 * 
 * Write a function to find all the 10-letter-long sequences (substrings) that
 * occur more than once in a DNA molecule.
 * 
 * Example:
 * 
 * 
 * Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
 * 
 * Output: ["AAAAACCCCC", "CCCCCAAAAA"]
 * 
 * 
 */
public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
    Set<Integer> words = new HashSet<>();
    Set<Integer> doubleWords = new HashSet<>();
    List<String> rv = new ArrayList<>();
    //We need to save space as much as possible, so we only use 2 bits, 00,01,10,11 to represent the value
    char[] map = new char[26];
    //map['A' - 'A'] = 0;
    map['C' - 'A'] = 1;
    map['G' - 'A'] = 2;
    map['T' - 'A'] = 3;

    //For every char until but the last 10
    for(int i = 0; i < s.length() - 9; i++) {
        int v = 0;
        //put the 10 chars from i into binary, and into decimal
        for(int j = i; j < i + 10; j++) {
            v <<= 2;
            v |= map[s.charAt(j) - 'A'];
        }
        //If can not add, means it has duplicate in hashset, which put the result into the arraylist
        //If cannot insert to doublewords, which means already found the duplicate once, no need to put into the arraylist as a result again
        if(!words.add(v) && doubleWords.add(v)) {
            rv.add(s.substring(i, i + 10));
        }
    }
    return rv;
    }
}
