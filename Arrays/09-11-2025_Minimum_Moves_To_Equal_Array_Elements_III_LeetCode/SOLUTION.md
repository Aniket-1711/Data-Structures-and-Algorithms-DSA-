# Minimum Moves to Equal Array Elements III 🎯

### Problem Explained in Simple Steps ✨

---

## 1. The Goal 🏁

We want to make **every number in the array equal**.
We can only **increase numbers by +1** each move.
Our objective is to find the **minimum number of moves** required to make all numbers equal.

---

## 2. The Key Insight 💡

### Rule:

We can only move **up** (e.g., 4 ➡️ 5). We can **never move down** (e.g., 5 ➡️ 4).

### Conclusion:

Since we can’t make any number smaller, our final equal number (the **target**) must be **greater than or equal to every number** in the array.

### Example:

If we have `[2, 1, 3]`, the target can’t be 2 (because we can’t reduce 3 to 2).

To minimize moves, we pick the **smallest possible target** that satisfies this rule — the **maximum element** in the array.

📘 **Target = max(nums)**

---

## 3. Example Walkthrough 🔢

Let’s trace with:

```java
nums = [2, 1, 3];
```

### Step 1: Find the target

Maximum element = 3
➡️ Target = 3

### Step 2: Calculate moves for each element

| Element | Moves Needed |
| ------- | ------------ |
| 2       | 3 - 2 = 1    |
| 1       | 3 - 1 = 2    |
| 3       | 3 - 3 = 0    |

### Step 3: Add them up

Total Moves = 1 + 2 + 0 = **3** ✅

---

## 4. General Formula 🧠

**Total Moves = Σ (target - nums[i])**

Simplify the equation:

```
Total Moves = (target * nums.length) - (sum of nums)
```

Since:

```
target = max(nums)
```

📘 **Final Formula:**

```
Total Moves = (nums.length * max(nums)) - sum(nums)
```

---

## 5. Implementation 🤝

This is how the logic directly translates into Java code:

```java
class Solution {
    public int minMoves(int[] nums) {
        int max=Integer.MIN_VALUE;
        int sum=0;
        for(int i:nums){
            sum+=i;
            max=Math.max(max, i);
        }
            return (max*nums.length)-sum;
    }
}
```

✅ The code efficiently finds the **maximum**, calculates the **sum**, and applies the derived formula in one pass.

---

## 6. Time and Space Complexity ⚙️

* **Time Complexity:** O(n) — Each element is processed once to find the max and sum.
* **Space Complexity:** O(1) — Only a few extra variables are used regardless of input size.

---

### 🎯 Final Takeaway

* Only upward moves are allowed ⬆️
* Final target = `max(nums)`
* Formula = `(max * n) - sum`

This concise, mathematically optimal approach ensures minimal operations with maximum clarity and efficiency.
