/*
 * [460] LFU Cache
 *
 * https://leetcode.com/problems/lfu-cache/description/
 *
 * algorithms
 * Hard (26.15%)
 * Total Accepted:    26.6K
 * Total Submissions: 101.7K
 * Testcase Example:  '["LFUCache","put","put","get","put","get","get","put","get","get","get"]\n[[2],[1,1],[2,2],[1],[3,3],[2],[3],[4,4],[1],[3],[4]]'
 *
 * Design and implement a data structure for Least Frequently Used (LFU) cache.
 * It should support the following operations: get and put.
 * 
 * 
 * 
 * get(key) - Get the value (will always be positive) of the key if the key
 * exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present.
 * When the cache reaches its capacity, it should invalidate the least
 * frequently used item before inserting a new item. For the purpose of this
 * problem, when there is a tie (i.e., two or more keys that have the same
 * frequency), the least recently used key would be evicted.
 * 
 * 
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 * 
 * Example:
 * 
 * LFUCache cache = new LFUCache( 2 /* capacity */ );
 * 
 * cache.put(1, 1);
 * cache.put(2, 2);
 * cache.get(1);       // returns 1
 * cache.put(3, 3);    // evicts key 2
 * cache.get(2);       // returns -1 (not found)
 * cache.get(3);       // returns 3.
 * cache.put(4, 4);    // evicts key 1.
 * cache.get(1);       // returns -1 (not found)
 * cache.get(3);       // returns 3
 * cache.get(4);       // returns 4
 * 
 * 
 */
class LFUCache {
    //Tag:Amazon
    //Tag:Pinterest
    //Tag:Bloomberg
    //Tag:Design
    Map<Integer, Integer> vals;
    Map<Integer, Integer> counts;
    Map<Integer, LinkedHashSet<Integer>> set;
    int cap = 0;
    int min = -1; //keep track of current min for O(1)

    public LFUCache(int capacity) {
        cap = capacity;
        vals = new HashMap<>();
        counts = new HashMap<>();
        set = new HashMap<>();
        set.put(1, new LinkedHashSet<Integer>());//make sure insert always has a initial list
    }
    
    public int get(int key) {
        if(vals.containsKey(key)){
            int count = counts.get(key);
            //update position of LinkedHashSet
            if(!set.containsKey(count+1)){
                set.put(count+1, new LinkedHashSet<Integer>());
            }
            counts.put(key, count+1);
            set.get(count+1).add(key);
            set.get(count).remove(key);
            //update min frequency number
            if(count==min && set.get(count).size()==0){
                min++;
            }
            return vals.get(key);
        }else{
            return -1;
        }
    }
    
    public void put(int key, int value) {
        //if update
        if(vals.containsKey(key)){
            //update value
            vals.put(key, value);
            //same as upadte
            get(key);
        }else{
            //if add
            //if full, remove first
            if(cap==0){
                if(vals.isEmpty()) return;
                //this returns the first number
                int k = set.get(min).iterator().next();
                set.get(min).remove(k);
                counts.remove(k);
                vals.remove(k);
                cap++;
            }
            counts.put(key, 1);
            vals.put(key, value);
            set.get(1).add(key);
            min = 1;
            cap--;
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
