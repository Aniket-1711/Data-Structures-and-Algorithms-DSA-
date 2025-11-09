# Count Subarrays With Majority Element I 🎯

### Problem Explanation and Brute-Force Solution Breakdown ✨

---

## 1. The Goal 🏁

We need to find the **total number of contiguous subarrays** where the **target element appears more than 50%** of the time.

A **subarray** is defined by its start and end indices.

For example, for `[1, 2, 3]`, the possible subarrays are:

```
[1]
[1, 2]
[1, 2, 3]
[2]
[2, 3]
[3]
```

---

## 2. The Strategy: Nested Loops 🔄

We use a **brute-force approach** with two nested loops to check all subarrays.

### Outer Loop (`i`):

Chooses the **start** of the subarray.

### Inner Loop (`j`):

Chooses the **end** of the subarray.

Together, `(i, j)` defines all possible subarrays. For each subarray, we count how many times the target appears and check if it’s a majority.

---

## 3. Example Walkthrough 🔢

Let’s trace with `nums = [1, 2, 2, 3]` and `target = 2`.

### Step-by-Step Trace:

**i = 0 (start = [1])**

```
j = 0 → [1] → len=1, targetCount=0 → not majority
j = 1 → [1,2] → len=2, targetCount=1 → not majority
j = 2 → [1,2,2] → len=3, targetCount=2 → majority ✅ count=1
j = 3 → [1,2,2,3] → len=4, targetCount=2 → not majority
```

**i = 1 (start = [2])**

```
j = 1 → [2] → len=1, targetCount=1 → majority ✅ count=2
j = 2 → [2,2] → len=2, targetCount=2 → majority ✅ count=3
j = 3 → [2,2,3] → len=3, targetCount=2 → majority ✅ count=4
```

**i = 2 (start = [2])**

```
j = 2 → [2] → len=1, targetCount=1 → majority ✅ count=5
j = 3 → [2,3] → len=2, targetCount=1 → not majority
```

**i = 3 (start = [3])**

```
j = 3 → [3] → len=1, targetCount=0 → not majority
```

✅ **Final Answer: count = 5**

---

## 4. Implementation Mapping 🤝

Here’s how this logic translates directly into Java code:

```java
class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int count = 0; // Final answer

        for (int i = 0; i < nums.length; i++) {
            int tcount = 0; // Target occurrences for each start index

            for (int j = i; j < nums.length; j++) {
                if (nums[j] == target) {
                    tcount++;
                }

                int len = j - i + 1; // Length of current subarray

                if (tcount > (len / 2)) {
                    count++; // Found a valid subarray
                }
            }
        }
        return count;
    }
}
```

---

## 5. Time and Space Complexity ⚙️

* **Time Complexity:** O(n²) — Both `i` and `j` loops traverse the array, generating all possible subarrays.
* **Space Complexity:** O(1) — Uses constant space (a few counters).

---

## 🎯 Final Takeaway

* Check every subarray using nested loops 🔁
* Count target frequency for each subarray 📊
* Validate if it appears **more than half** the length of that subarray ✅

This brute-force method is simple, clear, and effective for small input sizes.
