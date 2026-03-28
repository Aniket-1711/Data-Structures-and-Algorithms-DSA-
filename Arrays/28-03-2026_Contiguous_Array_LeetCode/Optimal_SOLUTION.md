# 📊 525. Contiguous Array

## 🧠 Problem Summary

Given a binary array `nums` (only 0s and 1s), find the **maximum length of a contiguous subarray** that contains an **equal number of 0s and 1s**.

---

## 💡 Key Idea

Convert the problem into a **prefix sum problem**:

* Treat `0` as `-1`
* Treat `1` as `+1`

👉 Now, if the prefix sum repeats at two indices, it means:

* The subarray between them has equal 0s and 1s

---

## ⚙️ Approach

1. Use a **HashMap** to store:

   * `prefix_sum → first occurrence index`

2. Initialize:

   * `map.put(0, -1)` (important for edge case)

3. Traverse the array:

   * If `0` → add `-1`
   * If `1` → add `+1`

4. If prefix sum already exists:

   * Calculate length = `current_index - previous_index`
   * Update max length

5. Else:

   * Store prefix sum in map

---

## 🧾 Code (Java)

```java
class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map=new HashMap<>();
        map.put(0,-1);
        int presum=0;
        int maxlen=0;

        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                presum+=-1;
            }
            else{
                presum+=1;
            }

            if(map.containsKey(presum)){
                int len=i-map.get(presum);
                maxlen=Math.max(maxlen, len);
            }

            else{
                map.put(presum, i);
            }
        }
        return maxlen;
    }
}
```

---

## ⏱️ Complexity

* **Time:** O(n)
* **Space:** O(n)

---

## 🔥 Example

Input:

```
[0,1,0]
```

Converted:

```
[-1, +1, -1]
```

Prefix Sum:

```
[-1, 0, -1]
```

👉 Longest subarray with same prefix sum = length **2**

---

## 🚀 Key Takeaways

* Convert binary problems into prefix sum problems
* Use hashmap to track first occurrence
* Repeated prefix sum = valid subarray

---

