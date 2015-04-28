/**
 * Created by Administrator on 2015/4/5.
 */
public class CountAndSay {
    public String countAndSay(int n) {
        StringBuilder cur =  new StringBuilder("1");

        for (int i = 1; i < n; i++) {
            StringBuilder next = new StringBuilder();
            char c = cur.charAt(0);
            int count = 1;
            int j = 1;
            for (; j < cur.length(); ) {
                while (j < cur.length() && c == cur.charAt(j)) {
                    count += 1;
                    j++;
                }

                next.append((char)('0' + count)).append(c);
                if (j == cur.length()) {
                    break;
                }
                c = cur.charAt(j);
                count = 0;
            }

            if ( j == 1) {
                next.append((char)('0' + count)).append(c);
            }
            cur = next;
        }
        return cur.toString();
    }

    public static void main(String[] args) {
        CountAndSay sol = new CountAndSay();
        System.out.println(sol.countAndSay(2));
    }
}
