# 🔢 Count Monobit Integers

## 📌 Problem Summary

You are given an integer `n`.

An integer is called **Monobit** if **all bits in its binary representation are the same**.

Your task is to count how many Monobit integers exist in the range **[0, n] (inclusive)**.

---

## 🧠 What is a Monobit number?

A number is **Monobit** if:

* Its binary representation contains **only 0s** or **only 1s**

### ✅ Examples

| Number | Binary | Monobit? |
| ------ | ------ | -------- |
| 0      | `0`    | ✅ Yes    |
| 1      | `1`    | ✅ Yes    |
| 2      | `10`   | ❌ No     |
| 3      | `11`   | ✅ Yes    |
| 4      | `100`  | ❌ No     |

---

## 🔍 Observation

All Monobit numbers (with only `1`s) follow this pattern:

```
1        -> 1
11       -> 3
111      -> 7
1111     -> 15
...
```

These numbers can be generated using:

```
(1 << k) - 1
```

Also:

* `0` is always Monobit

---

## 💡 Strategy

1. Start count with `1` (to include `0`).
2. Generate numbers of the form `(1 << k) - 1`.
3. Stop when the generated number becomes greater than `n`.
4. Count all valid numbers.

---

## 🧪 Examples

### Example 1

```
Input: n = 1
```

Valid Monobit numbers: `0`, `1`

✅ Output: `2`

---

### Example 2

```
Input: n = 4
```

Valid Monobit numbers: `0`, `1`, `3`

✅ Output: `3`

---

## ⚙️ Java Solution

```java
class Solution {
    public int countMonobit(int n) {
        int count = 1; // for 0
        int c = 0;

        while (true) {
            int num = (1 << c) - 1;
            if (num > n) {
                break;
            }
            if (num != 0) {
                count++;
            }
            c++;
        }
        return count;
    }
}
```

---

## ⏱️ Complexity Analysis

* **Time Complexity:** `O(log n)`
* **Space Complexity:** `O(1)`

---

## ✅ Final Notes

* Efficient solution without checking every number
* Uses bit manipulation smartly ⚡
