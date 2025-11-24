# 🧮 Binary Prefix Divisible By 5

## 🔍 Problem Summary

You are given a binary array `nums`. For every index `i`, create a number `xᵢ` whose binary form is `nums[0..i]`.

Your task is to return a list of booleans where:

* `true` → the number formed up to index `i` is divisible by **5**
* `false` → otherwise

---

## 🧠 Key Insight

Instead of forming the full number each time (which becomes huge), maintain only:

```
num = (num * 2 + current_bit) % 5
```

If `num % 5 == 0`, the current prefix is divisible by 5.

This works because:

* `% 5` keeps the number small
* binary left-shift `(num << 1)` = multiply by 2

---

## ✅ Example

### Input:

```
nums = [0, 1, 1]
```

### Binary Prefixes:

* `0` → 0 → divisible → true
* `01` → 1 → false
* `011` → 3 → false

### Output:

```
[true, false, false]
```

---

## 💡 Java Solution

```java
class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> list = new ArrayList<>();
        int num = 0;
        for (int bit : nums) {
            num = ((num << 1) + bit) % 5;
            list.add(num == 0);
        }
        return list;
    }
}
```

---

## 🏁 Complexity

* **Time:** O(n)
* **Space:** O(n) for the result list

---

## 🎯 Notes

* Keeping `num` modulo 5 avoids overflow.
* Efficient for large inputs up to `10⁵`.

---
