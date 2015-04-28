/**
 * Created by Administrator on 2015/4/6.
 */
public class MinDeepthOfBinaryTree {
    public int minDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        if (root.left == null) {
            return 1 + minDepth(root.right);
        }

        if (root.right == null) {
            return 1 + minDepth(root.left);
        }

        int minLeft = 1 + minDepth(root.left);
        int minRight = 1+ minDepth(root.right)
                ;
        return Math.min(minLeft, minRight);
    }


}
