## 🌀 Fibonacci Number

### 🧩 Problem Description

The **Fibonacci sequence** is a series of numbers where each number is the sum of the two preceding ones. The sequence starts with **0 and 1**, and follows the rule:

[ F(0) = 0, \quad F(1) = 1 ]
[ F(n) = F(n - 1) + F(n - 2) \quad \text{for } n > 1 ]

Given an integer `n`, the task is to return the **n-th Fibonacci number**.

---

### 💡 Example

**Example 1:**

```
Input: n = 2
Output: 1
Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1
```

**Example 2:**

```
Input: n = 3
Output: 2
Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2
```

**Example 3:**

```
Input: n = 4
Output: 3
Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3
```

---

### 📏 Constraints

```
0 <= n <= 30
```

---

### 🧠 Approach

* **Base Case:**
  If `n` is 0 or 1, return `n` directly.
* **Recursive Case:**
  Use recursion to find the sum of the two preceding Fibonacci numbers:
  `F(n) = F(n-1) + F(n-2)`

This approach follows the mathematical definition of Fibonacci numbers directly, ensuring clarity and simplicity.

---

### 💻 Code Implementation

```java
class Solution {
    public int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }
}
```

---

### ⏱️ Time & Space Complexity

* **Time Complexity:** O(2ⁿ) — because each call branches into two new recursive calls.
* **Space Complexity:** O(n) — due to recursive call stack depth.

---

