# 🧗 Climbing Stairs

## 📌 Problem Statement

You are climbing a staircase with **n steps**.

* You can climb **1 step** or **2 steps** at a time.
* Find the number of **distinct ways** to reach the top.

---

## 🧪 Examples

### Example 1

**Input:** `n = 2`

**Output:** `2`

**Ways:**

* 1 + 1
* 2

---

### Example 2

**Input:** `n = 3`

**Output:** `3`

**Ways:**

* 1 + 1 + 1
* 1 + 2
* 2 + 1

---

## 💡 Approach Used (Dynamic Programming – Iterative)

This solution uses **Dynamic Programming** with a loop.

### Idea

* To reach step `i`, you can come from:

  * step `i - 1`
  * step `i - 2`

So:

```
dp[i] = dp[i - 1] + dp[i - 2]
```

---

## 🗂️ DP Array Explanation

* `dp[i]` → number of ways to reach step `i`

### Base cases:

* `dp[0] = 1` (one way: stay there)
* `dp[1] = 1` (only one step)

The loop builds the answer from `2` to `n`.

---

## 🧩 Java Code

```java
class Solution {
    public int climbStairs(int n) {
        int dp[] = new int[46];
        dp[0] = 1;
        dp[1] = 1;

        for(int i = 2; i <= n; i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
}
```

---

## ⏱️ Time & Space Complexity

* **Time Complexity:** `O(n)`
* **Space Complexity:** `O(n)`

---

## ✅ Summary

* Uses bottom-up Dynamic Programming
* No recursion used
* Simple and easy to understand
* Works efficiently for `n ≤ 45`

---

