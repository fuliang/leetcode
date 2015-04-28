/**
 * Created by Administrator on 2015/4/6.
 */
public class ReverseWordInString {
    public String reverseWords(String s) {
        s = s.trim();
        if (s == null || s.isEmpty())
            return s;

        String[] words = s.split(" +");
        StringBuilder sb = new StringBuilder();
        sb.append(words[words.length-1]);
        for (int i = words.length - 2; i >= 0; i--) {
            sb.append(" ").append(words[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "the       word";
        ReverseWordInString sol = new ReverseWordInString();
        System.out.println(sol.reverseWords(s));
    }
}
