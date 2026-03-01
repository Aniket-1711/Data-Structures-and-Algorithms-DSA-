# 💰 Minimum Cost to Split into Ones

## 📌 Problem Statement

You are given an integer `n`.

In one operation, you can split a number `x` into two positive integers `a` and `b` such that:

```
a + b = x
```

The cost of this operation is:

```
a * b
```

Your task is to find the **minimum total cost** required to split `n` into `n` ones.

---

## 🧠 Key Idea

To get minimum cost, we should always split like this:

```
x → 1 + (x - 1)
```

Why?

* Because `1 * (x - 1)` is the smallest possible product.
* Any other split (like 2 + 2, 3 + 1, etc.) gives larger cost.

So we keep removing `1` step by step until all numbers become `1`.

---

## 🔎 Pattern Observation

If we split like this every time:

```
n → 1 + (n-1)   → cost = (n-1)
(n-1) → 1 + (n-2) → cost = (n-2)
(n-2) → 1 + (n-3) → cost = (n-3)
...
2 → 1 + 1 → cost = 1
```

Total cost becomes:

```
(n-1) + (n-2) + (n-3) + ... + 1
```

This is the sum of first (n-1) natural numbers.

Formula:

```
n × (n - 1) / 2
```

---

## 💻 Java Code

```java
class Solution {
    public int minCost(int n) {
        return n * (n - 1) / 2;
    }
}
```

---

## ⏱ Time Complexity

* **O(1)** → Direct formula

## 📦 Space Complexity

* **O(1)** → No extra space used

---

## ✅ Important Points

* Always split into `1` and `x-1` for minimum cost.
* Final answer is the sum of numbers from `1` to `n-1`.
* Works for all `1 ≤ n ≤ 500`.

---
