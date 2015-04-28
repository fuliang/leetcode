import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Administrator on 2015/4/6.
 */
public class BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
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
        return result;
    }

    public static void main(String[] args) {
        Integer[] nums = new Integer[] {1, null, 2};
        TreeNode treeNode = TreeNode.build(nums);
        BinaryTreeLevelOrderTraversal sol = new BinaryTreeLevelOrderTraversal();
        List<List<Integer>> result = sol.levelOrder(treeNode);
        Utils.printNestList(result);
    }
}
