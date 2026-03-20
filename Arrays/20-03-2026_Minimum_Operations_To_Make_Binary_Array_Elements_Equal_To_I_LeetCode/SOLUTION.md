# 🚀 Minimum Operations to Make Binary Array Elements Equal to One

## 🧠 Problem Summary

You are given a binary array (`0s` and `1s`).

👉 You can perform an operation:

* Select **any 3 consecutive elements**
* Flip them (0 → 1, 1 → 0)

🎯 Goal: Convert the entire array into **all 1s** using the **minimum number of operations**.

If it's not possible → return `-1`

---

## 💡 Key Idea (Greedy Approach)

We process the array from **left to right**.

### 🔑 Observation:

* If `nums[i] == 0`, we **must flip** at index `i`
* Because this is the **only chance** to fix it (later operations won't affect it)

---

## ⚙️ Algorithm Steps

1. Traverse from `i = 0` to `n - 3`
2. If `nums[i] == 0`:

   * Flip `nums[i]`, `nums[i+1]`, `nums[i+2]`
   * Increase operation count
3. After traversal:

   * Check last 2 elements
   * If any is `0` → ❌ return `-1`
4. Else → ✅ return count

---

## 🔁 Flip Operation

We use XOR to flip:

```
nums[i] = nums[i] ^ 1
```

| Value | After Flip |
| ----- | ---------- |
| 0     | 1          |
| 1     | 0          |

---

## 💻 Java Implementation

```java
class Solution {
    public int minOperations(int[] nums) {
        int count = 0;

        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] == 0) {
                nums[i] ^= 1;
                nums[i + 1] ^= 1;
                nums[i + 2] ^= 1;
                count++;
            }
        }

        // Check last two elements
        if (nums[nums.length - 2] == 0 || nums[nums.length - 1] == 0) {
            return -1;
        }

        return count;
    }
}
```

---

## 📊 Example Walkthrough

### Input:

```
[0,1,1,1,0,0]
```

### Steps:

1. Flip (0,1,2) → `[1,0,0,1,0,0]`
2. Flip (1,2,3) → `[1,1,1,0,0,0]`
3. Flip (3,4,5) → `[1,1,1,1,1,1]`

✅ Answer = `3`

---

## ❌ Edge Case

### Input:

```
[0,1,1,1]
```

Last elements cannot be fixed → ❌ Output = `-1`

---

## ⏱️ Complexity

* **Time:** O(n)
* **Space:** O(1)

---

## 🧩 Why This Works

* Greedy ensures we fix each position **as early as possible**
* Avoids unnecessary future flips
* Guarantees minimum operations

---

## 🏁 Final Thoughts

* Always think: *"Can I fix this later?"*
* If NOT → fix it immediately (Greedy mindset)


