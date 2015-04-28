import java.util.*;

/**
 * Created by fuliang on 2015/4/12.
 */
public class BinaryTreeLevelOrderTraversal2 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(null);
        queue.offer(root);

        int level = -1;
        while (true) {
            TreeNode node = queue.poll();
            if (queue.isEmpty()) {
                break;
            }

            if (node == null && !queue.isEmpty()) {
                queue.offer(null);
                List<Integer> lst = new ArrayList<Integer>();
                result.add(lst);
                ++level;
            } else {
                List<Integer> lst = result.get(level);
                lst.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        Collections.reverse(result);
        return result;
    }
}
