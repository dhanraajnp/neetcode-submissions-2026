class LRUCache {
    private static class Node {
        int key;
        int value;
        Node next;
        Node prev;

        Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;
    private final HashMap<Integer, Node> map;
    Node head = new Node(0,0);
    Node tail = new Node(0,0);
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();

        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {        
    
        Node node = map.get(key);
            
        if(node == null) return -1;

        remove(node);
        insertAtFront(node);            
    
        return node.value;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.value = value;
            remove(node);
            insertAtFront(node);
            return;
        }

        if(map.size() == capacity){
            Node last = tail.prev;
            remove(last);
            map.remove(last.key);
        }

        Node add = new Node(key, value);
        insertAtFront(add);
        map.put(key, add);
        return;
    }

    private void insertAtFront(Node node) {
        Node first = head.next;
        first.prev = node;
        node.next = first;
        node.prev = head;
        head.next = node;
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}
