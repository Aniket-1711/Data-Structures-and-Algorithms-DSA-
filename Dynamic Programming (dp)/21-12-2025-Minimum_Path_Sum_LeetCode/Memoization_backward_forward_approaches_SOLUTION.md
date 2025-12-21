# 🧭 64. Minimum Path Sum (Memoization – Top Down DP)

## 📌 Problem Statement

You are given an `m x n` grid filled with **non-negative integers**.

A robot starts at the **top-left cell `(0,0)`** and wants to reach the **bottom-right cell `(m-1,n-1)`**.

### 🚶‍♂️ Movement Rules

* The robot can move **only Right or Down**

👉 Find the **minimum path sum** from start to destination.

---

## 🧠 Why Memoization?

A naive recursive solution recalculates the same paths many times, causing **TLE**.

Memoization:

* Stores results of subproblems in `dp[][]`
* Ensures each cell is solved **only once**
* Reduces time complexity from exponential to polynomial

---

## 🔁 Approach 1: Memoization (Forward Direction)

### 👉 Idea

* Start from **(0,0)**
* Move **forward** → Down `(i+1, j)` and Right `(i, j+1)`
* `dp[i][j]` stores the **minimum path sum from `(i,j)` to destination**

---

### 💻 Code: Forward Memoization

```java
class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int dp[][] = new int[m+1][n+1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = -1;
            }
        }
        return pathSum(grid, m, n, 0, 0, dp);
    }

    public int pathSum(int[][] grid, int m, int n, int i, int j, int[][] dp) {
        if (i >= m || j >= n)
            return Integer.MAX_VALUE;

        if (i == m - 1 && j == n - 1)
            return grid[i][j];

        if (dp[i][j] != -1)
            return dp[i][j];

        return dp[i][j] = grid[i][j]
                + Math.min(pathSum(grid, m, n, i + 1, j, dp),
                           pathSum(grid, m, n, i, j + 1, dp));
    }
}
```

---

## 🔄 Approach 2: Memoization (Backward Direction)

### 👉 Idea

* Start from **destination `(m-1,n-1)`**
* Move **backward** → Up `(i-1, j)` and Left `(i, j-1)`
* `dp[i][j]` stores the **minimum path sum from `(0,0)` to `(i,j)`**

---

### 💻 Code: Backward Memoization

```java
class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int dp[][] = new int[m+1][n+1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = -1;
            }
        }
        return pathSum(grid, m - 1, n - 1, dp);
    }

    public int pathSum(int[][] grid, int i, int j, int[][] dp) {
        if (i < 0 || j < 0)
            return Integer.MAX_VALUE;

        if (i == 0 && j == 0)
            return grid[i][j];

        if (dp[i][j] != -1)
            return dp[i][j];

        return dp[i][j] = grid[i][j]
                + Math.min(pathSum(grid, i - 1, j, dp),
                           pathSum(grid, i, j - 1, dp));
    }
}
```

---

## ⏱️ Complexity Analysis (Both Approaches)

### ⏳ Time Complexity

[
O(m x n)
]

* Each cell is computed exactly once due to memoization

### 🧠 Space Complexity

[
O(m x n)
]

* DP table storage
* Recursive stack up to `O(m+n)`

---

## 📝 Key Notes

* Forward and backward memoization are **logically equivalent**
* Direction differs, but both yield the same result
* Next optimization step is **Tabulation (Bottom-Up DP)** 🚀

---
