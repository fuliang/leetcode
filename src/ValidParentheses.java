import java.util.Stack;

/**
 * Created by Administrator on 2015/4/5.
 */

public class ValidParentheses {
    private boolean isMatch(char c1, char c2) {
        return c1 == '(' && c2 == ')' || c1 == '[' && c2 == ']' || c1 == '{' && c2 == '}';
    }
    public boolean isValid(String s) {
        if (s == null || s.isEmpty())
            return true;

        Stack<Character> st = new Stack<Character>();
        st.push(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if (st.isEmpty()) {
                st.push(s.charAt(i));
                continue;
            }

            char top = st.peek();
            if (isMatch(top, s.charAt(i))) {
                st.pop();
            } else {
                st.push(s.charAt(i));
            }
        }
        return st.isEmpty();
    }

    public static void main(String[] args) {
        ValidParentheses sol = new ValidParentheses();
        System.out.println(sol.isValid("()()]"));
    }
}
