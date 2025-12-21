# 🧭 Unique Paths – Memoization (Top‑Down DP)

## 📘 Problem Overview

A robot is placed at the **top‑left corner** of an `m × n` grid.

### Allowed moves:

* ➡️ Right
* ⬇️ Down

The task is to count the number of **unique paths** to reach the **bottom‑right corner**.

---

## 🧠 Why Memoization?

Pure recursion causes **TLE** because the same subproblems are solved repeatedly.

Memoization fixes this by:

* Storing already computed results in a `dp` array
* Reusing them when needed

This reduces time complexity from **exponential** to **polynomial**.

---

## 🔁 Backward Memoization Approach

### 📌 Idea

* Start from the **destination cell** `(m-1, n-1)`
* Move **backward**:

  * Up → `(i-1, j)`
  * Left → `(i, j-1)`

Each state `(i, j)` stores the number of ways to reach the **start cell** `(0, 0)`.

---

### 🛑 Base Cases

* If `(i == 0 && j == 0)` → reached start → return `1`
* If `(i < 0 || j < 0)` → outside grid → return `0`

---

### 🧪 Code (Backward Memoization)

```java
class Solution {
    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = -1;
            }
        }
        return memoPath(m, n, dp, m - 1, n - 1);
    }

    public int memoPath(int m, int n, int dp[][], int i, int j) {
        if (i == 0 && j == 0) {
            return 1;
        }
        if (i < 0 || j < 0) {
            return 0;
        }
        if (dp[i][j] != -1) return dp[i][j];

        return dp[i][j] = memoPath(m, n, dp, i - 1, j)
                        + memoPath(m, n, dp, i, j - 1);
    }
}
```

---

## 🔁 Forward Memoization Approach

### 📌 Idea

* Start from the **start cell** `(0, 0)`
* Move **forward**:

  * Down → `(i+1, j)`
  * Right → `(i, j+1)`

Each state `(i, j)` stores the number of ways to reach the **destination cell** `(m-1, n-1)`.

---

### 🛑 Base Case

* If `(i == m-1 || j == n-1)` → only one straight path left → return `1`

---

### 🧪 Code (Forward Memoization)

```java
class Solution {
    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = -1;
            }
        }
        return recPath(m, n, 0, 0, dp);
    }

    public int recPath(int m, int n, int i, int j, int dp[][]) {
        if (i == m - 1 || j == n - 1) {
            return 1;
        }
        if (dp[i][j] != -1) return dp[i][j];

        return dp[i][j] = recPath(m, n, i + 1, j, dp)
                        + recPath(m, n, i, j + 1, dp);
    }
}
```

---

## ⏱️ Time Complexity

```
O(m × n)
```

* Each cell is computed **only once**

---

## 🧠 Space Complexity

```
O(m × n)  +  O(m + n)
```

* `dp` array → `O(m × n)`
* Recursion stack → `O(m + n)`

---

## 📌 Summary

* Memoization removes repeated work
* Both **forward** and **backward** approaches are valid
* Much faster than pure recursion
* Easy transition to tabulation (bottom‑up)

