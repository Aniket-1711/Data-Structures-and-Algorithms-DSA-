# 🔁 Matrix Similarity After Cyclic Shifts

## 📌 Problem Statement

Given an `m x n` matrix `mat` and an integer `k`, perform the following operation **k times**:

* Even-indexed rows (0, 2, 4, ...) → cyclic left shift
* Odd-indexed rows (1, 3, 5, ...) → cyclic right shift

👉 Return **true** if after all operations, the matrix becomes identical to the original matrix, otherwise return **false**.

---

## 🚀 Approach (Simulation Based)

### 1️⃣ Deep Copy the Matrix

Create a new matrix `a` to perform operations without modifying the original matrix.

```java
int[][] a = new int[rows][cols];
```

---

### 2️⃣ Edge Case Optimization

If all elements in the matrix are the same → no matter how many shifts happen, matrix remains unchanged.

👉 Directly return `true`

---

### 3️⃣ Reduce Unnecessary Work

Since shifting `cols` times brings row back to original:

```java
k = k % cols;
```

---

### 4️⃣ Perform k Cyclic Shifts

Repeat `k` times:

* 🔹 Even row → Left Shift

  ```java
  temp = a[i][0];
  shift elements left
  a[i][cols-1] = temp;
  ```

* 🔹 Odd row → Right Shift

  ```java
  temp = a[i][cols-1];
  shift elements right
  a[i][0] = temp;
  ```

---

### 5️⃣ Compare with Original Matrix

After all shifts:

* If both matrices are equal → return `true`
* Else → return `false`

---

## 🧠 Key Concepts Used

* Deep copy of 2D arrays
* Cyclic shifting (left & right)
* Simulation technique
* Matrix comparison

---

## 🧪 Example

### Input

```
mat = [[1,2,3],[4,5,6],[7,8,9]], k = 4
```

### Process

* Rows 0 & 2 → shifted left
* Row 1 → shifted right
* Repeated 4 times

### Output

```
false
```

---

## ⏱️ Time Complexity

* Each shift → O(n × m)
* Repeated k times → **O(k × n × m)**

---

## 📦 Space Complexity

* Extra matrix used → **O(n × m)**

---

## ⚠️ Limitations

* Not optimal for large `k`
* Repeated shifting increases time complexity

---

## ✨ Better Optimization (Concept)

Instead of simulating shifts, we can directly calculate final positions using index math to reduce complexity to:

👉 **O(n × m)**

---

## ✅ Summary

* Simple and intuitive approach
* Works well within constraints
* Good for understanding cyclic operations
* Can be optimized further using mathematical indexing
