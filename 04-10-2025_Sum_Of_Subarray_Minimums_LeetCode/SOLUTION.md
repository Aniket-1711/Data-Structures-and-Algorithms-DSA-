# 🌟 Sum of Subarray Minimums

## 📌 Problem Statement
Given an array of integers `arr`, find the sum of `min(b)`, where `b` ranges over every (contiguous) subarray of `arr`.  
Since the answer may be large, return the answer modulo **10^9 + 7**.

---

### Example 1
**Input:**  
arr = [3,1,2,4]
**Output:**  
17

**Explanation:**  
Subarrays are:  
- [3], [1], [2], [4], [3,1], [1,2], [2,4], [3,1,2], [1,2,4], [3,1,2,4]  

Minimums are:  
- 3, 1, 2, 4, 1, 1, 2, 1, 1, 1  

Sum = **17**

---

### Example 2
**Input:**  
arr = [11,81,94,43,3]
**Output:**  
444

---

### Constraints
- `1 <= arr.length <= 3 * 10^4`
- `1 <= arr[i] <= 3 * 10^4`

---

## 🐢 Brute Force Approach

### Idea
- Generate **all subarrays**.  
- For each subarray, find the **minimum element**.  
- Add it to the answer.  

This works but is **very slow** because for each subarray we scan to find the minimum.  
Time complexity can go up to `O(n^3)` in worst case.

---

### ✅ Brute Force Code
```java
class Solution {
    public int sumSubarrayMins(int[] arr) {
        int ans = 0;
        int m = (int)(1e9 + 7);

        for (int i = 0; i < arr.length; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = i; j < arr.length; j++) {
                min = Math.min(min, arr[j]);
                ans = (ans + min) % m;
            }
        }
        return ans;
    }
}
```
## 🚀 Optimal Approach (Monotonic Stack)

Instead of generating every subarray, let’s calculate how many subarrays each element contributes to as the minimum.

### Key Idea

Take each element arr[i].

Count:

- left → number of choices to extend on the left until a smaller element appears.

- right → number of choices to extend on the right until a smaller element appears.

Then, the number of subarrays where arr[i] is the minimum =
**left * right**
Contribution of arr[i] to the total =
**arr[i] * left * right**
So we just need two arrays:

- PrevSmaller[i] → index of previous smaller element.

- NextSmaller[i] → index of next smaller element.

- Both can be found using Monotonic Stack in O(n).
## ✅ Optimal Code
```java
import java.util.*;

class Solution {
    public int sumSubarrayMins(int[] arr) {
        int[] nextSmallerElement = findNextSmallerElement(arr);
        int[] prevSmallerElement = findPrevSmallerElement(arr);

        long sum = 0;
        int m = (int)(1e9 + 7);

        for (int i = 0; i < arr.length; i++) {
            long left = i - prevSmallerElement[i];
            long right = nextSmallerElement[i] - i;

            long contribution = (left * right) % m;
            contribution = (contribution * arr[i]) % m;

            sum = (sum + contribution) % m;
        }
        return (int)sum;
    }

    // Next Smaller Element
    public int[] findNextSmallerElement(int ar[]) {
        int nse[] = new int[ar.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = ar.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && ar[stack.peek()] >= ar[i]) {
                stack.pop();
            }
            nse[i] = !stack.isEmpty() ? stack.peek() : ar.length;
            stack.push(i);
        }
        return nse;
    }

    // Previous Smaller Element
    public int[] findPrevSmallerElement(int ar[]) {
        int pse[] = new int[ar.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < ar.length; i++) {
            while (!stack.isEmpty() && ar[stack.peek()] > ar[i]) {
                stack.pop();
            }
            pse[i] = !stack.isEmpty() ? stack.peek() : -1;
            stack.push(i);
        }
        return pse;
    }
}
```
## 📝 Detailed Explanation (Beginner Friendly)
### 🔹 Why Modulo?

- The number of subarrays is very large (~ n^2). Multiplying with arr[i] can exceed integer limits.
- So we apply % 1e9+7 after every addition/multiplication to avoid overflow.

### 🔹 Why Use a Contribution Variable?
**Formula:**
contribution = arr[i] * left * right
- left = i - prevSmaller[i]

- right = nextSmaller[i] - i

- This shows how much arr[i] alone adds to the final answer.

**Using a separate variable makes the math clearer and avoids mistakes.**
### (*IMP)🔹 Why > in Previous Smaller?

Case: [1,1]

- If we use >=, the second 1 will pop the first 1 → PSE = -1 → left = 2 → overcount ❌.

- If we use only >, the second 1 sees the first 1 as "previous smaller or equal" → PSE = 0 → left = 1 ✅.

Thus, we use strict > in PSE.

### 🔹 Why Two Stacks?

- One stack to compute Next Smaller Element (NSE).

- One stack to compute Previous Smaller Element (PSE).
This way we avoid scanning in O(n^2) and solve in O(n).
### 🔹 Why left × right = Number of Subarrays?

Take arr[i]:

- On the left side, it can extend from (prevSmallerIndex+1) to i → that’s left choices.

- On the right side, it can extend from i to (nextSmallerIndex-1) → that’s right choices.

So total subarrays where arr[i] is minimum = left * right.
### 🔹 Dry Run Example

For arr = [3,1,2,4]

For 1 at index 1:

PSE = -1 → left = 1 - (-1) = 2

NSE = 4 → right = 4 - 1 = 3

Contribution = 1 * 2 * 3 = 6

For 2 at index 2:

PSE = 1 → left = 2 - 1 = 1

NSE = 4 → right = 4 - 2 = 2

Contribution = 2 * 1 * 2 = 4

For 3 at index 0:

PSE = -1 → left = 0 - (-1) = 1

NSE = 1 → right = 1 - 0 = 1

Contribution = 3 * 1 * 1 = 3

For 4 at index 3:

PSE = 2 → left = 3 - 2 = 1

NSE = 4 → right = 4 - 3 = 1

Contribution = 4 * 1 * 1 = 4

Sum = 3 + 6 + 4 + 4 = 17

## ⏱️ Complexity

- Time: O(n) (each element pushed and popped once in the stack)

- Space: O(n) (for stacks and helper arrays)

