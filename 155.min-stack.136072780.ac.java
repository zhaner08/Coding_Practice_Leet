/*
 * [155] Min Stack
 *
 * https://leetcode.com/problems/min-stack/description/
 *
 * algorithms
 * Easy (31.45%)
 * Total Accepted:    187.4K
 * Total Submissions: 595.8K
 * Testcase Example:  '["MinStack","push","push","push","getMin","pop","top","getMin"]\n[[],[-2],[0],[-3],[],[],[],[]]'
 *
 * 
 * Design a stack that supports push, pop, top, and retrieving the minimum
 * element in constant time.
 * 
 * 
 * push(x) -- Push element x onto stack.
 * 
 * 
 * pop() -- Removes the element on top of the stack.
 * 
 * 
 * top() -- Get the top element.
 * 
 * 
 * getMin() -- Retrieve the minimum element in the stack.
 * 
 * 
 * 
 * 
 * Example:
 * 
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> Returns -3.
 * minStack.pop();
 * minStack.top();      --> Returns 0.
 * minStack.getMin();   --> Returns -2.
 * 
 * 
 */
class MinStack {
    Stack<Long> s;
    long min;

    /** initialize your data structure here. */
    public MinStack() {
        s = new Stack<Long>();
    }
    
    public void push(int x) {
        if(s.isEmpty()){
            s.push(0L);
            min = x;
        }else{
            if(x>=min){
                s.push(x-min);
            }else{
                s.push(x-min);
                //previous 4, current 2, 2-4 = -2
                min = x;
            }
        }
    }
    
    public void pop() {
        if(!s.isEmpty()){
            if(s.peek()>=0){
                s.pop();
            }else{
                long tmp = s.pop();
                min = min-tmp;
            }
        }
    }
    
    public int top() {
        long val = s.peek();
        if(val>=0) return (int)(val+min);
        else return (int)min;
    }
    
    public int getMin() {
        return (int)min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
