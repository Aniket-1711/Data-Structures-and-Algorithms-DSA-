# 🔁 Rearrange Array Elements by Sign

## 📌 Problem

Given an integer array `nums` of **even length** containing **equal number of positive and negative integers**, rearrange the array such that:

1. Every adjacent pair has **opposite signs**.
2. The **relative order** of positive and negative numbers is preserved.
3. The resulting array **starts with a positive number**.

Return the rearranged array.

---

## 💡 Approach Used

The idea is to **separate positives and negatives while maintaining their order**, and place them **alternatively** in the result array.

Two pointers are used:

```
pos → finds next positive number
neg → finds next negative number
```

Another index is used to **fill the result array**.

---

## 🧠 Algorithm

### 1️⃣ Create Result Array

```java
int ar[] = new int[nums.length];
```

This array stores the rearranged elements.

---

### 2️⃣ Initialize Pointers

```
pos = 0  → scans for positive numbers
neg = 0  → scans for negative numbers
index = 0 → position in result array
```

---

### 3️⃣ Find Next Positive

Move the `pos` pointer until a positive number is found.

```
while(nums[pos] < 0)
    pos++
```

---

### 4️⃣ Find Next Negative

Move the `neg` pointer until a negative number is found.

```
while(nums[neg] > 0)
    neg++
```

---

### 5️⃣ Insert Elements Alternately

Add elements to the result array in alternating order.

```
positive → negative → positive → negative
```

```
ar[index++] = nums[pos]
ar[index++] = nums[neg]
```

---

### 6️⃣ Continue Until Array Ends

Repeat until all elements are processed.

---

## 📊 Example

### Input

```
nums = [3,1,-2,-5,2,-4]
```

Positive numbers:

```
[3,1,2]
```

Negative numbers:

```
[-2,-5,-4]
```

### Rearranged Output

```
[3,-2,1,-5,2,-4]
```

---

## ⏱ Time Complexity

```
O(N)
```

Each element is visited once.

---

## 💾 Space Complexity

```
O(N)
```

An additional array is used to store the result.

---

## 🚀 Key Concepts

* Two pointer technique
* Maintaining relative order
* Alternating placement
* Array traversal

---

✔ The algorithm rearranges the array while preserving the **original order of positive and negative numbers**.
