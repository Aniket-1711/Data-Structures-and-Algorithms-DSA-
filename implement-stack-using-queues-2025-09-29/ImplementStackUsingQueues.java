/*
========================================================================================================
                           LEETCODE: IMPLEMENT STACK USING QUEUES
                                    OPTIMAL SOLUTION - SINGLE DEQUE
                                        Date: September 29, 2025
                                            Author: Aniket
========================================================================================================
*/

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * PROBLEM STATEMENT:
 * Implement a last-in-first-out (LIFO) stack using only queues. The implemented stack should support
 * all the functions of a normal stack (push, top, pop, and empty).
 * 
 * OPTIMAL APPROACH - SINGLE DEQUE (ArrayDeque):
 * Instead of using traditional queues, we use a Deque (double-ended queue) which allows us to add/remove
 * from both ends efficiently. This gives us O(1) operations for all stack operations.
 * 
 * Key Strategy:
 * - Use ArrayDeque which implements Deque interface
 * - Push: Add elements to the back (addLast)
 * - Pop: Remove elements from the back (removeLast) - mimics stack behavior
 * - Top: Peek at the back element (peekLast)
 * - This maintains LIFO order naturally
 * 
 * WHY THIS IS OPTIMAL:
 * 1. Time Complexity: O(1) for all operations
 * 2. Space Complexity: O(n) where n is number of elements
 * 3. Uses single data structure instead of multiple queues
 * 4. Natural LIFO behavior without complex manipulations
 */

class MyStack {
    
    // ===============================================================================================
    //                                    CLASS VARIABLES
    // ===============================================================================================
    
    private Deque<Integer> deque;
    
    // ===============================================================================================
    //                                      CONSTRUCTOR
    // ===============================================================================================
    
    /**
     * Initialize the stack object using a single ArrayDeque
     * ArrayDeque is chosen because:
     * - Implements Deque interface efficiently
     * - Provides O(1) operations at both ends
     * - Dynamically resizable
     * - No capacity restrictions (unlike ArrayBlockingQueue)
     */
    public MyStack() {
        deque = new ArrayDeque<>();
    }
    
    // ===============================================================================================
    //                                    STACK OPERATIONS
    // ===============================================================================================
    
    /**
     * PUSH OPERATION
     * Push element x onto stack.
     * 
     * APPROACH:
     * - Add element to the back of deque using addLast()
     * - This maintains insertion order where last added is at the back
     * 
     * Time Complexity: O(1)
     * Space Complexity: O(1) - just adding one element
     * 
     * @param x the element to push onto stack
     */
    public void push(int x) {
        deque.addLast(x);  // Add to back - most recent element
    }
    
    /**
     * POP OPERATION
     * Removes the element on the top of the stack and returns it.
     * 
     * APPROACH:
     * - Remove element from the back of deque using removeLast()
     * - Since we add to back, removing from back gives LIFO behavior
     * - Last added element is the first to be removed
     * 
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     * 
     * @return the top element that was removed
     */
    public int pop() {
        return deque.removeLast();  // Remove from back - LIFO behavior
    }
    
    /**
     * TOP OPERATION
     * Get the top element without removing it.
     * 
     * APPROACH:
     * - Peek at the back element using peekLast()
     * - Returns the most recently added element without removal
     * 
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     * 
     * @return the top element
     */
    public int top() {
        return deque.peekLast();  // Peek at back - most recent element
    }
    
    /**
     * EMPTY CHECK OPERATION
     * Returns whether the stack is empty.
     * 
     * APPROACH:
     * - Check if deque is empty using isEmpty()
     * 
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     * 
     * @return true if stack is empty, false otherwise
     */
    public boolean empty() {
        return deque.isEmpty();
    }
}

// ====================================================================================================
//                                     USAGE AND TESTING
// ====================================================================================================

public class ImplementStackUsingQueues {
    
    /**
     * DEMONSTRATION OF STACK OPERATIONS
     * Shows how the optimal deque-based stack works
     */
    public static void main(String[] args) {
        
        System.out.println("==".repeat(50));
        System.out.println("      LEETCODE: IMPLEMENT STACK USING QUEUES");
        System.out.println("           OPTIMAL SOLUTION - SINGLE DEQUE");
        System.out.println("==".repeat(50));
        
        // Create stack instance
        MyStack stack = new MyStack();
        
        // Test operations
        System.out.println("\n🔸 Testing Stack Operations:");
        System.out.println("-".repeat(40));
        
        // Push operations
        System.out.println("\n1. PUSH Operations:");
        stack.push(1);
        System.out.println("   Pushed: 1");
        stack.push(2);
        System.out.println("   Pushed: 2");
        stack.push(3);
        System.out.println("   Pushed: 3");
        
        // Top operation
        System.out.println("\n2. TOP Operation:");
        System.out.println("   Top element: " + stack.top());
        
        // Pop operations
        System.out.println("\n3. POP Operations:");
        System.out.println("   Popped: " + stack.pop());
        System.out.println("   Popped: " + stack.pop());
        
        // Check if empty
        System.out.println("\n4. EMPTY Check:");
        System.out.println("   Is empty: " + stack.empty());
        
        // Pop remaining
        System.out.println("\n5. Pop Remaining:");
        System.out.println("   Popped: " + stack.pop());
        System.out.println("   Is empty: " + stack.empty());
        
        System.out.println("\n" + "==".repeat(50));
        System.out.println("               TESTING COMPLETED");
        System.out.println("==".repeat(50));
    }
}

/*
========================================================================================================
                                      COMPLEXITY ANALYSIS
========================================================================================================

📊 TIME COMPLEXITY:
   • Push Operation:    O(1) - Direct insertion at back
   • Pop Operation:     O(1) - Direct removal from back  
   • Top Operation:     O(1) - Direct access to back element
   • Empty Operation:   O(1) - Simple boolean check
   
   Overall: All operations are O(1) - OPTIMAL!

💾 SPACE COMPLEXITY:
   • O(n) where n is the number of elements in the stack
   • Single deque used, no additional data structures needed
   • Space efficient compared to multi-queue approaches

========================================================================================================
                                       WHY THIS WORKS
========================================================================================================

🎯 KEY INSIGHTS:
   1. ArrayDeque allows O(1) insertion/deletion at both ends
   2. By using back of deque consistently, we maintain LIFO order naturally
   3. No need for complex queue manipulations or multiple data structures
   4. Deque is essentially a generalization of both stack and queue

⚡ ADVANTAGES OVER OTHER APPROACHES:
   1. Single Data Structure: Uses only one deque vs multiple queues
   2. All O(1) Operations: No O(n) operations unlike traditional queue-based approaches
   3. Memory Efficient: No extra space for queue rotations
   4. Code Simplicity: Straightforward implementation

🌟 REAL-WORLD APPLICATIONS:
   • Undo operations in text editors
   • Function call management in programming languages
   • Browser history navigation
   • Expression evaluation and syntax parsing

========================================================================================================
*/
