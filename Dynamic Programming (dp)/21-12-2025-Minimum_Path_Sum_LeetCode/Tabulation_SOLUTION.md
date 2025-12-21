# 🧭 64. Minimum Path Sum (Tabulation – Bottom-Up DP)

## 📌 Problem Statement

You are given an `m x n` grid filled with **non-negative integers**.

A robot starts at the **top-left cell (0,0)** and wants to reach the **bottom-right cell (m-1,n-1)**.

### 🚶‍♂️ Movement Rules

* The robot can move **only Right or Down** at any point in time.

👉 Find the **minimum path sum** from start to destination.

---

## 🧠 Why Tabulation?

* Recursive solutions may cause **TLE** due to repeated calculations
* Memoization improves it but still uses recursion
* **Tabulation (Bottom-Up DP)** is the most **efficient and clean** approach

This approach:

* Uses iteration instead of recursion
* Avoids stack overflow
* Computes each cell exactly once

---

## 📐 DP Definition

### 🔹 DP State

`dp[i][j]` = minimum path sum to reach cell `(i, j)` from `(0,0)`

---

### 🔹 Transition Rule

Since the robot can come to `(i, j)` only from **top** or **left**:

```
dp[i][j] = grid[i][j] + min(dp[i-1][j], dp[i][j-1])
```

---

## 🧱 Initialization

* `dp[0][0] = grid[0][0]`
* First row → can only come from **left**
* First column → can only come from **top**

---

## 💻 Code (Tabulation)

```java
class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int dp[][] = new int[m][n];

        dp[0][0] = grid[0][0];

        // first row
        for (int j = 1; j < n; j++) {
            dp[0][j] = grid[0][j] + dp[0][j - 1];
        }

        // first column
        for (int i = 1; i < m; i++) {
            dp[i][0] = grid[i][0] + dp[i - 1][0];
        }

        // remaining cells
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return dp[m - 1][n - 1];
    }
}
```

---

## ⏱️ Complexity Analysis

### ⏳ Time Complexity

O(m × n)

* Each cell in the grid is processed exactly once

### 🧠 Space Complexity

O(m × n)

* DP table of size `m x n`

---

## 📝 Key Points

* This is the **final optimized solution** for this problem
* No recursion → no stack overflow
* Commonly expected solution in **interviews and contests**

---

