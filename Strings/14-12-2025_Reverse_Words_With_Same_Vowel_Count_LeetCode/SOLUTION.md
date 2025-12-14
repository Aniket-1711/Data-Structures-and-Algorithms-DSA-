# 🔁 Reverse Words With Same Vowel Count

## 🧠 Problem Statement

You are given a sentence `s` made of lowercase English words separated by **single spaces**.

Steps to follow:

1. Count the number of **vowels** in the **first word**
2. For every next word:

   * If it has the **same vowel count**, reverse it
   * Otherwise, keep it as it is
3. Return the final modified string

Vowels considered: `a, e, i, o, u`

---

## 💡 Key Idea

* Use the **first word as reference**
* Compare vowel count of each word with the first word
* Reverse only the matching ones

---

## 🛠️ Approach

1. Split the string by spaces
2. Count vowels in the first word
3. Traverse remaining words:

   * If vowel count matches → reverse word
4. Build result using `StringBuilder`

---

## 💻 Java Implementation

```java
class Solution {
    public String reverseWords(String s) {
        String str[] = s.split(" ");
        int vcount = countVowl(str[0]);
        StringBuilder st = new StringBuilder(str[0]);

        for (int i = 1; i < str.length; i++) {
            if (vcount == countVowl(str[i])) {
                str[i] = new StringBuilder(str[i]).reverse().toString();
            }
            st.append(" ").append(str[i]);
        }
        return st.toString();
    }

    public int countVowl(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                count++;
            }
        }
        return count;
    }
}
```

---

## 🧪 Example Walkthrough

### Input

```
cat and mice
```

### Explanation

* `cat` → 1 vowel (reference)
* `and` → 1 vowel → reversed → `dna`
* `mice` → 2 vowels → unchanged

### Output

```
cat dna mice
```

---

## ⏱️ Complexity Analysis

* **Time Complexity:** `O(n)`
* **Space Complexity:** `O(n)` (for split + result)

---

## ✅ Notes

* Handles large input size
* Simple logic
* Beginner-friendly solution

---
