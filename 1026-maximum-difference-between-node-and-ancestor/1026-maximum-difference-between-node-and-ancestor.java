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
    public int maxAncestorDiff(TreeNode root) {
        return findMaxDiff(root, root.val, root.val);
    }

    public int findMaxDiff(TreeNode root, int currMax, int currMin) {
        if (root == null) return 0;

        int currDiff = Math.max(
            Math.abs(currMax - root.val),
            Math.abs(currMin - root.val)
        );

       

        currMax = Math.max(root.val, currMax);
        currMin = Math.min(root.val, currMin);

        int leftDiff = findMaxDiff(root.left, currMax, currMin);
        int rightDiff = findMaxDiff(root.right, currMax, currMin);

        return Math.max(
            currDiff,
            Math.max(leftDiff, rightDiff)
        );
    }
}










