# 🪟 Minimum Window Substring (LeetCode 76)

## 📌 Problem

Given two strings **s** and **t**, find the **smallest substring of `s`** that contains **all characters of `t` (including duplicates)**.

If no such window exists, return an empty string `""`.

### Example

```
Input:
s = "ADOBECODEBANC"
t = "ABC"

Output:
"BANC"
```

---

# 💡 Approach — Sliding Window

This problem can be solved using the **Sliding Window technique**.

Two pointers are used:

* `left` → start of the window
* `right` → end of the window

The window expands using `right` and shrinks using `left` to maintain the **minimum valid substring**.

---

# 🧠 Key Idea

1. Store the frequency of characters required from string **t**.
2. Expand the window using `right`.
3. Reduce the required count when matching characters are found.
4. When all characters are matched, try shrinking the window.
5. Track the **smallest valid window**.

---

# ⚙️ Algorithm

1. Create a frequency array `freq[128]`.
2. Store character counts of string `t`.
3. Initialize:

   * `left = 0`
   * `count = t.length()`
4. Traverse `s` using `right` pointer.
5. Decrease frequency of current character.
6. If character was required → decrease `count`.
7. When `count == 0`, all characters are present:

   * Update minimum window
   * Shrink window using `left`
8. Continue until traversal ends.

---

# 🧩 Java Implementation

```java
class Solution {
    public String minWindow(String s, String t) {

        if(s.length() < t.length()) return "";

        int[] freq = new int[128];

        for(char c : t.toCharArray()){
            freq[c]++;
        }

        int left = 0;
        int count = t.length();
        int minLen = Integer.MAX_VALUE;
        int start = 0;

        for(int right = 0; right < s.length(); right++){

            char ch = s.charAt(right);

            if(freq[ch] > 0){
                count--;
            }

            freq[ch]--;

            while(count == 0){

                if(right - left + 1 < minLen){
                    minLen = right - left + 1;
                    start = left;
                }

                char leftChar = s.charAt(left);
                freq[leftChar]++;

                if(freq[leftChar] > 0){
                    count++;
                }

                left++;
            }
        }

        if(minLen == Integer.MAX_VALUE) return "";

        return s.substring(start, start + minLen);
    }
}
```

---

# 📊 Complexity Analysis

### ⏱ Time Complexity

```
O(m + n)
```

* Each character is processed at most twice.

### 💾 Space Complexity

```
O(1)
```

* Fixed size frequency array.

---

# 🔑 Key Sliding Window Pattern

Most substring problems follow this structure:

```
expand right pointer
update frequency

while(window is valid):
    update answer
    shrink left pointer
```

---

# 🧾 Summary

✔ Uses **Sliding Window** technique
✔ Maintains character frequency
✔ Shrinks window to get minimum substring
✔ Efficient **O(m + n)** solution
