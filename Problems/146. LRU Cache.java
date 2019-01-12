class LRUCache {

    class DLinkedNode{
        int key, value;
        DLinkedNode prev, next;
    }
    
    Map<Integer, DLinkedNode> cache;
    DLinkedNode head, tail;
    int capacity, count;
    
    public LRUCache(int capacity) {
        cache = new HashMap<>();
        head = new DLinkedNode();
        tail = new DLinkedNode();
        
        head.next=tail;
        tail.prev=head;
        head.prev = null;
        tail.next = null;
        
        this.capacity = capacity;  
        this.count = 0;
    }
    
    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if(node== null) return -1;
        
        removeNode(node);
        addNode(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if(node==null){
            DLinkedNode newNode = new DLinkedNode();
            newNode.key = key;
            newNode.value = value;
            
            cache.put(key, newNode);
            addNode(newNode);
            count++;
            if(count > capacity){     
                cache.remove(tail.prev.key);
                removeNode(tail.prev);
                count--;
            }
        }else{
            node.value = value;
            removeNode(node);
            addNode(node);
        }
    }
    
    private void addNode(DLinkedNode node){
        node.prev = head;
        node.next = head.next;
        
        head.next.prev = node;
        head.next = node;
        
    }
    
    private void removeNode(DLinkedNode node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}
