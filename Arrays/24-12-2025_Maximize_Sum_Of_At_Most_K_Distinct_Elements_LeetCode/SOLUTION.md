# 🧮 Maximize Sum of At Most K Distinct Elements

## 📘 Problem Statement

You are given:

* An integer array `nums`
* An integer `k`

You can **choose at most `k` elements** from `nums` such that:

* All chosen elements are **distinct**
* The **sum is maximum**

Return the chosen elements in **strictly descending order**.

---

## 🔍 Key Observations

* Duplicate values are **not allowed** in the final selection
* To maximize sum, we should **prefer larger values**
* If unique elements are fewer than `k`, choose **all unique elements**

---

## 🧠 Approach

1. **Sort** the array in ascending order
2. Use a `HashSet` to count **unique elements**
3. Determine how many elements to pick: `min(k, uniqueCount)`
4. Traverse from the **largest element to smallest**
5. Pick elements only if they are **not already chosen**
6. Stop once required elements are collected

---

## 💻 Java Solution

```java
class Solution {
    public int[] maxKDistinct(int[] nums, int k) {
        Arrays.sort(nums);
        
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }
        
        int dist = Math.min(set.size(), k);
        int[] ar = new int[dist];
        Set<Integer> used = new HashSet<>();
        
        int index = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (!used.contains(nums[i])) {
                used.add(nums[i]);
                ar[index++] = nums[i];
                if (index == dist) {
                    return ar;
                }
            }
        }
        return ar;
    }
}
```

---

## ⏱️ Time & Space Complexity

* **Time Complexity:** `O(n log n)` (due to sorting)
* **Space Complexity:** `O(n)` (for HashSets)

---

## ✅ Example

**Input:**

```
nums = [84,93,100,77,93]
k = 3
```

**Output:**

```
[100, 93, 84]
```

---

## 📝 Notes

* Output is always in **descending order**
* Uses simple data structures, beginner-friendly
* Efficient for given constraints

---
