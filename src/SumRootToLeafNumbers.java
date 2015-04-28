import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by fuliang on 2015/4/20.
 */
public class SumRootToLeafNumbers {
    public int sumNumbers(TreeNode root) {
        if (root == null)
            return 0;

        Sum sum = new Sum();

        dfs(root, root.val, sum);
        return sum.getSum();
    }

    class Sum {
        private int sum = 0;

        public void add(int num) {
            sum += num;
        }

        public int getSum() {
            return sum;
        }
    }
    private void dfs(TreeNode node, int current, Sum sum) {
        if (node.left == null && node.right == null) {
            sum.add(current);
            return;
        }

        if (node.left != null) {
            dfs(node.left, current * 10 + node.left.val, sum);
        }

        if (node.right != null) {
            dfs(node.right, current * 10 + node.right.val, sum);
        }
    }

    private static void test(TreeNode root) {
        SumRootToLeafNumbers sol = new SumRootToLeafNumbers();
        int sum = sol.sumNumbers(root);
        System.out.println(sum);
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.build(new Integer[]{1,2,3});
        test(root);
    }
}
