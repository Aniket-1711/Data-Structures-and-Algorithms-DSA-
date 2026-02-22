# ⚡ Maximum Bitwise XOR After Rearrangement (Optimized)

## 📝 Problem Statement

You are given two binary strings:

* `s` → cannot be changed
* `t` → can be rearranged

Both strings have length `n`.

You must rearrange `t` such that:

> The value of `s XOR t` is maximum possible.

Return the resulting XOR string.

---

## 🧠 Key Observation

XOR rules:

```
1 XOR 0 = 1
0 XOR 1 = 1
1 XOR 1 = 0
0 XOR 0 = 0
```

To maximize the result, we try to generate as many `1`s as possible.

So at every index:

* If `s[i] == 1` → we want `t` to give `0`
* If `s[i] == 0` → we want `t` to give `1`

This is a greedy choice.

---

## 🚀 Approach

### Step 1️⃣ Count bits in `t`

* Count number of `1`s → `count1`
* Count number of `0`s → `count0`

### Step 2️⃣ Traverse string `s`

For every index:

* If opposite bit available → create `1` in result
* Otherwise → result becomes `0`
* Reduce the used count

---

## 💻 Java Implementation

```java
class Solution {
    public String maximumXor(String s, String t) {
        int count1 = 0, count0 = 0;

        // Count bits in t
        for(int i = 0; i < t.length(); i++) {
            if(t.charAt(i) == '1') count1++;
            else count0++;
        }

        StringBuilder result = new StringBuilder();

        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if(ch == '1' && count0 > 0) {
                result.append('1');
                count0--;
            }
            else if(ch == '0' && count1 > 0) {
                result.append('1');
                count1--;
            }
            else {
                result.append('0');
                if(ch == '1') count1--;
                else count0--;
            }
        }

        return result.toString();
    }
}
```

---

## ⏱ Complexity Analysis

* **Time Complexity:** O(n)
* **Space Complexity:** O(1) (excluding output string)

No extra arrays used.

---

## ✅ Why This Works

✔ Each position is independent

✔ Greedy works because maximizing left bits increases overall integer value

✔ No need to generate permutations

✔ Only counting + traversal required

---

## 🎯 Key Takeaways

✨ Maximize number of `1`s in XOR result

✨ Use counting instead of rearranging

✨ Simple greedy + frequency logic

---


