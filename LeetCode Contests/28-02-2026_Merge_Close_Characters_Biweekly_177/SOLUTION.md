# 📌 3853. Merge Close Characters

## 🧠 Problem Statement

Given:

* A string `s` (only lowercase letters)
* An integer `k`

Two equal characters are **close** if:

```
(right_index - left_index) ≤ k
```

### 🔁 Merge Rule

* When two equal characters are close →
  The **right character merges into the left** (right one gets deleted).
* After every merge, the string updates.
* Always choose:

  1. Smallest left index
  2. If tie → smallest right index

Continue until no more merges are possible.

---

## 📝 Approach

### 1️⃣ Use StringBuilder

Since strings are immutable in Java, we use `StringBuilder` for easy deletion.

### 2️⃣ Iterate from Left to Right

* Fix one index (`index`)
* Check all characters to its right
* If:

  * Characters are equal
  * Distance ≤ k

➡ Delete the right character
➡ Reset index to 0 (because string changed)

### 3️⃣ Continue Until No Merge Possible

If no merge found for current index → move forward.

---

## 💻 Java Code

```java
class Solution {
    public String mergeCharacters(String s, int k) {
        StringBuilder str = new StringBuilder(s);
        int index = 0;

        while (index < str.length()) {
            boolean flag = true;

            for (int i = index + 1; i < str.length(); i++) {
                if (str.charAt(index) == str.charAt(i) && i - index <= k) {
                    str.deleteCharAt(i);
                    index = 0;   // restart because string changed
                    flag = false;
                    break;
                }
            }

            if (flag) {
                index++;
            }
        }

        return str.toString();
    }
}
```

---

## 🔍 Dry Run Example

### Input

```
s = "yybyzybz"
k = 2
```

### Steps

1. Merge y(0) and y(1)
   → "ybyzybz"
2. Merge y(0) and y(2)
   → "ybzybz"
3. No more valid merges

### ✅ Output

```
"ybzybz"
```

---

## ⏱ Complexity Analysis

* **Time Complexity:** Worst case `O(n²)`
  (Because after every delete we restart)

* **Space Complexity:** `O(n)`
  (Using StringBuilder)

---

## 🚀 Key Concepts Used

* StringBuilder
* Simulation
* Greedy selection (smallest left index first)

---

