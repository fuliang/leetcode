import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Administrator on 2015/4/6.
 */

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }

    public static TreeNode build(Integer[] nums) {
        if (nums == null || nums.length == 0)
            return null;

        Queue<TreeNode> q = new LinkedList<TreeNode>();
        TreeNode root = new TreeNode(nums[0]);
        q.offer(root);

        int j = 1;
        while (!q.isEmpty()) {
            TreeNode treeNode = q.poll();
            if (j < nums.length) {
                Integer left = nums[j++];
                if (left != null) {
                    treeNode.left = new TreeNode(left);
                    q.offer(treeNode.left);
                }
            }

            if (j < nums.length) {
                Integer right = nums[j++];
                if (right != null) {
                    treeNode.right = new TreeNode(right);
                    q.offer(treeNode.right);
                }
            }
        }
        return root;
    }

}

