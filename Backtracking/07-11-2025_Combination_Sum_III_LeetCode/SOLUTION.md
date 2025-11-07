# 🎯 Combination Sum III (LeetCode Problem)

This repository contains the solution for the LeetCode problem **"Combination Sum III"**.

---

## 📜 Problem Description

Find all valid combinations of **k numbers** that sum up to **n** such that the following conditions are true:

* Only numbers **1 through 9** are used.
* Each number is used **at most once**.

Return a list of all possible valid combinations. The list must not contain the same combination twice, and the combinations may be returned in any order.

---

### 🧩 **Example 1:**

```
Input: k = 3, n = 7
Output: [[1,2,4]]
Explanation:
1 + 2 + 4 = 7
There are no other valid combinations.
```

### 🧩 **Example 2:**

```
Input: k = 3, n = 9
Output: [[1,2,6],[1,3,5],[2,3,4]]
Explanation:
1 + 2 + 6 = 9
1 + 3 + 5 = 9
2 + 3 + 4 = 9
There are no other valid combinations.
```

### 🧩 **Example 3:**

```
Input: k = 4, n = 1
Output: []
Explanation: There are no valid combinations.
Using 4 different numbers in the range [1,9], the smallest sum we can get is 1+2+3+4 = 10 and since 10 > 1, there are no valid combinations.
```

---

## 💡 Solution Approach: **Standard Backtracking**

This problem is a **classic example of backtracking**. We need to explore all possible combinations recursively and collect only those that satisfy the constraints.

The input numbers are fixed (**1 to 9**) and have no duplicates, which simplifies our logic compared to *Combination Sum II*.

We use the standard **“Pick / Don’t Pick”** recursive strategy.

---

### 🔹 **Step 1: The “Pick / Don’t Pick” Logic**

We define a helper function that tries two possibilities for each number:

* **"Pick" Path:** Include the current number in our combination.
* **"Don’t Pick" Path:** Skip the current number.

Since each number can be used **at most once**, every recursive call moves to the **next index** (`index + 1`).

---

### 🛑 **Step 2: Base Cases**

The recursion stops in two main situations:

#### ✅ **Success (Target Hit)**

* The **target sum** becomes `0`.
* The **list size** becomes exactly `k`.

When both conditions are met, we’ve found a valid combination and add it to our result list.

#### ❌ **Failure (Pruning)**

We stop exploring when:

* The **target becomes negative** (overshoot).
* The **list size exceeds k**.
* The **index goes past 9** (we’ve used all numbers).

---

### ⚡ **Step 3: Optimization**

The **maximum possible sum** using numbers 1 to 9 is `45`.
If `n > 45`, we can directly return an empty list — as no valid combination can exist.

---

## 💻 Full Java Implementation

```java
import java.util.ArrayList;
import java.util.List;

class Solution {
    // The fixed array of candidate numbers (1 through 9)
    public static int ar[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        // Optimization: Max sum of 1-9 is 45.
        // Also, min sum for k numbers is k*(k+1)/2.
        // But n > 45 is a simple, effective check.
        if (n > 45) {
            return result;
        }

        // Start the backtracking helper function
        combSum(k, 0, result, list, n);
        return result;
    }

    /**
     * Helper function to find combinations recursively.
     *
     * @param k       The required number of elements in the combination.
     * @param index   The current index in the 'ar' array we are considering.
     * @param result  The final list of all valid combinations.
     * @param list    The temporary list for the current combination being built.
     * @param target  The remaining sum we need to achieve.
     */
    public void combSum(int k, int index, List<List<Integer>> result, List<Integer> list, int target) {

        // --- Base Cases ---

        // 1. Success Case: We found a valid combination
        if (target == 0 && list.size() == k) {
            result.add(new ArrayList<>(list)); // Add a copy
            return;
        }

        // 2. Failure Cases (Pruning)
        if (index >= ar.length || target < 0 || list.size() > k) {
            return;
        }

        // --- Recursive Steps (Pick / Don't Pick) ---

        // 1. Pick Path: Include ar[index]
        list.add(ar[index]);
        combSum(k, index + 1, result, list, target - ar[index]);

        // 2. Don't Pick Path: Backtrack and move to next number
        list.remove(list.size() - 1);
        combSum(k, index + 1, result, list, target);
    }
}
```

---

## 📊 Complexity Analysis

| Type                    | Complexity | Description                                                                                                                                  |
| ----------------------- | ---------- | -------------------------------------------------------------------------------------------------------------------------------------------- |
| ⏱️ **Time Complexity**  | **O(2⁹)**  | For each of the 9 numbers, we can either “pick” or “not pick”, giving a total of 2⁹ (512) combinations. Each valid list creation takes O(k). |
| 💾 **Space Complexity** | **O(k)**   | Due to recursion depth (max 9) and the temporary combination list that can hold up to k elements.                                            |

---

### ✅ Summary

* Use **backtracking** to explore all valid number combinations.
* Implement **Pick / Don’t Pick** logic with pruning to stop invalid paths.
* Optimize early by skipping impossible sums (`n > 45`).
* Ensure each number is used **at most once**.

---

✨ This backtracking solution efficiently generates all **unique combinations of k numbers (1–9)** that sum up to **n**, while maintaining clarity, simplicity, and performance.
