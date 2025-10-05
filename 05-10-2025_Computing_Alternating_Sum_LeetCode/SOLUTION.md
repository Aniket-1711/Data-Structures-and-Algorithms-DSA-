# 🧮 Alternating Sum of Array

## 💡 Problem Statement
You are given an integer array `nums`.

The **alternating sum** of `nums` is calculated by **adding elements at even indices** and **subtracting elements at odd indices**.  
That is:  
`nums[0] - nums[1] + nums[2] - nums[3] + ...`

Return an integer representing the alternating sum of `nums`.

---

## 🧩 Examples

### Example 1
**Input:**  
`nums = [1, 3, 5, 7]`

**Output:**  
`-4`

**Explanation:**  
- Even indices → `nums[0] = 1`, `nums[2] = 5`  
- Odd indices → `nums[1] = 3`, `nums[3] = 7`  
- Alternating sum = `1 - 3 + 5 - 7 = -4`

---

### Example 2
**Input:**  
`nums = [100]`

**Output:**  
`100`

**Explanation:**  
Only one element exists at index `0`, which is even.  
So, alternating sum = `100`.

---

## ⚙️ Constraints
- `1 <= nums.length <= 100`  
- `1 <= nums[i] <= 100`

---

## 💻 Code Implementation
```java
class Solution {
    public int alternatingSum(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0)
                sum += nums[i];
            else
                sum -= nums[i];
        }
        return sum;
    }
}
```
## 🧠 Quick Insight
👉 Add numbers at even indices and subtract numbers at odd indices — that’s it!
