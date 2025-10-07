# 🧠 LRU Cache (Least Recently Used)

## 📘 Problem Statement

Design a data structure that follows the constraints of a **Least Recently Used (LRU) cache**.

Implement the class `LRUCache` with the following functionalities:

- **`LRUCache(int capacity)`** → Initialize the LRU cache with a positive size `capacity`.
- **`int get(int key)`** → Return the value of the key if it exists, otherwise return `-1`.
- **`void put(int key, int value)`** → Add or update the key-value pair.  
  If adding the pair exceeds the capacity, remove the **least recently used** key.

Both operations **`get()`** and **`put()`** must run in **O(1)** average time complexity.

---

## 🧩 Example

```java
Input:
["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]

Output:
[null, null, null, 1, null, -1, null, -1, 3, 4]
```
**Explanation**
```java
LRUCache lRUCache = new LRUCache(2);
lRUCache.put(1, 1); // cache is {1=1}
lRUCache.put(2, 2); // cache is {1=1, 2=2}
lRUCache.get(1);    // returns 1 (1 becomes most recently used)
lRUCache.put(3, 3); // evicts key 2, cache is {1=1, 3=3}
lRUCache.get(2);    // returns -1 (not found)
lRUCache.put(4, 4); // evicts key 1, cache is {4=4, 3=3}
lRUCache.get(1);    // returns -1 (not found)
lRUCache.get(3);    // returns 3
lRUCache.get(4);    // returns 4
```

## 🧮 Approach — HashMap + Doubly Linked List

To achieve O(1) time complexity for both operations, we use:

- HashMap → For constant-time access to nodes.

- Doubly Linked List → To maintain the order of usage:

- Most Recently Used (MRU) → Near the tail.

- Least Recently Used (LRU) → Near the head.

## ⚙️ Working Principle

**GET operation**

If the key is present:

Return its value.

Move the node to the end (MRU position) to mark it as recently used.

If not present → return -1.

**PUT operation**

- If the key already exists:

  - Update its value.

  - Move the node to MRU position.

- If the key doesn’t exist:

  - If the cache is full:

      - Remove the LRU node (head's next node).

  - Insert the new node at MRU position (end of the list).

## 🧱 Data Structure Design
Class: Node

Each node represents a cache entry:
```java
class Node {
    int key;
    int value;
    Node prev, next;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
```

**Class: LRUCache**

Core cache implementation:
```java
class LRUCache {
    HashMap<Integer, Node> map;
    int size;
    Node mru, lru;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        this.size = capacity;
        mru = new Node(-1, -1); // dummy MRU node
        lru = mru;              // initially both point to the same node
    }
}
```

## 💻 Complete Code
```java
class LRUCache {
    HashMap<Integer, Node> map;
    int size;
    Node mru;
    Node lru;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        this.size = capacity;
        mru = new Node(-1, -1);
        lru = mru;
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            Node delNode = map.get(key);
            if (delNode == mru) return delNode.value;

            Node prevNode = delNode.prev;
            Node nextNode = delNode.next;
            prevNode.next = nextNode;
            if (nextNode != null) nextNode.prev = prevNode;

            mru.next = delNode;
            delNode.prev = mru;
            mru = delNode;

            return delNode.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node temp = map.get(key);
            temp.value = value;

            if (temp == mru) return;

            temp.prev.next = temp.next;
            if (temp.next != null) temp.next.prev = temp.prev;

            mru.next = temp;
            temp.prev = mru;
            mru = temp;
        } 
        else {
            if (map.size() == size) {
                Node delNode = lru.next;
                if (delNode != null) {
                    map.remove(delNode.key);
                    lru.next = delNode.next;
                    if (delNode.next != null) delNode.next.prev = lru;
                    if (delNode == mru) mru = lru;
                }
            }

            Node newNode = new Node(key, value);
            map.put(key, newNode);
            mru.next = newNode;
            newNode.prev = mru;
            mru = newNode;
        }
    }
}

class Node {
    int key;
    int value;
    Node prev, next;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
        this.prev = this.next = null;
    }
}
```
## 🧠 Complexity Analysis
| Operation | Time Complexity | Space Complexity | Explanation                                                |
| --------- | --------------- | ---------------- | ---------------------------------------------------------- |
| **get()** | O(1)            | O(N)             | HashMap provides O(1) access                               |
| **put()** | O(1)            | O(N)             | HashMap + LinkedList together store up to `capacity` nodes |

## 🔍 Key Takeaways

- LRU Cache combines the fast lookup of a HashMap and the ordering ability of a Doubly Linked List.

- MRU node is always at the tail.

- LRU node is always at the head.

- Every time we access or insert, that node becomes the MRU.
## ✨ Example Visualization
Capacity = 2
Operations:
put(1, 1) → [1]
put(2, 2) → [1, 2]
get(1)    → [2, 1]
put(3, 3) → Evict 2 → [1, 3]
get(2)    → -1


**🧩 MRU = rightmost element**

**🪶 LRU = leftmost element**

## 🧾 Notes

- This version maintains a linked list manually, without using LinkedHashMap.

- The nodes are dynamically shifted to mark recent usage.

- Handles all edge cases including:

  - Capacity overflow.
  
  - Updating existing keys.
  
  - Accessing non-existent keys.
## ✅ Output Verification
Input:
```
["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]

Output:
[null, null, null, 1, null, -1, null, -1, 3, 4]
