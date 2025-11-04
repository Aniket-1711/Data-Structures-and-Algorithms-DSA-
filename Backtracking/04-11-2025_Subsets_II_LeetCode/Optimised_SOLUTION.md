# 📂 Subsets II (Power Set with Duplicates)

### 🎯 Problem Statement

Given an integer array `nums` that **may contain duplicates**, return all possible **unique subsets** (the power set).

> The output must **not contain duplicate subsets**.

### ✅ Example

**Input:** `nums = [1,2,2]`
**Output:** `[[], [1], [1,2], [1,2,2], [2], [2,2]]`

---

## 🚀 Approaches

### **Approach 1️⃣ — Using Set to Avoid Duplicates**

✔️ Sort the array to group duplicates
✔️ Recursively generate all subsets
✔️ Use `HashSet` to ensure only unique subsets remain

#### **Intuition**

We explore both choices for every element:

* Include element
* Exclude element

Duplicates are removed using `Set`.

#### **⚙️ Process Flow**

1. Sort the input array
2. At each index:

   * Add element → Recurse
   * Remove (backtrack) → Recurse
3. Store subsets in `Set`

#### **⏱️ Complexity**

* **Time:** `O(n · 2^n)`
* **Space:** `O(n · 2^n)`

#### **Java Code**

```java
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        generateSubsets(nums, result, list, 0);
        return new ArrayList<>(result);
    }

    public void generateSubsets(int[] nums, Set<List<Integer>> result, List<Integer> list, int index) {
        if (index == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }

        list.add(nums[index]);
        generateSubsets(nums, result, list, index + 1);
        list.remove(list.size() - 1);
        generateSubsets(nums, result, list, index + 1);
    }
}
```

---

### **Approach 2️⃣ — Without Set (Skip Duplicates in Recursion) OPTIMISED SOLUTION**

✔️ Sort the array
✔️ Skip duplicate elements **during recursion**
✔️ Only generate unique subsets directly

#### **Intuition**

If the element at current index is same as previous, and previous was excluded, directly skip to avoid re‑creating same subset.

#### ✅ Key Logic

Use pointer `nextInd` → jump over all duplicates before next recursion.

#### **⏱️ Complexity**

* **Time:** `O(n · 2^n)`
* **Space:** `O(n · 2^n)`

#### **Java Code**

```java
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        generateSubsets(nums, result, list, 0, nums.length);
        return result;
    }

    public void generateSubsets(int[] nums, List<List<Integer>> result, List<Integer> list, int index, int n) {
        if (index == n) {
            result.add(new ArrayList<>(list));
            return;
        }

        list.add(nums[index]);
        generateSubsets(nums, result, list, index + 1, n);
        list.remove(list.size() - 1);

        int nextInd = index + 1;
        while (nextInd < n && nums[nextInd] == nums[nextInd - 1]) {
            nextInd++;
        }

        generateSubsets(nums, result, list, nextInd, n);
    }
}
```

---

### 🎯 Final Takeaway

| Feature                | With Set | Without Set |
| ---------------------- | -------- | ----------- |
| Works with duplicates  | ✅        | ✅           |
| Removes extra overhead | ❌        | ✅           |
| Better performance     | ❌        | ✅           |

---

### 🧠 Tip

Always `sort(nums)` first — this gives control to **skip duplicates smartly**!

---

### ✨ Output Order

Order does **not matter** — only uniqueness matters.

✅ You now have a clean understanding + both solutions! 💪🔥
