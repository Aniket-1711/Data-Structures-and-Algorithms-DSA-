
# 🔢 Sum of Elements With Frequency Divisible by K

## 📝 Problem Statement

You are given an integer array `nums` and an integer `k`.

Return the **sum of all elements** in `nums` whose **frequency** is **divisible by k**, or `0` if there are no such elements.

> Note: An element is included in the sum **exactly as many times** as it appears in the array **if its total frequency is divisible by k**.

---

## 🔍 Example 1
**Input:**
```text
nums = [1,2,2,3,3,3,3,4], k = 2
```

**Output:**
```text
16
```

**Explanation:**
- `1` appears once → not divisible by 2  
- `2` appears twice → divisible by 2  
- `3` appears four times → divisible by 2  
- `4` appears once → not divisible by 2  

Total sum = 2 + 2 + 3 + 3 + 3 + 3 = **16**

---

## 🔍 Example 2
**Input:**
```text
nums = [1,2,3,4,5], k = 2
```

**Output:**
```text
0
```

**Explanation:**
No element appears an even number of times, so total sum = **0**.

---

## 🔍 Example 3
**Input:**
```text
nums = [4,4,4,1,2,3], k = 3
```

**Output:**
```text
12
```

**Explanation:**
- `4` appears 3 times → divisible by 3  
- `1`, `2`, `3` each appear once → not divisible by 3  

Sum = 4 + 4 + 4 = **12**

---

## ⚙️ Constraints
- `1 <= nums.length <= 100`
- `1 <= nums[i] <= 100`
- `1 <= k <= 100`

---

## 💡 Approach

1. Use a **HashMap** to count the **frequency** of each element.
2. Iterate over each key-value pair in the map.
3. If the frequency of a number is **divisible by k**, multiply the element by its frequency and add it to the answer.
4. Return the final sum.

> ✅ This approach runs in **O(n)** time and **O(n)** space, which is efficient for the given constraints.

---

## 🧠 Intuition

We only include elements whose total occurrences fit evenly into groups of `k`.  
Example: If an element appears 6 times and `k = 3`, we include it since `6 % 3 == 0`.

---

## 💻 Code Implementation (Java)
```java
class Solution {
    public int sumDivisibleByK(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        // Count frequency of each element
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        int ans = 0;

        // Add elements whose frequency is divisible by k
        for (int i : map.keySet()) {
            if (map.get(i) % k == 0) {
                ans += (map.get(i) * i);
            }
        }
        return ans;
    }
}
```

---

## 🧮 Complexity Analysis

| Type | Complexity |
|------|-------------|
| **Time** | O(n) |
| **Space** | O(n) |

---

## 🏁 Summary

This problem focuses on **frequency counting** and **modulo-based selection** of elements.  
By efficiently mapping elements to counts and filtering with a modulo check, we can compute the desired sum with minimal effort.
