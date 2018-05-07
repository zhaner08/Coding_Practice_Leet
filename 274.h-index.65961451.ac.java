/*
 * [274] H-Index
 *
 * https://leetcode.com/problems/h-index/description/
 *
 * algorithms
 * Medium (33.77%)
 * Total Accepted:    97.4K
 * Total Submissions: 288.4K
 * Testcase Example:  '[]'
 *
 * 
 * Given an array of citations (each citation is a non-negative integer) of a
 * researcher, write a function to compute the researcher's h-index.
 * 
 * 
 * 
 * According to the definition of h-index on Wikipedia: "A scientist has index
 * h if h of his/her N papers have at least h citations each, and the other N −
 * h papers have no more than h citations each."
 * 
 * 
 * 
 * For example, given citations = [3, 0, 6, 1, 5], which means the researcher
 * has 5 papers in total and each of them had received 3, 0, 6, 1, 5 citations
 * respectively. Since the researcher has 3 papers with at least 3 citations
 * each and the remaining two with no more than 3 citations each, his h-index
 * is 3.
 * 
 * 
 * 
 * Note: If there are several possible values for h, the maximum one is taken
 * as the h-index.
 * 
 * 
 * Credits:Special thanks to @jianchao.li.fighter for adding this problem and
 * creating all test cases.
 */
public class Solution {
    public int hIndex(int[] citations) {
        //This way, only go though once, O(N) time
        int length = citations.length;
        if (length == 0) return 0;
        
        //Create a new list to hold number of items, number of items is the max of H you can get
        int[] array2 = new int[length + 1];
        for (int i = 0; i < length; i++) {
            //If number larger than total items amount, put into last element, since it can be use to count toward every element
            if (citations[i] > length) {
                array2[length] += 1;
            //Other, put into crossponding place, which means, if 3 citation for a paper, this number can be use toward a h=3
            } else {
                array2[citations[i]] += 1;
            }
        }
        //Start from last element, total hold number of element can be count toward h
        int total = 0;
        int result = 0;

        for (int i = length; i >= 0; i--) {
            //if 5 elements, if there are total 5 available papers which 5 about citations, than h=5
            //if 5 elements, if there are total 3 elements with citation larger than 3, h=3
            total += array2[i];
            if (total >= i) {
                return i;
            }
        }
        return 0;
    }
}


//This is my work, took O(Nlog(N)) time since need to sort

        // if(citations==null || citations.length==0) return 0;
        // Arrays.sort(citations);
        // int result =1;
        // if(citations[citations.length-1]==0) return 0;
        // for(int i= citations.length-1; i > 0; i--)
        // {
        //     if(citations[i]>=result && citations[i-1]<=result) return result;
        //     if(citations[i]<result) return result-1;
        //     result++;
            
        // }
        // if(citations[0]>=result) return result;
        // else return result-1;
