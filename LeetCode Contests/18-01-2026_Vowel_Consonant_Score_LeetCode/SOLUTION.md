# 🔤 Vowel-Consonant Score (LeetCode 3813)

## 📘 Problem Statement

You are given a string `s` containing:

* lowercase letters (`a` to `z`)
* spaces
* digits

Count:

* `v` = number of vowels (`a, e, i, o, u`)
* `c` = number of consonants (other letters from `a` to `z`)

### 🧮 Score Formula

* If `c > 0` → `score = floor(v / c)`
* Else → `score = 0`

---

## 🧠 Approach

1. Initialize two counters: `v` for vowels and `c` for consonants.
2. Traverse each character of the string:

   * If it is a vowel → increment `v`.
   * Else if it is a lowercase letter → increment `c`.
3. If `c > 0`, return `v / c` (integer division gives floor automatically).
4. Otherwise, return `0`.

---

## 💻 Java Implementation

```java
class Solution {
    public int vowelConsonantScore(String s) {
        int v = 0, c = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                v++;
            } else if (ch >= 'a' && ch <= 'z') {
                c++;
            }
        }

        if (c > 0) {
            return v / c; // integer division = floor
        }
        return 0;
    }
}
```

---

## ✨ Example

Input: `"cooear"`

* Vowels = 4 (`o, o, e, a`)
* Consonants = 2 (`c, r`)
* Score = `4 / 2 = 2`

Output: `2` 🎯
