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

    class Pair{
        TreeNode node;
        int idx;
        Pair(TreeNode node , int i){
            this.node = node;
            this.idx = i;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair>q = new LinkedList<>();
        q.offer(new Pair(root,0));

        int ans = 0;

        while(!q.isEmpty()){
            int n = q.size();
            int l = 0 , r = 0;
            for(int i = 0; i < n; i++){
                Pair p = q.poll();
                TreeNode node = p.node;
                int idx = p.idx;
                if(i == 0) l = idx;
                if(i == n-1) r = idx;

                if(node.left != null) q.offer(new Pair(node.left,2*idx+1));
                if(node.right != null) q.offer(new Pair(node.right,2*idx+2));

            }

            ans = Math.max(ans,r-l);

        }
        return ans+1;
    }
}