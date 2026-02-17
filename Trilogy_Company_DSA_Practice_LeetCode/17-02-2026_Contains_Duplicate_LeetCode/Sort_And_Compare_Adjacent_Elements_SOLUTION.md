# 🧩 Contains Duplicate (Sorting Approach)

## 📌 Problem Statement

You are given an integer array `nums`.

* Return **true** if any value appears **at least twice** in the array.
* Return **false** if **all elements are distinct**.

---

## 🧠 Approach: Sorting

In this approach, we **sort the array first** and then check for **adjacent equal elements**.

### Why this works?

* After sorting, **duplicate elements come next to each other**
* We only need to compare `nums[i]` with `nums[i-1]`

---

## 🔍 Step-by-Step Logic

1. Sort the array using `Arrays.sort()`
2. Traverse from index `1` to `n-1`
3. If any adjacent elements are equal → duplicate found
4. If loop ends → all elements are unique

---

## ✨ Example Walkthrough

### Example 1

```
nums = [1, 2, 3, 1]
```

After sorting:

```
[1, 1, 2, 3]
```

* `nums[0] == nums[1]` → duplicate → **true**

### Example 2

```
nums = [1, 2, 3, 4]
```

After sorting:

```
[1, 2, 3, 4]
```

* No adjacent elements are equal → **false**

---

## 💻 Java Solution

```java
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == nums[i]) {
                return true;
            }
        }
        return false;
    }
}
```

---

## ⏱️ Complexity Analysis

* **Time Complexity:** `O(n log n)` (due to sorting)
* **Space Complexity:** `O(1)` (ignoring sorting internals)

---

## ⚠️ Important Note

This approach **modifies the original array** due to sorting.

If modifying the array is not allowed, prefer the **HashSet approach**.

---

## ✅ Key Takeaway

Sorting + adjacent comparison is a **simple and clean solution**, but not the fastest compared to HashSet 🚀
