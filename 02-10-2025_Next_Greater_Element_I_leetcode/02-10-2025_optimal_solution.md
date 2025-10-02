# 🔥 Next Greater Element I (LeetCode 496)

## 📌 Problem Statement
You are given two arrays:  
- `nums1`, a subset of `nums2`.  
- `nums2`, a larger array.  

For each element in `nums1`, find the **next greater element** in `nums2`.  
The **next greater element** of a number `x` in `nums2` is the **first greater number to the right** of `x` in `nums2`. If no such element exists, return `-1`.  

### Example
Input: nums1 = [4,1,2], nums2 = [1,3,4,2]
Output: [-1,3,-1]
Explanation:
- For `4` → No greater element to the right → `-1`  
- For `1` → Next greater element is `3` → `3`  
- For `2` → No greater element to the right → `-1`  

---

## 🧠 Intuition
- We need to find the **first greater number to the right** for each element in `nums2`.  
- A **monotonic decreasing stack** helps us efficiently track potential next greater elements while traversing `nums2` from **right to left**.  
- Use a `HashMap` to map elements of `nums1` to their indices, so we can directly fill results.

---

## ⚡ Optimized Approach (Stack + HashMap)
1. Traverse `nums2` from right → left.  
2. Use a stack to maintain candidates for the "next greater element".  
   - Pop elements from the stack while they are **≤ current element**.  
   - If stack is empty → next greater = `-1`.  
   - Else → top of stack = next greater.  
3. Store the result only for elements that are present in `nums1`.  
4. Finally, return the result array for `nums1`.

---

## 📝 Java Code
  ```java
      import java.util.*;
      
      class Solution {
          public int[] nextGreaterElement(int[] nums1, int[] nums2) {
              Stack<Integer> stack = new Stack<>();
              int[] result = new int[nums1.length];
              HashMap<Integer, Integer> map = new HashMap<>();
      
              // Map nums1 values to their indices
              for (int i = 0; i < nums1.length; i++) {
                  map.put(nums1[i], i);
                  result[i] = -1; // default
              }
      
              int ans = -1;
              for (int i = nums2.length - 1; i >= 0; i--) {
                  while (!stack.isEmpty() && stack.peek() < nums2[i]) {
                      stack.pop();
                  }
      
                  ans = stack.isEmpty() ? -1 : stack.peek();
      
                  if (map.containsKey(nums2[i])) {
                      result[map.get(nums2[i])] = ans;
                  }
      
                  stack.push(nums2[i]);
              }
      
              return result;
            }
        }
  ```
---
**⏱ Time Complexity: O(N + M) where N = nums1.length, M = nums2.length**

**💾 Space Complexity: O(M) for stack + hashmap**

## 🖼 Dry Run (Example)
Input:
  ```ini
  nums1 = [4,1,2]
  nums2 = [1,3,4,2]
  ```
## Step by Step:
  ```perl
      Traverse nums2 from right → left
      stack = []
      
      i=3 → nums2[i]=2
       stack empty → next greater = -1
       map? yes (for 2 → index=2)
       result[2] = -1
       stack=[2]
      
      i=2 → nums2[i]=4
       stack=[2], top=2 < 4 → pop → stack=[]
       stack empty → next greater=-1
       map? yes (for 4 → index=0)
       result[0] = -1
       stack=[4]
      
      i=1 → nums2[i]=3
       stack=[4], top=4 > 3 → next greater=4
       map? no (3 not in nums1)
       stack=[4,3]
      
      i=0 → nums2[i]=1
       stack=[4,3], top=3 > 1 → next greater=3
       map? yes (for 1 → index=1)
       result[1] = 3
       stack=[4,3,1]
      
      Final result = [-1,3,-1]
  ```
---
# 📊 Dry Run Diagram
  ```makefile
  nums2 = [1,   3,   4,   2]
           ↑    ↑    ↑    ↑
  Stack:  []  [4]  [4,3] [2]
  
  nums1 = [4, 1, 2]
  result = [-1, 3, -1]
  ```
# **Monotic Stack definition**:
  ## 📘 What is a Monotonic Stack?

  - A monotonic stack is a stack that maintains its elements in a specific order (increasing or decreasing) while processing data.
  
  - **Monotonic Increasing Stack**: The stack elements are always in increasing order from bottom → top. (used for problems like "Next Smaller Element").
  
  - **Monotonic Decreasing Stack**: The stack elements are always in decreasing order from bottom → top. (used here for "Next Greater Element").

👉 It is often used in problems involving "next greater/smaller element" or "sliding window" where we need to quickly find relationships between elements.
