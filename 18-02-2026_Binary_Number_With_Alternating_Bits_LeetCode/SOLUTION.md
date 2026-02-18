# 🔢 Binary Number with Alternating Bits (LeetCode 693)

## 📌 Problem Statement

Given a **positive integer `n`**, check whether its **binary representation** has **alternating bits**.

👉 Alternating bits means **no two adjacent bits are the same**.

---

## 🧠 Understanding the Idea

* Convert the number into binary (implicitly using bit operations)
* Compare **each bit** with the **previous bit**
* If two adjacent bits are the same → ❌ Not alternating
* If all adjacent bits are different → ✅ Alternating

---

## 🧪 Examples

| Input | Binary | Output  | Reason                 |
| ----- | ------ | ------- | ---------------------- |
| `5`   | `101`  | `true`  | Bits alternate         |
| `7`   | `111`  | `false` | Same adjacent bits     |
| `11`  | `1011` | `false` | Last two bits are same |

---

## ⚙️ Approach

1. Store the **last bit** using `n & 1`
2. Right shift `n` by 1
3. Loop until `n` becomes 0:

   * Get current bit using `n & 1`
   * Compare with previous bit
   * If same → return `false`
4. If loop finishes → return `true`

---

## 💻 Java Solution

```java
class Solution {
    public boolean hasAlternatingBits(int n) {
        int prev = n & 1;
        n >>= 1;

        while (n > 0) {
            int curr = n & 1;
            if (curr == prev) {
                return false;
            }
            prev = curr;
            n >>= 1;
        }
        return true;
    }
}
```

---

## ⏱️ Complexity Analysis

* **Time Complexity:** `O(log n)`
* **Space Complexity:** `O(1)`

---

## ✅ Key Takeaways

* Bitwise operations avoid explicit binary conversion
* `& 1` helps extract the last bit
* Right shift (`>>`) moves through the binary number efficiently

---

