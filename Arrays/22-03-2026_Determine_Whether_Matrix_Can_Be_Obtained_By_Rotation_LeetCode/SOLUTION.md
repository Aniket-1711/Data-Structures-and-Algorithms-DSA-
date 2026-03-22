# 🔄 Determine Whether Matrix Can Be Obtained By Rotation

## 📌 Problem

Given two **n x n binary matrices** `mat` and `target`, check if `mat` can be rotated (in 90° steps) to match `target`.

---

## 💡 Approach

We simulate all possible rotations:

* 0° (no rotation)
* 90°
* 180°
* 270°

### 🔁 How to Rotate Matrix (90° Clockwise)

We use 2 steps:

1. **Transpose the matrix**
2. **Reverse each row**

---

## 🧠 Steps

1. Check if `mat == target` (0° case)
2. Repeat 4 times:

   * Transpose matrix
   * Reverse rows
   * Compare with target
3. If any match → return `true`
4. Else → return `false`

---

## 💻 Java Code

```java
class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {

        if(same(mat, target)) return true;

        for(int i = 0; i < 4; i++){
            transpose(mat);
            reverse(mat);

            if(same(mat, target)) return true;
        }

        return false;
    }

    public void transpose(int[][] mat){
        for(int i = 0; i < mat.length; i++){
            for(int j = i + 1; j < mat[0].length; j++){
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }
    }

    public void reverse(int[][] mat){
        for(int i = 0; i < mat.length; i++){
            int left = 0, right = mat[0].length - 1;
            while(left < right){
                int temp = mat[i][left];
                mat[i][left] = mat[i][right];
                mat[i][right] = temp;
                left++;
                right--;
            }
        }
    }

    public boolean same(int[][] mat, int[][] target){
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){
                if(mat[i][j] != target[i][j]) return false;
            }
        }
        return true;
    }
}
```

---

## ⏱️ Complexity

* **Time Complexity:** `O(4 * n^2) ≈ O(n^2)`
* **Space Complexity:** `O(1)` (in-place operations)

---

## 🚀 Key Takeaways

* Rotation can be done efficiently using **transpose + reverse**
* Always check the **original matrix first (0° case)**
* Works in-place → no extra space needed

---

## 🧩 Example

```
mat = [[0,1],
       [1,0]]

After 90° rotation → [[1,0],
                       [0,1]]

Matches target ✅
```

---

