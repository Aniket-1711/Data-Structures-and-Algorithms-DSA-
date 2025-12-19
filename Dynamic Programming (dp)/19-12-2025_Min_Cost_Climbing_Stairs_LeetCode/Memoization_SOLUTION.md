# 🧗‍♂️ Min Cost Climbing Stairs

## 📌 Problem Statement

You are given an integer array `cost` where `cost[i]` is the cost of the **i-th step** on a staircase.

* After paying the cost of a step, you can move **1 or 2 steps** ahead.
* You can start from **index 0 or index 1**.

🎯 **Goal:** Find the **minimum cost** to reach the top of the floor.

---

## 🧠 Approach (Dynamic Programming)

We use **Top-Down DP (Recursion + Memoization)**.

### Idea:

* From any step `i`, you can go to:

  * step `i + 1`
  * step `i + 2`
* Choose the path with **minimum cost**.
* Store results in a `dp[]` array to avoid recomputation.

We calculate the minimum cost starting from:

* step `0`
* step `1`

And take the **minimum of both**.

---

## 🧩 Algorithm Steps

1. Create a `dp` array initialized with `-1`.
2. Use a recursive helper function.
3. Base case: if index goes out of bounds → cost = `0`.
4. Memoize results to improve performance.

---

## 💻 Java Code

```java
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int dp[] = new int[cost.length + 1];
        Arrays.fill(dp, -1);
        return Math.min(helper(cost, dp, 0), helper(cost, dp, 1));
    }

    public int helper(int[] cost, int[] dp, int index) {
        if (index >= cost.length) {
            return 0;
        }

        if (dp[index] != -1) {
            return dp[index];
        }

        return dp[index] = cost[index] + Math.min(
            helper(cost, dp, index + 1),
            helper(cost, dp, index + 2)
        );
    }
}
```

---

## 🧪 Example

**Input:**

```
cost = [10, 15, 20]
```

**Output:**

```
15
```

---

## ⏱️ Complexity Analysis

* **Time Complexity:** `O(n)`
* **Space Complexity:** `O(n)` (DP array + recursion stack)

---

## ✅ Key Takeaways

* Classic **DP staircase problem**
* Memoization avoids repeated work
* Clean and efficient solution for beginners 🚀
