# 📌 MinStack Implementation (Optimized - Single Stack)  

This repository contains an optimized implementation of the **MinStack** problem, where we can perform all operations (`push`, `pop`, `top`, `getMin`) in **O(1)** time and with only **one stack** (instead of using two stacks).  

---

## 🚀 Problem Statement  
Design a stack that supports the following operations in constant time **O(1)**:  
1. `push(x)` → Push element `x` onto stack.  
2. `pop()` → Removes the element on top of the stack.  
3. `top()` → Get the top element.  
4. `getMin()` → Retrieve the minimum element in the stack.  

---

## 📝 Approach  

Unlike the two-stack solution, here we use **only one stack** and an extra variable `min` to track the current minimum.  

### 🔑 Key Idea  
We encode values in the stack to track changes in the minimum:  

- **Push:**  
  - If stack is empty → push the value, set `min = val`.  
  - If `val < min` → push encoded value `2*val - min`, update `min = val`.  
  - Else, push normally.  

- **Pop:**  
  - If `top < min` → it’s an encoded value, so decode old min using:  
    ```
    min = 2*min - top
    ```
  - Then pop.  

- **Top:**  
  - If `top < min` → actual top is `min`.  
  - Else return top normally.  

- **getMin():** return the current `min`.  

---

## 📂 Code Implementation  
    
  ```java
      class MinStack {
          Stack<Long> stack;
          long min = Integer.MIN_VALUE;
      
          public MinStack() {
              stack = new Stack<>();
          }
          
          // Push operation
          public void push(int val) {
              if (stack.isEmpty()) {
                  stack.push((long) val);
                  min = val;
              } else if (val < min) {
                  // Push encoded value
                  stack.push((long) 2 * val - min);
                  min = val;
              } else {
                  stack.push((long) val);
              }
          }
          
          // Pop operation
          public void pop() {
              if (stack.peek() < min) {
                  // Restore previous minimum
                  min = 2 * min - stack.peek();
              }
              stack.pop();
          }
          
          // Get top element
          public int top() {
              if (stack.peek() < min) {
                  return (int) min;
              }
              long t = stack.peek();
              return (int) t;
          }
          
          // Get minimum element
          public int getMin() {
              return (int) min;
          }
      }
```
 # ✅ Example Usage
 
  ```java
      MinStack obj = new MinStack();
      obj.push(3);
      obj.push(5);
      System.out.println(obj.getMin()); // 3
      obj.push(2);
      obj.push(1);
      System.out.println(obj.getMin()); // 1
      obj.pop();
      System.out.println(obj.getMin()); // 2
      System.out.println(obj.top());    // 2
```
---
# 📊 Time & Space Complexity

- **push()** → O(1)

- **pop()** → O(1)

- **top()** → O(1)

- **getMin()** → O(1)

👉 **Space Complexity**: O(n) (only one stack is used).
---
# 🔍 Dry Run with Diagram

Let’s dry run this input:
  ```java
    push(3), push(5), getMin(), push(2), push(1), getMin(), pop(), getMin(), top()
  ```
---
# Step by Step Execution
  | Operation | Stack Contents   | min | Explanation                                        |
| --------- | ---------------- | --- | -------------------------------------------------- |
| push(3)   | [3]              | 3   | First element, min = 3                             |
| push(5)   | [3, 5]           | 3   | 5 ≥ min → normal push                              |
| getMin()  | [3, 5]           | 3   | Current min = 3                                    |
| push(2)   | [3, **1**]       | 2   | 2 < min → push encoded (2*2 - 3 = 1), update min=2 |
| push(1)   | [3, 5, 1, **0**] | 1   | 1 < min → push encoded (2*1 - 2 = 0), update min=1 |
| getMin()  | [3, 5, 1, 0]     | 1   | Current min = 1                                    |
| pop()     | [3, 5, 1]        | 2   | Top=0 < min, restore min=2*1 - 0 = 2               |
| getMin()  | [3, 5, 1]        | 2   | Current min = 2                                    |
| top()     | [3, 5, 1]        | 2   | Top=1 < min, so actual top = min = 2               |
---
## 🖼 Visual Representation
  ```arduino
    Initial: stack = [], min = ∞
    
    push(3) → stack=[3], min=3
    push(5) → stack=[3,5], min=3
    push(2) → stack=[3,5,1], min=2   (encoded 1 stored)
    push(1) → stack=[3,5,1,0], min=1 (encoded 0 stored)
    
    pop()   → top=0<min → restore old min=2, stack=[3,5,1]
