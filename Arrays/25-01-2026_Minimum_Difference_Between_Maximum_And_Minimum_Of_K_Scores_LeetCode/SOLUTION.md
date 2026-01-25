# 📉 Minimum Difference Between Highest and Lowest of K Scores

## 🧩 Problem

You are given an array `nums` where each value is a student's score. You are also given an integer `k`.

Your task is to pick any `k` students such that the difference between the **highest** and **lowest** score among them is **minimum**.

Return this minimum difference.

---

## 💡 Idea

1. Sort the array.
2. Use a sliding window of size `k`.
3. For every window, calculate:

   `difference = nums[i + k - 1] - nums[i]`
4. Keep the smallest difference.

Sorting helps because the smallest range of `k` numbers will always give the minimum difference.

---

## 🧠 Example

Input:

```
nums = [9, 4, 1, 7], k = 2
```

After sorting:

```
[1, 4, 7, 9]
```

Windows of size 2:

* [1, 4] → diff = 3
* [4, 7] → diff = 3
* [7, 9] → diff = 2 ✅ (minimum)

Output:

```
2
```

---

## 🧪 Java Code

```java
class Solution {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int minVal = Integer.MAX_VALUE;

        for (int i = 0; i + k - 1 < nums.length; i++) {
            minVal = Math.min(minVal, nums[i + k - 1] - nums[i]);
        }

        return minVal;
    }
}
```

---

## ⏱️ Time Complexity

* Sorting: `O(n log n)`
* Sliding window: `O(n)`
* Total: `O(n log n)`

---

## ✅ Key Points

* Always sort first 📊
* Use window of size `k`
* Compare first and last element of window
* Return the minimum difference 🎯
