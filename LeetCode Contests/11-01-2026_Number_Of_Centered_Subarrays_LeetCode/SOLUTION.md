# 🎯 Number of Centered Subarrays (LeetCode 3804)

## 📌 Problem

You are given an integer array `nums`.

A subarray is called **centered** if:

```
Sum of elements in the subarray == At least one element inside that subarray
```

Return the total number of such centered subarrays.

---

## 🧠 Idea

* Every single element subarray is always centered (sum = element itself).
* For longer subarrays:

  * Calculate the sum.
  * Check if this sum exists inside the same subarray.

---

## ⚙️ Approach

1. Fix a starting index `i`.
2. Move the ending index `j` from `i` to end.
3. Maintain:

   * `sum` of elements from `i` to `j`.
   * A `HashSet` to store all elements in the current subarray.
4. If `sum` exists in the set → it is a centered subarray.
5. Count it.

---

## 🧩 Example

For `nums = [-1, 1, 0]`

| Subarray | Sum | Present in Subarray? | Centered |
| -------- | --- | -------------------- | -------- |
| [-1]     | -1  | Yes                  | ✅        |
| [1]      | 1   | Yes                  | ✅        |
| [0]      | 0   | Yes                  | ✅        |
| [1, 0]   | 1   | Yes                  | ✅        |
| [-1,1,0] | 0   | Yes                  | ✅        |

Answer = `5`

---

## 💻 Java Code

```java
class Solution {
    public int centeredSubarrays(int[] nums) {
        int count = 0;
        
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            HashSet<Integer> set = new HashSet<>();

            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                set.add(nums[j]);
                
                if (set.contains(sum)) {
                    count++;
                }
            }
        }
        return count;
    }
}
```

---

## ⏱️ Complexity

* **Time:** O(n²)
* **Space:** O(n)

---

## 🏁 Notes

* Constraints are small (n ≤ 500), so O(n²) is acceptable.
* HashSet gives O(1) average lookup for sum checking.

