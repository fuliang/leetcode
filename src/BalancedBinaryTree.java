/**
 * Created by fuliang on 2015/4/6.
 *
 * https://leetcode.com/problems/balanced-binary-tree/
 *
 * Given a binary tree, determine if it is height-balanced.
 *
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 */

public class BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;

        int diff = depth(root.right) - depth(root.left);
        if (Math.abs(diff) > 1) {
            return false;
        }

        return isBalanced(root.left) && isBalanced(root.right);
    }

    public int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int depthLeft = 1 + depth(root.left);
        int depthRight = 1+ depth(root.right);
        return Math.max(depthLeft, depthRight);
    }

}
