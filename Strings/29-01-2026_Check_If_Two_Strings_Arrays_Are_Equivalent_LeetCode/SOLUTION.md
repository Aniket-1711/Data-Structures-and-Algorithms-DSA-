# 🧩 Check If Two String Arrays are Equivalent (LeetCode 1662)

## 📌 Problem

You are given two string arrays `word1` and `word2`.

Each array represents a string formed by joining all its elements in order.

Your task is to check whether both arrays form the same final string.

---

## 🧠 Idea

1. Join all strings in `word1` to make one full string.
2. Join all strings in `word2` to make another full string.
3. Compare both strings using `.equals()`.
4. If they are same → return `true`, else return `false`.

---

## 💻 Java Solution

```java
class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        String s1 = "";
        String s2 = "";

        for (String s : word1) {
            s1 += s;
        }
        
        for (String s : word2) {
            s2 += s;
        }
        
        return s1.equals(s2);
    }
}
```

---

## 🧪 Example

**Input:**

```
word1 = ["ab", "c"]
word2 = ["a", "bc"]
```

**Process:**

* `word1` → "ab" + "c" = "abc"
* `word2` → "a" + "bc" = "abc"

**Output:**

```
true
```

---

## ⏱ Time & Space

* **Time Complexity:** O(n)
* **Space Complexity:** O(n)

---

## ✅ Result

Both arrays are converted into strings and compared. If equal, the function returns `true`.

