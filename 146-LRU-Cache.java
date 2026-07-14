class Node {
    int key,value;
    Node prev,next;
    Node(int key, int value)
    {
        this.key=key;
        this.value=value;
    }
}
class LRUCache {
    
    private final int capacity;
    private final Map<Integer, Node> map;
    private final Node head, tail;

    public LRUCache(int capacity) {
        
        this.capacity=capacity;
        this.map = new HashMap<>();
        head = new Node (0,0);
        tail= new Node(0,0);
        head.next=tail;
        tail.prev=head;
    }
    
    public int get(int key) {

        if(map.containsKey(key))
        {
            Node node = map.get(key);
            remove(node);
            insertFirst(node);
            return node.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        
        if(map.containsKey(key))
        {
            Node node = map.get(key);
            node.value=value;
            remove(node);
            insertFirst(node);
        }
        else
        {
            
            if(map.size()==capacity)
            {
                Node least = tail.prev;
                remove(least);
                map.remove(least.key);
            }
            Node newnode = new Node(key,value);
            insertFirst(newnode);
            map.put(key,newnode);
        }
    }

    public void remove (Node node)
    {
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }

    public void insertFirst(Node node)
    {
        node.next=head.next;
        node.prev=head;
        head.next.prev = node;
        head.next=node;
        
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */