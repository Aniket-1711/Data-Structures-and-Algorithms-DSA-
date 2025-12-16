# 🧗 Climbing Stairs

## 📌 Problem Statement

You are climbing a staircase with **n steps**.

* You can climb **1 step** or **2 steps** at a time.
* Find how many **distinct ways** you can reach the top.

---

## ✨ Examples

### Example 1

**Input:** `n = 2`

**Output:** `2`

**Ways:**

* 1 step + 1 step
* 2 steps

---

### Example 2

**Input:** `n = 3`

**Output:** `3`

**Ways:**

* 1 + 1 + 1
* 1 + 2
* 2 + 1

---

## 🧠 Approach Used (Recursion + DP)

This solution uses:

* **Recursion** to explore all possible ways
* **Dynamic Programming (Memoization)** to avoid repeated calculations

### Key Idea

* To reach step `n`, you can come from:

  * step `n - 1`
  * step `n - 2`
* So,

```
ways(n) = ways(n - 1) + ways(n - 2)
```

---

## 🗂️ DP Array

* `dp[n]` stores number of ways to reach step `n`
* Initialized with `-1` to mark uncalculated states

Base cases:

* `dp[0] = 1`
* `dp[1] = 1`

---

## 🧩 Java Code

```java
class Solution {
    public static int dp[] = new int[46];

    public Solution() {
        for(int i = 0; i < 46; i++) {
            dp[i] = -1;
        }
        dp[0] = 1;
        dp[1] = 1;
    }

    public int climbStairs(int n) {
        if(n == 0 || n == 1) {
            return 1;
        }

        if(dp[n] == -1) {
            dp[n] = climbStairs(n - 1) + climbStairs(n - 2);
        }

        return dp[n];
    }
}
```

---

## ⏱️ Time & Space Complexity

* **Time Complexity:** `O(n)`
* **Space Complexity:** `O(n)` (DP array + recursion stack)

---

## ✅ Summary

* Simple recursion problem
* Optimized using memoization
* Same pattern as Fibonacci series
* Works efficiently for `n ≤ 45`

---
