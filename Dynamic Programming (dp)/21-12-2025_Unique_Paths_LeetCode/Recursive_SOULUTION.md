# 🧭 Unique Paths – Recursive Approach (TLE)

## 📘 Problem Overview

A robot is placed at the **top-left corner** of an `m × n` grid.

### Allowed moves:

* ➡️ Right
* ⬇️ Down

The goal is to count how many **unique paths** the robot can take to reach the **bottom-right corner**.

---

## 🧠 Approach Used

This solution uses **pure recursion**.

At each cell `(i, j)`, the robot:

* Moves **down** to `(i + 1, j)`
* Moves **right** to `(i, j + 1)`

The total paths from `(i, j)` is the **sum of paths** from these two moves.

---

## 🛑 Base Case

```java
if(i == m - 1 || j == n - 1) {
    return 1;
}
```

### Why this works:

* If the robot is already on the **last row** or **last column**,
* There is only **one straight path** left to reach the destination.

---

## 🧪 Recursive Code

```java
class Solution {
    public int uniquePaths(int m, int n) {
        return recPath(m, n, 0, 0);
    }

    public int recPath(int m, int n, int i, int j) {
        if (i == m - 1 || j == n - 1) {
            return 1;
        }
        return recPath(m, n, i + 1, j) + recPath(m, n, i, j + 1);
    }
}
```

---

## ⏱️ Time Complexity

```
O(2^(m + n))
```

### Explanation:

* From each cell, the robot has **two choices**: right or down
* Same subproblems are solved **again and again**
* Total recursive calls grow exponentially

This leads to **Time Limit Exceeded (TLE)** for large grids** for larger values of `m` and `n`.

---

## 🧠 Space Complexity

```
O(m + n)
```

### Explanation:

* No extra data structures are used
* Space is consumed only by the **recursion call stack**
* Maximum depth is `(m - 1) + (n - 1)`

---

## ⚠️ Limitation

* No memoization
* No reuse of previously computed results
* Not suitable for large grids

---

## 📌 Summary

* Simple and easy to understand
* Shows the **core idea** of the problem
* Useful for learning recursion
* ❌ Not efficient for large inputs

