# 🟦 Final Value of Variable After Performing Operations

---

## 🟩 Problem Overview
- Only **one variable `X`**  
- **Four operations:** `++X`, `X++`, `--X`, `X--`  
- **Initial value:** `X = 0`  
- **Goal:** Final value of `X` after performing all operations  

---

## 🟨 Operations Table

| 🔹 Operation | 📝 Effect |
|-------------|-----------|
| `++X`       | Increment X by 1 |
| `X++`       | Increment X by 1 |
| `--X`       | Decrement X by 1 |
| `X--`       | Decrement X by 1 |

---

## 🟧 Examples

### Example 1
Input: ["--X","X++","X++"]
Output: 1

📝 Steps:
1. X = 0  
2. `--X` → X = -1  
3. `X++` → X = 0  
4. `X++` → X = 1 ✅  

### Example 2
Input: ["++X","++X","X++"]
Output: 3

### Example 3

Input: ["X++","++X","--X","X--"]
Output: 0


---

## 🟪 Approach / Algorithm

1. Initialize `X = 0`  
2. Loop through operations:
   - If operation contains `"++"` → X++  
   - If operation contains `"--"` → X--  
3. Return `X`  

---

## 🟫 Java Code

```java
class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int x = 0;
        for(String op: operations){
            if(op.startsWith("--") || op.endsWith("--")) x--;
            else if(op.startsWith("++") || op.endsWith("++")) x++;
        }
        return x;
    }
}
```
