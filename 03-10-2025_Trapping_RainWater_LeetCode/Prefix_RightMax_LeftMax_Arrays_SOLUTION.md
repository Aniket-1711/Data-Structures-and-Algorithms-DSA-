# 🌊 Trapping Rain Water

## 📖 Problem Statement
Given **n non-negative integers** representing an elevation map where the width of each bar is `1`, compute **how much water it can trap** after raining.

---

## 🛠️ Input Format
- An integer array `height[]` of size `n`.

## 📤 Output Format
- Return a single integer representing the total units of trapped rainwater.

---

## 🧮 Examples

### Example 1
**Input:**  
height = [0,1,0,2,1,0,1,3,2,1,2,1]
**Output:**  
6
**Explanation:**  
The bars form valleys where water can accumulate. A total of **6 units** of rainwater are trapped.

---

### Example 2
**Input:**  
height = [4,2,0,3,2,5]

**Output:**  
9

---

## 💡 Approach: Precomputing LeftMax and RightMax

1. Create two arrays:
   - `maxLeft[i]`: The tallest bar to the **left** of index `i`.  
   - `maxRight[i]`: The tallest bar to the **right** of index `i`.  

2. For each index `i`, the water trapped is:  

trapped[i] = min(maxLeft[i], maxRight[i]) - height[i]

3. Add all trapped values to get the final answer.

---

## ⚡ Java Solution (Precomputation)

```java
class Solution {
 public int trap(int[] height) {
     int n = height.length;
     int[] maxLeft = new int[n];
     int[] maxRight = new int[n];

     int prevMaxLeft = Integer.MIN_VALUE, prevMaxRight = Integer.MIN_VALUE;

     for (int i = 0; i < n; i++) {
         // Compute maxLeft
         if (height[i] > prevMaxLeft) {
             prevMaxLeft = height[i];
         }
         maxLeft[i] = prevMaxLeft;

         // Compute maxRight simultaneously
         if (height[n - 1 - i] > prevMaxRight) {
             prevMaxRight = height[n - 1 - i];
         }
         maxRight[n - 1 - i] = prevMaxRight;
     }

     int ans = 0;
     for (int i = 0; i < n; i++) {
         ans += Math.min(maxLeft[i], maxRight[i]) - height[i];
     }
     return ans;
 }
}
```
## 🔄 Dry Run

For height = [0,1,0,2,1,0,1,3,2,1,2,1]
| i  | height[i] | maxLeft[i] | maxRight[i] | min(L,R) | trapped[i] |
| -- | --------- | ---------- | ----------- | -------- | ---------- |
| 0  | 0         | 0          | 3           | 0        | 0          |
| 1  | 1         | 1          | 3           | 1        | 0          |
| 2  | 0         | 1          | 3           | 1        | 1          |
| 3  | 2         | 2          | 3           | 2        | 0          |
| 4  | 1         | 2          | 3           | 2        | 1          |
| 5  | 0         | 2          | 3           | 2        | 2          |
| 6  | 1         | 2          | 3           | 2        | 1          |
| 7  | 3         | 3          | 3           | 3        | 0          |
| 8  | 2         | 3          | 2           | 2        | 0          |
| 9  | 1         | 3          | 2           | 2        | 1          |
| 10 | 2         | 3          | 2           | 2        | 0          |
| 11 | 1         | 3          | 1           | 1        | 0          |

Total = 6 units
## 📊 Complexity Analysis

- Time Complexity: O(N) → Single pass to compute left & right arrays + single pass to calculate trapped water.

- Space Complexity: O(N) → Two extra arrays.
