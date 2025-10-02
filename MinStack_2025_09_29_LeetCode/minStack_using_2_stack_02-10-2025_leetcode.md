# 📌 MinStack Implementation in Java

This repository contains an implementation of the MinStack problem, where along with normal stack operations (push, pop, top), you can also retrieve the minimum element in constant time O(1).

# 🚀 Problem Statement

  1.Design a stack that supports the following operations in O(1) time complexity:
  
  2.push(x) → Push element x onto stack.
  
  3.pop() → Removes the element on top of the stack.
  
  4.top() → Get the top element.
  
  5.getMin() → Retrieve the minimum element in the stack.

 # **📝 Approach**

  To solve this, we use **two stacks**:
  
  **stack** → Main stack that stores all values.
  
  **stack1 (minStack)** → Helper stack that keeps track of the minimum element at each stage.
  
  # 🔑 Key Idea
  
Whenever we **push** a new value:

Always push it to the main stack.

If minStack is empty OR the new value is **less than or equal** to the current minimum, push it to minStack as well.

Whenever we **pop** a value:

Remove the element from the main stack.

If the popped element is also the **current minimum** (top of minStack), pop it from minStack too.

top() simply returns the top element of the main stack.

getMin() simply returns the top element of minStack, which is always the **current minimum**.

**This ensures that minimum tracking is always in sync with the main stack.Whenever we push a new value:**

# 📂 Code Implementation
    class MinStack {
      Stack<Integer> stack;   // Main stack
      Stack<Integer> stack1;  // Min stack

    public MinStack() {
        stack = new Stack<>();
        stack1 = new Stack<>();
    }
    
    // Push operation
    public void push(int val) {
        stack.push(val);

        if (stack1.isEmpty()) {
            stack1.push(val);
        } else {
            if (stack1.peek() >= val) {
                stack1.push(val);
            }
        }
    }
    
    // Pop operation
    public void pop() {
        int item = stack.pop();
        if (stack1.peek() == item) {
            stack1.pop();
        }
    }
    
    // Get top element
    public int top() {
        return stack.peek();
    }
    
    // Get minimum element
    public int getMin() {
        return stack1.peek();
    }
    }
# ✅ Example Usage
    MinStack obj = new MinStack();
    obj.push(-2);
    obj.push(0);
    obj.push(-3);
    System.out.println(obj.getMin()); // -3
    obj.pop();
    System.out.println(obj.top());    // 0
    System.out.println(obj.getMin()); // -2
# 📊 Time & Space Complexity

-push() → O(1)

-pop() → O(1)

-top() → O(1)

-getMin() → O(1)

**👉 Space Complexity: O(n), since we use an extra stack (minStack).**
