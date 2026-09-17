class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        Queue<TreeNode> q = new LinkedList<TreeNode>();
        List<List<Integer>> list = new LinkedList<List<Integer>>();

        if(root == null)
            return list;

        q.offer(root);
        int ctr = 0;

        while(!q.isEmpty())
        {
            int size = q.size();
            List<Integer> li = new LinkedList<Integer>();

            for(int i = 0; i < size; i++)
            {
                TreeNode current = q.poll();

                li.add(current.val);

                if(current.left != null)
                    q.offer(current.left);

                if(current.right != null)
                    q.offer(current.right);
            }

            if(ctr == 1)
                Collections.reverse(li);

            list.add(li);

            ctr = (ctr == 0) ? 1 : 0;
        }

        return list;
    }
}