# 🧹 Remove Element – LeetCode 27

## 📌 Problem

Given an integer array `nums` and an integer `val`, remove all occurrences of `val` **in-place**.

Return the number of elements `k` that are **not equal to `val`**.

After the operation:

* The **first `k` elements** of the array should contain elements not equal to `val`.
* The **remaining elements do not matter**.

## 🧠 Idea

Instead of creating a new array, shift the valid elements to the front of the same array.

Use two pointers:

* `k` → scans the array
* `j` → position where the next valid element should be placed

Whenever the element is **not equal to `val`**, copy it to index `j` and move `j` forward.

## ⚙️ Algorithm

1. Initialize two pointers `k = 0` and `j = 0`.
2. Traverse the array using `k`.
3. If `nums[k] != val`:

   * Copy it to `nums[j]`.
   * Increment `j`.
4. Continue until the array ends.
5. Return the count of valid elements.

## 💻 Java Implementation

```java
class Solution {
    public int removeElement(int[] nums, int val) {
        int k = 0, j = 0;
        int count = 0;

        while (k < nums.length) {
            if (nums[k] != val) {
                nums[j++] = nums[k];
                count++;
            }
            k++;
        }
        return count;
    }
}
```

## 🔍 Example

### Input

```
nums = [3,2,2,3]
val = 3
```

### Steps

```
3 == val → skip
2 != val → move to front
2 != val → move to front
3 == val → skip
```

### Result

```
k = 2
nums = [2,2,_,_]
```

## ⏱ Time & Space Complexity

**Time Complexity:** ⏱ `O(n)`

* Traverse the array once.

**Space Complexity:** 💾 `O(1)`

* No extra space used (in-place modification).

## ✨ Key Points

* Uses **two-pointer technique**.
* Works **in-place** without extra memory.
* Order of remaining elements **does not matter**.
