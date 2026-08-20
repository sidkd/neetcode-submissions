public class DoubleNode {
	    int key;
	    int value;

	    DoubleNode prev;
	    DoubleNode next;

	    DoubleNode(int key, int value) {
	        this.key = key;
	        this.value = value;
	    }
}

class LRUCache {

	
	int capacity;
	
	DoubleNode head = new DoubleNode(0, 0);
	
	DoubleNode tail = new DoubleNode(0, 0);
	
	Map<Integer, DoubleNode> hashMap;

    public LRUCache(int capacity) {
    	
    	hashMap = new HashMap<Integer, DoubleNode>();
    	this.capacity=capacity;
    	
    	head.next = tail;
        tail.prev = head;
        
    }
    
    public int get(int key) {
    	
    	if(this.hashMap.containsKey(key)) {
    		DoubleNode node = this.hashMap.get(key);
    		
            removeNode(node);
            insertAtTail(node);
    		
    		return node.value;

    	}else {
    		return -1;
    	}
        
    }
    
    public void put(int key, int value) {
    	
    	
    	if(this.hashMap.containsKey(key)) {
    		
    		DoubleNode newNode = new DoubleNode(key, value);
    		
    		DoubleNode node = this.hashMap.get(key);
    		node.value=value;
    		
    		removeNode(node);
    		insertAtTail(node);
    		
    	}else {
    		DoubleNode newNode = new DoubleNode(key, value);
    		
    		if(hashMap.size()<this.capacity) {
    			
    			hashMap.put(key, newNode);
    			insertAtTail(newNode);
    			
    		}else {
    			hashMap.remove(head.next.key);
    			removeNode(head.next);

    			hashMap.put(key, newNode);
    			insertAtTail(newNode);
    			
    		}
    		
    		
    	}
    	
    	
        
    }

	private void insertAtTail(DoubleNode node) {
		
		DoubleNode prevTail = tail.prev;
		
		node.prev=prevTail;
		node.next=tail;
		
		prevTail.next=node;
		
		tail.prev=node;
	}

	private void removeNode(DoubleNode node) {
		
		DoubleNode prevNode = node.prev;
		DoubleNode nextNode = node.next;
		
		prevNode.next = nextNode;
		nextNode.prev=prevNode;
		
		node.next=null;
		node.prev=null;
		
	}

}
