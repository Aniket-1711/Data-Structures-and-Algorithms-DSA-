# 🧮 Smallest Missing Multiple of K

---

## 💡 Problem Statement
Given an integer array `nums` and an integer `k`, return the **smallest positive multiple of `k`** that is **missing** from the array.

A multiple of `k` is any positive integer divisible by `k`.

---

## 🧾 Example 1
**Input:**  
`nums = [8, 2, 3, 4, 6], k = 2`

**Output:**  
`10`

**Explanation:**  
The multiples of `k = 2` are → 2, 4, 6, 8, 10, 12...  
Missing multiple = **10** ✅

---

## 🧾 Example 2
**Input:**  
`nums = [1, 4, 7, 10, 15], k = 5`

**Output:**  
`5`

**Explanation:**  
Multiples of `k = 5` are → 5, 10, 15, 20...  
Missing multiple = **5** ✅

---

## ⚙️ Constraints
```
1 <= nums.length <= 100
1 <= nums[i] <= 100
1 <= k <= 100
```

---

## 🧠 Approach
1. 🔹 Store all elements in a **HashSet** for fast lookup.
2. 🔹 Start checking multiples of `k` → `k`, `2k`, `3k`, ...
3. 🔹 The first multiple not found in the set is the answer.

✅ **Why HashSet?**  
Because it allows O(1) average-time lookup instead of scanning through the array repeatedly.

---

## 🧩 Java Solution
```java
class Solution {
    public int missingMultiple(int[] nums, int k) {
        // 🧩 Step 1: Store all numbers in a HashSet for quick lookup
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        // 🔍 Step 2: Start checking from the smallest multiple of k
        int search = k;

        // 🔁 Step 3: Keep finding multiples of k until one is missing
        while (true) {
            // ❌ If the multiple is not found in nums, we found our answer
            if (!set.contains(search)) {
                return search; // ✅ Smallest missing multiple found
            }

            // ➕ Otherwise, move to the next multiple
            search += k;
        }
    }
}
```

---

## 🧮 Example Walkthrough
**nums = [8, 2, 3, 4, 6], k = 2**

| Step | Multiple | Exists in Array? | Action |
|------|-----------|------------------|---------|
| 1️⃣  | 2 | ✅ Yes | Continue |
| 2️⃣  | 4 | ✅ Yes | Continue |
| 3️⃣  | 6 | ✅ Yes | Continue |
| 4️⃣  | 8 | ✅ Yes | Continue |
| 5️⃣  | 10 | ❌ No | 🔥 Found Answer = 10 |

---

## ⏱️ Time Complexity
- Building HashSet → **O(n)**
- Checking multiples → **O(m)** (until missing one found)
- ✅ **Total = O(n + m)** (very efficient for small constraints)

---

## 🧩 Optimization Tip
You can remove the sorting step (if any) since the **order doesn’t matter** when using a HashSet. 💡

---

## 🗣️ Final Thoughts
This approach is clean, efficient, and beginner-friendly 💪  
You can further optimize by limiting the search up to `100 * k` since `nums[i] <= 100`.

---
