# 🏆Container With Most Water  

You are given an integer array `height` of length `n`. There are `n` vertical lines drawn such that the two endpoints of the `i-th` line are `(i, 0)` and `(i, height[i])`.  

Find two lines that together with the x-axis form a container, such that the container contains the most water.  

Return the maximum amount of water a container can store.  

Notice that you may not slant the container.  

---

## 📌 Example 1

**Input:**  
height = [1,8,6,2,5,4,8,3,7]
**Output:**  
49
**Explanation:**  
The above vertical lines are represented by array `[1,8,6,2,5,4,8,3,7]`.  
In this case, the max area of water (blue section) the container can contain is **49**.

---

## 📌 Example 2

**Input:**  
height = [1,1]
**Output:**  
1

---

## Constraints
- `n == height.length`  
- `2 <= n <= 10^5`  
- `0 <= height[i] <= 10^4`  

---

## 🐢 Brute Force Approach

### 💡Intuition
- Assuming 2 heights are a container, so we need to find the maximum water stored in between the container that we have chosen.  
- So we can ignore the other heights present or lying in between the main container we choose.  
- In brute force we were checking all possible containers.  

```java
class Solution {
    public int maxArea(int[] height) {
        int maxArea=0;
        for(int i=0;i<height.length;i++){
            for(int j=i+1;j<height.length;j++){
                int width=j-i;
                int he=Math.min(height[i], height[j]);
                int currArea=width*he;

                maxArea=Math.max(maxArea, currArea);
            }
        }
        return maxArea;
    }
}
```
#### ⏳ Time Complexity: O(n²)
#### 💾 Space Complexity: O(1)

## Optimized Two-Pointer Approach
### 🤔Why Two Pointers?

- Coz we are comparing 2 values at a time.

- To get the maximum water stored, we will put the pointers at the ends initially.

- The water stored will be affected by the height of the smaller tower among the 2 pointers.
### 📐Formula

Width = j - i (difference of the pointers)

Height = min(height[i], height[j])

Area = width * height
### 🎯Which Pointer to Move?

- Move the pointer pointing to the smaller height tower.

### Why?

- If we move the pointer pointing to the greater height, we can never get the max area, as the smaller tower is the one contributing to the water stored.

- Hence, we will only end up minimizing the area.

- That’s the whole point → keep updating answer with max(ans, area) while moving the smaller pointer.

## ✅ Code

```java
  class Solution {
      public int maxArea(int[] height) {
          int i=0, j=height.length-1;
          int ans=0;
          while(i<j){
              int width=j-i;
              ans=Math.max(ans, width * (Math.min(height[i], height[j])));
  
              if(height[i]<height[j]){
                  i++;
              }
              else{
                  j--;
              }
          }
          return ans;
      }
  }
```
#### ⏳ Time Complexity: O(n)
#### 💾 Space Complexity: O(1) 
## Why The Optimized Solution Works

- In brute force we were checking all containers, but in optimized we are checking them wisely or greedily.

### 🔎What are we carrying forward?

- In brute force → we checked everything.

- In optimized → we carry forward the selection of container by skipping the limiting smaller line.

- This is **greedy**, but mathematically safe:

- Width always decreases,

- So the only chance of increasing area is by finding a taller height.
