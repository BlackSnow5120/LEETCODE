class LRUCache {
    int capacity;
    LinkedList<Integer> l1;
    HashMap <Integer,Integer> hs1;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        l1 = new LinkedList<>();
        hs1 = new HashMap<>();
    }

    public int get(int key) {
        if (hs1.containsKey(key)) {
            l1.remove(Integer.valueOf(key));
            l1.offer(key);                   
            return hs1.get(key);
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (hs1.containsKey(key)) {
            l1.remove(Integer.valueOf(key));
        } else if (l1.size() == capacity) {
            int oldestKey = l1.pollFirst(); 
            hs1.remove(oldestKey);           
        }
        l1.offer(key);             
        hs1.put(key, value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */