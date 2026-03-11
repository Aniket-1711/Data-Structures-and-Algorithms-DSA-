# 🔁 Complement of Base 10 Integer

## 📌 Problem

Given a number **n**, return its **bitwise complement**.

The complement is obtained by:

* Converting the number to **binary**
* Flipping every bit

  * `0 → 1`
  * `1 → 0`

Then convert the result back to **decimal**.

### Example

| Input | Binary | Complement | Output |
| ----- | ------ | ---------- | ------ |
| 5     | 101    | 010        | 2      |
| 7     | 111    | 000        | 0      |
| 10    | 1010   | 0101       | 5      |

---

# 💡 Idea

We only flip the bits that exist in the number.

Example:

```
5 → 101
mask → 111
```

Then we use **XOR**:

```
101 XOR 111 = 010
```

Result = **2**

So the plan is:

1. Create a **mask of all 1s** having the same length as the binary number.
2. XOR the number with the mask to flip the bits.

---

# ⚙️ Algorithm

1. If `n == 0`, return `1`
2. Copy `n` to a temporary variable.
3. Build a **mask of 1s** while shifting bits.
4. XOR the number with the mask.
5. Return the result.

---

# 💻 Java Implementation

```java
class Solution {
    public int bitwiseComplement(int n) {

        if(n == 0) return 1;

        int mask = 0;
        int temp = n;

        while(temp > 0){
            mask = (mask << 1) | 1;
            temp = temp >> 1;
        }

        return n ^ mask;
    }
}
```

---

# 🧠 Example Walkthrough

### Input

```
n = 5
```

### Binary

```
5 → 101
```

### Mask Creation

```
mask → 111
```

### XOR Operation

```
101 XOR 111 = 010
```

### Output

```
2
```

---

# ⏱ Complexity

**Time Complexity:**

```
O(log n)
```

Because we process each binary bit.

**Space Complexity:**

```
O(1)
```

No extra memory used.

---

# 🚀 Key Concepts

* Binary representation
* Bit manipulation
* XOR operation
* Bit masking
