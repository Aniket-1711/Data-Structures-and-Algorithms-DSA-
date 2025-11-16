# ✨ Maximize Expression of Three Elements ✨

## 📌 Problem Overview

You are given an integer array `nums` and must select **three distinct** elements `a`, `b`, and `c` such that the expression:

> **a + b - c**

is **maximized** 🎯

Return the **maximum possible** value of this expression.

---

## 🧠 Key Idea

To maximize:

* `a + b` should be as **large** as possible → choose **two largest elements**
* `-c` should be as **large (positive)** as possible → choose the **smallest element**

So the best choice is:

```
a = largest
b = second largest
c = smallest
```

✔️ Because: **largest + second largest − smallest = highest result** 🚀

---

## 🛠️ Approach (Optimized)

1️⃣ Sort the array in ascending order
2️⃣ Pick:

* Last element → biggest (`a`)
* Second last → second biggest (`b`)
* First element → smallest (`c`)
  3️⃣ Return `a + b - c`

🕒 Time Complexity: **O(n log n)** (sorting step)
📦 Space Complexity: **O(1)** (in‑place)

---

## 👨‍💻 Java Code Implementation

```java
class Solution {
    public int maximizeExpressionOfThree(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length-1] + nums[nums.length-2] - nums[0];
    }
}
```

---

## 🧾 Example

### 👉 Input

```
nums = [1,4,2,5]
```

### 👉 Best choice

* a = 5
* b = 4
* c = 1

### 👉 Output

```
5 + 4 - 1 = 8
```

🎉 Max value = **8**

---

## 🏁 Conclusion

Use the **top two maximum numbers** and **lowest number** for best result 😎🔥

---

## ✍️ Notes

* Ensure all three numbers are from **different indices**
* Works for negative values too

---

