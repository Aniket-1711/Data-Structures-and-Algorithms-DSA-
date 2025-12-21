# 🧭 63. Unique Paths II (Memoization – Top Down DP)

## 📌 Problem Statement

You are given an `m x n` grid where:

* `0` → free cell
* `1` → obstacle ❌

A robot starts at the **top-left cell `(0,0)`** and wants to reach the **bottom-right cell `(m-1,n-1)`**.

### 🚶‍♂️ Robot Rules

* Can move **only Right or Down**
* Cannot step on an **obstacle**

👉 Return the **number of unique paths** to reach the destination.

---

## 🧠 Why Memoization?

The pure recursive solution recalculates the same states again and again, which causes **TLE**.

Memoization solves this by:

* Storing answers of subproblems in a `dp[][]` array
* Reusing already computed results

This reduces time complexity drastically.

---

## 🔁 Approach 1: Memoization (Forward Direction)

### 👉 Idea

* Start from **(0,0)**
* Move **forward** → Right `(i, j+1)` and Down `(i+1, j)`
* Use `dp[i][j]` to store number of paths from `(i,j)` to destination

---

### 💻 Code: Forward Memoization

```java
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int dp[][] = new int[m+1][n+1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = -1;
            }
        }
        return uPO(obstacleGrid, m, n, 0, 0, dp);
    }

    public int uPO(int[][] obstacleGrid, int m, int n, int i, int j, int[][] dp) {
        if (i >= m || j >= n || obstacleGrid[m-1][n-1] == 1)
            return 0;

        if (obstacleGrid[i][j] == 1)
            return 0;

        if (i == m-1 && j == n-1)
            return 1;

        if (dp[i][j] != -1)
            return dp[i][j];

        return dp[i][j] = uPO(obstacleGrid, m, n, i+1, j, dp)
                        + uPO(obstacleGrid, m, n, i, j+1, dp);
    }
}
```

---

## 🔄 Approach 2: Memoization (Backward Direction)

### 👉 Idea

* Start from **destination `(m-1,n-1)`**
* Move **backward** → Up `(i-1, j)` and Left `(i, j-1)`
* Use `dp[i][j]` to store number of paths from start to `(i,j)`

---

### 💻 Code: Backward Memoization

```java
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int dp[][] = new int[m+1][n+1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = -1;
            }
        }
        return uPO(obstacleGrid, m, n, m-1, n-1, dp);
    }

    public int uPO(int[][] obstacleGrid, int m, int n, int i, int j, int[][] dp) {
        if (i < 0 || j < 0 || obstacleGrid[m-1][n-1] == 1)
            return 0;

        if (obstacleGrid[i][j] == 1)
            return 0;

        if (i == 0 && j == 0)
            return 1;

        if (dp[i][j] != -1)
            return dp[i][j];

        return dp[i][j] = uPO(obstacleGrid, m, n, i-1, j, dp)
                        + uPO(obstacleGrid, m, n, i, j-1, dp);
    }
}
```

---

## ⏱️ Complexity Analysis (Both Approaches)

### ⏳ Time Complexity

[
O(m x n)
]

* Each cell `(i,j)` is computed **only once**
* Memoization prevents repeated recursion

### 🧠 Space Complexity

[
O(m x n)
]

* `dp` array for memoization
* Recursive stack depth up to `O(m+n)`

---

## 📝 Notes

* Forward and Backward memoization are **logically same**, only direction changes
* Both remove **TLE** problem of pure recursion
* Final optimized solution is **Tabulation (Bottom-Up DP)** 🚀

---
