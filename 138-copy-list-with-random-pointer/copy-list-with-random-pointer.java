/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> hm= new HashMap<>();
        Node temp=head;
        while(temp!=null){
            // temp.val is the deep copy of temp or we can say the element n is temp itslef..
            hm.put(temp, new Node(temp.val));
            temp=temp.next;
        }
        // Ab isko nyi cpy mei add kro

        temp=head;

        while(temp!=null){
            Node curr=hm.get(temp);
            curr.next=hm.get(temp.next);
            curr.random=hm.get(temp.random);

            temp=temp.next;
        }
        return hm.get(head);

        
    }
}