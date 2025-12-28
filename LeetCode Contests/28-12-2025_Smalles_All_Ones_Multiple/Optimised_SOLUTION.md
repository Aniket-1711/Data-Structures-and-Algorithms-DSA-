# 🔢 Smallest All-Ones Multiple

## 📌 Problem Statement

You are given a positive integer `k`.

You need to find the **smallest number `n`** such that:

* `n` is divisible by `k`
* `n` contains **only digit `1`** in its decimal form

Examples of valid numbers: `1`, `11`, `111`, `1111`, ...

Return the **number of digits** in `n`.
If no such number exists, return `-1`.

---

## ✨ Examples

### Example 1

**Input:**

```
k = 3
```

**Output:**

```
3
```

**Explanation:**
`111` is divisible by `3` and has `3` digits.

---

### Example 2

**Input:**

```
k = 7
```

**Output:**

```
6
```

**Explanation:**
`111111` is divisible by `7`.

---

### Example 3

**Input:**

```
k = 2
```

**Output:**

```
-1
```

**Explanation:**
No number made of only `1`s can be divisible by `2`.

---

## 💡 Key Observations

* Any number made only of `1`s **cannot** be divisible by:

  * `2` (needs even last digit)
  * `5` (needs last digit `0` or `5`)
* So if `k % 2 == 0` or `k % 5 == 0`, answer is **-1** directly.

---

## 🧠 Approach

Instead of building very large numbers, we use **remainders**.

### Idea:

* Start with remainder = `0`
* For each new digit `1`, update remainder as:

  ```
  remainder = (remainder * 10 + 1) % k
  ```
* If remainder becomes `0`, the number formed so far is divisible by `k`

Why this works:

* Modulo keeps numbers small
* There are only `k` possible remainders
* If no solution appears within `k` steps, it will never appear

---

## 🧠 Algorithm Steps

1. If `k` is divisible by `2` or `5`, return `-1`
2. Initialize `remainder = 0`
3. For `i` from `1` to `k`:

   * Update remainder using modulo
   * If remainder becomes `0`, return `i`
4. If loop ends, return `-1`

---

## 🧩 Java Solution

```java
class Solution {
    public int minAllOneMultiple(int k) {
        if (k % 2 == 0 || k % 5 == 0) return -1;

        int remainder = 0;
        int count = 0;

        for (int i = 1; i <= k; i++) {
            remainder = (remainder * 10 + 1) % k;
            count++;
            if (remainder == 0) {
                return count;
            }
        }
        return -1;
    }
}
```

---

## ⏱️ Time Complexity

* **O(k)** — at most `k` iterations

## 💾 Space Complexity

* **O(1)** — constant extra space

---

## ✅ Key Takeaway

This problem looks like a big-number problem, but using **modulo arithmetic** turns it into a simple and efficient solution 🚀
