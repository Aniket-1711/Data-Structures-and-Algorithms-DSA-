# 📊 Largest Submatrix With Rearrangements

## 🧩 Problem

Given a binary matrix `m x n`, columns can be **rearranged in any order**. After rearranging columns optimally, find the **largest submatrix consisting only of 1s** and return its **area**.

Constraints:

* `1 <= m * n <= 10^5`
* Matrix contains only `0` and `1`

---

# 💡 Key Idea

Instead of thinking about rearranging columns directly, convert each column into a **height of consecutive 1s** (like a histogram).

Then for every row:

1. Treat the row as histogram heights
2. Sort the heights
3. Calculate the largest possible rectangle

Sorting works because **columns can be rearranged freely**.

---

# 🔧 Step‑by‑Step Approach

## 1️⃣ Build Heights

Convert each cell to represent the **number of consecutive 1s above it**.

Example:

Original Matrix

```
1 0 1
1 1 1
1 0 1
```

Height Matrix

```
1 0 1
2 1 2
3 0 3
```

If the current cell is `1`, add the value from the cell above.

---

## 2️⃣ Rearrange Columns

For every row:

* Copy the row
* Sort it in **ascending order**

Example row:

```
2 1 2
```

Sorted:

```
1 2 2
```

---

## 3️⃣ Calculate Possible Areas

For each column after sorting:

```
area = height * width
```

Where:

* `height = row[j]`
* `width = n - j`

Example:

```
1 2 2
```

Possible rectangles:

```
1 * 3 = 3
2 * 2 = 4
2 * 1 = 2
```

Maximum = **4**

---

# 🧠 Algorithm

1. Traverse matrix to build **height values**.
2. For each row:

   * Clone the row
   * Sort it
   * Compute area using `height * width`
3. Track the maximum area.

---

# 💻 Java Implementation

```java
class Solution {
    public int largestSubmatrix(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;
        int ans = 0;

        // Build heights
        for(int i = 1; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == 1){
                    matrix[i][j] += matrix[i-1][j];
                }
            }
        }

        for(int i = 0; i < m; i++){

            int[] row = matrix[i].clone();
            Arrays.sort(row);

            for(int j = 0; j < n; j++){
                int height = row[j];
                int width = n - j;
                ans = Math.max(ans, height * width);
            }
        }

        return ans;
    }
}
```

---

# ⏱ Time Complexity

```
Building heights  → O(m * n)
Sorting each row  → O(m * n log n)

Total             → O(m * n log n)
```

---

# 📚 Pattern Used

This problem combines two important ideas:

* **Histogram heights**
* **Greedy column rearrangement using sorting**

Similar problems:

* Largest Rectangle in Histogram
* Maximal Rectangle

---

# ✅ Key Takeaway

Instead of rearranging columns explicitly:

1️⃣ Convert the matrix into **heights of consecutive 1s**
2️⃣ **Sort each row** to simulate optimal column rearrangement
3️⃣ Compute rectangle areas using `height × width`

This efficiently finds the **largest submatrix of 1s** after column rearrangement.
