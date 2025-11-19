# 🚀 Keep Multiplying Found Values by Two — Linear Search Approach (Java)

## 📘 Problem Summary

You are given:

* An array of integers `nums`.
* A number `original`.

Your task is to:

1. Check if `original` exists in `nums`.
2. If found ➝ multiply `original` by **2**.
3. Repeat the process until `original` is no longer found.
4. Return the final `original` value.

This README explains the **Linear Search** approach.

---

## 💡 Why Linear Search?

Linear search is simple:

* You scan the array from **start to end**.
* If you find the number, update it.
* Start scanning again.

Best when the array is **unsorted** and operations are small.

---

## 🔍 Algorithm Steps

1. Start with index `j = 0`.
2. If `nums[j] == original`, multiply `original` by 2.
3. Reset `j = 0` (because updated value might exist earlier).
4. Otherwise, move to next index.
5. Continue until you scan full array **without finding the value**.

---

## ✅ Java Code (Linear Search)

```java
class Solution {
    public int findFinalValue(int[] nums, int original) {
        int j = 0;
        while (j < nums.length) {
            if (nums[j] == original) {
                original *= 2;
                j = 0; // restart search
            } else {
                j++;
            }
        }
        return original;
    }
}
```

---

## 🧠 Time & Space Complexity

| Type      | Complexity                                                                |
| --------- | ------------------------------------------------------------------------- |
| **Time**  | Worst: **O(n²)** (because each time we find a match, we restart scanning) |
| **Space** | **O(1)** (no extra memory used)                                           |

---

## 🟢 Example Walkthrough

### Input:

```
nums = [5, 3, 6, 1, 12]
original = 3
```

### Process:

* Find **3** ➝ becomes **6**
* Find **6** ➝ becomes **12**
* Find **12** ➝ becomes **24**
* **24** not found.

### Output: `24`

---

## 🎉 Summary

The **linear search solution** is simple and easy to understand.
It works well for smaller arrays and when clarity is more important than performance.

---

