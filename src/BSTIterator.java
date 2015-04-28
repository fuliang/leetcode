import java.util.Stack;

/**
 * Created by fuliang on 2015/4/11.
 *
 * https://leetcode.com/problems/binary-search-tree-iterator/
 *
 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
 * Calling next() will return the next smallest number in the BST.
 * Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
 * Credits:
 * Special thanks to @ts for adding this problem and creating all test cases.
 */

public class BSTIterator {
    private Stack<TreeNode> stack = new Stack<TreeNode>();

    public BSTIterator(TreeNode root) {
        TreeNode p = root;
        while (p != null) {
            stack.push(p);
            p = p.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode node = stack.pop();
        int val = node.val;

        TreeNode p = node.right;

        while (p != null) {
            stack.push(p);
            p = p.left;
        }
        return  val;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.build(new Integer[]{9, 7, 13, null, 8, 12, 14});
        BSTIterator it = new BSTIterator(root);
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
