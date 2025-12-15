# ➕ Add Binary

## 📌 Problem Statement

You are given **two binary strings** `a` and `b`.
Your task is to **add them** and return the result as a **binary string**.

---

## 🧠 Idea (Simple)

Binary addition works just like normal addition, but:

* `0 + 0 = 0`
* `0 + 1 = 1`
* `1 + 1 = 0` with **carry = 1**

We:

1. Start from the **last index** of both strings
2. Add digits one by one
3. Keep track of the **carry**
4. Store result in reverse, then reverse it back

---

## ⚙️ Algorithm Steps

* Initialize two pointers at the end of both strings
* Initialize `carry = 0`
* While any pointer is valid or carry exists:

  * Add digits + carry
  * Store `sum % 2` in result
  * Update carry as `sum / 2`
* Reverse the final result

---

## 💻 Java Code

```java
class Solution {
    public String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder();
        int p1 = a.length() - 1;
        int p2 = b.length() - 1;
        int carry = 0;

        while (p1 >= 0 || p2 >= 0 || carry == 1) {
            int sum = carry;

            if (p1 >= 0) {
                sum += a.charAt(p1) - '0';
                p1--;
            }
            if (p2 >= 0) {
                sum += b.charAt(p2) - '0';
                p2--;
            }

            carry = sum / 2;
            res.append(sum % 2);
        }

        return res.reverse().toString();
    }
}
```

---

## 🧪 Example Walkthrough

**Input**

```
a = "11"
b = "1"
```

**Steps**

```
1 + 1 = 0 (carry 1)
1 + carry = 0 (carry 1)
carry = 1
```

**Output**

```
"100"
```

---

## ⏱️ Complexity

* **Time:** O(n)
* **Space:** O(n)

---

## ✅ Key Points

* No conversion to integers (handles large input)
* Uses two pointers
* Clean and efficient


