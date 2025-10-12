# 🔢 Longest Fibonacci Subarray

## 📝 Problem Statement
You are given an array of positive integers `nums`.

A **Fibonacci array** is a contiguous sequence where the **third and subsequent elements** each equal the **sum of the two preceding elements**.

Return the **length of the longest Fibonacci subarray** in `nums`.

**Note:**  
- Subarrays of length 1 or 2 are always considered Fibonacci.  
- A subarray is a contiguous non-empty sequence of elements within an array.

## 📥 Input Format
- An array of positive integers `nums`.

## 📤 Output Format
- Return an integer representing the length of the longest Fibonacci subarray.

## ⚙️ Constraints
- `3 <= nums.length <= 10^5`  
- `1 <= nums[i] <= 10^9`

## 🔍 Example 1
**Input:**
nums = [1,1,1,1,2,3,5,1]
**Output:**
5
**Explanation:**  
The longest Fibonacci subarray is `nums[2..6] = [1, 1, 2, 3, 5]`  
- 1 + 1 = 2  
- 1 + 2 = 3  
- 2 + 3 = 5  

Length = 5

## 🔍 Example 2
**Input:**
nums = [5,2,7,9,16]
**Output:**
5
**Explanation:**  
The longest Fibonacci subarray is `nums[0..4] = [5, 2, 7, 9, 16]`  
- 5 + 2 = 7  
- 2 + 7 = 9  
- 7 + 9 = 16  

Length = 5

## 🔍 Example 3
**Input:**
nums = [1000000000,1000000000,1000000000]

**Output:**
2
**Explanation:**  
The longest Fibonacci subarray is `[1000000000, 1000000000]`  
- Its length is 2, which is the minimum for a Fibonacci subarray.

## 💡 Approach
1. Initialize `len = 2` (minimum Fibonacci subarray length) and `longSubLen = -1`.  
2. Traverse the array from index 2:
   - If `nums[i] == nums[i-1] + nums[i-2]`, increment `len`.  
   - Otherwise, reset `len = 2`.  
   - Update `longSubLen = max(longSubLen, len)`.  
3. Return `longSubLen`.  

This is an **O(n)** solution with **O(1)** space.

## 🧠 Intuition
A Fibonacci subarray behaves like the Fibonacci sequence:  
- Each element after the first two is the sum of the previous two.  
- By keeping a running length of the current Fibonacci subarray, we can efficiently track the longest one.

## 🧾 Code Implementation
```java
class Solution {
    public int longestSubarray(int[] nums) {
        int longSubLen = -1;
        int len = 2;

        for (int i = 2; i < nums.length; i++) {
            if (nums[i] == (nums[i-1] + nums[i-2])) {
                len++;
            } else {
                len = 2;
            }
            longSubLen = Math.max(longSubLen, len);
        }

        return longSubLen;
    }
}
```
## 🧮 Complexity Analysis
| Type     | Complexity |
| -------- | ---------- |
| ⏱️ Time  | O(n)       |
| 🧠 Space | O(1)       |

## 🧩 Example Dry Run
**Input:**
nums = [1,1,1,1,2,3,5,1]
| i | nums[i] | nums[i-1]+nums[i-2] | len | longSubLen |
| - | ------- | ------------------- | --- | ---------- |
| 2 | 1       | 1+1=2               | 2   | 2          |
| 3 | 1       | 1+1=2               | 2   | 2          |
| 4 | 2       | 1+1=2               | 3   | 3          |
| 5 | 3       | 1+2=3               | 4   | 4          |
| 6 | 5       | 2+3=5               | 5   | 5          |
| 7 | 1       | 3+5=8               | 2   | 5          |

✅ Longest Fibonacci subarray length = 5

**🏁 Output**
5
