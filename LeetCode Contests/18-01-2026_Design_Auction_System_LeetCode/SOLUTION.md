# 🏷️ Design Auction System (LeetCode 3815)

## 📘 Problem Overview

You need to design an auction system where multiple users can place bids on multiple items in real time.

Each bid has:

* `userId`
* `itemId`
* `bidAmount`

### Required Operations

* `addBid(userId, itemId, bidAmount)` → Add or replace a bid
* `updateBid(userId, itemId, newAmount)` → Update existing bid
* `removeBid(userId, itemId)` → Remove a bid
* `getHighestBidder(itemId)` → Return user with highest bid (tie → higher userId)

If no bids exist for an item, return `-1`.

---

## 🧠 Data Structures Used

1. **HashMap<Integer, Map<Integer, Integer>> bmap**

   * `itemId -> (userId -> bidAmount)`

2. **HashMap<Integer, TreeSet<MyBid>> imap**

   * `itemId -> sorted set of bids`
   * Sorted by:

     * Highest bidAmount first
     * If tie, higher userId first

---

## ⚙️ Custom Bid Class

```java
class MyBid {
    int uId, uAmount;
    public MyBid(int uId, int uAmount) {
        this.uId = uId;
        this.uAmount = uAmount;
    }
}
```

---

## 💻 Java Implementation

```java
class AuctionSystem {
    class MyBid{
        int uId, uAmount;

        public MyBid(int uId, int uAmount){
            this.uId=uId;
            this.uAmount=uAmount;
        }
    }
    
    private HashMap<Integer, Map<Integer,Integer>> bmap;
    private HashMap<Integer, TreeSet<MyBid>> imap;
    
    public AuctionSystem() {
        bmap=new HashMap<>();
        imap=new HashMap<>();
    }

    private TreeSet<MyBid> sortItem(int itemId){
        return imap.computeIfAbsent(itemId, k->new TreeSet<>(
            (a,b)->{
                if(a.uAmount!=b.uAmount){
                    return b.uAmount-a.uAmount;
                }
                return b.uId-a.uId;
            }
        ));
    }
    public void addBid(int userId, int itemId, int bidAmount) {
        bmap.putIfAbsent(itemId, new HashMap<>());
        TreeSet<MyBid> set=sortItem(itemId);
        Map<Integer, Integer> map =bmap.get(itemId);

        if(map.containsKey(userId)){
            int old=map.get(userId);
            set.remove(new MyBid(userId, old));
        }

        map.put(userId, bidAmount);
        set.add(new MyBid(userId, bidAmount));
    }
    
    public void updateBid(int userId, int itemId, int newAmount) {
        TreeSet<MyBid> set=sortItem(itemId);
        Map<Integer,Integer> map=bmap.get(itemId);

        int old=map.get(userId);
        set.remove(new MyBid(userId, old));

        map.put(userId, newAmount);
        set.add(new MyBid(userId, newAmount));
    }
    
    public void removeBid(int userId, int itemId) {
        TreeSet<MyBid> set=sortItem(itemId);
        Map<Integer, Integer> map=bmap.get(itemId);

        int old=map.get(userId);
        set.remove(new MyBid(userId, old));
        map.remove(userId);
    }
    
    public int getHighestBidder(int itemId) {
        if(!imap.containsKey(itemId) || imap.get(itemId).isEmpty()){
            return -1;
        }
        return imap.get(itemId).first().uId;
    }
}
```

---

## 🎯 Key Idea

* `TreeSet` keeps bids always sorted.
* First element is always the highest bid.
* Comparator handles both bidAmount and userId tie-breaking.

This gives:

* `O(log N)` for add, update, remove
* `O(1)` for getHighestBidder

---

## 🚀 Example

Item 7 bids:

* (1,5), (2,6) → Highest = 2
* Update (1,8) → Highest = 1
* Remove (2,6) → Highest = 1
* Item 3 → No bids → `-1`
