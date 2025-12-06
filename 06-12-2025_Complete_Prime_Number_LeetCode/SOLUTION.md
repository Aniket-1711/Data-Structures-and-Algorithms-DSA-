# ✅ Complete Prime Number 💡

## 📌 Problem Statement

A number is called a **Complete Prime Number** if **every prefix and every suffix** of the number is **prime**.

### 🔹 Definitions

* **Prefix**: First `k` digits of the number
* **Suffix**: Last `k` digits of the number
* **Prime Number**: A natural number > 1 with exactly two factors (1 and itself)
* **Single-digit numbers** are complete prime **only if they are prime**

---

## 🧠 Logic / Approach

1. Convert the number to a string.
2. Loop from `1` to length of the string.
3. For each `i`:

   * Take **prefix** → first `i` digits
   * Take **suffix** → last `i` digits
4. Check if **both prefix and suffix are prime**.
5. If any one is not prime → return `false`.
6. If all checks pass → return `true`.

---

## 🧪 Examples

### Example 1

```
Input: 23
Output: true
```

**Explanation**:

* Prefixes: 2, 23 → prime ✅
* Suffixes: 3, 23 → prime ✅

---

### Example 2

```
Input: 39
Output: false
```

**Explanation**:

* Prefix: 39 → not prime ❌
* Suffix: 9 → not prime ❌

---

### Example 3

```
Input: 7
Output: true
```

**Explanation**:

* Single digit and prime ✅

---

## 🧩 Java Code 💻

```java
class Solution {
    public boolean completePrime(int num) {
        String s = String.valueOf(num);

        for (int i = 1; i <= s.length(); i++) {
            int prefix = Integer.parseInt(s.substring(0, i));
            int suffix = Integer.parseInt(s.substring(s.length() - i));

            if (!isPrime(prefix) || !isPrime(suffix)) {
                return false;
            }
        }
        return true;
    }

    public boolean isPrime(int numb) {
        if (numb <= 1) return false;
        if (numb == 2) return true;

        for (int i = 2; i * i <= numb; i++) {
            if (numb % i == 0) {
                return false;
            }
        }
        return true;
    }
}
```

---

## ⏱️ Time & Space Complexity

* **Time Complexity**: `O(d * √n)`

  * `d` = number of digits
  * Prime check per prefix/suffix
* **Space Complexity**: `O(1)` (constant extra space)

---

## ✅ Key Points

* Checks **both prefix and suffix** at every length
* Works for **single-digit** and **multi-digit** numbers
* Clean and readable implementation ✨

---

⭐ If all prefixes and suffixes are prime → **Complete Prime Number**
