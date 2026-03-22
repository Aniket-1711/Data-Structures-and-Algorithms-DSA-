# ⚖️ Construct Uniform Parity Array

## 📌 Problem

Given an array `nums1` of **distinct integers**, construct another array `nums2` such that:

* All elements in `nums2` are either **all even** or **all odd**
* For each index `i`, you can choose:

  * `nums2[i] = nums1[i]`
  * `nums2[i] = nums1[i] - nums1[j]` where `j ≠ i`

Return `true` if possible, else `false`.

---

## 💡 Key Observation

👉 Parity rules:

* **Even - Even = Even**
* **Odd - Odd = Even**
* **Even - Odd = Odd**
* **Odd - Even = Odd**

So:

* If we want **even result** → subtract same parity
* If we want **odd result** → subtract different parity

---

## 🧠 Strategy

Count:

* `evenCount`
* `oddCount`

### ✅ Cases

1. **All numbers already same parity**

   * Directly return `true`

2. **Mixed parity exists**

   * We can always create **odd numbers** using (even - odd) or (odd - even)
   * So as long as we have **at least one even and one odd → possible**

---

## 🚨 Final Logic

👉 Answer is always `true`

Why?

* If all are even → already valid
* If all are odd → already valid
* If mixed → can always make all odd using subtraction

---

## 💻 Java Code

```java
class Solution {
    public boolean uniformArray(int[] nums1) {
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

2 - 3 = -1 (odd)
3 stays 3 (odd)

Result → [-1, 3] ✅
```

---

## 🚀 Key Takeaways

* Focus on **parity transformation rules**
* Subtraction gives flexibility to change parity
* Problem reduces to a simple observation → always possible

---


