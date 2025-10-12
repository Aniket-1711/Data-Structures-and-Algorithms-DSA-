# 🧩 Equal Score Substrings
---

## 📝 Problem Statement

You are given a string `s` consisting of lowercase English letters.

The **score** of a string is the sum of the positions of its characters in the English alphabet, where:  
`'a' = 1`, `'b' = 2`, `'c' = 3`, …, `'z' = 26`.

You need to determine whether there exists an index `i` such that the string can be split into two **non-empty substrings**:
- Left substring → `s[0..i]`
- Right substring → `s[(i + 1)..(n - 1)]`

Both substrings must have **equal scores**.

Return:
- `true` → if such a split exists  
- `false` → otherwise  

---

## 📥 Input Format
- A single string `s` consisting of lowercase English letters.

---

## 📤 Output Format
- Return `true` if there exists an index `i` such that both substrings have equal scores.  
- Otherwise, return `false`.

---

## ⚙️ Constraints
- `2 <= s.length <= 100`
- `s` consists only of lowercase English letters.

---

## 🔍 Example 1

**Input:**
```text
s = "adcb"
```
**Output:**
```
true
```

**Explanation:**

- Split at index i = 1:

- Left substring = "ad" → score = 1 + 4 = 5

- Right substring = "cb" → score = 3 + 2 = 5

✅ Both substrings have equal scores → output is true.

## 🔍 Example 2

**Input:**
s = "bace"
**Output**
false

**Explanation:**

No split produces equal scores, hence output is false

## 💡 Approach

- Calculate the total score of the entire string.

- Traverse each character from left to right:

- Maintain a running leftSum of scores.

- Compute rightSum = total - leftSum.

    - If leftSum == rightSum at any point, return true.

    - If loop completes with no match, return false.

**This ensures an O(n) time complexity with O(1) space.**

## 🧠 Intuition

We are finding a balance point in the string — like a seesaw — where the sum of alphabetic values to the left equals the sum to the right.
## 🧾 Code Implementation
```java
class Solution {
    public boolean scoreBalance(String s) {
        int n = s.length();
        int total = 0;

        // Step 1: Calculate total score of the string
        for (int i = 0; i < n; i++) {
            total += s.charAt(i) - 'a' + 1;
        }

        int leftSum = 0;

        // Step 2: Find a split point where leftSum == rightSum
        for (int i = 0; i < n; i++) {
            leftSum += s.charAt(i) - 'a' + 1;
            int rightSum = total - leftSum;

            if (leftSum == rightSum) {
                return true;
            }
        }

        // Step 3: If no valid split found
        return false;
    }
}
```
## 🧮 Complexity Analysis
| Type     | Complexity |
| -------- | ---------- |
| ⏱️ Time  | O(n)       |
| 🧠 Space | O(1)       |

## 🧩 Example Dry Run
**Input:**
s = "adcb"
| i | char | value | leftSum | rightSum | Match |
| - | ---- | ----- | ------- | -------- | ----- |
| 0 | a    | 1     | 1       | 9        | ❌     |
| 1 | d    | 4     | 5       | 5        | ✅     |

✅ Equal scores found at i = 1, return true.

**🏁 Final Output:**
true
