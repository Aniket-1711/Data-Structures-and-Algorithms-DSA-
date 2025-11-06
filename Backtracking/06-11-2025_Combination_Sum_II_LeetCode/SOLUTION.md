# 🎯 Combination Sum II - Backtracking Solution

### 💡 Problem Overview

Given a collection of integers `candidates` (which may contain duplicates) and a target integer `target`, the task is to find all **unique combinations** where the sum of selected numbers equals the target. Each number in `candidates` may **only be used once**.

**Example:**
Input → `candidates = [10,1,2,7,6,1,5]`, `target = 8`
Output → `[[1,1,6], [1,2,5], [1,7], [2,6]]`

### 🧠 Key Points

* Each number can be used **only once**.
* The solution must not contain **duplicate combinations**.
* Sorting the array helps handle duplicates easily.
* We use **backtracking** to explore all valid combinations.

---

### ⚙️ Approach (Step-by-Step)

1. **Sort the array** → ensures duplicates are adjacent and easy to skip.
2. **Backtracking function**:

   * Recursively try each candidate from the current index onward.
   * If the current number exceeds the remaining target, **stop** (pruning).
   * If the target becomes **0**, store a copy of the current list.
   * Skip elements that are duplicates of the previous one at the same recursion level.
3. **Backtrack** → After exploring a branch, remove the last added element to explore others.

---

### 🧩 Code Implementation (with Comments)

```java
import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        
        Arrays.sort(candidates); // ✅ Sort to easily skip duplicates
        combSum(candidates, 0, result, list, target);
        return result;
    }

    public void combSum(int[] candidates, int index, List<List<Integer>> result, List<Integer> list, int target) {

        // ✅ Base case: if target becomes 0, we found a valid combination
        if (target == 0) {
            result.add(new ArrayList<>(list)); // store a copy of current list
            return;
        }

        // 🔁 Try every candidate starting from the current index
        for (int i = index; i < candidates.length; i++) {
            
            // 🚫 Skip duplicate elements at the same recursion level
            if (i > index && candidates[i] == candidates[i - 1]) continue;

            // ⛔ Stop exploring if the number is greater than the remaining target
            if (candidates[i] > target) break;

            // ✅ Include the candidate in the current combination
            list.add(candidates[i]);

            // 🔁 Recur with next index (i + 1) since each element can be used once
            combSum(candidates, i + 1, result, list, target - candidates[i]);

            // 🔙 Backtrack: remove the last element before trying the next
            list.remove(list.size() - 1);
        }
    }
}
```

---

### 🧩 Example Walkthrough

**Input:** `candidates = [10,1,2,7,6,1,5]`, `target = 8`
**Sorted:** `[1,1,2,5,6,7,10]`

| Step | Current Combination | Remaining Target | Action              |
| ---- | ------------------- | ---------------- | ------------------- |
| 1    | []                  | 8                | Start recursion     |
| 2    | [1]                 | 7                | Include first 1     |
| 3    | [1,1]               | 6                | Include next 1      |
| 4    | [1,1,6]             | 0                | ✅ Found valid combo |
| 5    | [1,2,5]             | 0                | ✅ Found valid combo |
| 6    | [1,7]               | 0                | ✅ Found valid combo |
| 7    | [2,6]               | 0                | ✅ Found valid combo |

✅ Final Output → `[[1,1,6], [1,2,5], [1,7], [2,6]]`

---

### ⏱️ Complexity Analysis

| Type                 | Complexity                                                 |
| -------------------- | ---------------------------------------------------------- |
| **Time Complexity**  | Exponential, roughly `O(2^n)` due to recursive exploration |
| **Space Complexity** | `O(n)` (recursion stack + temporary list)                  |

---

### 🧰 Key Takeaways

* Sorting is essential for duplicate skipping. 🧩
* Use `i + 1` for next recursive call since each number can be used once. 🔁
* Always backtrack after exploring a branch. 🔙

---

### ✨ Output Examples

```java
Input: candidates = [2,5,2,1,2], target = 5
Output: [[1,2,2], [5]]

Input: candidates = [10,1,2,7,6,1,5], target = 8
Output: [[1,1,6], [1,2,5], [1,7], [2,6]]
```

---

### 🪄 Summary Table

| Concept            | Description                       |
| ------------------ | --------------------------------- |
| Technique          | Backtracking                      |
| Allows Reuse       | ❌ No                              |
| Handles Duplicates | ✅ Yes (skip adjacent same values) |
| Strategy           | Include → Recurse → Backtrack     |

---

🚀 **Pro Tip:** When handling duplicates, always sort the array and skip equal elements *only at the same recursion level*! This ensures unique combinations efficiently. 💡
