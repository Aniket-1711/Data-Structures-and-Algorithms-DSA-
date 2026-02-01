# 🚗 Design Ride Sharing System

## 📌 Problem Summary

You need to design a **Ride Sharing System** that matches riders and drivers **in the order they arrive**.

The system supports:

* Adding riders
* Adding drivers
* Matching the earliest driver with the earliest rider
* Cancelling a rider before they are matched

---

## 🧠 Key Idea

This is a **queue-based problem**.

* Riders wait in a queue
* Drivers wait in a queue
* Matching always happens using **FIFO (First In First Out)** order

So, the best data structure here is:

👉 **Deque / Queue**

---

## 🔧 Data Structures Used

* `Deque<Integer> rider` → stores waiting riders
* `Deque<Integer> driver` → stores available drivers

Both are implemented using **ArrayDeque** for efficiency.

---

## ⚙️ Operations Explained

### ➕ `addRider(int riderId)`

* Adds the rider to the end of the rider queue

### ➕ `addDriver(int driverId)`

* Adds the driver to the end of the driver queue

### 🔄 `matchDriverWithRider()`

* If **either queue is empty**, return `[-1, -1]`
* Otherwise:

  * Remove the first driver
  * Remove the first rider
  * Return `[driverId, riderId]`

### ❌ `cancelRider(int riderId)`

* If the rider is **still waiting**, remove them from the rider queue
* If the rider is already matched, do nothing

---

## 🧪 Example

### Input

```
addRider(3)
addDriver(2)
addRider(1)
matchDriverWithRider()
```

### Output

```
[2, 3]
```

Explanation:

* Rider queue: [3, 1]
* Driver queue: [2]
* Earliest driver `2` matched with earliest rider `3`

---

## 🧾 Java Implementation

```java
class RideSharingSystem {

    Deque<Integer> driver;
    Deque<Integer> rider;
    
    public RideSharingSystem() {
        driver = new ArrayDeque<>();
        rider = new ArrayDeque<>();
    }
    
    public void addRider(int riderId) {
        rider.add(riderId);
    }
    
    public void addDriver(int driverId) {
        driver.add(driverId);
    }
    
    public int[] matchDriverWithRider() {
        if (driver.isEmpty() || rider.isEmpty())
            return new int[]{-1, -1};
        
        int d = driver.poll();
        int r = rider.poll();
        return new int[]{d, r};
    }
    
    public void cancelRider(int riderId) {
        if (rider.contains(riderId))
            rider.remove(riderId);
    }
}
```

---

## ⏱️ Time & Space Complexity

| Operation            | Complexity |
| -------------------- | ---------- |
| addRider             | O(1)       |
| addDriver            | O(1)       |
| matchDriverWithRider | O(1)       |
| cancelRider          | O(n)       |

---

## ✅ Final Notes

* Simple and clean queue-based solution
* Preserves arrival order correctly
* Works well within given constraints

