import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * Created by fuliang on 2015/4/12.
 */
public class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }

        List<Integer> result = new ArrayList<Integer>();

        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);

            if (node.right != null) {
                stack.push(node.right);
            }

            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return result;
    }

    private static void test(TreeNode root) {
        BinaryTreePreorderTraversal sol = new BinaryTreePreorderTraversal();
        List<Integer> result = sol.preorderTraversal(root);
        for (Integer e : result) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        test(TreeNode.build(new Integer[]{1,null, 2, 3}));
        test(TreeNode.build(new Integer[]{1,2,3,4,5}));
    }
}
