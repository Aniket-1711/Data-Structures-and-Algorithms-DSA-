# 📡 Best Reachable Tower (LeetCode 3809)

This problem finds the best tower you can reach within a given Manhattan distance.

---

## 🧠 Problem Summary

You are given:

* A list of towers: `towers[i] = [xi, yi, qi]`

  * `(xi, yi)` → position of the tower
  * `qi` → quality of the tower
* Your position: `center = [cx, cy]`
* A distance limit: `radius`

A tower is **reachable** if:

```
|xi - cx| + |yi - cy| ≤ radius
```

From all reachable towers:

* Choose the one with **maximum quality**
* If quality is same, choose **lexicographically smallest** `[x, y]`
* If none is reachable, return `[-1, -1]`

---

## ⚙️ Approach

1. Loop through all towers
2. Calculate Manhattan distance from center
3. If distance ≤ radius:

   * Compare quality
   * If equal, compare coordinates
4. Keep updating the best tower

Time Complexity: **O(N)**

---

## 💻 Java Solution

```java
class Solution {
    public int[] bestTower(int[][] towers, int[] center, int radius) {
        int bestQuality = -1;
        int x = -1, y = -1;

        for (int i = 0; i < towers.length; i++) {
            int dist = Math.abs(center[0] - towers[i][0]) + Math.abs(center[1] - towers[i][1]);

            if (dist <= radius) {
                int q = towers[i][2];

                if (q > bestQuality ||
                   (q == bestQuality && (towers[i][0] < x ||
                   (towers[i][0] == x && towers[i][1] < y)))) {
                    bestQuality = q;
                    x = towers[i][0];
                    y = towers[i][1];
                }
            }
        }

        if (bestQuality == -1) return new int[]{-1, -1};
        return new int[]{x, y};
    }
}
```

---

## 🧪 Example

Input:

```
towers = [[1,2,5],[2,1,7],[3,1,9]]
center = [1,1]
radius = 2
```

Output:

```
[3,1]
```

Because it has the highest quality (9) among all reachable towers.

---

## ✅ Key Points

* Uses Manhattan distance
* Handles tie using lexicographical order
* Works efficiently for large inputs

---

