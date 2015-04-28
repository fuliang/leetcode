/**
 * Created by Administrator on 2015/4/5.
 */
public class LengthofLastWord {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        if (s == null || s.length() == 0) {
            return 0;
        }

        int index = s.lastIndexOf(' ');
        if (index == -1)
            return s.length();

        return s.length() - index - 1;
    }

    public static void main(String[] args) {
        String str = "Hello World ";
        LengthofLastWord sol = new LengthofLastWord();
        System.out.println(sol.lengthOfLastWord(str));
    }
}
