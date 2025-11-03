## 🌟 Subsets

**Difficulty:** Medium
**Topics:** Array, Backtracking
**Companies:** 💼 Common Interview Problem

---

### 🧩 Problem Description

Given an integer array `nums` containing **unique elements**, return **all possible subsets** (the **power set**).

The solution set **must not contain duplicate subsets**, and the subsets can be returned in **any order**.

---

### 📘 Example 1

**Input:**
`nums = [1, 2, 3]`

**Output:**
`[[], [1], [2], [1,2], [3], [1,3], [2,3], [1,2,3]]`

---

### 📘 Example 2

**Input:**
`nums = [0]`

**Output:**
`[[], [0]]`

---

### ⚙️ Constraints

* `1 <= nums.length <= 10`
* `-10 <= nums[i] <= 10`
* All numbers in `nums` are **unique**

---

### 💡 Approach

This problem can be efficiently solved using **Backtracking**:

1. Use recursion to explore two possibilities for each element:

   * Include the element.
   * Exclude the element.
2. Each recursive call builds subsets step by step.
3. Once the end of the array is reached, the current subset is added to the result.

This ensures all `2^n` subsets are generated.

---

### 🧠 Algorithm

1. Start with an empty subset `[]`.
2. For every element in `nums`, decide:

   * ✅ Include it → move to the next index.
   * 🚫 Exclude it → move to the next index.
3. When the index reaches the end of the array, store the subset copy in the result.
4. Use backtracking to remove the last added element and explore other possibilities.

---

### 🧾 Code Implementation

```java
import java.util.*;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        generateSubsets(nums, result, list, 0, nums.length);
        return result;
    }

    public void generateSubsets(int[] nums, List<List<Integer>> result, List<Integer> list, int index, int n) {
        if (index == n) {
            result.add(new ArrayList<>(list)); // add a copy of current subset
            return;
        }

        // Include current element
        list.add(nums[index]);
        generateSubsets(nums, result, list, index + 1, n);

        // Exclude current element
        list.remove(list.size() - 1);
        generateSubsets(nums, result, list, index + 1, n);
    }
}
```

---

### 🧮 Time & Space Complexity

* **Time Complexity:** O(2^n) ⏱️ — Every element has two choices (include/exclude).
* **Space Complexity:** O(n) 💾 — Recursion stack depth.

---

### 🏁 Summary

| Concept            | Explanation                       |
| ------------------ | --------------------------------- |
| **Technique Used** | Backtracking                      |
| **Output Type**    | List of Lists                     |
| **Subsets Count**  | 2ⁿ                                |
| **Key Operation**  | Add & remove elements recursively |

---

✨ **In short:** Explore every include/exclude path recursively to generate all possible subsets — a clean, elegant use of backtracking.
