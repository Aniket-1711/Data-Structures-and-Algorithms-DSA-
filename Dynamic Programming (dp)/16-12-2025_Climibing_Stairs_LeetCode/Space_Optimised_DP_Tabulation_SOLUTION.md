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

## 💡 Approach Used (Space Optimized DP)

This solution improves Dynamic Programming by **not using a DP array**.

### Key Idea

* The number of ways follows the **Fibonacci pattern**.
* To calculate the current value, only the **previous two values** are needed.

So instead of an array, we use three variables:

* `a` → ways to reach step `i - 2`
* `b` → ways to reach step `i - 1`
* `ans` → ways to reach step `i`

---

## 🧠 Logic Explanation

* If `n = 0` or `n = 1`, there is only **one way**.
* Start with:

  * `a = 1`
  * `b = 1`
* For each step from `2` to `n`:

  * `ans = a + b`
  * move values forward

---

## 🧩 Java Code

```java
class Solution {
    public int climbStairs(int n) {
        if(n == 0 || n == 1) {
            return 1;
        }

        int a = 1, b = 1, ans = 0;
        for(int i = 2; i <= n; i++) {
            ans = a + b;
            a = b;
            b = ans;
        }

        return ans;
    }
}
```

---

## ⏱️ Time & Space Complexity

* **Time Complexity:** `O(n)`
* **Space Complexity:** `O(1)`

---

## ✅ Summary

* No recursion used
* No DP array used
* Uses only constant space
* Fast and clean solution for `n ≤ 45`

---

