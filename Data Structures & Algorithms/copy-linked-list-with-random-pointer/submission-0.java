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
        
    	
    	//part-1 insert new nodes in between
    	Node temp = head;
    	
    	while(temp!=null) {
    		Node copyNode = new Node(temp.val);
    		
    		copyNode.next = temp.next;
    		temp.next=copyNode;
    		
    		temp=temp.next.next;
    	}
    	
    	//part-2 adjusting the random pointers for copy nodes
    	temp=head;
    	
    	while(temp!=null) {
    		
    		if(temp.random==null) {
    			temp.next.random=null;
    		}else {
    			temp.next.random = temp.random.next;
    		}
    		
    		temp = temp.next.next;
    		
    	}
    	
    	//part3 - adjusting next pointers for new nodes;
    	Node dummyNode = new Node(-1);
    	Node res = dummyNode;
    	temp=head;
    	
    	while(temp!=null) {
    		res.next=temp.next;
    		temp.next=temp.next.next;
    		res=res.next;
    		temp=temp.next;
    	}
        return dummyNode.next;
    
    }
}
