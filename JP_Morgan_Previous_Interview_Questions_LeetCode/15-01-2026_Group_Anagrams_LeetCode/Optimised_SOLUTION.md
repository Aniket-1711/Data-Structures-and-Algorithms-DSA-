# 🧩 Group Anagrams (LeetCode 49)

## 📌 Problem Statement

Given an array of strings, group all the anagrams together.

Anagrams are strings that contain the same characters with the same frequency, only the order is different.

You can return the groups in any order.

---

## 🧠 Examples

Input:

```
["eat","tea","tan","ate","nat","bat"]
```

Output:

```
[["bat"], ["nat","tan"], ["ate","eat","tea"]]
```

Input:

```
[""]
```

Output:

```
[[""]]
```

Input:

```
["a"]
```

Output:

```
[["a"]]
```

---

## ⚙️ Approach

1. Create a `HashMap` where:

   * Key → Sorted version of the string
   * Value → List of original strings that match this sorted form

2. For each word:

   * Convert to character array
   * Sort it
   * Convert back to string (this becomes the key)
   * Add the original word to the list for that key

3. Finally, return all the values of the map as a list of lists.

---

## 💻 Java Code

```java
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        
        for(String s : strs) {   
            char ch[] = s.toCharArray();
            Arrays.sort(ch);
            String str = new String(ch);

            if(!map.containsKey(str)) {
                map.put(str, new ArrayList<>());
            }
            map.get(str).add(s);
        }

        return new ArrayList<>(map.values());
    }
}
```

---

## ⏱️ Time & Space Complexity

* **Time:** O(N * K log K)

  * N = number of strings
  * K = length of each string (sorting each string)

* **Space:** O(N * K)

  * For storing all strings in the HashMap

---

## ✅ Conclusion

By sorting each word and using it as a key, all anagrams are grouped easily and efficiently. 🚀
