# 🔍 Find Unique Binary String

## 📘 Problem

You are given an array `nums` containing **n unique binary strings**, each of length `n`.

Your task is to **return a binary string of length `n` that does NOT exist in the array**.

If multiple answers are possible, you can return **any one of them**.

---

## 💡 Key Idea (Diagonal Trick)

We use a clever idea called **Diagonalization**.

### Steps

1. Look at the **i-th character of the i-th string**.
2. Flip the bit:

   * If it is `'0'`, change it to `'1'`
   * If it is `'1'`, change it to `'0'`
3. Append the flipped bit to the answer string.

This guarantees the new string will **differ from every string in the array at least at one position**, so it cannot exist in the list.

---

## ⚙️ Algorithm

1. Create an empty string builder.
2. Loop from `0` to `n-1`.
3. For each index `i`:

   * Check `nums[i].charAt(i)`
   * Flip the bit and append it.
4. Return the constructed string.

---

## 💻 Java Implementation

```java
class Solution {
    public String findDifferentBinaryString(String[] nums) {
        StringBuilder ans = new StringBuilder();
        int n = nums.length;

        for(int i = 0; i < n; i++){
            if(nums[i].charAt(i) == '0'){
                ans.append('1');
            } else {
                ans.append('0');
            }
        }

        return ans.toString();
    }
}
```

---

## 🧠 Example

### Input

```
nums = ["01","10"]
```

### Process

| Index | nums[i][i] | Flipped |
| ----- | ---------- | ------- |
| 0     | 0          | 1       |
| 1     | 0          | 1       |

### Output

```
"11"
```

This string does **not exist in the input array**, so it is valid.

---

## ⏱ Complexity

**Time Complexity:** `O(n)`
We traverse the array once.

**Space Complexity:** `O(n)`
To store the result string.

---

## 🚀 Why This Works

The generated string differs from:

* `nums[0]` at index `0`
* `nums[1]` at index `1`
* `nums[2]` at index `2`
* ...

Therefore, it **cannot match any string in the array**, guaranteeing a unique result.
