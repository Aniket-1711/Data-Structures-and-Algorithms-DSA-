# 🔤 Valid Anagram (LeetCode 242)

## 📌 Problem Statement

Given two strings `s` and `t`, check whether `t` is an anagram of `s`.

An anagram means both strings contain the same characters with the same frequency, only the order can be different.

---

## 🧠 Example

| Input                        | Output  |
| ---------------------------- | ------- |
| s = "anagram", t = "nagaram" | ✅ true  |
| s = "rat", t = "car"         | ❌ false |

---

## ⚙️ Approach

We use an integer array of size 26 (for lowercase letters `a` to `z`).

1. If lengths are different → return false.
2. Traverse both strings together:

   * Increase count for character in `s`.
   * Decrease count for character in `t`.
3. At the end, if all values in array are zero → strings are anagrams.

This works because each character added is also removed if both strings have same frequency.

---

## 💻 Java Code

```java
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }

        int ar[] = new int[26];
        
        for(int i = 0; i < s.length(); i++) {
            ar[s.charAt(i) - 'a']++;
            ar[t.charAt(i) - 'a']--;
        }

        for(int i : ar) {
            if(i != 0) {
                return false;
            }
        }
        return true;
    }
}
```

---

## ⏱️ Time & Space Complexity

* **Time:** O(n)
* **Space:** O(1) (only 26 size array)

---

## ✅ Conclusion

This method is fast and memory efficient for checking anagrams using frequency counting. 🎯
