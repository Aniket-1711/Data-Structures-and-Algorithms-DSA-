# 🧩 Intersection of Two Arrays II 

This **README.md** explains the problem *"Intersection of Two Arrays II"* in a simple, clean, and friendly way with emojis and easy understanding.

---

## 📘 Problem Summary

You are given two integer arrays **nums1** and **nums2**.
Your task is to find the **common elements** between them.

But there is a twist:

* Each element should appear **as many times as it appears in both arrays**.
* The order of the result **doesn't matter**.

---

## ✨ Example

### Example 1

```
nums1 = [1,2,2,1]
nums2 = [2,2]
Output: [2,2]
```

### Example 2

```
nums1 = [4,9,5]
nums2 = [9,4,9,8,4]
Output: [4,9]
```

Either `[4,9]` or `[9,4]` is valid.

---

## 🧠 How the Logic Works (Simple Explanation)

We use a **HashMap** to store the **frequency** of each number in `nums1`.

1. 🔢 Loop through `nums1` and count how many times each number appears.
2. 🔍 Loop through `nums2` and check:

   * If a number exists in the map → it is a **common element**.
   * Add it to the result.
   * Decrease its frequency in the map.
   * If frequency becomes 0 → remove it from the map.
3. Convert the result list into an array.

That's it! 🎉

---

## 🧾 Java Code Used

```java
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for (int i : nums1) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }

        for (int i : nums2) {
            if (map.containsKey(i)) {
                result.add(i);
                map.put(i, map.get(i) - 1);

                if (map.get(i) == 0) {
                    map.remove(i);
                }
            }
        }

        int[] ar = new int[result.size()];

        for (int i = 0; i < result.size(); i++) {
            ar[i] = result.get(i);
        }

        return ar;
    }
}
```

---

## ⚙️ Time & Space Complexity

⏳ **Time Complexity:** `O(n + m)`
📦 **Space Complexity:** `O(min(n, m))`

We store only frequencies of one array in the map.

---

## 📝 Key Points to Remember

* ✔️ Use a HashMap to track counts.
* ✔️ Decrease frequency when matching.
* ✔️ Remove the number when count becomes zero.
* ✔️ Works efficiently for all array sizes.

---

## 🎯 Final Output Format

The result is always **an array of integers** representing the intersection.

---

