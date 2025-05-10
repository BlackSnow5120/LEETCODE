class Solution {
    public TreeNode func(TreeNode root) {
        if (root == null) return null;

        TreeNode left = func(root.left);
        TreeNode right = func(root.right);

        root.left = null;

        if (left != null) {
            root.right = left;
            TreeNode temp = left;
            while (temp.right != null) temp = temp.right;
            temp.right = right;
        } else {
            root.right = right;
        }

        return root;
    }

    public void flatten(TreeNode root) {
        func(root);
    }
}
