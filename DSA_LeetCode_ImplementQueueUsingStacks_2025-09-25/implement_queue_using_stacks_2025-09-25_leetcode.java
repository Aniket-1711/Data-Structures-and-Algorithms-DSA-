/**
 * LeetCode Problem: Implement Queue using Stacks
 * 
 * ALGORITHM EXPLANATION:
 * This solution implements a queue (FIFO - First In, First Out) using two stacks (LIFO - Last In, First Out).
 * The key insight is to use one stack for enqueue operations and another for dequeue operations,
 * transferring elements between them when needed to maintain queue ordering.
 * 
 * APPROACH:
 * - stack1: Used primarily for push operations (input stack)
 * - stack2: Used primarily for pop/peek operations (output stack)
 * - When stack2 is empty and we need to pop/peek, transfer all elements from stack1 to stack2
 * - This reverses the order, making the oldest element (first in queue) at the top of stack2
 * 
 * TIME COMPLEXITY:
 * - Push: O(1) - Always constant time
 * - Pop: O(1) amortized - Each element is moved at most twice (stack1 -> stack2 -> out)
 * - Peek: O(1) amortized - Same as pop but without removing
 * - Empty: O(1) - Constant time check
 * 
 * SPACE COMPLEXITY: O(n) where n is the number of elements in the queue
 * 
 * EDGE CASES HANDLED:
 * 1. Empty queue operations (peek/pop on empty queue will be handled by Stack's built-in behavior)
 * 2. Multiple consecutive push/pop operations
 * 3. Mixed operations (push, pop, peek in any order)
 * 
 * Date: 2025-09-25
 * Author: Aniket-1711
 */

import java.util.Stack;

class MyQueue {
    // Input stack - used for all push operations
    private Stack<Integer> stack1;
    
    // Output stack - used for pop and peek operations
    private Stack<Integer> stack2;
    
    /**
     * Constructor: Initialize both stacks as empty
     * Time Complexity: O(1)
     */
    public MyQueue() {
        stack1 = new Stack<>();  // Input stack for new elements
        stack2 = new Stack<>();  // Output stack for dequeue operations
    }
    
    /**
     * Push element x to the back of queue
     * Always pushes to stack1 (input stack)
     * 
     * @param x - integer value to be added to queue
     * Time Complexity: O(1) - Always constant time
     * 
     * ALGORITHM:
     * 1. Simply push the element to stack1
     * 2. No need to modify stack2 during push operation
     */
    public void push(int x) {
        stack1.push(x);  // Add new element to input stack
    }
    
    /**
     * Removes and returns the element from the front of queue
     * Uses stack2 for actual pop operation after ensuring it has elements
     * 
     * @return integer value from front of queue
     * Time Complexity: O(1) amortized
     * 
     * ALGORITHM:
     * 1. Call peek() to ensure stack2 has the front element at top
     * 2. Pop and return from stack2 (which now has correct order)
     * 
     * EDGE CASE: If queue is empty, Stack.pop() will throw EmptyStackException
     */
    public int pop() {
        peek();  // Ensure stack2 has elements in correct order
        return stack2.pop();  // Remove and return front element
    }
    
    /**
     * Get the front element of the queue without removing it
     * Transfers elements from stack1 to stack2 if stack2 is empty
     * 
     * @return integer value at front of queue
     * Time Complexity: O(1) amortized
     * 
     * ALGORITHM:
     * 1. If stack2 is empty, transfer all elements from stack1 to stack2
     * 2. This reverses the order: newest elements go to bottom, oldest to top
     * 3. Return top of stack2 (oldest element = front of queue)
     * 
     * EDGE CASE: If both stacks are empty, Stack.peek() will throw EmptyStackException
     */
    public int peek() {
        // If output stack is empty, transfer all elements from input stack
        if (stack2.empty()) {
            // Move all elements from stack1 to stack2 (reverses order)
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();  // Return front element (top of stack2)
    }
    
    /**
     * Returns whether the queue is empty
     * Queue is empty only when both stacks are empty
     * 
     * @return true if queue is empty, false otherwise
     * Time Complexity: O(1) - Constant time check
     * 
     * ALGORITHM:
     * 1. Check if both stack1 and stack2 are empty
     * 2. If both are empty, no elements exist in queue
     * 3. If either has elements, queue is not empty
     */
    public boolean empty() {
        return stack1.empty() && stack2.empty();
    }
}

/**
 * USAGE EXAMPLE:
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);                    // Add element to back of queue
 * int param_2 = obj.pop();        // Remove and return front element
 * int param_3 = obj.peek();       // Get front element without removing
 * boolean param_4 = obj.empty();  // Check if queue is empty
 * 
 * EXAMPLE EXECUTION TRACE:
 * MyQueue queue = new MyQueue();
 * queue.push(1);    // stack1: [1], stack2: []
 * queue.push(2);    // stack1: [1,2], stack2: []
 * queue.peek();     // Returns 1, stack1: [], stack2: [2,1] (transferred)
 * queue.pop();      // Returns 1, stack1: [], stack2: [2]
 * queue.empty();    // Returns false (stack2 has element 2)
 * queue.pop();      // Returns 2, stack1: [], stack2: []
 * queue.empty();    // Returns true (both stacks empty)
 */
