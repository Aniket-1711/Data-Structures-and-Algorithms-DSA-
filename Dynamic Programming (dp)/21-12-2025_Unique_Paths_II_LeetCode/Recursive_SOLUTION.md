# 🧭 63. Unique Paths II (Recursive Solution)

## 📌 Problem Overview

A robot starts at the **top-left corner** of an `m x n` grid and wants to reach the **bottom-right corner**.

* The robot can move **only right or down** 🚶‍♂️➡️⬇️
* `0` → free cell
* `1` → obstacle ❌
* The robot **cannot pass through obstacles**

The task is to count the number of **unique paths** from start to destination.

---

## 🧠 Approach Used Here

This solution uses a **pure recursive approach (no DP)**.

### 🔁 Recursive Idea

From a cell `(i, j)`:

* Move **down** → `(i + 1, j)`
* Move **right** → `(i, j + 1)`

Total paths = paths from down + paths from right

---

## 🛑 Base Conditions

* If the robot goes **outside the grid** → return `0`
* If the current cell is an **obstacle** → return `0`
* If the robot **reaches the destination** → return `1`

---

## 💻 Code (Recursive)

```java
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        return uPO(obstacleGrid, m, n, 0, 0);
    }

    public int uPO(int[][] obstacleGrid, int m, int n, int i, int j) {
        // out of bounds or destination blocked
        if (i >= m || j >= n || obstacleGrid[m - 1][n - 1] == 1)
            return 0;

        // obstacle cell
        if (obstacleGrid[i][j] == 1)
            return 0;

        // reached destination
        if (i == m - 1 && j == n - 1)
            return 1;

        return uPO(obstacleGrid, m, n, i + 1, j)
             + uPO(obstacleGrid, m, n, i, j + 1);
    }
}
```

---

## ⚠️ Important Note (Why This Gives TLE)

* This solution **recalculates the same subproblems again and again** 🔁
* Time Complexity is **exponential**: `O(2^(m+n))`
* For large grids (`100 x 100`), this will **Time Limit Exceed (TLE)** ❌

This solution is useful **only for understanding recursion**, not for final submission.

---

## ⏱️ Complexity

### ⏳ Time Complexity

[
O(2^{(m+n)})
]

* From each cell, the recursion branches into **two calls** (right and down)
* Maximum recursion depth is `(m - 1) + (n - 1)`
* This forms a **binary recursion tree** where the same subproblems are recomputed multiple times

Hence, the total number of recursive calls grows exponentially.

### 🧠 Space Complexity

[
O(m+n)
]

* Due to the recursive call stack
* At most `(m + n)` calls deep along one path

---
