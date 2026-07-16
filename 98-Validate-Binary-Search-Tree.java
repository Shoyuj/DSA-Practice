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
    public boolean isValidBST(TreeNode root) {
        // high level: recursion to traversal this tree.
        //              if curr.val <= prev.val stop traversal and return false;
        //              or after we have traversed it, return true;
        // TC: O(n), SC: O(height)

        if (root == null) return true;

        TreeNode[] prev = new TreeNode[1];
        return inorder(root, prev);
    }

    private boolean inorder(TreeNode root, TreeNode[] prev) {
        if (root == null) return true;

        if (!inorder(root.left, prev)) {
            return false;
        }

        if (prev[0] != null && prev[0].val >= root.val) {
            return false;
        }
        prev[0] = root;

        return inorder(root.right, prev);
    }
}