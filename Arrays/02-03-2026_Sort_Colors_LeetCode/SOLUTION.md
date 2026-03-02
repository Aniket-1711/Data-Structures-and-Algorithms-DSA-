# 🎨 Sort Colors (Dutch National Flag Algorithm)

## 📌 Problem Statement

Given an array containing only:

* `0` → Red 🔴
* `1` → White ⚪
* `2` → Blue 🔵

Sort the array **in-place** so that all 0s come first, then 1s, then 2s.

❗ You cannot use the built-in sort function.

---

## 🚀 Approach: Dutch National Flag Algorithm

We use **three pointers**:

* `low` → Position to place next `0`
* `mid` → Current element
* `high` → Position to place next `2`

### 🧠 Idea

Traverse the array once:

* If element is `0` → swap with `low`, move `low` and `mid`
* If element is `1` → just move `mid`
* If element is `2` → swap with `high`, move `high`

This works in **one pass** with **constant extra space**.

---

## 💻 Code Implementation (Java)

```java
class Solution {
    public void sortColors(int[] nums) {
        int low = 0, mid = 0;
        int high = nums.length - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                int temp = nums[mid];
                nums[mid] = nums[low];
                nums[low] = temp;
                low++;
                mid++;
            } 
            else if (nums[mid] == 1) {
                mid++;
            } 
            else {
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;
                high--;
            }
        }
    }
}
```

---

## 📊 Example

Input:

```
[2,0,2,1,1,0]
```

Output:

```
[0,0,1,1,2,2]
```

---

## ⏱ Complexity Analysis

* ⏳ Time Complexity: **O(n)** (Single pass)
* 💾 Space Complexity: **O(1)** (In-place sorting)

---

## 🎯 Key Points

* Uses three-pointer technique
* No extra array required
* Solves problem in one traversal
* Also known as the **Dutch National Flag Algorithm** 🇳🇱

---


