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
    public int goodNodes(TreeNode root) {
    // Start DFS traversal with the root value as the initial maximum
        return dfs(root, root.val);
    }
    
    private int dfs(TreeNode node, int maxSoFar) {
        if (node == null) {
            return 0;
        }
        
        int good = 0;
        // Check if the current node is a "good" node
        if (node.val >= maxSoFar) {
            good = 1;
            // Update the maximum value for the deeper paths
            maxSoFar = node.val;
        }
        
        // Recurse down to left and right subtrees and sum up the results
        return good + dfs(node.left, maxSoFar) + dfs(node.right, maxSoFar);
    }
}