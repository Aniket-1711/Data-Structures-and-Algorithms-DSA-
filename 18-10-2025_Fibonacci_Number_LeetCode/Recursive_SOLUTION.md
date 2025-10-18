# 🌀 Fibonacci Number — Recursive Approach (Java Solution)

## 🧩 Problem Statement

The **Fibonacci sequence** is defined as:

```
F(0) = 0,
F(1) = 1,
F(n) = F(n - 1) + F(n - 2)  for n > 1
```

Given an integer `n`, return `F(n)`.

---

## 💡 Examples

| Input   | Output | Explanation                    |
| :------ | :----- | :----------------------------- |
| `n = 2` | `1`    | F(2) = F(1) + F(0) = 1 + 0 = 1 |
| `n = 3` | `2`    | F(3) = F(2) + F(1) = 1 + 1 = 2 |
| `n = 4` | `3`    | F(4) = F(3) + F(2) = 2 + 1 = 3 |

---

## ⚙️ Approach (Recursive)

1. Base cases:

   * If `n == 0`, return `0`.
   * If `n == 1`, return `1`.
2. For all other cases, return the sum of the previous two Fibonacci numbers.

This is a **direct mathematical recursion** approach.

---

## ✅ Java Implementation

```java
class Solution {
    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }
}
```

---

## 🧾 Time and Space Complexity

* **Time Complexity:** `O(2^n)` → each call branches into two recursive calls.
* **Space Complexity:** `O(n)` → recursion stack depth.

---

## ⚠️ Drawback

This approach is **slow for large n**, since many subproblems are recomputed repeatedly.

---

## 🔍 Summary

* Simple to implement ✅
* Inefficient for higher `n` ❌
* Best used for learning recursion basics
