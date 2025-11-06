# 🧮 Combination Sum - Backtracking Solution

### 💡 Problem Overview

Given an array of **distinct integers** `candidates` and a **target** integer `target`, you must return **all unique combinations** of candidates where the chosen numbers sum up exactly to `target`. Each candidate can be chosen **unlimited times**.

**Example:**
Input → `candidates = [2,3,6,7], target = 7`
Output → `[[2,2,3], [7]]`

### 🧠 Key Points

* Each number can be used multiple times.
* The order of numbers in a combination does not matter.
* Only unique combinations should be included.
* Total combinations are guaranteed to be less than 150.

### ⚙️ Approach (Backtracking)

We use **recursion and backtracking** to explore all possible combinations:

1. **Base Cases:**

   * If `target == 0`: A valid combination is found → add it to the result.
   * If `index == candidates.length` or `target < 0`: Stop recursion (invalid path).

2. **Choices at each step:**

   * **Include** the current number → keep the same index (reuse allowed).
   * **Exclude** the current number → move to the next index.

3. **Backtracking Step:**

   * After exploring one branch, remove the last added number to explore other possibilities.

4. **Avoiding Duplicates:**

   * A `HashSet` is used to store combinations that were already added to prevent duplicates.

### 🧩 Code Implementation

```java
class Solution {
    public static Set<List<Integer>> set=new HashSet<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        combSum(candidates, 0, result, list,target);
        set.clear();
        return result;
    }

    public void combSum(int candidates[], int index,List<List<Integer>> result, List<Integer> list, int target){
        
        //base cases 
        if(index==candidates.length){
            return;
        }
        if(target==0){
            if(!set.contains(list)){
            result.add(new ArrayList<>(list));
            set.add(list);
            return;
        }
        }
        if(target<0){
            return; //make sures that when we keep adding single element multiple times the target is acheieved or  we return
        }

        //for each element we have 3 choices - include (once), include (multiple times), exclude

        list.add(candidates[index]);//add the element to the list
        combSum(candidates, index+1, result, list, target-candidates[index]); //include element (once)
        combSum(candidates, index, result, list, target-candidates[index]); //include element (multiple times)
        //backtrack
        list.remove(list.size()-1);
        combSum(candidates, index+1, result, list, target); //exclude the element
    }
}
```

### 🧩 Example Trace

For `candidates = [2,3,6,7]`, `target = 7`

| Step | Current List | Remaining Target | Action                    |
| ---- | ------------ | ---------------- | ------------------------- |
| 1    | []           | 7                | Start                     |
| 2    | [2]          | 5                | Include 2                 |
| 3    | [2,2]        | 3                | Include 2 again           |
| 4    | [2,2,3]      | 0                | ✅ Found valid combination |
| 5    | [7]          | 0                | ✅ Found valid combination |

Result → `[[2,2,3],[7]]`

### ⏱️ Complexity Analysis

| Type  | Complexity                                                  |
| ----- | ----------------------------------------------------------- |
| Time  | Exponential (due to recursive exploration)                  |
| Space | O(target/min(candidates)) for recursion depth + output size |

### 🧰 Key Takeaways

* Backtracking explores all possible choices recursively.
* Pruning (`if target < 0`) avoids unnecessary recursive calls.
* Duplicates are avoided using a `HashSet`.

### 🪄 Output Examples

```java
Input: [2,3,5], target = 8
Output: [[2,2,2,2], [2,3,3], [3,5]]

Input: [2], target = 1
Output: []
```

### ✍️ Summary

| Concept            | Description                         |
| ------------------ | ----------------------------------- |
| Technique          | Backtracking                        |
| Allows Reuse       | ✅ Yes                               |
| Duplicate Handling | ✅ Using HashSet                     |
| Suitable For       | Problems requiring sum combinations |

🚀 **Master Tip:** Always backtrack after including an element — this ensures your recursion tree explores all paths cleanly!
