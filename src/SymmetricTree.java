/**
 * Created by Administrator on 2015/4/6.
 */
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;

        return isMatch(root.left, root.right);
    }

    private boolean isMatch(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null)
            return true;

        if (node1 == null || node2 == null || node1.val != node2.val)
            return false;

        return isMatch(node1.left, node2.right) && isMatch(node1.right, node2.left);
    }

    public static void test(TreeNode root) {
        SymmetricTree sol = new SymmetricTree();
        boolean result = sol.isSymmetric(root);
        System.out.println(result);
    }

    public static void main(String[] args) {
        test(TreeNode.build(new Integer[]{1, 2, 2, 3, 4, 4, 3}));
        test(TreeNode.build(new Integer[]{}));
        test(TreeNode.build(new Integer[]{1}));
        test(TreeNode.build(new Integer[]{1,2,2,null,3, null, 3}));
    }
}