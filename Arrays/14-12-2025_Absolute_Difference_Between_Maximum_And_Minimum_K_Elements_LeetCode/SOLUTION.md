# 📊 Absolute Difference Between Maximum and Minimum K Elements

## 🧠 Problem Statement

You are given:

* An integer array `nums`
* An integer `k`

Your task is to find the **absolute difference** between:

* 🟢 The sum of the **k largest elements**
* 🔵 The sum of the **k smallest elements**

Return the final absolute difference.

---

## 🔍 Approach

### Step-by-step logic:

1. **Sort the array** in ascending order
2. Add the **first `k` elements** → smallest sum
3. Add the **last `k` elements** → largest sum
4. Return `abs(maxSum - minSum)`

This works because sorting places:

* Smallest elements at the beginning
* Largest elements at the end

---

## 💻 Java Implementation

```java
class Solution {
    public int absDifference(int[] nums, int k) {
        Arrays.sort(nums);

        int minSum = 0;
        int maxSum = 0;

        // sum of k smallest elements
        for (int i = 0; i < k; i++) {
            minSum += nums[i];
        }

        // sum of k largest elements
        for (int i = nums.length - 1; i >= nums.length - k; i--) {
            maxSum += nums[i];
        }

        return Math.abs(maxSum - minSum);
    }
}
```

---

## 🧪 Example

### Input

```
nums = [5, 2, 2, 4]
k = 2
```

### Explanation

* k smallest → 2 + 2 = 4
* k largest → 5 + 4 = 9
* Absolute difference → |9 − 4| = **5**

### Output

```
5
```

---

## ⏱️ Complexity Analysis

* **Time Complexity:** `O(n log n)` (due to sorting)
* **Space Complexity:** `O(1)` (no extra space used)

---

## ✅ Key Points

* Sorting makes selection easy
* Constraints are small, so this approach is efficient
* Clean and beginner-friendly solution

---

