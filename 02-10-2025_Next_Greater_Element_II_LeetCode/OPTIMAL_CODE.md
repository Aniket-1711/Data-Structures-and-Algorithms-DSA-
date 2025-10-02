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

Consider `nums = [1, 2, 1]`

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

## 💻 Solution : Most Optimal Solution (Monotonic Stack)

Uses a stack to efficiently find the next greater elements while simulating the circular array.

  ```java
    import java.util.Stack;

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int ar[] = new int[nums.length];
        Stack<Integer> stack = new Stack<>();

        // Traverse array twice (circular simulation)
        for (int i = 2 * nums.length - 1; i >= 0; i--) {
            int curr = nums[i % nums.length];

            // Maintain decreasing stack
            while (!stack.isEmpty() && stack.peek() <= curr) {
                stack.pop();
            }

            // If stack empty → no greater element
            if (stack.isEmpty()) {
                ar[i % nums.length] = -1;
            } else {
                ar[i % nums.length] = stack.peek();
            }

            // Push current element
            stack.push(curr);
        }

        return ar;
    }
}
  ```
## ⏱️ Complexity:

- Time: O(n) → each element pushed and popped at most once.

- Space: O(n) → stack + result array.
