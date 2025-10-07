# 🧠 LRU Cache — Smart Interviews Edition

## 📘 Problem Statement

Design and implement a **Least Recently Used (LRU) Cache**.

Given a list of **page numbers**, insert them into a cache of size **K** in an **LRU fashion**.  
This means:
- If a page is already in the cache → mark it as **most recently used**.
- If the cache is **full** and a **new page** comes → remove the **least recently used** page and insert the new one.

Your task is to print the final state of the cache for each test case.

---

## 🧩 Input Format

- The first line contains **T**, the number of test cases.  
- Each test case consists of **2 lines**:
  1. Two integers **N** and **K** — number of page requests and cache size.
  2. A list of **N page numbers** separated by spaces.

---

## 📤 Output Format

For each test case, print the **final contents** of the cache (from **Least Recently Used → Most Recently Used**) in a single line.

---

## ⚙️ Constraints

| Constraint | Description |
|-------------|--------------|
| 1 ≤ p[i] ≤ 100000 | Page number range |
| 1 ≤ T ≤ 1000 | Number of test cases |
| 1 ≤ N, K ≤ 5000 | Number of pages and cache size |

---

## 💡 Example

### Input
```
3
5 3
3 8 2 8 1
8 5
4 7 3 10 7 8 5 3
10 5
6 5 6 2 3 14 2 1 10 10
```

### Output
```
2 8 1
10 7 8 5 3
3 14 2 1 10
```

---

## 🧠 Explanation

Let's break down the **first test case**:

N = 5, K = 3
Pages = [3, 8, 2, 8, 1]

**Step-by-step process:**

| Step | Page | Cache State (LRU → MRU) | Explanation |
|------|-------|--------------------------|--------------|
| 1 | 3 | [3] | Cache empty → add 3 |
| 2 | 8 | [3, 8] | Add 8 |
| 3 | 2 | [3, 8, 2] | Add 2 (cache full now) |
| 4 | 8 | [3, 2, 8] | 8 already exists → move to MRU |
| 5 | 1 | [2, 8, 1] | 3 (LRU) removed → insert 1 |

✅ **Final Cache:** `2 8 1`

---

## 🏗️ Approach — HashMap + Doubly Linked List

To achieve **O(1)** performance for insertion and lookup, we combine:

1. **HashMap** → To quickly find whether a page is in the cache.  
2. **Doubly Linked List** → To efficiently remove and insert nodes (pages) in LRU order.

### 🧩 Design Logic:
- The **head** of the linked list → Dummy node before LRU.
- The **tail** of the linked list → Dummy node after MRU.
- When a page is accessed:
  - If it exists → move it to the **tail** (most recently used).
  - If not:
    - If cache full → remove **head.next** (least recently used).
    - Then add the new page just before the tail.

---

## 💻 Complete Java Code

```java
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();

        while (testCases-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();

            int[] pages = new int[n];
            for (int i = 0; i < n; i++) {
                pages[i] = sc.nextInt();
            }

            LRUCache lru = new LRUCache(k);
            for (int i = 0; i < n; i++) {
                lru.put(pages[i]);
            }

            lru.printCache();
        }
    }
}

class Node {
    int data;
    Node prev, next;

    public Node(int data) {
        this.data = data;
        this.prev = this.next = null;
    }
}

class LRUCache {

    private final int capacity;
    HashMap<Integer, Node> map;
    Node head;
    Node tail;

    public LRUCache(int size) {
        this.capacity = size;
        map = new HashMap<>();

        // Dummy head and tail
        head = new Node(-1);
        tail = new Node(-1);
        head.next = tail;
        tail.prev = head;
    }

    // Remove a node from its current position
    public void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // Add a node right before the tail (MRU position)
    public void addNodeToTail(Node node) {
        node.prev = tail.prev;
        node.next = tail;
        tail.prev.next = node;
        tail.prev = node;
    }

    // Insert or update the cache
    public void put(int key) {
        if (map.containsKey(key)) {
            Node existingNode = map.get(key);
            removeNode(existingNode);
            addNodeToTail(existingNode);
        } else {
            Node newNode = new Node(key);

            if (map.size() >= capacity) {
                // Evict LRU
                Node lruNode = head.next;
                removeNode(lruNode);
                map.remove(lruNode.data);
            }

            addNodeToTail(newNode);
            map.put(key, newNode);
        }
    }

    // Print the cache from LRU to MRU
    public void printCache() {
        Node temp = head.next;
        while (temp != tail) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}
```
## 🧮 Complexity Analysis
| Operation   | Time Complexity | Space Complexity | Description                     |
| ----------- | --------------- | ---------------- | ------------------------------- |
| **put()**   | O(1)            | O(K)             | Insert / Update a page in cache |
| **get()**   | O(1)            | O(K)             | Lookup using HashMap            |
| **Overall** | O(N) per test   | O(K)             | Efficient for all constraints   |

## 🔍 Key Insights

- Most Recently Used (MRU) pages stay near the tail.

- Least Recently Used (LRU) pages stay near the head.

- Whenever a page is accessed:

  - It’s removed from its position.
  
  - Reinserted before the tail.

- When cache is full, remove head.next.
## 🧩 Visual Representation
```
 [Head] ⇄ 2 ⇄ 8 ⇄ 1 ⇄ [Tail]
↑ LRU                  ↑ MRU
```
When a page (e.g., 8) is accessed:

Remove 8 and move it before the tail → becomes most recently used.

## 🧾 Summary
| Step | Concept                              | Description                     |
| ---- | ------------------------------------ | ------------------------------- |
| 1️⃣  | Use HashMap                          | For quick lookups               |
| 2️⃣  | Use Doubly Linked List               | For maintaining LRU → MRU order |
| 3️⃣  | Remove `head.next`                   | When cache full                 |
| 4️⃣  | Add new node before `tail`           | To mark as most recently used   |
| 5️⃣  | Print from `head.next` → `tail.prev` | For final output                |


## ✨ Sample Run
**Input:**
1
5 3
3 8 2 8 1

**Output:**
2 8 1

**Execution Trace:**
```
put(3) → [3]
put(8) → [3, 8]
put(2) → [3, 8, 2]
put(8) → [3, 2, 8]
put(1) → [2, 8, 1]
