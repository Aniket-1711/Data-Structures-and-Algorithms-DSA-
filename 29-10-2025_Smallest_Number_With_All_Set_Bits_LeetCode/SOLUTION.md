# Smallest Number With All Set Bits ✅

> Find the smallest number `x` (x >= n) whose binary representation has only set bits (i.e., of the form `11..1` = `2^k - 1`).

---

## Problem statement 🧩

You are given a positive integer `n`.

Return the smallest integer `x` such that `x >= n` and the binary representation of `x` contains only set bits (all ones). Examples of such numbers: `1 (1)`, `3 (11)`, `7 (111)`, `15 (1111)`, etc.

---

## Examples ✨

* **Input:** `n = 5`
  **Output:** `7`
  Explanation: `7` in binary is `111`.

* **Input:** `n = 10`
  **Output:** `15`
  Explanation: `15` in binary is `1111`.

* **Input:** `n = 3`
  **Output:** `3`
  Explanation: `3` in binary is `11`.

---

## Idea / Approach (Beginner → Pro) 💡

**Short intuition (one-liner):** We want the smallest number which is all ones in binary and still ≥ `n`. Those numbers are `2^k - 1` for `k = 1,2,3,...` so find the smallest `k` where `2^k - 1 >= n`.

**Bit-trick approach (efficient):** Instead of looping `k` from 1 upwards, we can transform `n` into the next number that has all low bits set by repeatedly setting the lowest zero bit to 1 and propagating that effect:

1. Check whether `n` is already all ones: `n & (n + 1) == 0` means `n` is `11..1`.
2. If not, set the lowest zero bit and keep doing this until it becomes all ones: `n |= (n + 1)`.

This uses only bit operations and runs very fast.

---

## Java solution (compact) 🧾

```java
class Solution {
    public int smallestNumber(int n) {
        while ((n & (n + 1)) != 0) {
            n |= (n + 1);
        }
        return n;
    }
}
```

---

## Line-by-line explanation (detailed) 🔍

* `n & (n + 1)` checks whether `n` is already of the form `2^k - 1`.

  * If `n = 7 (111)`, then `(n+1) = 8 (1000)`, so `n & (n+1) = 0`.
  * If result is `0`, we are done.

* `n |= (n + 1)` sets bits of `n` where `(n+1)` has bits; this effectively turns the lowest zero bit of `n` (to the right of the highest 1 block) into 1 and fills bits to the right with 1s as needed. Repeating this pushes `n` towards the next all-ones number.

**Why the loop terminates:** Each iteration strictly increases `n` and there's an upper bound (the next `2^k - 1`), so it finishes in at most `O(number_of_bits)` steps.

---

## Time & Space Complexity ⏱️

* **Time:** `O(b)` where `b` = number of bits in `n` (for constraints up to 1000, `b ≤ 10` — extremely fast).
* **Space:** `O(1)` constant extra space.

---

## Edge cases & constraints ⚠️

* Given `1 ≤ n ≤ 1000` in the prompt. The method works for larger `n` too (within integer limits). For very large `n`, use `long` in Java to be safe.
* If `n` is already all ones, the function returns `n` unchanged.

---

## Tests to try ✅

* `n = 1` → `1` (binary `1`)
* `n = 2` → `3` (binary `11`)
* `n = 4` → `7` (binary `111`)
* `n = 15` → `15` (already all ones)
* `n = 1000` → result value (try running to see exact integer)

---

## Tips & variations (pro) 🔧

* If `n` may exceed `2^31-1`, use `long` in Java and adjust checks accordingly.
* Another simple method: compute `k` by increasing `k` until `(1 << k) - 1 >= n`. This is straightforward but still `O(b)`.
* For teaching / debugging, print intermediate `n` in binary each loop to visualize how bits get filled.

---

## Short summary (one line) 🏁

Turn `n` into the nearest `2^k - 1` ≥ `n` using a bitwise loop: check `n & (n + 1)` and update `n |= (n + 1)` until condition meets.

---

