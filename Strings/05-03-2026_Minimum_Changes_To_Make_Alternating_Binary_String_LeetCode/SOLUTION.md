# 🔄 Minimum Changes to Make Alternating Binary String

## 📌 Problem

Given a binary string consisting of **0s and 1s**, we can flip any character (0 → 1 or 1 → 0).

The goal is to find the **minimum number of changes required to make the string alternating**.

An **alternating string** means no two adjacent characters are the same.

Examples:

* ✅ `0101`
* ✅ `1010`
* ❌ `0011`

---

# 🧠 Key Idea

For any binary string, only **two valid alternating patterns** are possible:

1️⃣ Start with **0** → `010101...`

2️⃣ Start with **1** → `101010...`

The approach is to compare the input string with **both patterns** and count mismatches.

The minimum mismatch count will be the answer.

---

# ⚙️ Approach

### Step 1

Initialize two counters:

* `changeStart0` → changes needed if pattern starts with **0**
* `changeStart1` → changes needed if pattern starts with **1**

---

### Step 2

Traverse the string from **index 0 to n-1**.

For each position:

* If the index is **even**:

  * expected character for pattern1 → `0`
  * expected character for pattern2 → `1`

* If the index is **odd**:

  * expected character for pattern1 → `1`
  * expected character for pattern2 → `0`

---

### Step 3

Compare the actual character with the expected character.

If they are different, increase the mismatch counter.

---

### Step 4

After checking the whole string:

Return

```
min(changeStart0, changeStart1)
```

This gives the **minimum operations required**.

---

# 💻 Java Implementation

```java
class Solution {
    public int minOperations(String s) {
        int changeStart0 = 0;
        int changeStart1 = 0;

        for(int i = 0; i < s.length(); i++) {

            char expected0 = (i % 2 == 0) ? '0' : '1';
            char expected1 = (i % 2 == 0) ? '1' : '0';

            if(s.charAt(i) != expected0) changeStart0++;
            if(s.charAt(i) != expected1) changeStart1++;
        }

        return Math.min(changeStart0, changeStart1);
    }
}
```

---

# ⏱ Complexity Analysis

**Time Complexity:** ⏳ `O(n)`

* Only one traversal of the string.

**Space Complexity:** 📦 `O(1)`

* Only two counters are used.

---

# 🎯 Example

Input

```
s = "1111"
```

Possible alternating strings:

```
0101
1010
```

Changes required:

* To `0101` → 2 changes
* To `1010` → 2 changes

Minimum = **2** ✅

---

# 🚀 Key Insight

Whenever a problem asks to make a **binary string alternating**, remember:

👉 Only **two patterns** exist:

```
010101...
101010...
```

Simply count mismatches with both patterns and take the **minimum**.
