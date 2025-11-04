# 🔁 Permutations — Backtracking with In‑Place Swapping (Java)

## 📌 Problem

Given an array `nums` of **distinct** integers, return **all possible permutations**. You can return the answer in any order.

**Constraints**

* `1 <= nums.length <= 6`
* `-10 <= nums[i] <= 10`
* All values are **unique**

---

## 💡 Core Idea (Backtracking)

We build permutations **position by position**. At index `index`, we try every element that hasn’t been fixed yet by **swapping** it into position `index`, recurse to fill the next position, and then **swap back** to restore the array (backtrack).

This avoids extra memory for visited sets and produces permutations **in‑place**.

---

## 🧭 Algorithm (Step‑by‑Step)

1. **Base Case**: If `index == nums.length`, the array now holds one complete permutation. Copy it into a `List<Integer>` and add to `result`.
2. **For each choice** `i` from `index` to `n-1`:

   * **Swap** `nums[index]` and `nums[i]` (put choice `i` at current position).
   * **Recurse** with `index + 1` to fill the next slot.
   * **Backtrack**: swap back to restore original order for the next choice.

> Swapping is both the **state change** and the **undo** operation.

---

## ✅ Correctness Sketch

* **Exhaustiveness**: At level `index`, we try every remaining element at that position, so every possible ordering is generated.
* **No duplicates**: Since input elements are distinct and we use a simple position‑based swap, each ordering is produced exactly once.
* **Termination**: The recursion depth is `n`; at each leaf we append a copy to `result`.

---

## 🧪 Dry Run (nums = [1,2,3])

**Level 0 (index=0):** try 1,2,3 at position 0

* Place 1 → recurse on [1,2,3]

  * Place 2 → [1,2,3] → place 3 → **[1,2,3]** ✅
  * Place 3 → [1,3,2] → place 2 → **[1,3,2]** ✅
* Place 2 → recurse on [2,1,3]

  * Place 1 → [2,1,3] → place 3 → **[2,1,3]** ✅
  * Place 3 → [2,3,1] → place 1 → **[2,3,1]** ✅
* Place 3 → recurse on [3,2,1]

  * Place 2 → [3,2,1] → place 1 → **[3,2,1]** ✅
  * Place 1 → [3,1,2] → place 2 → **[3,1,2]** ✅

All 6 permutations are produced.

---

## ⏱️ Complexity

* **Time**: `O(n · n!)`

  * There are `n!` permutations; copying each permutation into a list costs `O(n)`.
* **Space**:

  * **Auxiliary** (recursion) `O(n)` depth.
  * **Output** requires `O(n · n!)` to store all permutations.

---

## 🧰 Implementation

```java
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        genPermut(nums, result, 0);
        return result;
    }

    public void genPermut(int[] nums, List<List<Integer>> result, int index) {
        if (index == nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int x : nums) list.add(x);
            result.add(list);
            return;
        }
        for (int i = index; i < nums.length; i++) {
            // swap
            int temp = nums[index];
            nums[index] = nums[i];
            nums[i] = temp;

            genPermut(nums, result, index + 1);

            // backtrack (swap back)
            temp = nums[index];
            nums[index] = nums[i];
            nums[i] = temp;
        }
    }
}
```

---




