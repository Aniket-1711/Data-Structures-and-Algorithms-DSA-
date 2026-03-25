# 🚀 Maximum Achievable Number

## 📌 Problem

You are given two integers:

* `num`
* `t`

You can perform an operation **at most `t` times**:

* Increase or decrease `x` by 1
* At the same time, increase or decrease `num` by 1

👉 Goal: Find the **maximum possible value of `x`** such that it can become equal to `num`.

---

## 💡 Key Idea

To maximize `x`, we should:

* Increase `x` by 1
* Decrease `num` by 1

Each operation increases the gap by **2**.

So after `t` operations:

```
Maximum x = num + 2 * t
```

---

## 🧠 Intuition

Each operation helps in pushing `x` higher by 2 compared to `num`.

So we simply multiply `t` by 2 and add it to `num`.

---

## 🧾 Example

### Example 1

```
Input: num = 4, t = 1
Output: 6
```

### Example 2

```
Input: num = 3, t = 2
Output: 7
```

---

## ⚙️ Approach

1. Read `num` and `t`
2. Compute `num + 2 * t`
3. Return the result

---

## 💻 Java Code

```java
class Solution {
    public int theMaximumAchievableX(int num, int t) {
        return num + 2 * t;
    }
}
```

---

## ⏱️ Complexity

* Time Complexity: **O(1)**
* Space Complexity: **O(1)**

---

## ✅ Summary

* Simple math-based problem
* No loops or extra space needed
* Just apply the formula directly 🎯
