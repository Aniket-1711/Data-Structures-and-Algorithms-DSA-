# 🔻 Minimum String Length After Balanced Removals 🔻

## 📌 Problem Overview

You are given a string `s` made only of **'a'** and **'b'** characters.
You can remove any substring where:

> number of 'a' = number of 'b'

After removal, remaining parts join together.

Your goal 🎯 → **Minimize** the final string length after any number of such removals.

---

## 🧠 Main Idea

To form a removable substring:

* We need **equal count** of 'a' and 'b'
* So every time we remove them in pairs

What **cannot** be removed ❌:

* Extra 'a' or extra 'b' characters after maximum removals

🎯 Minimum length = `|count(a) - count(b)|`

---

## 🛠️ Steps

1️⃣ Count number of `a` → `c`

2️⃣ Count number of `b` → `d`

3️⃣ Return `abs(c - d)`

✔️ Because that’s the leftover imbalance

🕒 Time Complexity: **O(n)**
📦 Space Complexity: **O(1)**

---

## 👨‍💻 Java Code

```java
class Solution {
    public int minLengthAfterRemovals(String s) {
        int c = 0, d = 0;

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == 'a'){
                c++;
            }
            else{
                d++;
            }
        }
        return Math.abs(c - d);
    }
}
```

---

## 🔍 Example

### Input

`s = "aaabb"`

Counts:

* a: 3
* b: 2

Minimum leftover = `|3 - 2| = 1`

🎉 Result = **1**

---

## 🏁 Conclusion

Remove all balanced `a-b` pairs ➝ only leftover imbalance stays 😎🔥

---

