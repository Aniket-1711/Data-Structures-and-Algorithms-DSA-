# ⚖️ Construct Uniform Parity Array II

## 📌 Problem

Given an array `nums1` of **distinct integers**, construct another array `nums2` such that:

* All elements are either **all even** or **all odd**
* For each index `i`, you can choose:

  * `nums2[i] = nums1[i]`
  * `nums2[i] = nums1[i] - nums1[j]` where `j ≠ i` AND result ≥ 1

Return `true` if possible, else `false`.

---

## 💡 Key Difference from Part I

👉 Now we have a restriction:

```
nums1[i] - nums1[j] ≥ 1
```

So we **cannot subtract a larger number from a smaller one**.

---

## 🔍 Parity Rules

* Even - Even = Even
* Odd - Odd = Even
* Even - Odd = Odd
* Odd - Even = Odd

---

## 🧠 Strategy

We try to make **all elements ODD** (best option)

### Step 1: Find smallest odd number

* Let `minOdd` = smallest odd in array

### Step 2: Check even numbers

* For every even number `e`
* We try: `e - minOdd`

👉 This gives an **odd number**, BUT only if:

```
e > minOdd
```

---

## 🚨 Important Cases

### ✅ Case 1: No odd numbers

* All numbers are even → already valid

### ❌ Case 2: Even ≤ smallest odd

* Cannot subtract → result becomes ≤ 0 ❌

### ✅ Case 3: All evens > smallest odd

* Can convert all evens → odd ✅

---

## 💻 Java Code

```java
class Solution {
    public boolean uniformArray(int[] nums1) {
        int min = Integer.MAX_VALUE;
        boolean hasOdd = false;

        for(int i : nums1){
            if(i % 2 == 1){
                hasOdd = true;
                min = Math.min(min, i);
            }
        }

        // All even
        if(!hasOdd) return true;

        for(int i : nums1){
            if(i % 2 == 0){
                if(i <= min){
                    return false;
                }
            }
        }

        return true;
    }
}
```

---

## ⏱️ Complexity

* **Time:** O(n)
* **Space:** O(1)

---

## 🧩 Example

```
nums1 = [2, 3]

minOdd = 3

Check 2:
2 - 3 = -1 ❌ (invalid)

So answer = false
```

---

## 🚀 Key Takeaways

* Always try converting everything to **odd**
* Use **smallest odd** as reference
* Check constraint: result must be ≥ 1
* This constraint makes problem tricky compared to Part I

---


