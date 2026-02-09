/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */

func balanceBST(root *TreeNode) *TreeNode {
    var vals []int
    // Use a helper to populate the slice correctly
    inorder(root, &vals) 
    return build(vals, 0, len(vals)-1)
}

func inorder(root *TreeNode, vals *[]int) {
    if root == nil {
        return
    }
    inorder(root.Left, vals)
    *vals = append(*vals, root.Val) // Update the actual slice header
    inorder(root.Right, vals)
}

func build(vals []int, l int, r int) *TreeNode {
    if l > r {
        return nil
    }
    mid := l + (r-l)/2 // Safer way to calculate mid
    
    // Initialize the node with the middle value
    node := &TreeNode{Val: vals[mid]} 
    
    node.Left = build(vals, l, mid-1)
    node.Right = build(vals, mid+1, r)
    
    return node
}