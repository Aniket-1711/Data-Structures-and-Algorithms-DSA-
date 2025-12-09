# 🧮 Maximum Median Sum of Subsequences of Size 3

## 📌 Problem Overview

You are given an integer array `nums` where the length of the array is divisible by **3**.

You must remove the array in steps:

* In each step, pick **any 3 elements**.
* Find the **median** of those 3 elements.
* Remove them from the array.

👉 Your goal is to **maximize the total sum of all chosen medians**.

---

## ✅ Key Idea

To **maximize the median**, we should:

* Always try to make the median as **large as possible**.
* A median of 3 numbers is the **middle value after sorting**.

So:

1. **Sort the array**.
2. From the **largest side**, pick numbers smartly so that:

   * The median is as large as possible.
3. Skip one element each time to keep space for forming valid triples.

---

## 🧠 Strategy Explained

After sorting:

* The best medians come from the **larger half** of the array.
* For every group of 3 elements, the **second largest** contributes as the median.

We:

* Start from index `n-2` (second largest element)
* Move backwards by 2
* Stop after selecting `n / 3` medians

---

## 💻 Java Code

```java
class Solution {
    public long maximumMedianSum(int[] nums) {
        Arrays.sort(nums);        // Step 1: Sort array
        int n = nums.length;
        long sum = 0;
        
        // Step 2: Pick medians from the right side
        for (int i = n - 2; i >= n / 3; i -= 2) {
            sum += nums[i];
        }
        
        return sum;
    }
}
```

---

## 📊 Example

**Input:**

```
[2, 1, 3, 2, 1, 3]
```

**Sorted:**

```
[1, 1, 2, 2, 3, 3]
```

**Selected Medians:**

* `3`
* `2`

✅ **Output:** `5`

---

## ⏱️ Complexity Analysis

* **Time Complexity:** `O(n log n)` (due to sorting)
* **Space Complexity:** `O(1)` (ignoring sort space)

---

## ⭐ Summary

* Sorting helps control median selection
* Greedy choice from the end gives maximum sum
* Clean and efficient solution for large inputs 🚀
