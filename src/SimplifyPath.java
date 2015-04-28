import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * Created by fuliang on 2015/4/22.
 */
public class SimplifyPath {
    public String simplifyPath(String path) {
        if (path == null || path.length() == 0)
            return path;

        String[] segs = path.split("/");
        Stack<String> stack = new Stack<String>();
        for (int i = 0; i < segs.length; i++) {
            if (segs[i].length() == 0 || ".".equals(segs[i])) {
                continue;
            } else if (segs[i].equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(segs[i]);
            }
        }

        List<String> res = new ArrayList<String>();
        while (!stack.isEmpty()) {
            res.add(stack.pop());
        }

        if (res.isEmpty())
            return "/";

        StringBuilder sb = new StringBuilder();
        for (int i = res.size() - 1; i >= 0; i--) {
            sb.append("/").append(res.get(i));
        }
        return sb.toString();
    }

    public static void test(String str) {
        SimplifyPath sp = new SimplifyPath();
        System.out.println(sp.simplifyPath(str));
    }

    public static void main(String[] args) {
        test("/a/./b/../../c/");
        test("/..");
    }
}
