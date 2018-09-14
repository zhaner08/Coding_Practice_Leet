/*
 * [146] LRU Cache
 *
 * https://leetcode.com/problems/lru-cache/description/
 *
 * algorithms
 * Hard (20.03%)
 * Total Accepted:    174.5K
 * Total Submissions: 871.1K
 * Testcase Example:  '["LRUCache","put","put","get","put","get","put","get","get","get"]\n[[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]'
 *
 * 
 * Design and implement a data structure for Least Recently Used (LRU) cache.
 * It should support the following operations: get and put.
 * 
 * 
 * 
 * get(key) - Get the value (will always be positive) of the key if the key
 * exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present.
 * When the cache reached its capacity, it should invalidate the least recently
 * used item before inserting a new item.
 * 
 * 
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 * 
 * Example:
 * 
 * LRUCache cache = new LRUCache( 2 /* capacity */ );
 * 
 * cache.put(1, 1);
 * cache.put(2, 2);
 * cache.get(1);       // returns 1
 * cache.put(3, 3);    // evicts key 2
 * cache.get(2);       // returns -1 (not found)
 * cache.put(4, 4);    // evicts key 1
 * cache.get(1);       // returns -1 (not found)
 * cache.get(3);       // returns 3
 * cache.get(4);       // returns 4
 * 
 * 
 */
class LRUCache {
    //Tag:All
    //Tag:Design
    class DLinkedNode{
        DLinkedNode pre;
        DLinkedNode next;
        int key;
        int value;
    }
    
    private DLinkedNode head, tail;
    private HashMap<Integer, DLinkedNode> map = new HashMap<Integer, DLinkedNode>();
    private int count, capacity;
    
    private void addNode(DLinkedNode node){
        node.pre = head;
        node.next = head.next;
        
        head.next.pre = node;
        head.next = node;
    }
    
    private void removeNode(DLinkedNode node){
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }
    
    private void moveToHead(DLinkedNode node){
        //move to front
        removeNode(node);
        addNode(node);
    }
    
    private DLinkedNode removeLast(){
        DLinkedNode tmp = tail.pre;
        removeNode(tmp);
        return tmp;
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        count = 0;
        head = new DLinkedNode();
        head.pre =null;
        tail = new DLinkedNode();
        tail.next = null;
        head.next = tail;
        tail.pre = head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)){
            //no 
            return -1;
        }else{
            DLinkedNode tmp = map.get(key);
            moveToHead(tmp);
            return tmp.value;
        }
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            //update
            DLinkedNode tmp = map.get(key);
            tmp.value = value;
            moveToHead(tmp);
        }else{
            DLinkedNode newNode = new DLinkedNode();
            newNode.key = key;
            newNode.value = value;
            map.put(key, newNode);
            count++;
            addNode(newNode);
            if(count>capacity){
                DLinkedNode old = removeLast();
                map.remove(old.key);
                count--;
            }
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
