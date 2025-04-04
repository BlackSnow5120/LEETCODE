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
    public int left = 0;
    public int right = 0;

    public void func(TreeNode root, int hd) {
        if (root == null)
            return;
        if (hd < 0 && hd < left)
            left = hd;
        else if (hd > 0 && hd > right)
            right = hd;
        func(root.left, hd - 1);
        func(root.right, hd + 1);
    }

    public int widthOfBinaryTree(TreeNode root) {
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        q1.add(root);
        q2.add(0);
        int width = 0;
        int size = q1.size();
        int nulls = -1;
        int t = 3;
        while (!q1.isEmpty()) {
            size = q1.size();
            int minIndex = q2.peek(); 
            Integer l = 0;
            Integer r = 0;
            for (int i = 0; i < size; i++) {
                TreeNode temp = q1.peek();
                q1.poll();
                Integer curr = q2.peek();
                q2.poll();
                if(i==0) l=curr;
                if(i==size-1) r=curr;
                if(temp.left!=null)
                {
                    q1.add(temp.left);
                    q2.add(2*curr + 1);
                }
                if(temp.right!=null)
                {
                    q1.add(temp.right);
                    q2.add(2*curr + 2);
                }


            }
            width = Math.max(width, r - l+1);
            size = q1.size();
        }

        return width;
    }
}