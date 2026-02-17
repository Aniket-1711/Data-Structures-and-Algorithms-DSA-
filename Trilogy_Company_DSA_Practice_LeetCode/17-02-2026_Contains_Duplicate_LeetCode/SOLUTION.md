# 🧩 Contains Duplicate (LeetCode 217)

## 📌 Problem Statement

You are given an integer array `nums`.

* Return **true** if **any value appears at least twice** in the array.
* Return **false** if **all elements are distinct**.

---

## 🧠 Approach

We use a **HashSet** to store elements while iterating through the array.

### Why HashSet?

* It stores **only unique elements**
* Insertion and lookup are **fast (O(1))**

### Logic

* Add all elements of the array to the set
* If the size of the set is **less than** the array length → duplicates exist

---

## ✨ Example Walkthrough

### Example 1

```
nums = [1, 2, 3, 1]
```

* Set = `{1, 2, 3}`
* Size mismatch → duplicate found → **true**

### Example 2

```
nums = [1, 2, 3, 4]
```

* Set = `{1, 2, 3, 4}`
* Sizes match → no duplicate → **false**

---

## 💻 Java Solution

```java
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> ele = new HashSet<>();
        for (int i : nums) {
            ele.add(i);
        }
        return ele.size() != nums.length;
    }
}
```

---

## ⏱️ Complexity Analysis

* **Time Complexity:** `O(n)`
* **Space Complexity:** `O(n)`

---

## ✅ Key Takeaway

Using a **HashSet** is the simplest and most efficient way to detect duplicates in an array 🚀
