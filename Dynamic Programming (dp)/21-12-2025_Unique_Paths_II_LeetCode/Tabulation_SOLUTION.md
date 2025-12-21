# 🧭 63. Unique Paths II (Tabulation – Bottom-Up DP)

## 📌 Problem Statement

You are given an `m x n` grid where:

* `0` → free cell
* `1` → obstacle ❌

A robot starts at the **top-left cell `(0,0)`** and wants to reach the **bottom-right cell `(m-1,n-1)`**.

### 🚶‍♂️ Robot Rules

* The robot can move **only Right or Down**
* The robot **cannot step on obstacles**

👉 Return the number of **unique paths** to reach the destination.

---

## 🧠 Why Tabulation?

* Recursive solutions cause **TLE** due to repeated calculations
* Memoization improves it, but still uses recursion
* **Tabulation (Bottom-Up DP)** is the **most optimized and safest approach**

This approach:

* Uses iteration instead of recursion
* Avoids stack overflow
* Computes each state exactly once

---

## 📐 DP Definition

### 🔹 DP State

`dp[i][j]` = number of unique paths to reach cell `(i, j)` from `(0,0)`

### 🔹 Transition

If cell `(i,j)` is **not an obstacle**:

```
dp[i][j] = dp[i-1][j] + dp[i][j-1]
```

If cell `(i,j)` **is an obstacle**:

```
dp[i][j] = 0
```

---

## 🧱 Initialization

* If starting cell `(0,0)` is an obstacle → answer is `0`
* First row: can only come from **left**
* First column: can only come from **top**

---

## 💻 Code (Tabulation)

```java
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int dp[][] = new int[m][n];

        // starting cell
        dp[0][0] = obstacleGrid[0][0] == 1 ? 0 : 1;

        // first row
        for (int j = 1; j < n; j++) {
            if (obstacleGrid[0][j] != 1)
                dp[0][j] = dp[0][j - 1];
            else
                dp[0][j] = 0;
        }

        // first column
        for (int i = 1; i < m; i++) {
            if (obstacleGrid[i][0] != 1)
                dp[i][0] = dp[i - 1][0];
            else
                dp[i][0] = 0;
        }

        // rest of grid
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] != 1)
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                else
                    dp[i][j] = 0;
            }
        }

        return dp[m - 1][n - 1];
    }
}
```

---

## ⏱️ Complexity Analysis

### ⏳ Time Complexity

[
O(m x n)
]

* Each cell is processed exactly once

### 🧠 Space Complexity

[
O(m x n)
]

* DP table of size `m x n`

---

## 📝 Key Points

* This is the **final optimized solution**
* No recursion → no stack overflow
* Preferred solution in **interviews and submissions**

---
