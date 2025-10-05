# 🌄 Sum of Subarray Ranges

## Problem Statement
You are given an integer array `nums`.  
The **range** of a subarray is `max(subarray) - min(subarray)`.  
Return the **sum of ranges of all subarrays** of `nums`.  
A subarray is a contiguous, non-empty slice of the array.

**Examples**
- `nums = [1,2,3]` → output `4`  
- `nums = [1,3,3]` → output `4`  
- `nums = [4,-2,-3,4,1]` → output `59`

---

## ✅ Key Idea
Sum of all subarray ranges = **(sum of contributions when each element is the maximum)** − **(sum of contributions when each element is the minimum)**.

For each index `i`:
- Number of subarrays where `nums[i]` is the **minimum** = `minLeft * minRight`  
  where `minLeft = i - prevSmallerIndex[i]` and `minRight = nextSmallerIndex[i] - i`.
- Number of subarrays where `nums[i]` is the **maximum** = `maxLeft * maxRight`  
  where `maxLeft = i - prevGreaterIndex[i]` and `maxRight = nextGreaterIndex[i] - i`.

Then:
totalMinSum = Σ nums[i] * (minLeft * minRight)
totalMaxSum = Σ nums[i] * (maxLeft * maxRight)
**answer = totalMaxSum - totalMinSum**


---

## 🔁 Prerequisite
This problem is a direct extension of **LeetCode: Sum of Subarray Minimums**.  
That problem teaches you how to compute the total contribution of each element when it acts as the **minimum** of subarrays using monotonic stacks.  

To solve **Sum of Subarray Ranges**, you do the same thing twice:
1. Compute contributions when elements are **minimums** (use monotonic stack for "next smaller" and "previous smaller").
2. Compute contributions when elements are **maximums** (use monotonic stack for "next greater" and "previous greater").
3. Subtract min-sum from max-sum.

---

## ⚙️ Monotonic Stack Usage
We precompute four arrays of indices:

1. `prevSmaller[i]`  — index of previous element to the left that is **≤ or <** `nums[i]`. If none, `-1`.
2. `nextSmaller[i]`  — index of next element to the right that is **<** `nums[i]`. If none, `n`.
3. `prevGreater[i]`  — index of previous element to the left that is **≥** `nums[i]`. If none, `-1`.
4. `nextGreater[i]`  — index of next element to the right that is **>** `nums[i]`. If none, `n`.

We **push indices** on the stack (not values) to compute distances `(i - prevIndex)` and `(nextIndex - i)` easily.

---

## 🔍 Handling Duplicates
When elements are equal, we must consistently break ties so each subarray gets its min and max counted exactly once:

- **For minima:**
  - `prevSmaller`: pop while `stack.peek() > nums[i]` → leaves indices with value `<= nums[i]` on stack.
  - `nextSmaller`: pop while `stack.peek() >= nums[i]` → leaves indices with value `< nums[i]` on stack.

- **For maxima:**
  - `prevGreater`: pop while `stack.peek() < nums[i]` → leaves indices with value `>= nums[i]` on stack.
  - `nextGreater`: pop while `stack.peek() <= nums[i]` → leaves indices with value `> nums[i]` on stack.

This ensures each equal element contributes correctly without double-counting.

---

## ✅ Full Java Implementation

```java
import java.util.Stack;

class Solution {
    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        int nextSmallerElement[] = findNextSmallerElement(nums);
        int prevSmallerElement[] = findPrevSmallerElement(nums);
        int nextGreaterElement[] = findNextGreaterElement(nums);
        int prevGreaterElement[] = findPrevGreaterElement(nums);

        long minSum = 0L;
        long maxSum = 0L;

        for (int i = 0; i < n; i++) {
            long minLeft = i - prevSmallerElement[i];
            long minRight = nextSmallerElement[i] - i;

            long maxLeft = i - prevGreaterElement[i];
            long maxRight = nextGreaterElement[i] - i;

            long minContribution = minLeft * minRight * nums[i];
            long maxContribution = maxLeft * maxRight * nums[i];

            minSum += minContribution;
            maxSum += maxContribution;
        }

        return maxSum - minSum;
    }

    public int[] findNextSmallerElement(int ar[]) {
        int n = ar.length;
        int nse[] = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && ar[stack.peek()] >= ar[i]) stack.pop();
            nse[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
        return nse;
    }

    public int[] findPrevSmallerElement(int ar[]) {
        int n = ar.length;
        int pse[] = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && ar[stack.peek()] > ar[i]) stack.pop();
            pse[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        return pse;
    }

    public int[] findNextGreaterElement(int ar[]) {
        int n = ar.length;
        int nge[] = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && ar[stack.peek()] <= ar[i]) stack.pop();
            nge[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
        return nge;
    }

    public int[] findPrevGreaterElement(int ar[]) {
        int n = ar.length;
        int pge[] = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && ar[stack.peek()] < ar[i]) stack.pop();
            pge[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        return pge;
    }
}
```
---
## ⏱ Complexity

- Time: O(n) — each index is pushed/popped at most once in each monotonic stack (4 stacks → still O(n)).

- Space: O(n) — arrays for prev/next elements and one stack per computation.
