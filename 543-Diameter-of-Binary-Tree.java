class Solution {

    int answer = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return answer;
    }

    private int height(TreeNode node) {

        if (node == null)
            return 0;

        int left = height(node.left);
        int right = height(node.right);

        answer = Math.max(answer, left + right);

        return 1 + Math.max(left, right);
    }
}