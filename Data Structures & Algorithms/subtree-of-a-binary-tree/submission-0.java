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

	public boolean isSubtree(TreeNode root, TreeNode subRoot) {
    if (root == null || subRoot == null) {
        return false;
    }

    return findNode(root, subRoot) != null;
}

public TreeNode findNode(TreeNode root, TreeNode subRoot) {
    if (root == null) {
        return null;
    }

    if (isSameTree(root, subRoot)) {
        return root;
    }

    TreeNode leftResult = findNode(root.left, subRoot);
    if (leftResult != null) {
        return leftResult;
    }

    return findNode(root.right, subRoot);
}

public boolean isSameTree(TreeNode p, TreeNode q) {
    if (p == null || q == null) {
        return p == q;
    }

    return (p.val == q.val) && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
}}
