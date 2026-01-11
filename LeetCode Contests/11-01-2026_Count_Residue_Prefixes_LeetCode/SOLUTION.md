# 🧮 Count Residue Prefixes (LeetCode 3803)

## 📌 Problem

You are given a string `s` with only lowercase letters.

A prefix is called a **residue** if:

```
number of distinct characters in prefix == (length of prefix) % 3
```

Your task is to count how many such prefixes exist.

---

## 🧠 Approach

* Traverse the string from left to right.
* Maintain a `HashSet` to store distinct characters seen so far.
* For each prefix:

  * Add the current character to the set.
  * Check if:

    ```
    set.size() == (currentLength % 3)
    ```
  * If true, increment the count.

---

## 💡 Example

For `s = "abc"`

| Prefix | Distinct Count | Length % 3 | Residue? |
| ------ | -------------- | ---------- | -------- |
| a      | 1              | 1          | ✅ Yes    |
| ab     | 2              | 2          | ✅ Yes    |
| abc    | 3              | 0          | ❌ No     |

Answer = `2`

---

## 🧩 Java Code

```java
class Solution {
    public int residuePrefixes(String s) {
        HashSet<Character> set = new HashSet<>();
        int count = 0;
        
        for (int i = 0; i < s.length(); i++) {
            set.add(s.charAt(i));
            
            if (set.size() == (i + 1) % 3) {
                count++;
            }
        }
        return count;
    }
}
```

---

## ⏱️ Complexity

* **Time:** O(n)
* **Space:** O(1) (max 26 characters)

---

## 🚀 Key Takeaways

* Prefix problems are best solved using incremental traversal.
* `HashSet` helps track distinct characters easily.
* Modulo patterns are common in competitive programming.

