# ⚡ Fibonacci Number — Precomputation Approach (Java Solution)

## 🧩 Problem Statement

Given an integer `n`, return the nth Fibonacci number `F(n)` where:

```
F(0) = 0,
F(1) = 1,
F(n) = F(n - 1) + F(n - 2)  for n > 1
```

This version uses **precomputation** to efficiently calculate Fibonacci numbers for any `n ≤ 30`.

---

## 💡 Examples

| Input   | Output | Explanation |
| :------ | :----- | :---------- |
| `n = 2` | `1`    | F(2) = 1    |
| `n = 3` | `2`    | F(3) = 2    |
| `n = 4` | `3`    | F(4) = 3    |

---

## ⚙️ Approach (Precomputation)

1. **Precompute** all Fibonacci numbers from `0` to `30` once using iteration.
2. Store them in an integer array `ar[]`.
3. When a query `fib(n)` is called, simply return the precomputed value.

This avoids redundant calculations and recursion overhead.

---

## ✅ Java Implementation

```java
class Solution {
    int ar[] = new int[31];

    public Solution() {
        preCompute();
    }

    public int fib(int n) {
        return ar[n];
    }

    public void preCompute() {
        ar[0] = 0;
        ar[1] = 1;
        for (int i = 2; i < 31; i++) {
            ar[i] = ar[i - 1] + ar[i - 2];
        }
    }
}
```

---

## 🧾 Time and Space Complexity

* **Precomputation Time:** `O(n)` (only once during initialization)
* **Query Time:** `O(1)` per Fibonacci lookup
* **Space Complexity:** `O(n)` for storing precomputed values

---

## 🚀 Advantages

* Very fast lookup (constant time per call) ✅
* Avoids recursion and stack overhead ✅
* Efficient for repeated queries ✅

---

## 🔍 Summary

* Best for problems with **multiple Fibonacci queries**.
* Demonstrates the power of **dynamic programming via tabulation (bottom-up)**.
