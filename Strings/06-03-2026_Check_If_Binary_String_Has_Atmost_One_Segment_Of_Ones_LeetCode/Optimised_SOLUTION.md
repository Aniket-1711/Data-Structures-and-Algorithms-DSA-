# ✅ Check if Binary String Has at Most One Segment of Ones

## 📌 Problem

Given a **binary string `s`** without leading zeros, determine whether the string contains **at most one contiguous segment of `1`s**.

Return:

* `true` → if there is **only one continuous group of `1`s**
* `false` → if there are **multiple separated groups of `1`s`

---

## 💡 Approach Used

The idea is to **track when a segment of `1`s starts and when it ends**.

If another `1` appears **after a segment has already ended**, then the string contains **more than one segment**, so we return `false`.

---

## 🧠 Algorithm

### 1️⃣ Initialize Variables

```
flag = true
startIndex = -1
```

* `startIndex` → indicates whether we are currently inside a segment of `1`s
* `flag` → becomes `false` when the first segment ends

---

### 2️⃣ Traverse the String

Loop through every character in the string.

```
for each character in s
```

---

### 3️⃣ Detect Start of Ones Segment

If the character is `1`:

```
startIndex = current index
```

This means we are inside a **segment of ones**.

---

### 4️⃣ Detect End of Ones Segment

If we encounter `0` **after seeing `1`**:

```
flag = false
startIndex = -1
```

This means the **segment of ones has ended**.

---

### 5️⃣ Check for Another Segment

If `flag` is already `false` and we encounter `1` again:

```
return false
```

This means another **separate segment of ones has started**.

---

### 6️⃣ Return Result

If the loop finishes without detecting another segment:

```
return true
```

---

## 📊 Example

### Example 1

Input

```
s = "1001"
```

Segments of ones

```
1   00   1
```

Two segments → Output

```
false
```

---

### Example 2

Input

```
s = "110"
```

Segments of ones

```
11
```

Only one segment → Output

```
true
```

---

## ⏱ Time Complexity

```
O(n)
```

* Traverse the string once.

---

## 💾 Space Complexity

```
O(1)
```

* Only a few variables are used.

---

## 🚀 Key Concepts

* String traversal
* Detecting contiguous segments
* Simple state tracking

---

✔ Efficient solution that checks if a binary string contains **only one continuous segment of ones**.
