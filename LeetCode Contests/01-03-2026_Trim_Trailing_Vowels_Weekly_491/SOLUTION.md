# ✂️ Trim Trailing Vowels

## 📌 Problem Statement

Given a string `s` consisting of lowercase English letters, remove all **trailing vowels** from the string.

Vowels are:

```
a, e, i, o, u
```

Return the modified string after removing trailing vowels.

---

## 🧠 Example

### Example 1

**Input:** `"idea"`
**Output:** `"id"`

### Example 2

**Input:** `"day"`
**Output:** `"day"`

### Example 3

**Input:** `"aeiou"`
**Output:** `""`

---

## 🚀 Approach

1. Convert the string into a `StringBuilder`.
2. Reverse the string.
3. Remove characters from the beginning while they are vowels.
4. Reverse the string again.
5. Return the final result.

This works because reversing makes trailing characters become leading characters, which are easy to remove.

---

## 💻 Java Code

```java
class Solution {
    public String trimTrailingVowels(String s) {
        StringBuilder str = new StringBuilder(s);
        int i = 0;
        str.reverse();
        
        while (i < str.length()) {
            if (!isVowel(str.charAt(i))) {
                break;
            } else {
                str.deleteCharAt(i);
                i = 0;
            }
        }
        
        return str.reverse().toString();
    }

    public static boolean isVowel(Character ch) {
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
            return true;
        }
        return false;
    }
}
```

---

## ⏱ Time Complexity

* **O(n)** – Each character is processed at most once.

## 📦 Space Complexity

* **O(n)** – Using `StringBuilder`.

---

## ✅ Key Points

* Only trailing vowels are removed.
* If the entire string contains vowels → result is empty string.
* If there are no trailing vowels → string remains unchanged.

---

