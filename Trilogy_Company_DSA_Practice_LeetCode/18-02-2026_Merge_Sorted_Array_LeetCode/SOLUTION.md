# 🔀 Merge Sorted Array (LeetCode 88)

## 📌 Problem Statement

You are given two integer arrays **nums1** and **nums2**, both sorted in **non-decreasing order**.

* `nums1` has a length of `m + n`
* First `m` elements of `nums1` are valid
* Last `n` elements of `nums1` are `0` placeholders
* `nums2` has `n` valid elements

Your task is to **merge nums2 into nums1** so that `nums1` becomes a **single sorted array**.

⚠️ The result must be stored **inside nums1**. Do not return anything.

---

## 🧠 Key Insight

If we start merging from the **front**, we may overwrite useful values in `nums1`.

👉 So the best approach is to **merge from the back** of the array.

This way:

* Empty spaces in `nums1` are used first
* No extra space is required

---

## 🧪 Examples

| nums1           | m | nums2     | n | Result          |
| --------------- | - | --------- | - | --------------- |
| `[1,2,3,0,0,0]` | 3 | `[2,5,6]` | 3 | `[1,2,2,3,5,6]` |
| `[1]`           | 1 | `[]`      | 0 | `[1]`           |
| `[0]`           | 0 | `[1]`     | 1 | `[1]`           |

---

## ⚙️ Approach (Three Pointers)

1. `i` → last valid index of nums1 (`m - 1`)
2. `j` → last index of nums2 (`n - 1`)
3. `k` → last index of nums1 (`m + n - 1`)

Compare elements from the **end** and place the larger one at position `k`.

---

## 💻 Java Solution

```java
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (j >= 0) {
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
    }
}
```

---

## ⏱️ Complexity Analysis

* **Time Complexity:** `O(m + n)`
* **Space Complexity:** `O(1)` (in-place)

---

## ✅ Why This Works

* Uses already available empty space in nums1
* Avoids overwriting elements
* Handles all edge cases (`m = 0`, `n = 0`)

---

