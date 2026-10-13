class LRUCache {
    class Node{
        int key;
        int value;
        Node prev;
        Node next;
        Node(int key, int value){
            this.key=key;
            this.value=value;
        }
    }

    private HashMap<Integer, Node> hm;
    private Node head, tail;
    private int capacity; 
    public LRUCache(int capacity) {
        this.capacity= capacity;
        hm= new HashMap<>();

        head= new Node(-1,-1);
        tail= new Node(-1,-1);
        head.next=tail;
        tail.prev=head;
    }

    private void remove(Node node){
        node.prev.next=node.next;
        node.next.prev= node.prev;
    }
    private void insertAfterHead(Node node){
        node.next=head.next;
        node.prev= head;

        head.next.prev= node;
        head.next= node;

    }
    
    public int get(int key) {
        if(!hm.containsKey(key)){
            return -1;
        }
        Node node= hm.get(key);
        // Now as this node is used, so remove it and insert it at the head;
        remove(node);
        insertAfterHead(node);
        return node.value;
        
    }
    
    public void put(int key, int value) {
        // Update the value as key already exists
        if(hm.containsKey(key)){
            Node node= hm.get(key);
            node.value= value;

            remove(node);
            insertAfterHead(node);
        }
        else{
            Node node= new Node(key,value);

            hm.put(key, node);
            insertAfterHead(node);

            if(hm.size()>capacity){
                Node least= tail.prev;
                remove(least);
                hm.remove(least.key);
            }
        }
        
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */