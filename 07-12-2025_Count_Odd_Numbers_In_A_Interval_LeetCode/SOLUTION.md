# 🧮 Count Odd Numbers in an Interval Range

## 📌 Problem Statement

You are given two non-negative integers **low** and **high**.

Your task is to **count how many odd numbers** exist between **low** and **high** (inclusive).

---

## ✅ Examples

### Example 1

**Input:**

```
low = 3, high = 7
```

**Output:**

```
3
```

**Explanation:** Odd numbers are `[3, 5, 7]`.

---

### Example 2

**Input:**

```
low = 8, high = 10
```

**Output:**

```
1
```

**Explanation:** Odd number is `[9]`.

---

## ⚙️ Constraints

* `0 <= low <= high <= 10^9`

---

## 🧠 Approach (Simple Logic)

1. First, calculate how many numbers are present between `low` and `high`:

   * `totalNumbers = (high - low) + 1`
2. If `low` is **even** → exactly half of them will be odd.
3. If `low` is **odd** → odd numbers will be one more than half.

This avoids looping and works in **O(1) time** ✅

---

## 💻 Java Code

```java
class Solution {
    public int countOdds(int low, int high) {
        int nums = (high - low) + 1;
        if (low % 2 == 0) {
            return nums / 2;
        }
        return (nums + 1) / 2;
    }
}
```

---

## 🚀 Key Points

* No loops used ✅
* Very fast and efficient
* Handles large values easily

---

🎯 **Time Complexity:** `O(1)`
🎯 **Space Complexity:** `O(1)`

---

