/*
 * [648] Replace Words
 *
 * https://leetcode.com/problems/replace-words/description/
 *
 * algorithms
 * Medium (47.98%)
 * Total Accepted:    16.7K
 * Total Submissions: 34.8K
 * Testcase Example:  '["cat", "bat", "rat"]\n"the cattle was rattled by the battery"'
 *
 * 
 * In English, we have a concept called root, which can be followed by some
 * other words to form another longer word - let's call this word successor.
 * For example, the root an, followed by other, which can form another word
 * another.
 * 
 * 
 * 
 * 
 * Now, given a dictionary consisting of many roots and a sentence. You need to
 * replace all the successor in the sentence with the root forming it. If a
 * successor has many roots can form it, replace it with the root with the
 * shortest length.
 * 
 * 
 * 
 * You need to output the sentence after the replacement.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: dict = ["cat", "bat", "rat"]
 * sentence = "the cattle was rattled by the battery"
 * Output: "the cat was rat by the bat"
 * 
 * 
 * 
 * 
 * Note:
 * 
 * The input will only have lower-case letters.
 * ⁠1 
 * ⁠1 
 * ⁠1 
 * ⁠1 
 * 
 * 
 */
public class Solution {
    public String replaceWords(List<String> dict, String sentence) {
        if(dict == null || dict.size()==0 || sentence.length()<=1) return sentence;
        // Collections.sort(dict, new Comparator<String>(){
        //     @Override
        //     public int compare(String a, String b){
        //         return a.length()-b.length();
        //     }
        // });
        
        //Dont sort, add to hashset, runing time n
        
        Set<String> roots = new HashSet<String>();
        for(String s : dict){
            roots.add(s);
        }
        
        StringBuilder sb = new StringBuilder();
            
        //Avg running time n* avg of words length
        String[] words = sentence.split(" ");
        for(int j = 0; j< words.length; j++){
            String temp = "";
            //smaller or equals
            for(int i = 1; i<=words[j].length();i++){
                //lower letter substring
                temp = words[j].substring(0, i);
                if(roots.contains(temp)){
                    break;
                }
            }
            sb.append(temp);
            sb.append(" ");
        }
        
        //Dont use trim, better way handleing available
        return sb.toString().trim();
    }
}
