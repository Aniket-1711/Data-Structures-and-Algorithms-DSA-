# 🔁 Reverse Degree of a String

## 📘 Problem Overview

Given a string `s` consisting of lowercase English letters, calculate its **reverse degree**.

The reverse degree is calculated by:

* Finding each character's position in the **reversed alphabet**

  * `'a' → 26`, `'b' → 25`, ..., `'z' → 1`
* Multiplying it by the character’s **1-based position** in the string
* Summing all these products

---

## 🧮 Example

### Input

```
s = "abc"
```

### Calculation

| Character | Reverse Alphabet Value | Position | Product |
| --------- | ---------------------- | -------- | ------- |
| a         | 26                     | 1        | 26      |
| b         | 25                     | 2        | 50      |
| c         | 24                     | 3        | 72      |

### Output

```
148
```

---

## 🧠 Approach

1. Create a mapping of characters `'a'` to `'z'` with reverse alphabet values.
2. Traverse the string from left to right.
3. For each character:

   * Fetch its reverse alphabet value
   * Multiply it by its 1-based index
4. Add all results to get the final reverse degree.

---

## 🧑‍💻 Java Implementation

```java
import java.util.*;
class Solution {
    public int reverseDegree(String s) {
        HashMap<Character, Integer> ref = new HashMap<>();
        int num = 26;
        
        // Create reverse alphabet mapping
        for (int i = 97; i <= 122; i++) {
            ref.put((char) i, num--);
        }
        
        int sum = 0;
        // Calculate reverse degree
        for (int j = 0; j < s.length(); j++) {
            sum += ref.get(s.charAt(j)) * (j + 1);
        }
        return sum;
    }
}
```

---

## ⏱️ Complexity Analysis

* **Time Complexity:** `O(n)`
* **Space Complexity:** `O(1)` (fixed-size HashMap of 26 letters)

---

## ✅ Key Points

* Uses ASCII values to map characters easily
* Handles all valid inputs within constraints
* Clean and beginner-friendly solution

---

