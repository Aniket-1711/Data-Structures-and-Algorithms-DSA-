# ✂️ Maximum Score of a Split

## 📌 Problem Statement

You are given an integer array `nums` of length `n`.

You must choose a split index `i` such that:

```
0 <= i < n - 1
```

For a chosen index `i`:

* **prefixSum(i)** = sum of elements from `nums[0]` to `nums[i]`
* **suffixMin(i)** = minimum value from `nums[i+1]` to `nums[n-1]`

The **score** of a split is:

```
score(i) = prefixSum(i) - suffixMin(i)
```

Your task is to return the **maximum possible score**.

---

## ✨ Examples

### Example 1

**Input:**

```
[10, -1, 3, -4, -5]
```

**Output:** `17`

---

### Example 2

**Input:**

```
[-7, -5, 3]
```

**Output:** `-2`

---

### Example 3

**Input:**

```
[1, 1]
```

**Output:** `0`

---

## 💡 Approach

We solve this efficiently using **prefix sum** and **suffix minimum**.

### Key Idea:

* While splitting at index `i`, we need:

  * sum of elements on the **left**
  * minimum element on the **right**

Instead of recalculating every time:

* Precompute a **suffix minimum array**
* Maintain a running **prefix sum**

---

## 🧠 Algorithm Steps

1. Create a `suffix[]` array where:

   * `suffix[i]` stores the minimum value from index `i` to end
2. Traverse the array from right to left to fill `suffix[]`
3. Traverse from left to `n-2`:

   * Keep adding to `prefix sum`
   * Calculate `score = prefixSum - suffix[i+1]`
   * Update maximum result

---

## 🧩 Java Solution

```java
class Solution {
    public long maximumScore(int[] nums) {
        long[] suffix = new long[nums.length];
        long sum = 0;

        suffix[nums.length - 1] = nums[nums.length - 1];

        for (int i = nums.length - 2; i >= 0; i--) {
            suffix[i] = Math.min(suffix[i + 1], nums[i]);
        }

        long result = Long.MIN_VALUE;

        for (int i = 0; i < nums.length - 1; i++) {
            sum += nums[i];
            long score = sum - suffix[i + 1];
            result = Math.max(result, score);
        }
        return result;
    }
}
```

---

## ⏱️ Time Complexity

* **O(n)** — single pass for suffix + single pass for prefix

## 💾 Space Complexity

* **O(n)** — suffix minimum array

---

## ✅ Key Takeaway

By combining **prefix sum** with **suffix minimum**, we avoid nested loops and achieve an efficient **linear-time solution** 🚀
