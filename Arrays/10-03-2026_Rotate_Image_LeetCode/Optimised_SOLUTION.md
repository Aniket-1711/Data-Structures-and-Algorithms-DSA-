# 🔄 48. Rotate Image

## 📌 Problem

Given an **n × n 2D matrix** representing an image, rotate the matrix by **90 degrees clockwise**.

⚠️ The rotation must be done **in-place**, meaning we cannot create another matrix.

---

## 🧠 Approach

To rotate the matrix **90° clockwise**, we perform **two steps**:

1️⃣ **Transpose the Matrix**
2️⃣ **Reverse each row**

---

## 🔹 Step 1: Transpose the Matrix

Transpose means converting **rows into columns**.

We swap:

```id="t7a9m2"
matrix[i][j] ↔ matrix[j][i]
```

Example:

Before transpose

```id="yr9k7x"
1 2 3
4 5 6
7 8 9
```

After transpose

```id="y7tmn1"
1 4 7
2 5 8
3 6 9
```

---

## 🔹 Step 2: Reverse Each Row

After transpose, reverse every row using **two pointers**.

Example:

Before reversing rows

```id="d3p7rw"
1 4 7
2 5 8
3 6 9
```

After reversing rows

```id="ex6v6p"
7 4 1
8 5 2
9 6 3
```

This gives the **90° clockwise rotation**.

---

## 💻 Java Implementation

```java id="g42q0s"
class Solution {
    public void rotate(int[][] matrix) {

        // Step 1: Transpose the matrix
        for(int i = 0; i < matrix.length; i++){
            for(int j = i; j < matrix[0].length; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Step 2: Reverse each row
        for(int i = 0; i < matrix.length; i++){
            int left = 0;
            int right = matrix[0].length - 1;

            while(left < right){
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;

                left++;
                right--;
            }
        }
    }
}
```

---

## ⏱️ Complexity Analysis

**Time Complexity**

```id="0zv2um"
O(n²)
```

Because we traverse the entire matrix.

**Space Complexity**

```id="4y7k5v"
O(1)
```

Rotation is done **in-place without extra space**.

---

## 📊 Example

### Input

```id="b3i9p2"
1 2 3
4 5 6
7 8 9
```

### Output

```id="n3r0ys"
7 4 1
8 5 2
9 6 3
```

---

## ✅ Key Points

* Use **transpose + reverse rows** to rotate matrix.
* Works only for **square matrices (n × n)**.
* Efficient **in-place solution**.
* Common matrix manipulation technique used in many problems.
