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
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root==null)return false;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        

        while(!q.isEmpty())
        {
            int cc=0;
            int size=q.size();
            for(int i=0;i<size;i++)
            {
                int pc=0;
                TreeNode node = q.poll();
                if(node.left!=null)
                {
                if(node.left.val==x||node.left.val==y)
                {
                    pc++;
                    cc++;
                }
                q.offer(node.left);
                }

                if(node.right!=null)
                {
                if(node.right.val==x||node.right.val==y)
                {
                    pc++;
                    cc++;
                }
                q.offer(node.right);
                }
                if(pc==2)
                return false;
            }
                if(cc==2)
                return true;
                if(cc==1)
                return false;
        }
        return false;
    }
}