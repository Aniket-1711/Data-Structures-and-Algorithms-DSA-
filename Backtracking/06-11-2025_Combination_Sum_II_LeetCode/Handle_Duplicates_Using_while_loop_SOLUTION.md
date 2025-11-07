# 🎯 Combination Sum II (LeetCode Problem)

This repository contains the solution for the LeetCode problem **"Combination Sum II"**.

---

## 📜 Problem Description

Given a collection of candidate numbers (**candidates**) and a target number (**target**), find all **unique combinations** in candidates where the candidate numbers sum up to the target.

### **Key Constraints:**

* Each number in candidates may only be used **once** in the combination.
* The solution set must not contain **duplicate combinations**.

---

### 🧩 **Example 1:**

```
Input: candidates = [10,1,2,7,6,1,5], target = 8
Output:
[
  [1,1,6],
  [1,2,5],
  [1,7],
  [2,6]
]
```

### 🧩 **Example 2:**

```
Input: candidates = [2,5,2,1,2], target = 5
Output:
[
  [1,2,2],
  [5]
]
```

---

## 💡 Solution Approach: **Backtracking with Duplicate Skipping**

The problem asks for all **unique combinations**, which strongly suggests a **backtracking (recursive)** approach. The main challenge is handling two constraints:

1. Using each number only once.
2. Avoiding duplicate combinations.

---

### 🔹 **Step 1: Sorting (сортировка)**

The first and most important step is to **sort** the candidates array:

```java
Arrays.sort(candidates);
```

Sorting does two critical things:

* It groups all identical numbers together (e.g., `[1, 1, 2, 5, 6, 7]`).
* This grouping allows us to easily **find and skip duplicates**.

---

### 🔹 **Step 2: Backtracking Logic (Pick / Don't Pick)**

We write a recursive helper function that explores two paths at every step:

#### ✅ **Path 1: “Pick” candidates[index]**

This path includes the current element.

1. Add `candidates[index]` to our temporary list.
2. Recursively call the function for the **next index (index + 1)**.
3. Remove it (backtrack) after the recursive call returns.

```java
// --- Path 1: "Pick" candidates[index] ---
list.add(candidates[index]);
combSum(candidates, index + 1, result, list, target - candidates[index]);
list.remove(list.size() - 1);
```

---

#### 🚫 **Path 2: “Don’t Pick” candidates[index]**

This is where we **avoid duplicates**. If we skip a number, we must skip all of its duplicates too.

Why? Because we’ve already explored all valid combinations starting with that number in Path 1.

```java
// --- Path 2: "Don't Pick" candidates[index] ---
while (index + 1 < candidates.length && candidates[index] == candidates[index + 1]) {
    index++;
}
combSum(candidates, index + 1, result, list, target);
```

---

### 🛑 **Step 3: Base Cases**

The recursion stops when:

* **Target Hit (Success):** `target == 0` → Add a copy of the current list to results.
* **Overshot or Out of Bounds (Failure):** `target < 0` or `index >= candidates.length` → Return.

---

## 💻 Full Java Code Implementation

```java
class Solution {
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // Result list to store all unique combinations
        List<List<Integer>> result = new ArrayList<>();
        
        // Temporary list to store current combination
        List<Integer> list = new ArrayList<>();
        
        // Step 1: Sort to handle duplicates easily
        Arrays.sort(candidates);
        
        // Start recursive backtracking
        combSum(candidates, 0, result, list, target);
        
        return result;
    }

    public void combSum(int candidates[], int index, List<List<Integer>> result, List<Integer> list, int target){
        
        // ✅ Base Case 1: If target is reached, store the current list
        if(target == 0){
            result.add(new ArrayList<>(list));
            return;
        }

        // ❌ Base Case 2: If target < 0 or we run out of candidates
        if(target < 0 || index >= candidates.length){
            return;
        }

        // --- Path 1: Pick current element ---
        list.add(candidates[index]);
        combSum(candidates, index + 1, result, list, target - candidates[index]);

        // 🔙 Backtrack to explore other possibilities
        list.remove(list.size() - 1);

        // --- Path 2: Skip all duplicates ---
        while(index + 1 < candidates.length && candidates[index] == candidates[index + 1]){
            index++;
        }

        // Recur for the next unique element
        combSum(candidates, index + 1, result, list, target);
    }
}
```

---

## 📊 Complexity Analysis

| Type                    | Complexity | Description                                                                                         |
| ----------------------- | ---------- | --------------------------------------------------------------------------------------------------- |
| ⏱️ **Time Complexity**  | **O(2^n)** | In the worst case, all subsets are explored. Sorting (`O(n log n)`) is negligible compared to this. |
| 💾 **Space Complexity** | **O(n)**   | Due to recursion depth and the temporary list used during exploration.                              |

---

### ✅ Summary

* Use **sorting** to handle duplicates.
* Use **backtracking** to explore combinations.
* **Skip identical numbers** after not picking one to avoid duplicate results.
* Carefully handle **base cases** for correctness.

---

✨ This approach efficiently generates all **unique combinations** that sum up to the target while respecting all constraints.
