# Count Operations to Obtain Zero ⚙️

### Problem Explanation and Step-by-Step Solution ✨

---

## 1. The Goal 🏁

You are given **two non-negative integers**, `num1` and `num2`.

In one operation:

* If `num1 >= num2`, subtract `num2` from `num1`.
* Otherwise, subtract `num1` from `num2`.

You must count how many operations it takes until **either num1 or num2 becomes zero.**

---

## 2. Understanding the Process 🔁

Each operation gradually reduces the larger number by the smaller one.

This process is somewhat similar to the **Euclidean algorithm** for computing the GCD, except that we count each subtraction as one operation.

The process stops when at least one of the numbers becomes **0**.

---

## 3. Example Walkthrough 🔢

### Example 1:

**Input:** `num1 = 2, num2 = 3`

| Step | num1 | num2 | Action             | Explanation |
| ---- | ---- | ---- | ------------------ | ----------- |
| 1    | 2    | 3    | num2 = num2 - num1 | → (2, 1)    |
| 2    | 2    | 1    | num1 = num1 - num2 | → (1, 1)    |
| 3    | 1    | 1    | num1 = num1 - num2 | → (0, 1)    |

✅ **Total Operations = 3**

---

### Example 2:

**Input:** `num1 = 10, num2 = 10`

| Step | num1 | num2 | Action             | Explanation |
| ---- | ---- | ---- | ------------------ | ----------- |
| 1    | 10   | 10   | num1 = num1 - num2 | → (0, 10)   |

✅ **Total Operations = 1**

---

## 4. Implementation 🤝

Here’s how the logic maps directly into Java code:

```java
class Solution {
    public int countOperations(int num1, int num2) {
        int count = 0;
        
        while (!(num1 == 0 || num2 == 0)) {
            if (num1 >= num2) {
                num1 = num1 - num2;
            } else {
                num2 = num2 - num1;
            }
            count++;
        }
        
        return count;
    }
}
```

---

## 5. Key Observations 💡

* Every step ensures at least one number decreases.
* The loop ends once one of the numbers hits **0**.
* If both numbers start at 0 → **no operations needed.**
* If both numbers are equal → only **one operation** is needed.

---

## 6. Time and Space Complexity ⚙️

* **Time Complexity:** O(max(num1, num2)) — Each subtraction reduces at least one value.
* **Space Complexity:** O(1) — Only a few integer variables are used.

---

### 🎯 Final Takeaway

* Repeated subtraction until one number becomes 0.
* Count each subtraction as one operation.
* Simple and efficient — works perfectly within the given constraints.
