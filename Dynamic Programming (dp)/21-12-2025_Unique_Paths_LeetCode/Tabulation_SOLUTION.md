# 🧭 Unique Paths – Tabulation (Bottom-Up DP)

## 📘 Problem Overview

A robot is placed at the **top-left corner** of an `m × n` grid.

### Allowed moves:

* ➡️ Right
* ⬇️ Down

The robot must reach the **bottom-right corner** `(m-1, n-1)`.
The task is to return the number of **unique paths** the robot can take.

---

## 🧠 Tabulation Approach (Bottom-Up DP)

This solution uses **Dynamic Programming with tabulation**.

Instead of recursion, we:

* Build the solution **from the smallest subproblems**
* Store results in a 2D DP table

---

## 📌 DP Definition

```
dp[i][j] = number of unique paths to reach cell (i, j)
```

---

## 🛑 Base Initialization

* `dp[0][0] = 1` → starting cell
* First row → only **right moves** → all `1`
* First column → only **down moves** → all `1`

---

## 🔁 Transition Formula

To reach cell `(i, j)`:

```
dp[i][j] = dp[i-1][j] + dp[i][j-1]
```

* From top → `dp[i-1][j]`
* From left → `dp[i][j-1]`

---

## 🧪 Code (Tabulation)

```java
class Solution {
    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m][n];

        dp[0][0] = 1;

        for (int j = 1; j < n; j++) {
            dp[0][j] = 1;
        }

        for (int i = 1; i < m; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }
}
```

---

## ⏱️ Time Complexity

```
O(m × n)
```

* Each cell is computed exactly once

---

## 🧠 Space Complexity

```
O(m × n)
```

* A 2D DP table is used

---

## 📌 Summary

* Bottom-up dynamic programming
* No recursion, no stack overhead
* Efficient and easy to understand
* Clean transition from memoization

This is the **standard and most readable DP solution** for Unique Paths 🚀
