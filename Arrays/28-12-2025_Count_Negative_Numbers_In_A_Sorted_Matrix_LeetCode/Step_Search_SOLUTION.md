# 🧮 Count Negative Numbers in a Sorted Matrix

## 📌 Problem Statement

You are given a matrix `grid` of size `m x n`.

* Each **row** is sorted in **non-increasing order**
* Each **column** is sorted in **non-increasing order**

Your task is to **count how many negative numbers** are present in the matrix.

---

## ✨ Example 1

**Input:**

```
[[4, 3, 2, -1],
 [3, 2, 1, -1],
 [1, 1, -1, -2],
 [-1, -1, -2, -3]]
```

**Output:** `8`

---

## ✨ Example 2

**Input:**

```
[[3, 2],
 [1, 0]]
```

**Output:** `0`

---

## 💡 Approach (Optimized O(m + n))

We use the sorted property of the matrix.

### Idea:

* Start from the **bottom-left corner**
* If the current number is **negative**:

  * All elements to the **right** are also negative
  * Add `(n - j)` to the answer
  * Move **up**
* If the current number is **non-negative**:

  * Move **right**

This avoids checking every cell.

---

## 🧠 Algorithm Steps

1. Initialize `i = m - 1` (last row)
2. Initialize `j = 0` (first column)
3. While `i >= 0` and `j < n`:

   * If `grid[i][j] < 0`:

     * Add `n - j` to answer
     * Move up (`i--`)
   * Else:

     * Move right (`j++`)

---

## 🧩 Java Solution

```java
class Solution {
    public int countNegatives(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int i = m - 1, j = 0;
        int ans = 0;

        while (i >= 0 && j < n) {
            if (grid[i][j] < 0) {
                ans += (n - j);
                i--;
            } else {
                j++;
            }
        }
        return ans;
    }
}
```

---

## ⏱️ Time Complexity

* **O(m + n)**

## 💾 Space Complexity

* **O(1)** (no extra space used)

---

## ✅ Key Takeaway

Using matrix sorting smartly helps reduce time from **O(m × n)** to **O(m + n)** 🚀
