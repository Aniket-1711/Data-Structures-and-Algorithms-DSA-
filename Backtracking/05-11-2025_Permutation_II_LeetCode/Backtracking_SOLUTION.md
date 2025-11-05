# 🔁 Permutations II — Unique Permutations

This problem asks us to generate **all unique permutations** of an integer array that **may contain duplicates**.

> We must return only **distinct arrangements** of the numbers.

---

## 🧠 Problem Understanding

Given an array `nums` which might contain duplicates, generate **all possible unique permutations**.

### ✅ Example

Input:

```text
[1,1,2]
```

Output:

```text
[1,1,2]
[1,2,1]
[2,1,1]
```

---

## 🚀 Key Idea

This is a **backtracking** problem, similar to generating permutations, **but duplicates must be skipped**.

### 🎯 Why duplicates occur

While generating permutations, if the same number appears again at the same recursion level, it would create **duplicate branches** → duplicate permutations.

So we must avoid choosing the **same number again** at a single recursion depth.

### ✅ Strategy

* Sort the array (brings duplicates together)
* Use **HashSet at each recursion level** to avoid picking the same value again
* Swap, recurse, backtrack

---

## 🧩 Code Explanation (Clean + Clear)

### 💡 Highlights

* `HashSet` ensures each number is used once **per position**
* If a number is already present in the set, we skip it

---

### 🧾 Code

```java
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // ✅ Sorting helps group duplicates
        genPermut(nums, result, 0);
        return result;   
    }

    public void genPermut(int nums[], List<List<Integer>> result, int index){

        // ✅ Base case — when index reaches end, one valid permutation is formed
        if(index == nums.length){
            List<Integer> list = new ArrayList<>();
            for(int i : nums) list.add(i);
            result.add(list);
            return;
        }

        // ✅ Set to track values used at this recursion level
        HashSet<Integer> used = new HashSet<>();

        for(int i = index; i < nums.length; i++){

            // ✅ Skip duplicates — avoid using same value again at same level
            if(used.contains(nums[i])) continue;
            used.add(nums[i]);

            // ✅ Swap current index with i to fix a number at current position
            int temp = nums[index];
            nums[index] = nums[i];
            nums[i] = temp;

            genPermut(nums, result, index + 1); // 🔁 Recurse

            // ♻️ Backtrack — revert swap
            temp = nums[index];
            nums[index] = nums[i];
            nums[i] = temp;
        }
    }
}
```

---

## 🤓 Why HashSet?

If we only checked:

```java
if(i != index && nums[i] == nums[index]) continue;
```

It works **only when the array remains sorted** during recursion.
But here we **swap values**, so the array may become unsorted → skip logic breaks.

✅ **HashSet guarantees correctness** regardless of swaps.

---

## 🏁 Final Notes

| Concept      | Meaning                               |
| ------------ | ------------------------------------- |
| Backtracking | Try → Recurse → Undo                  |
| Sorting      | Helps detect duplicates together      |
| HashSet      | Ensures unique number usage per depth |

### 🎉 Output will always contain unique permutations

---

## ✅ Time & Space Complexity

| Metric           | Value                                 |
| ---------------- | ------------------------------------- |
| Time Complexity  | `O(n * n!)` (worst case permutations) |
| Space Complexity | `O(n)` recursion + set usage          |

---

## 🌈 Summary

* Sort array
* Use Set at each level
* Swap → Recurse → Backtrack
* Skip duplicate values → avoid duplicate permutations

🚀 **Efficient and clean solution to handle duplicates in permutations**!
