# 🚀 Check If All 1's Are at Least Length K Places Away

This project solves the problem: **1437. Check If All 1's Are at Least Length K Places Away** 🧠✨

---

## 📌 Problem Description

Given a **binary array** `nums` and an integer `k`, we need to check:

* Every `1` should be at least **k places away** from the next `1` ➡️
* If this condition is satisfied → return **true** 👍
* Otherwise → return **false** ❌

---

## 🔍 Example

### Example 1

**Input:**

```
nums = [1,0,0,0,1,0,0,1]
k = 2
```

**Output:** `true`

📌 All the `1`s are spaced properly.

---

### Example 2

**Input:**

```
nums = [1,0,0,1,0,1]
k = 2
```

**Output:** `false`

⚠️ Here, two `1`s are only **1 place apart**, not allowed.

---

## 🧠 Approach

We track the index of the **previous 1** and ensure the distance condition:

✅ Gap should be: `currentIndex - previousIndex > k`

---

## 💻 Java Code

```java
class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int prev = -1;
        for(int i=0; i<nums.length; i++){
            if(nums[i] == 1){
                if(prev != -1 && i - prev <= k){
                    return false;
                }
                prev = i;
            }
        }
        return true;
    }
}
```

---

## 🏁 Output

✔️ Efficient
✔️ Easy to understand
✔️ Works for all constraints

---

