# 🚀 Longest Consecutive Sequence (Sorting Approach)

## 📌 Problem

Given an unsorted array of integers, find the length of the longest sequence of consecutive numbers.

👉 Example:

```
Input: [100,4,200,1,3,2]
Output: 4
Explanation: [1,2,3,4]
```

---

## 🧠 Approach Used: Sorting

### 💡 Idea

* First, sort the array.
* Then traverse it and count consecutive numbers.
* Handle duplicates carefully (ignore them).

---

## ⚙️ Steps

1. If array is empty → return `0`
2. Sort the array
3. Initialize:

   * `streak = 1`
   * `maxStreak = 1`
4. Traverse the array:

   * If current element = previous + 1 → increase streak
   * If duplicate → ignore
   * Else → reset streak to 1
5. Keep updating `maxStreak`

---

## 🧾 Code

```java
class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0) return 0;
        Arrays.sort(nums);

        int streak=1,maxStreak=1;
        int min=Integer.MIN_VALUE;

        for(int i=0;i<nums.length;i++){
            if(nums[i]-1==min){
                streak++;
                maxStreak=Math.max(maxStreak, streak);
                min=nums[i];
            }
            else if(nums[i]==min){
                // duplicate → ignore
            }
            else{
                maxStreak=Math.max(maxStreak, streak);
                streak=1;
                min=nums[i];
            }
        }
        return maxStreak;
    }
}
```

---

## ⏱️ Complexity

| Type  | Complexity                  |
| ----- | --------------------------- |
| Time  | O(n log n) (due to sorting) |
| Space | O(1)                        |

---

## ⚠️ Important Points

* Sorting makes it easier to detect consecutive numbers
* Duplicates must be skipped
* This approach does **NOT** satisfy O(n) constraint of the problem

---

## 🧩 When to Use

* Good for understanding the problem
* Useful when O(n log n) is acceptable
* Not optimal for strict constraints

---

## 📌 Summary

✔ Simple and easy to implement
❌ Not optimal (violates O(n) requirement)
✔ Helps build intuition before optimal solution

---
