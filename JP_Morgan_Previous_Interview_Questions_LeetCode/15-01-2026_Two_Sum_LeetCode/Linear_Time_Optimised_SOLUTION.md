# 🎯 Two Sum (LeetCode 1)

## 📌 Problem Statement

Given an array of integers `nums` and an integer `target`, find the indices of two numbers such that their sum is equal to `target`.

You can assume:

* Exactly one valid answer exists.
* You cannot use the same element twice.
* Order of output does not matter.

---

## 🧠 Examples

Input:

```
nums = [2,7,11,15], target = 9
```

Output:

```
[0,1]
```

Input:

```
nums = [3,2,4], target = 6
```

Output:

```
[1,2]
```

Input:

```
nums = [3,3], target = 6
```

Output:

```
[0,1]
```

---

## ⚙️ Approach (Using HashMap)

1. Create a HashMap to store numbers and their indices.
2. Traverse the array:

   * For each number `nums[i]`, calculate `target - nums[i]`.
   * If this value exists in the map, we found the pair.
   * Return the stored index and current index.
3. If not found, store the current number with its index in the map.

---

## 💻 Java Code

```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }
}
```

---

## ⏱️ Time & Space Complexity

* **Time:** O(n)
* **Space:** O(n)

---

## ✅ Conclusion

Using HashMap helps to find the required pair in one pass efficiently. 🚀
