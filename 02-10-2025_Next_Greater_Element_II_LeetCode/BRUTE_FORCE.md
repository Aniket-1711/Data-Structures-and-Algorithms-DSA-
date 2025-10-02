# 🔄 Next Greater Element II

## 📌 Problem Statement
You are given a **circular integer array** `nums` (i.e., the next element of `nums[nums.length - 1]` is `nums[0]`).  
Return the **Next Greater Number** for every element in `nums`.  

- The Next Greater Number of a number `x` is the **first greater number** to its traversing-order next in the array, which means you may need to loop around circularly.
- If it doesn’t exist, output `-1` for that number.

---

## 🧩 Example
**Input:**  
nums = [1, 2, 1]

**Output:**  
[2, -1, 2]


**Explanation:**  
- For `1` → the next greater element is `2`.  
- For `2` → no greater element, hence `-1`.  
- For the last `1` → circularly, the next greater element is `2`.  

---

## 🖼️ Dry Run Diagram

Index: 0 1 2
Nums: [1, 2, 1]
Output: [?, ?, ?]

Step 1: i=0 (value=1)
Next greater = 2 → ar[0] = 2

Step 2: i=1 (value=2)
No greater found → ar[1] = -1

Step 3: i=2 (value=1)
Circularly → next greater = 2 → ar[2] = 2

Final: [2, -1, 2]


---

## 💻 Solution 1: **Basic Brute Force Approach**

This approach explicitly checks:
1. Forward elements from `i+1` to end.  
2. If not found, checks from start `0` to `i-1`.  
3. If still not found, assigns `-1`.  

```java
    class Solution {
        public int[] nextGreaterElements(int[] nums) {
            int ar[] = new int[nums.length];
    
            // Initialize with sentinel
            for (int i = 0; i < ar.length; i++) {
                ar[i] = Integer.MIN_VALUE;
            }
    
            for (int i = 0; i < nums.length; i++) {
                // Step 1: check forward elements
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] > nums[i]) {
                        ar[i] = nums[j];
                        break;
                    }
                }
    
                // Step 2: if not found, check circular from 0 → i-1
                if (ar[i] == Integer.MIN_VALUE) {
                    for (int j = 0; j < i; j++) {
                        if (nums[j] > nums[i]) {
                            ar[i] = nums[j];
                            break;
                        }
                    }
                }
    
                // Step 3: if still not found → assign -1
                if (ar[i] == Integer.MIN_VALUE) ar[i] = -1;
            }
    
            return ar;
        }
    }
```

## 💻 Solution 2: Optimized Brute Force

Instead of writing two loops, we merge them into one loop by using the modulus % operator.

Loop from i+1 to i+nums.length-1

Use j % nums.length to simulate circular indexing

Consider `nums = [1, 2, 1]`
```java
    class Solution {
        public int[] nextGreaterElements(int[] nums) {
            int ar[] = new int[nums.length];
    
            // Initialize with sentinel
            for (int i = 0; i < nums.length; i++) {
                ar[i] = Integer.MIN_VALUE;
            }
    
            for (int i = 0; i < nums.length; i++) {
                // Circular traversal using modulo
                for (int j = i + 1; j <= i + nums.length - 1; j++) {
                    if (nums[j % nums.length] > nums[i]) {
                        ar[i] = nums[j % nums.length];
                        break;
                    }
                }
    
                // If not updated → assign -1
                if (ar[i] == Integer.MIN_VALUE) ar[i] = -1;
            }
            return ar;
        }
    }
```
## ⏱️ Complexity Analysis

  - Time Complexity: O(n^2)
  
  - Worst case, for each element we might scan the whole array.
  
  - Space Complexity: O(n)
  
  - Only result array used.
