# 🚀 Keep Multiplying Found Values by Two — Binary Search Approach (Java)

## 📘 Problem Summary

You're given:

* An integer array `nums`
* A number `original`

Your job is to:

1. Check if `original` exists in `nums`.
2. If yes → multiply `original` by **2**.
3. Repeat as long as the updated value is found.
4. Stop when the number is no longer present.
5. Return the final value of `original`.

This README explains the **Binary Search** version of the solution.

---

## 💡 Why Binary Search?

Binary search helps when the array is **sorted**, making searches much faster:

* Instead of scanning the whole array every time, you divide the search space into half.
* This reduces search time from **O(n)** to **O(log n)** per check.

So, this approach is faster than the linear one.

---

## 🔍 Algorithm Steps

1. Sort the array (important because binary search requires sorting).
2. Use `lo` and `hi` pointers for binary search.
3. If `nums[mid] == original` → multiply `original` by 2.
4. Reset `lo = 0` and `hi = nums.length - 1` because a new value must be searched from the beginning.
5. If `nums[mid] < original` → search in the right half.
6. If `nums[mid] > original` → search in the left half.
7. Continue until `lo > hi`.

---

## ✅ Java Code (Binary Search)

```java
class Solution {
    public int findFinalValue(int[] nums, int original) {
        Arrays.sort(nums);
        int lo = 0, hi = nums.length - 1;
        
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            
            if (nums[mid] == original) {
                original *= 2;     // value found → multiply
                lo = 0;            // restart search
                hi = nums.length - 1;
            } else if (nums[mid] < original) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        
        return original;
    }
}
```

---

## 🧠 Time & Space Complexity

| Type                         | Complexity                                    |
| ---------------------------- | --------------------------------------------- |
| **Sorting**                  | O(n log n)                                    |
| **Binary Search (repeated)** | Each check: O(log n) → repeated several times |
| **Overall**                  | **O(n log n)**                                |
| **Space**                    | **O(1)**                                      |

This makes it significantly faster than the linear method.

---

## 🟢 Example Walkthrough

### Input:

```
nums = [5, 3, 6, 1, 12]
original = 3
```

### Process:

* Sort: `[1, 3, 5, 6, 12]`
* Find **3** → becomes **6**
* Find **6** → becomes **12**
* Find **12** → becomes **24**
* **24** not found → stop

### Output: `24`

---

## 🎉 Summary

The **Binary Search Approach** is:

* Faster ⚡
* More efficient 🔥
* Clean and optimized for larger inputs 📈
