# 🔢 Third Maximum Number
---

## 🧩 Problem Summary

You are given an integer array **nums**. Your task is to find the **third distinct maximum number**.

* If the **third maximum exists → return it**.
* If it **does not exist → return the maximum number** in the array.

The key point:
👉 **Only distinct values are considered. Duplicate values are counted as one.**

---

## 📘 Examples

### Example 1

```
Input: nums = [3,2,1]
Output: 1
```

Distinct nums: `3, 2, 1` → Third maximum = **1**

### Example 2

```
Input: nums = [1,2]
Output: 2
```

Distinct nums: `2, 1` → No third maximum → return **2**

### Example 3

```
Input: nums = [2,2,3,1]
Output: 1
```

Distinct nums: `3, 2, 1` → Third maximum = **1**

---

## 🧠 How the Logic Works (Beginner‑Friendly)

1. 🔄 First, **sort the array** in ascending order.
2. 🧹 Remove duplicates using a list of distinct elements.
3. ✔️ If the list has **3 or more values** → answer = 3rd from the end.
4. ❗ Otherwise → answer = **largest value**.

This method is easy to understand and works correctly.

---

## 🧾 Java Code (Your Code)

```java
class Solution {
    public int thirdMax(int[] nums) {
        Arrays.sort(nums);
        if (nums.length == 1 || nums.length == 2) {
            return nums[nums.length - 1];
        }

        List<Integer> list = new ArrayList<>();
        for (int i : nums) {
            if (!list.contains(i))
                list.add(i);
        }

        if (list.size() > 2)
            return list.get(list.size() - 3);

        return list.get(list.size() - 1);
    }
}
```

---

## ⚙️ Time & Space Complexity

### ⏳ Time Complexity:

* Sorting → `O(n log n)`
* Removing duplicates → `O(n)`

Total: **O(n log n)**

### 📦 Space Complexity:

* List to store unique values → **O(n)**

---

## ⭐ Key Takeaways

* Sorting makes the logic simple.
* Removing duplicates is important.
* If the third distinct value doesn’t exist → return the **maximum number**.
* Works for negative numbers and very large numbers too.

---


