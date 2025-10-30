# Next Permutation — README 🚀

**Short description:**
Given an array of integers, modify it *in-place* to form the next lexicographical permutation. If the array is the highest permutation, rearrange it to the lowest (ascending) order. 🔁

**Why this matters:**
This algorithm is widely used in combinatorics, backtracking, and permutation generation. It’s optimized for in-place transformation with O(1) extra memory.

---

## Sections

1. Problem statement ✅
2. Intuition 💡
3. Algorithm 🔧
4. Java implementation 🧾
5. Time & Space complexity ⏱️📦
6. Examples ✏️
7. Edge cases ⚠️
8. Improvements / variants ⚙️

---

## 1) Problem statement

Given an integer array `nums`, transform it into the next lexicographical permutation of its elements using only constant extra memory. If no greater permutation exists, rearrange it into the smallest possible order (ascending).

---

## 2) Intuition

Think of the array as a number formed by its digits. The goal is to find the next higher number using the same digits.

Steps:

* Find the first position (from right to left) where the order is increasing — this is the **pivot**.
* If no pivot is found, the array is in descending order → reverse it.
* Otherwise, find the smallest element to the right of the pivot that is greater than it.
* Swap both.
* Finally, reverse the suffix (the part to the right of the pivot) to make it as small as possible.

This gives the smallest lexicographically larger arrangement.

---

## 3) Algorithm

1. Let `n = nums.length`.
2. Find the largest index `k` where `nums[k] < nums[k + 1]`. If none found, reverse entire array and return.
3. Find the rightmost index `i > k` such that `nums[i] > nums[k]`.
4. Swap `nums[k]` and `nums[i]`.
5. Reverse the subarray `nums[k + 1 ... n - 1]`.

---

## 4) Java implementation

```java
class Solution {
    public void nextPermutation(int[] nums) {
        int pivot = -1;
        int n = nums.length;
        // Step 1: find pivot
        for (int i = n - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                pivot = i - 1;
                break;
            }
        }

        // Step 2: if no pivot, reverse whole array
        if (pivot == -1) {
            reverseArray(nums, 0, n - 1);
            return;
        }

        // Step 3: find rightmost element greater than pivot and swap
        for (int i = n - 1; i > pivot; i--) {
            if (nums[i] > nums[pivot]) {
                int temp = nums[i];
                nums[i] = nums[pivot];
                nums[pivot] = temp;
                break;
            }
        }

        // Step 4: reverse suffix
        reverseArray(nums, pivot + 1, n - 1);
    }

    void reverseArray(int nums[], int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left++] = nums[right];
            nums[right--] = temp;
        }
    }
}
```

---

## 5) Complexity

* **Time Complexity:** O(n)
* **Space Complexity:** O(1)

---

## 6) Examples

**Example 1:** `nums = [1,2,3]`

* Pivot = 1 (value 2). Swap with 3 → [1,3,2]. Reverse suffix → `[1,3,2]`.

**Example 2:** `nums = [3,2,1]`

* No pivot → reverse → `[1,2,3]`.

**Example 3:** `nums = [1,1,5]`

* Pivot = 1 (value 1). Swap with 5 → [1,5,1]. Reverse suffix → `[1,5,1]`.

---

## 7) Edge cases

* Arrays with duplicates: works fine since it uses `>` comparison.
* Single-element array: unchanged.
* All elements equal: reverse gives same array.
* Watch for off-by-one errors in reversal.

---

## 8) Improvements / variants

* Repeatedly calling this function generates all permutations in lexicographic order.
* In large datasets, this is the optimal way to compute the next permutation efficiently in O(n) time.

---

