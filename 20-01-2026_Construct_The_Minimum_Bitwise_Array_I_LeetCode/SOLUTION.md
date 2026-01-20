# 🧩 Construct the Minimum Bitwise Array I

## 📌 Problem Statement

You are given a list of prime numbers `nums`.

For each number `nums[i]`, find the smallest integer `ans[i]` such that:

```
ans[i] | (ans[i] + 1) = nums[i]
```

If no such number exists, set `ans[i] = -1`.

---

## 💡 Key Idea

The bitwise OR of two consecutive numbers becomes the target prime only when their binary patterns combine to form it.

We simply:

* Try all values from `0` to `nums[i]`
* Check if `num | (num + 1) == nums[i]`
* Take the smallest valid one

---

## 🛠️ Java Solution

```java
class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        boolean flag = false;
        int a[] = new int[nums.size()];
        
        for (int i = 0; i < nums.size(); i++) {
            flag = false;
            for (int num = 0; num <= nums.get(i); num++) {
                if ((num | (num + 1)) == nums.get(i)) {
                    a[i] = num;
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                a[i] = -1;
            }
        }
        return a;
    }
}
```

---

## 🧪 Example

Input:

```
nums = [2, 3, 5, 7]
```

Output:

```
[-1, 1, 4, 3]
```

---

## 🚀 Complexity

* Time: O(n × max(nums[i]))
* Space: O(n)

---

## ✨ Notes

* Since `nums[i]` are small primes (≤ 1000), brute force is fast.
