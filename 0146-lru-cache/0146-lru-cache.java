class LRUCache {
    Node head = new Node(0, 0);
    Node tail = new Node(0, 0);    
    int size;
    Map<Integer, Node> map = new HashMap<>();

    public LRUCache(int capacity) {
        head.next = tail;
        tail.prev = head;
        size = capacity;
    }
    
    public void insert(Node node){
        map.put(node.key, node);
        Node first = head.next;
        head.next = node;
        node.prev = head;
        first.prev = node;
        node.next = first;
    }
    
    public void remove(Node node){
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        } else{
            Node node = map.get(key);
            remove(node);            
            insert(node);
            // return map.get(key).val;   
            return node.val;
        }
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            remove(map.get(key));
        }
        if(map.size()>=size){
            remove(tail.prev);
        }
        
        insert(new Node(key, value));
    }
}

public class Node{
    Node prev, next;
    int key, val;
        
    public Node(int key, int val){
        this.key = key;
        this.val = val;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */