# 💎 Jewels and Stones

## 📝 Problem Statement

You're given strings `jewels` representing the types of stones that are jewels, and `stones` representing the stones you have. Each character in `stones` is a type of stone you have. You want to know how many of the stones you have are also jewels.

> Letters are case sensitive, so `"a"` is considered a different type of stone from `"A"`.

## 📚 Examples

**Example 1:**

```
Input: jewels = "aA", stones = "aAAbbbb"
Output: 3
```

**Example 2:**

```
Input: jewels = "z", stones = "ZZ"
Output: 0
```

## 📏 Constraints

* 1 <= jewels.length, stones.length <= 50
* jewels and stones consist of only English letters.
* All the characters of jewels are unique.

## 💻 Java Solution

```java
class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        int count = 0;
        for(int i = 0; i < jewels.length(); i++) {
            for(int j = 0; j < stones.length(); j++) {
                if(jewels.charAt(i) == stones.charAt(j)) {
                    count++;
                }
            }
        }
        return count;
    }
}
```

## ⚡ Explanation

1. Initialize a counter `count` to 0.
2. Loop through each character in `jewels`.
3. For each jewel, loop through each character in `stones`.
4. If the jewel matches the stone, increment `count`.
5. Return the total `count` which represents the number of stones that are jewels.
