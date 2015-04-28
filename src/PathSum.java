/**
 * Created by Administrator on 2015/4/6.
 */
public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
            return false;

        return hasPathSum(root, sum, 0);
    }

    public boolean hasPathSum(TreeNode root, int sum, int tmpSum) {
        if (root.left == null && root.right == null) {
            return sum == tmpSum + root.val;
        }

        if (root.left == null) {
            return hasPathSum(root.right, sum, tmpSum + root.val);
        }

        if (root.right == null) {
            return hasPathSum(root.left, sum, tmpSum + root.val);
        }

        boolean leftHas = hasPathSum(root.left, sum, tmpSum + root.val);
        boolean rightHas = hasPathSum(root.right, sum, tmpSum + root.val);
        return leftHas || rightHas;
    }
}
