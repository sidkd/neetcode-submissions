/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {

    public ListNode reverseKGroup(ListNode head, int k) {
    	
    	ListNode temp = head;
    	ListNode prevNode = null;
    	ListNode nextNode = null;
    	
    	while(temp!=null) {
    		
    		ListNode kthNode = findKthNode(temp,k);
    		
    		
    		if(kthNode==null) {
        		if(prevNode!=null) {
        			prevNode.next=temp;
        			break;
        		}
    		}
    		
    		nextNode = kthNode.next;

    		kthNode.next=null;
    		
    		
    		ListNode reversedHead = reverseLinkedList(temp);

    		if(head==temp) {
    			head=kthNode;
    		}else if(prevNode!=null) {
    			prevNode.next = reversedHead;
    		}
    		
    		 prevNode = temp;
    		 
    		 prevNode.next = nextNode;
    		
    		temp=nextNode;
    	}
    	
    	return head;
        
    }

	private ListNode findKthNode(ListNode temp, int k) {
		
		int counter = 0 ;
		
		ListNode kthNode = temp;
		
		while(kthNode!=null) {
			counter ++;
			if(counter==k) {
				break;
			}
            kthNode = kthNode.next;
		}
		
		if(counter<k) {
			return null;
		}
		
		return kthNode;
		
	}
	
	public ListNode reverseLinkedList(ListNode head) {
		
		ListNode prev=null;
		
		ListNode temp = head;
		
		while(temp!=null) {
			
			ListNode front = temp.next;
			
			temp.next=prev;
			
			prev=temp;
			temp=front;
			
		}
		return prev;		
	}

}
