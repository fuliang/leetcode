/**
 * Created by Administrator on 2015/4/5.
 */
public class StringToInteger {
    public int atoi(String str) {
        str = str.trim();
        int num = 0;
        if (str.isEmpty())
            return 0;

        int i = 0;

        if (str.charAt(0) == '+' || str.charAt(0) == '-') {
            i++;
        }

        for (; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isDigit(c)) {
                if (num > 214748364) {
                    if (str.charAt(0) == '-') {
                        num = Integer.MIN_VALUE;
                    } else {
                        num = Integer.MAX_VALUE;
                    }
                    break;
                } else if (num == 214748364) {
                    if (str.charAt(0) == '-' && c > '7') {
                        num = Integer.MIN_VALUE;
                        break;
                    } else if (c > '7') {
                        num = Integer.MAX_VALUE;
                        break;
                    }
                }
                num *= 10;
                num += c - '0';
            } else{
                break;
            }
        }

        return str.charAt(0) == '-' && num > 0 ? -num: num;
    }

    public static void main(String[] args) {
        StringToInteger sol = new StringToInteger();
        System.out.println(sol.atoi("-2147483648"));
        System.out.println(Integer.MAX_VALUE);
    }
}
