# 🔍 Smallest Window Containing All Characters

## 📌 Problem

Given two strings **`s`** and **`p`**, find the **smallest substring in `s`** that contains **all characters of `p` (including duplicates)**.

If multiple substrings of the same minimum length exist, return the one with the **smallest starting index**.

If no such substring exists, return an **empty string**.

---

## 💡 Approach Used — Sliding Window + Frequency Array

The solution uses the **Sliding Window technique** to efficiently find the smallest valid substring.

### 1️⃣ Store Required Character Frequencies

Create an array `ar[26]` to store how many times each character appears in string `p`.

Example
If `p = "toc"`

```
t → 1
o → 1
c → 1
```

---

### 2️⃣ Maintain Current Window Frequencies

Another array `br[26]` stores the frequency of characters in the **current window of string `s`**.

The window is defined by two pointers:

```
left  → start of window
right → end of window
```

---

### 3️⃣ Expand the Window

Move the `right` pointer through string `s` and update the frequency of characters in `br`.

```
br[s.charAt(right) - 'a']++
```

This gradually grows the window.

---

### 4️⃣ Check if Window is Valid

A helper function `same(ar, br)` checks whether the current window contains **all characters required by `p`**.

Condition:

```
br[i] >= ar[i]  for all characters
```

If this is true, the window is valid.

---

### 5️⃣ Shrink the Window

Once a valid window is found, try **shrinking it from the left** to make it as small as possible.

Steps:

1. Update the minimum window length.
2. Store the indices of the best window.
3. Remove the left character from the window.
4. Move `left` forward.

---

### 6️⃣ Return the Result

If a valid window was found, return the substring:

```
s.substring(li, ri + 1)
```

Otherwise return:

```
""
```

---

## 🧠 Example

Input

```
s = "timetopractice"
p = "toc"
```

Valid window found:

```
toprac
```

Output

```
"toprac"
```

---

## ⏱ Time Complexity

```
O(26 × N) ≈ O(N)
```

* `N` → length of string `s`
* `26` → number of lowercase letters checked in `same()` function

---

## 💾 Space Complexity

```
O(26)
```

Only two frequency arrays are used.

---

## 🚀 Key Concepts Used

* Sliding Window Technique
* Two Pointer Method
* Frequency Counting
* Window Shrinking Strategy

---

✔ Efficiently finds the **minimum substring containing all characters of another string**.
