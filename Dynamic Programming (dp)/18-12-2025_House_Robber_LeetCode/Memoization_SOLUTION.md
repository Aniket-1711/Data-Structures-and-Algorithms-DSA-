# 🏠 House Robber (LeetCode 198)

## 📌 Problem Summary

You are a robber planning to steal money from houses arranged in a line. Each house has some money, but **you cannot rob two adjacent houses** because of security alarms.

Your task is to **find the maximum amount of money** you can rob without alerting the police.

---

## 🧠 Key Idea

This problem is a classic **Dynamic Programming** problem.

At every house, you have **two choices**:

* 🤑 **Rob the current house** → then skip the next house
* 🚫 **Skip the current house** → move to the next house

You choose the option that gives **maximum money**.

---

## 🔁 Recursive Relation

For a given index `i`:

```
maxMoney(i) = max(
    nums[i] + maxMoney(i + 2),  // steal
    maxMoney(i + 1)             // skip
)
```

To avoid recomputation, we store results using **memoization (dp array)**.

---

## 🧪 Examples

### Example 1

```
Input:  [1, 2, 3, 1]
Output: 4
```

Explanation: Rob house 1 and house 3 → `1 + 3 = 4`

### Example 2

```
Input:  [2, 7, 9, 3, 1]
Output: 12
```

Explanation: Rob house 1, 3, and 5 → `2 + 9 + 1 = 12`

---

## 🧩 Java Solution (Top-Down DP)

```java
class Solution {
    public int helper(int nums[], int index, int dp[]) {
        if (index >= nums.length) return 0;
        if (dp[index] != -1) return dp[index];

        int steal = nums[index] + helper(nums, index + 2, dp);
        int skip = helper(nums, index + 1, dp);

        return dp[index] = Math.max(steal, skip);
    }

    public int rob(int[] nums) {
        int dp[] = new int[100];
        Arrays.fill(dp, -1);
        return helper(nums, 0, dp);
    }
}
```

---

## ⏱️ Complexity Analysis

* **Time Complexity:** `O(n)`
* **Space Complexity:** `O(n)` (dp array + recursion stack)

---

## ✅ Why This Works

* Each house is solved **only once** due to memoization
* Prevents robbing adjacent houses naturally by jumping `index + 2`
* Simple and clean recursive thinking

---

## 🌟 Takeaway

If a problem asks for **maximum/minimum** with **choices at each step**, think **Dynamic Programming**.

