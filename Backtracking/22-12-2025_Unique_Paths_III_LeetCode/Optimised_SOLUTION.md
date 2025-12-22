# 🧭 Unique Paths III

## 🧠 Problem Overview

You are given a grid where:

* `1` → starting cell (only one)
* `2` → ending cell (only one)
* `0` → empty cells (must be visited)
* `-1` → obstacles (cannot be visited)

The task is to count **all possible 4-directional paths** from start to end such that:

* Every **non-obstacle cell** is visited **exactly once**

---

## 💡 Approach Used

This solution uses **Backtracking + DFS**.

### Key Ideas:

* Count all empty cells (`0`) first
* Start DFS from the starting cell (`1`)
* Move in **4 directions**: up, down, left, right
* Mark cells as visited by temporarily setting them to `-1`
* Backtrack by restoring the cell value
* When reaching the ending cell (`2`), check if **all empty cells + start** are visited

---

## 🔄 Algorithm Steps

1. Scan the grid to:

   * Find start position
   * Count empty cells
2. Run DFS from the start cell
3. For each move:

   * Check bounds and obstacles
   * Mark cell as visited
   * Explore all 4 directions
   * Backtrack
4. If end cell is reached and all cells are covered, increment path count

---

## 🧪 Example

**Input**

```
[[1,0,0,0],
 [0,0,0,0],
 [0,0,2,-1]]
```

**Output**

```
2
```

---

## 🧑‍💻 Java Solution

```java
class Solution {
    int empcount = 0;
    int paths = 0;

    public int uniquePathsIII(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int si = 0, sj = 0;

        empcount = 0;
        paths = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    si = i;
                    sj = j;
                } else if (grid[i][j] == 0) {
                    empcount++;
                }
            }
        }

        dfs(grid, m, n, si, sj, 0);
        return paths;
    }

    private void dfs(int[][] grid, int m, int n, int i, int j, int count) {
        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == -1) {
            return;
        }

        if (grid[i][j] == 2) {
            if (count == empcount + 1) paths++;
            return;
        }

        int temp = grid[i][j];
        grid[i][j] = -1;

        dfs(grid, m, n, i, j - 1, count + 1);
        dfs(grid, m, n, i, j + 1, count + 1);
        dfs(grid, m, n, i - 1, j, count + 1);
        dfs(grid, m, n, i + 1, j, count + 1);

        grid[i][j] = temp;
    }
}
```

---

## ⏱️ Complexity Analysis

* **Time Complexity:** `O(4^(m*n))` (all possible paths explored)
* **Space Complexity:** `O(m*n)` (recursion stack)

---

## ✅ Key Takeaways

* Classic **DFS + Backtracking** problem
* Small grid size makes exponential solution feasible
* Careful counting of visited cells is crucial

---

