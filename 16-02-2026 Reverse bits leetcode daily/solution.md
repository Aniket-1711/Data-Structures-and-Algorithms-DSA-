# 🔥 Reverse Bits (LeetCode 190)

## 📌 Problem Statement

Reverse the bits of a given **32-bit unsigned integer**.

The input is treated as a binary sequence of length **32**, and you must return the integer obtained after reversing those bits.

---

## ✅ Example

### Example 1

**Input:** `n = 43261596`

| Integer                | Binary                           |
| ---------------------- | -------------------------------- |
| 43261596               | 00000010100101000001111010011100 |
| **Output → 964176192** | 00111001011110000010100101000000 |

---

### Example 2

**Input:** `n = 2147483644`

| Integer                 | Binary                           |
| ----------------------- | -------------------------------- |
| 2147483644              | 01111111111111111111111111111100 |
| **Output → 1073741822** | 00111111111111111111111111111110 |

---

## 🧠 Intuition

Reversing bits means flipping their positions:

* Bit at position **0** moves to **31**
* Bit at position **1** moves to **30**
* ...
* Bit at position **31** moves to **0**

We inspect every bit of `n` and rebuild the reversed number.

Core idea:

* Use **bit masking** to check whether a bit is set
* Use **bit shifting** to place bits correctly

---

## ⚡ Approach (Bit Manipulation)

1. Initialize `ans = 0`
2. Iterate through all **32 bit positions**
3. If bit `i` is set in `n`, set bit `(31 - i)` in `ans`

Why this works:

* `(n & (1 << i))` checks if bit `i` is ON
* `(1 << (31 - i))` places the bit in reversed position

---

## 📝 C++ Implementation

```cpp
class Solution {
public:
    uint32_t reverseBits(uint32_t n) {
        uint32_t ans = 0;

        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                ans = ans | (1 << (31 - i));
            }
        }

        return ans;
    }
};
```

---

## ⏱ Time Complexity

**O(32) → O(1)** (constant work)

## 💾 Space Complexity

**O(1)**

---

## 🖼 Conceptual Visualization

```
Original Bits:  b31 b30 b29 ... b2 b1 b0
Reversed Bits:  b0  b1  b2  ... b29 b30 b31
```

---

# 🚀 Follow-up: Optimizing for Many Calls

If this function is called repeatedly, looping through 32 bits every time is not ideal.

### ✅ Faster Strategy — Lookup Table

1. Precompute reversed values for all **8-bit numbers (0 → 255)**
2. Split the 32-bit integer into **4 bytes**
3. Reverse each byte using the table
4. Reassemble in reversed order

Concept:

```
n = [byte1][byte2][byte3][byte4]

Reverse → [rev(byte4)][rev(byte3)][rev(byte2)][rev(byte1)]
```

### ✅ Why This is Faster

* Bit reversal logic runs once
* Each call uses only a few operations
* Extremely efficient for large-scale usage

---

## 🧩 Key Takeaways

✔ Bit masking
✔ Bit shifting
✔ Positional reasoning
✔ Precomputation for optimization

---

⭐ If you found this helpful, consider giving the repository a star!
