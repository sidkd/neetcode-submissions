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

    public List<Integer> rightSideView(TreeNode root) {
        
    	List<Integer> rightview = new ArrayList<Integer>();
    	
    	if(root==null) {
    		return rightview;
    	}
    	
    	traverseRightSideView(root, 0, rightview);
    	
    	return rightview;
    	
    	
    }
    
    public void traverseRightSideView(TreeNode node, int level, List<Integer> rightView) {
    	
    	if(node==null) {
    		return;
    	}
    	
    	if(level==rightView.size()) {
    		rightView.add(node.val);
    	}
    	
    	traverseRightSideView(node.right, level+1, rightView);
    	
    	traverseRightSideView(node.left, level+1, rightView);
    	
    }


}
