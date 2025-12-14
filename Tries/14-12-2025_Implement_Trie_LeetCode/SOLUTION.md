# 🌳 Implement Trie (Prefix Tree)

## 📌 Problem Overview

A **Trie** (also called Prefix Tree) is a special tree used to store strings efficiently.
It is very useful for:

* 🔍 Fast word search
* ✨ Prefix checking (autocomplete)
* 📝 Spell checking

In this problem, we implement a Trie with three main operations:

* `insert(word)`
* `search(word)`
* `startsWith(prefix)`

---

## 🛠️ Trie Structure

Each Trie node contains:

* 🔢 `children[26]` → array for lowercase English letters `a-z`
* ✅ `containsWord` → marks end of a complete word

The Trie also has a **root node** which is the starting point.

---

## 🚀 Operations Explained

### 1️⃣ Insert a Word

* Start from the root
* For each character in the word:

  * Move to the corresponding child
  * Create a new node if it does not exist
* Mark the last node as `containsWord = true`

⏱️ Time Complexity: **O(length of word)**

---

### 2️⃣ Search a Word

* Start from the root
* Traverse character by character
* If any character path is missing → return `false`
* After traversal, check `containsWord`

⏱️ Time Complexity: **O(length of word)**

---

### 3️⃣ Check Prefix (startsWith)

* Similar to search
* Only checks if the prefix path exists
* No need to check `containsWord`

⏱️ Time Complexity: **O(length of prefix)**

---

## 🧪 Example

```
Insert: apple
Search: apple   → true
Search: app     → false
StartsWith: app → true
Insert: app
Search: app     → true
```

---

## ✅ Constraints

* Only lowercase letters `a-z`
* Word / prefix length ≤ 2000
* Maximum operations ≤ 3 × 10⁴

---

## 📦 Key Takeaways

* Trie is best for prefix-based problems
* Much faster than checking strings one by one
* Widely used in search engines and autocomplete systems

---

## 💻 Java Implementation

```java
class Trie {
    Trie[] children = new Trie[26];
    Trie root;
    boolean containsWord;

    public Trie() {
        for (int i = 0; i < 26; i++) {
            children[i] = null;
        }
        this.root = null;
        this.containsWord = false;
    }
    
    public void insert(String word) {
        if (root == null) {
            root = new Trie();
        }
        Trie temp = root;

        for (int i = 0; i < word.length(); i++) {
            int ch = word.charAt(i) - 'a';
            if (temp.children[ch] == null) {
                temp.children[ch] = new Trie();
            }
            temp = temp.children[ch];
        }
        temp.containsWord = true;
    }
    
    public boolean search(String word) {
        if (root == null) return false;

        Trie temp = root;
        for (int i = 0; i < word.length(); i++) {
            int ch = word.charAt(i) - 'a';
            if (temp.children[ch] == null) {
                return false;
            }
            temp = temp.children[ch];
        }
        return temp.containsWord;
    }
    
    public boolean startsWith(String prefix) {
        if (root == null) return false;

        Trie temp = root;
        for (int i = 0; i < prefix.length(); i++) {
            int ch = prefix.charAt(i) - 'a';
            if (temp.children[ch] == null) {
                return false;
            }
            temp = temp.children[ch];
        }
        return true;
    }
}
```

---

