# 🧾 Coupon Code Validator

## 📌 Problem Overview

You are given details of **n coupons** using three arrays:

* `code[]` → coupon codes
* `businessLine[]` → category of coupon
* `isActive[]` → whether coupon is active

Your task is to **filter valid coupons** and return their codes in a **specific sorted order**.

---

## ✅ Coupon Validation Rules

A coupon is **valid** only if **all** conditions below are satisfied:

* 🔤 `code` is **not empty**
* 🔢 `code` contains **only**:

  * alphabets (`a-z`, `A-Z`)
  * digits (`0-9`)
  * underscore (`_`)
* 🏷️ `businessLine` must be **one of**:

  * `electronics`
  * `grocery`
  * `pharmacy`
  * `restaurant`
* 🟢 `isActive` must be `true`

---

## 🔃 Sorting Rules

Valid coupons must be sorted:

1. **By businessLine order**:

   ```text
   electronics → grocery → pharmacy → restaurant
   ```
2. **By code** (lexicographical order) within the same category

---

## 🧠 Approach (Simple Steps)

1. Create a **priority order map** for business lines
2. Loop through all coupons
3. Check validation rules one by one
4. Store valid coupons as `(businessLine, code)` pairs
5. Sort using:

   * business line priority
   * code string comparison
6. Extract only the sorted coupon codes

---

## 💻 Java Solution

```java
class Solution {
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        Map<String, Integer> businessOrderMap = new HashMap<>();
        businessOrderMap.put("electronics", 0);
        businessOrderMap.put("grocery", 1);
        businessOrderMap.put("pharmacy", 2);
        businessOrderMap.put("restaurant", 3);

        List<String[]> validCouponList = new ArrayList<>();

        for (int i = 0; i < code.length; i++) {
            if (code[i] == null || code[i].isEmpty()) continue;
            if (!code[i].matches("[a-zA-Z0-9_]+")) continue;
            if (!businessOrderMap.containsKey(businessLine[i])) continue;
            if (!isActive[i]) continue;

            validCouponList.add(new String[]{businessLine[i], code[i]});
        }

        validCouponList.sort((a, b) -> {
            int cmp = Integer.compare(businessOrderMap.get(a[0]), businessOrderMap.get(b[0]));
            return cmp != 0 ? cmp : a[1].compareTo(b[1]);
        });

        List<String> result = new ArrayList<>();
        for (String[] c : validCouponList) {
            result.add(c[1]);
        }
        return result;
    }
}
```

---

## ⏱️ Complexity Analysis

* **Time Complexity:** `O(n log n)` (due to sorting)
* **Space Complexity:** `O(n)` (to store valid coupons)

---

## 🧪 Example

**Input:**

```text
code = ["SAVE20", "", "PHARMA5", "SAVE@20"]
businessLine = ["restaurant", "grocery", "pharmacy", "restaurant"]
isActive = [true, true, true, true]
```

**Output:**

```text
["PHARMA5", "SAVE20"]
```

---

## 🎯 Key Takeaways

* Regex is useful for strict string validation
* Custom sorting is easy using a priority map
* Clean filtering + sorting makes logic readable

