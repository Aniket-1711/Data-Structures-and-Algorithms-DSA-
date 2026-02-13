# 🔢 Count Pairs Whose Sum is Less than Target

## 📘 Problem Statement

Given an integer array `nums` and an integer `target`, count the number of index pairs `(i, j)` such that:

* `0 ≤ i < j < n`
* `nums[i] + nums[j] < target`

---

## 🧪 Examples

### Example 1

**Input:**

```
nums = [-1, 1, 2, 3, 1]
target = 2
```

**Output:**

```
3
```

### Example 2

**Input:**

```
nums = [-6, 2, 5, -2, -7, -1, 3]
target = -2
```

**Output:**

```
10
```

---

## 💡 Approach (Two Pointer Technique)

1. Sort the array
2. Use two pointers:

   * `left` starting from beginning
   * `right` starting from end
3. While `left < right`:

   * If `nums[left] + nums[right] < target`

     * All pairs between `left` and `right` are valid
     * Add `(right - left)` to answer
     * Move `left++`
   * Else

     * Move `right--`

---

## ✅ Java Solution

```java
class Solution {
    public int countPairs(List<Integer> nums, int target) {
        Collections.sort(nums);

        int left = 0;
        int right = nums.size() - 1;
        int count = 0;

        while (left < right) {
            if (nums.get(left) + nums.get(right) < target) {
                count += (right - left);
                left++;
            } else {
                right--;
            }
        }
        return count;
    }
}
```

---

## ⏱️ Complexity Analysis

* **Time Complexity:** `O(n log n)` (due to sorting)
* **Space Complexity:** `O(1)` (no extra space used)

---

## 🎯 Key Takeaways

* Sorting helps reduce time complexity
* Two pointer method avoids nested loops
* Efficient and clean solution for pair problems

---

