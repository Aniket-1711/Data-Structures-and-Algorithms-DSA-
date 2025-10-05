# ⚡ Longest Subsequence With Non-Zero Bitwise XOR

## 💡 Problem Statement
You are given an integer array `nums`.

Return the **length of the longest subsequence** in `nums` whose **bitwise XOR** is **non-zero**.  
If no such subsequence exists, return `0`.

A subsequence is a non-empty array that can be derived from another array by deleting some or no elements without changing the order of the remaining elements.

---

## 🧩 Examples

### Example 1
**Input:**  
`nums = [1, 2, 3]`  

**Output:**  
`2`  

**Explanation:**  
One longest subsequence is `[2, 3]`.  
The bitwise XOR = `2 ^ 3 = 1` (non-zero).  
Hence, the length of the longest subsequence = `2`.

---

### Example 2
**Input:**  
`nums = [2, 3, 4]`  

**Output:**  
`3`  

**Explanation:**  
The XOR of all elements = `2 ^ 3 ^ 4 = 5` (non-zero).  
So the entire array `[2, 3, 4]` forms the longest valid subsequence.  
Length = `3`.

---

## ⚙️ Constraints
- `1 <= nums.length <= 10^5`  
- `0 <= nums[i] <= 10^9`

---

## 🧠 Intuition
The XOR of all elements determines whether the whole array itself forms a valid subsequence:
- If the XOR of all elements ≠ 0 → **entire array** gives a non-zero XOR.  
- If XOR = 0 → we can remove any one element to make the XOR non-zero, giving length = `n - 1`.  
- If all elements are `0`, no non-empty subsequence can give non-zero XOR, so answer = `0`.

---

## 💻 Code Implementation
```java
class Solution {
    public int longestSubsequence(int[] nums) {
        int xor = 0;
        boolean allzeros = true;

        for (int i : nums) {
            xor ^= i;
            if (i != 0) allzeros = false;
        }

        if (allzeros) return 0;            // all elements are zero → no non-zero XOR
        if (xor != 0) return nums.length;   // entire array works
        return nums.length - 1;             // remove one element to make XOR non-zero
    }
}
```
## 🔍 Dry Run

Example:
nums = [1, 2, 3]

| Step | Operation | XOR Value                            | Remark          |
| ---- | --------- | ------------------------------------ | --------------- |
| 1    | 1         | 1                                    | (first element) |
| 2    | 1 ^ 2 = 3 | 3                                    |                 |
| 3    | 3 ^ 3 = 0 | XOR = 0 → need to remove one element |                 |

✅ Hence, longest subsequence length = 3 - 1 = 2.
## 🧠 Summary
| Case                     | Condition          | Result         |
| ------------------------ | ------------------ | -------------- |
| All elements = 0         | XOR = 0            | Return `0`     |
| XOR ≠ 0                  | Non-zero XOR       | Return `n`     |
| XOR = 0 but not all zero | Remove one element | Return `n - 1` |
