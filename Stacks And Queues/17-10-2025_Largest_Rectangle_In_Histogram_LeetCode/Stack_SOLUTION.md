# 🧱 Largest Rectangle in Histogram

## 🧩 Problem Description

You are given an array of integers `heights` representing the histogram's bar height, where the width of each bar is **1**.
Return the **area of the largest rectangle** in the histogram.

---

## 🧠 Example 1

**Input:**

```
heights = [2,1,5,6,2,3]
```

**Output:**

```
10
```

**Explanation:**
The largest rectangle area is 10 units, formed between bars with heights `5` and `6`.

---

## 🌳 Example 2

**Input:**

```
heights = [2,4]
```

**Output:**

```
4
```

**Explanation:**
The rectangle itself forms the largest possible area.

---

## ⚙️ Constraints

* `1 <= heights.length <= 10^5`
* `0 <= heights[i] <= 10^4`

---

## 🧮 Approach

The problem is solved efficiently using the **Monotonic Stack** approach.

1. For each bar, we find:

   * The **nearest smaller element to the left**.
   * The **nearest smaller element to the right**.
2. These two boundaries help calculate the **width** of the largest possible rectangle that can be formed using that bar's height.
3. Finally, compute the area for each bar using the formula:

   `area = height[i] * (right[i] - left[i] - 1)`
4. The **maximum** among all these areas is the answer.

**Time Complexity:** O(N)
**Space Complexity:** O(N)

---

## 💻 Code Implementation (Java)

```java
class Solution {
    public int largestRectangleArea(int[] heights) {
        long ans = 0;
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> stack1 = new Stack<>();
        int ar[] = new int[heights.length];
        int ar1[] = new int[heights.length];

        // Find nearest smaller element to the left
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                ar[i] = -1;
            } else {
                ar[i] = stack.peek();
            }
            stack.push(i);
        }

        // Find nearest smaller element to the right
        for (int i = heights.length - 1; i >= 0; i--) {
            while (!stack1.isEmpty() && heights[stack1.peek()] >= heights[i]) {
                stack1.pop();
            }
            if (stack1.isEmpty()) {
                ar1[i] = heights.length;
            } else {
                ar1[i] = stack1.peek();
            }
            stack1.push(i);
        }

        // Calculate maximum area
        for (int i = 0; i < heights.length; i++) {
            int boundary = ar1[i] - ar[i] - 1;
            ans = Math.max(ans, (long) heights[i] * boundary);
        }
        return (int) ans;
    }
}
```

---

## 🧾 Example Dry Run

### Input:

```
heights = [2,1,5,6,2,3]
```

| Index | Height | Left Smaller | Right Smaller | Width | Area |
| ----- | ------ | ------------ | ------------- | ----- | ---- |
| 0     | 2      | -1           | 1             | 1     | 2    |
| 1     | 1      | -1           | 6             | 6     | 6    |
| 2     | 5      | 1            | 4             | 2     | 10   |
| 3     | 6      | 2            | 4             | 1     | 6    |
| 4     | 2      | 1            | 6             | 4     | 8    |
| 5     | 3      | 4            | 6             | 1     | 3    |

✅ **Maximum Area = 10**

---

## 🧠 Key Points

* Uses **Monotonic Stack** to efficiently find nearest smaller elements.
* Avoids brute-force O(N²) solution.
* Works in linear time, ideal for large inputs.
