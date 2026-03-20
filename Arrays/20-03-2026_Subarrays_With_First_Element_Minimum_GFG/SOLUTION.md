# 🚀 Subarrays with First Element Minimum

## 🧠 Problem Summary

Given an array `arr[]`, count the number of subarrays such that:

👉 The **first element is the minimum** in that subarray

---

## 💡 Key Idea

For every index `i`, we try to extend the subarray to the right.

### 🔑 Condition:

* As long as `arr[j] ≥ arr[i]`, the subarray is valid
* If we find `arr[j] < arr[i]`, we STOP

---

## ⚙️ Approach (Brute Force)

### Steps:

1. Fix starting index `i`
2. Extend `j` from `i → n-1`
3. If `arr[j] < arr[i]`:

   * ❌ break
4. Else:

   * ✅ count++

---

## 💻 Java Implementation

```java
class Solution {
    public int countSubarrays(int[] arr) {
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[i]) {
                    break;
                }
                count++;
            }
        }

        return count;
    }
}
```

---

## 📊 Example Walkthrough

### Input:

```
[1, 2, 1]
```

Valid subarrays:

* [1]
* [1,2]
* [1,2,1]
* [2]
* [1]

✅ Answer = 5

---

## ⚡ Optimization Idea (Important for Interviews)

Brute force is **O(n²)** ❌

We can optimize using **Next Smaller Element (Monotonic Stack)**:

### 🔥 Insight:

For each index `i`, find how far we can extend until a **smaller element appears**

👉 Count = `(nextSmallerIndex - i)`

---

## 🚀 Optimized Approach (Monotonic Stack)

### Steps:

1. Find **Next Smaller Element index** for each position
2. If none → assume `n`
3. For each index `i`:

   ```
   count += nextSmaller[i] - i
   ```

---

## 💻 Optimized Java Code

```java
import java.util.*;

class Solution {
    public int countSubarrays(int[] arr) {
        int n = arr.length;
        int[] nextSmaller = new int[n];
        Stack<Integer> stack = new Stack<>();

        // Find next smaller element index
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) nextSmaller[i] = n;
            else nextSmaller[i] = stack.peek();

            stack.push(i);
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            count += nextSmaller[i] - i;
        }

        return count;
    }
}
```

---

## ⏱️ Complexity

| Approach    | Time  | Space |
| ----------- | ----- | ----- |
| Brute Force | O(n²) | O(1)  |
| Optimized   | O(n)  | O(n)  |

---

## 🧩 Why This Works

* We only care about when a smaller element appears
* Stack helps efficiently find boundaries
* Avoids re-checking elements repeatedly

---

## 🏁 Final Thoughts

* Brute force works for understanding
* Stack solution is **interview-level** ⭐
* Pattern: **Next Smaller Element (NSE)**

