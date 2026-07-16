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
    public boolean evaluateTree(TreeNode node) {
        if (node.left == null)
        return (node.val == 1);

        boolean left = evaluateTree(node.left);
        boolean right = evaluateTree(node.right);

        if(node.val == 2)
        return left || right;

        if(node.val == 3)
        return left && right;


    return false;
    }
}