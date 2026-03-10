# 🌡️ 739. Daily Temperatures

## 📌 Problem

You are given an array `temperatures` where `temperatures[i]` represents the temperature on the **ith day**.

For each day, determine **how many days you must wait** until a **warmer temperature** occurs.

If there is **no future day with a warmer temperature**, return `0` for that day.

---

## 🧠 Approach – Monotonic Stack

To efficiently find the **next warmer day**, we use a **monotonic decreasing stack**.

The stack will store **indices of days**, not temperatures.

### Why store indices?

Because we need to calculate the **difference in days**.

---

## 🔹 Key Idea

We iterate **from right to left** (future → past).

For each day:

1️⃣ Remove all days from the stack whose temperature is **less than or equal** to the current temperature.

```id="p8d8b0"
temperatures[i] >= temperatures[stack.peek()]
```

These days cannot be the next warmer day.

2️⃣ After popping:

* If the stack is **not empty**,
  the top element represents the **next warmer day**.

```id="2c0a1o"
answer[i] = stack.peek() - i
```

3️⃣ If the stack is **empty**, there is **no warmer day**, so answer is `0`.

4️⃣ Push the current **index** into the stack.

---

## 💻 Java Implementation

```java id="k7f8y3"
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

        Stack<Integer> stack = new Stack<>();
        int n = temperatures.length;
        int[] answer = new int[n];

        for(int i = n - 1; i >= 0; i--){

            while(!stack.isEmpty() && temperatures[i] >= temperatures[stack.peek()]){
                stack.pop();
            }

            if(!stack.isEmpty()){
                answer[i] = stack.peek() - i;
            } 
            else{
                answer[i] = 0;
            }

            stack.push(i);
        }

        return answer;
    }
}
```

---

## ⏱️ Complexity Analysis

**Time Complexity**

```id="g6z9e4"
O(n)
```

Each element is pushed and popped **at most once**.

**Space Complexity**

```id="5k8t0x"
O(n)
```

Extra space used for the **stack**.

---

## 📊 Example

### Input

```id="0f6b0u"
temperatures = [73,74,75,71,69,72,76,73]
```

### Output

```id="y2c0xo"
[1,1,4,2,1,1,0,0]
```

### Explanation

* Day 0 → warmer day after **1 day**
* Day 2 → warmer day after **4 days**
* Day 6 → **no warmer temperature** ahead → `0`

---

## ✅ Key Points

* Uses **Monotonic Stack pattern**
* Traverse **from right to left**
* Stack stores **indices of temperatures**
* Helps find **Next Greater Element** efficiently
* Each element processed only once
