# 🌄 Sum of Subarray Ranges

## 🧩 Problem Statement
You are given an integer array `nums`.  
The **range** of a subarray is defined as the **difference between the largest and smallest element** in that subarray.  

You need to **return the sum of all subarray ranges** of `nums`.

A **subarray** is a contiguous non-empty sequence of elements within an array.

---

## 🧠 Example

### Example 1:
**Input:**  
`nums = [1, 2, 3]`  

**Output:**  
`4`  

**Explanation:**
The 6 subarrays are:
| Subarray | Max | Min | Range |
|-----------|-----|-----|--------|
| [1]       | 1   | 1   | 0 |
| [2]       | 2   | 2   | 0 |
| [3]       | 3   | 3   | 0 |
| [1,2]     | 2   | 1   | 1 |
| [2,3]     | 3   | 2   | 1 |
| [1,2,3]   | 3   | 1   | 2 |

**Sum of ranges = 0 + 0 + 0 + 1 + 1 + 2 = 4 ✅**

---

### Example 2:
**Input:**  
`nums = [1, 3, 3]`

**Output:**  
`4`

---

### Example 3:
**Input:**  
`nums = [4, -2, -3, 4, 1]`

**Output:**  
`59`

---

## 🧮 Brute Force Approach (Your Code)

### 💡 Idea
We can iterate through all possible subarrays and calculate:
- the **maximum** and **minimum** for each subarray,
- then add `(max - min)` to the total sum.

---

### 🧱 Steps:
1. Start with each index `i` as the beginning of a subarray.
2. Initialize `min` and `max` with `nums[i]`.
3. Expand the subarray by increasing `j` (from `i` to `n-1`).
4. Update `min` and `max` each time.
5. Add `(max - min)` to the total `sum`.

---

### 💻 Code Implementation

```java
class Solution {
    public long subArrayRanges(int[] nums) {
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            int min = nums[i], max = nums[i];
            for (int j = i; j < nums.length; j++) {
                if (nums[j] < min) {
                    min = nums[j];
                }
                if (nums[j] > max) {
                    max = nums[j];
                }
                sum += (long)(max - min);
            }
        }
        return sum;
    }
}
```
## 🔁 Dry Run

Let’s dry-run with nums = [1, 2, 3]

| i | j | Subarray | min | max | range | sum |
| - | - | -------- | --- | --- | ----- | --- |
| 0 | 0 | [1]      | 1   | 1   | 0     | 0   |
| 0 | 1 | [1,2]    | 1   | 2   | 1     | 1   |
| 0 | 2 | [1,2,3]  | 1   | 3   | 2     | 3   |
| 1 | 1 | [2]      | 2   | 2   | 0     | 3   |
| 1 | 2 | [2,3]    | 2   | 3   | 1     | 4   |
| 2 | 2 | [3]      | 3   | 3   | 0     | 4   |

✅ Final answer = 4


## ⏱️ Time Complexity

- Outer loop runs n times.

- Inner loop runs up to n times.

So total = O(n²)

For each subarray, we compute max and min directly → O(1) work per inner loop.
- ✅ Final Time Complexity: **O(n²)**
- ✅ Space Complexity: **O(1)** (constant extra space)
