import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by fuliang on 2015/4/9.
 */
public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return null;
        }

        List<Integer> result = new ArrayList<Integer>();

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(null);
        queue.offer(root);

        TreeNode preNode = null;
        while (true) {
            TreeNode node = queue.poll();
            if (queue.isEmpty()) {
                result.add(preNode.val);
                break;
            }

            if (node == null) {
                queue.offer(null);
                if (preNode != null) {
                    result.add(preNode.val);
                }
            } else {
                preNode = node;
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        BinaryTreeRightSideView sol = new BinaryTreeRightSideView();
        Integer[] nums = new Integer[] {1,2,3,null, 5};
        TreeNode root = TreeNode.build(nums);
        List<Integer> result = sol.rightSideView(root);
        for (Integer e : result) {
            System.out.println(e);
        }
    }
}
