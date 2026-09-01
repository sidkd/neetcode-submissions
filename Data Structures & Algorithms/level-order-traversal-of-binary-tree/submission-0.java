/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        
    	Queue<TreeNode> traversalQueue = new LinkedList<TreeNode>();
    	
    	List<List<Integer>> traversedList = new ArrayList<List<Integer>>();
    	
    	if(root==null) {
    		return traversedList;
    	}
    	
    	traversalQueue.add(root);
    	
    	while(!traversalQueue.isEmpty()) {
    		
    		int size = traversalQueue.size();
    		
    		List<Integer> levelList = new ArrayList<Integer>();
    		
    		for(int i=0;i<size;i++) {
    			
    			if(traversalQueue.peek().left!=null) {
    				traversalQueue.offer(traversalQueue.peek().left);
    			}
    			
    			if(traversalQueue.peek().right!=null) {
    				traversalQueue.offer(traversalQueue.peek().right);
    			}
    			
    			TreeNode node = traversalQueue.poll();
    			
    			levelList.add(node.val);
    			
    		}
    		
    		traversedList.add(levelList);

    	}
    	
    	return traversedList;
    	
    
    }
}
