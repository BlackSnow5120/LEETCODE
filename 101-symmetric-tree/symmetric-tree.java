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
    public boolean isSymmetric(TreeNode root) {
        TreeNode p =root.left;
        TreeNode q=root.right;
        ArrayList <Integer> arr1 = new ArrayList<>();
        ArrayList <Integer> arr2 = new ArrayList<>();

        Queue <TreeNode> q1 = new LinkedList<>();
        Queue <TreeNode> q2 = new LinkedList<>();

        q1.add(p);
        q2.add(q);
        while(!q1.isEmpty())
        {
            TreeNode temp = q1.poll();
            if(temp!=null)
            {
                arr1.add(temp.val);
                q1.add(temp.left);
                q1.add(temp.right);
            }
            else
            {
                arr1.add(null);
            }
        }
                while(!q2.isEmpty())
        {
            TreeNode temp = q2.poll();
            if(temp!=null)
            {
                arr2.add(temp.val);
                q2.add(temp.right);
                q2.add(temp.left);
            }
            else
            {
                arr2.add(null);
            }
        }

        return Arrays.equals(arr1.toArray(),arr2.toArray());
    }
}