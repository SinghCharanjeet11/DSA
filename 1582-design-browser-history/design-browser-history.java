class BrowserHistory {
    // Initilization of Node
    public class Node{
        String url;
        Node next;
        Node prev;
        Node(String url){
            this.url=url;
            this.next=null;
            this.prev=null;
        }
    }
    Node curr;
    public BrowserHistory(String homepage) {
        curr=new Node(homepage);
    }
    
    public void visit(String url) {
        Node second=new Node(url);
        curr.next=second;
        second.prev=curr;
        curr=second;   
    }
    
    public String back(int steps) {
        while(curr.prev!=null && steps>0){
            steps--;
            curr=curr.prev;
        }
        return curr.url;
        
    }
    
    public String forward(int steps) {
        while(curr.next!=null && steps-- >0){
            curr=curr.next;
        }
        return curr.url;
        
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */