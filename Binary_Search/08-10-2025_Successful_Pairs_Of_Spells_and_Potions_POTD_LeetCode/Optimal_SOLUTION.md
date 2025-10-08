# 🧙‍♂️ Successful Pairs of Spells and Potions

## 🧩 Problem Statement
You are given two positive integer arrays `spells` and `potions` of lengths `n` and `m` respectively.  
- `spells[i]` represents the strength of the *i-th spell*  
- `potions[j]` represents the strength of the *j-th potion*  

You are also given an integer `success`.  
A **spell and potion pair** is considered **successful** if the **product** of their strengths is **at least `success`**.

Return an integer array `pairs` of length `n`, where `pairs[i]` is the **number of potions** that form a successful pair with the *i-th spell*.

---

## 🧠 Example

### Example 1:
**Input:**
```
spells = [5,1,3]
potions = [1,2,3,4,5]
success = 7
```

**Output:**
[4,0,3]


**Explanation:**
- Spell `5` → Products = `[5,10,15,20,25]` → **4 successful**
- Spell `1` → Products = `[1,2,3,4,5]` → **0 successful**
- Spell `3` → Products = `[3,6,9,12,15]` → **3 successful**

✅ Result → `[4,0,3]`

---

### Example 2:
**Input:**
```
spells = [3,1,2]

potions = [8,5,8]

success = 16
```

**Output:**
[2,0,2]

**Explanation:**
- Spell `3` → `[24,15,24]` → **2 successful**
- Spell `1` → `[8,5,8]` → **0 successful**
- Spell `2` → `[16,10,16]` → **2 successful**

✅ Result → `[2,0,2]`

---

## ⚙️ Constraints
n == spells.length

m == potions.length

1 <= n, m <= 10^5

1 <= spells[i], potions[i] <= 10^5

1 <= success <= 10^10


---

## 💡 Approach Explanation

### 🪄 Step 1: Sort the `potions` array
We sort the potions so that we can use **Binary Search** to quickly find the minimum potion required for each spell.

---

### 🧮 Step 2: For each spell
We calculate the **maximum possible product** →  
`spells[i] * max(potions)`

If this maximum product is **less than success**, no potion will ever be successful → directly store `0`.

Otherwise, we perform a **binary search** on the sorted `potions` array to find the **first potion** that satisfies:

(spells[i] * potions[j]) >= success

---

### 🔍 Step 3: Binary Search Logic
We keep track of the **lowest index** that satisfies the success condition.

- If `spells[i] * potions[mid] >= success`, move **left** (hi = mid - 1)
- Else move **right** (lo = mid + 1)

After finding the first valid index,  
✅ `count of successful potions = total potions - index`

---

## 🧾 Java Code Implementation

```java
class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int[] result = new int[spells.length];
        int maxPotion = 0;

        // Find maximum element in potions
        for (int p : potions) {
            if (p > maxPotion) {
                maxPotion = p;
            }
        }

        // For each spell
        for (int i = 0; i < spells.length; i++) {
            // If even the largest potion can't reach success
            if ((long) spells[i] * maxPotion < success) {
                result[i] = 0;
            } else {
                // Binary search for first successful potion
                int index = binarySearch(spells[i], potions, success);
                result[i] = potions.length - index;
            }
        }
        return result;
    }

    // Binary Search function
    private int binarySearch(int spell, int[] potions, long success) {
        int lo = 0, hi = potions.length - 1;
        int ans = potions.length; // default to end if not found
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if ((long) spell * potions[mid] >= success) {
                ans = mid;
                hi = mid - 1; // search left part
            } else {
                lo = mid + 1;
            }
        }
        return ans;
    }
}
```
## 🧩 Dry Run Example

spells = [5, 1, 3],

potions = [1, 2, 3, 4, 5],

success = 7
| Spell | Binary Search Result | Successful Count |
| ----- | -------------------- | ---------------- |
| 5     | index = 1 (potion=2) | 5 - 1 = 4        |
| 1     | no valid potion      | 0                |
| 3     | index = 2 (potion=3) | 5 - 2 = 3        |

**✅ Output → [4, 0, 3]**
## 🕒 Time Complexity

- Sorting potions → O(m log m)

- For each spell, binary search → O(n log m)

- Total: O(m log m + n log m)

## 💾 Space Complexity

- Using only constant extra space → O(1)
## 🧠 Intuition Recap

The core idea is:

For every spell, find the smallest potion that makes their product ≥ success.

The rest of the potions after that point will always work (since potions are sorted).

## ✨ Concise Explanation

Sort potions → For each spell, use binary search to find the first potion where
spell * potion ≥ success.

Count of successful potions = total potions - index.

**🚀 Output**
| Input                                                | Output  |
| ---------------------------------------------------- | ------- |
| spells = [5,1,3], potions = [1,2,3,4,5], success = 7 | [4,0,3] |
| spells = [3,1,2], potions = [8,5,8], success = 16    | [2,0,2] |
