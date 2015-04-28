import java.util.*;

/**
 * Created by fuliang on 2015/4/11.
 */
public class FractionToRecurringDecimal {
    public String fractionToDecimal(int numerator, int denominator) {
        long n = numerator;
        long d = denominator;

        if (numerator == 0) {
            return "0";
        }

        Map<Long, Integer> rem2Index = new HashMap<Long, Integer>();
        List<Long> divs = new ArrayList<Long>();

        int index = 0;
        long r = Long.MAX_VALUE;
        int sign = (numerator < 0 && denominator < 0) || (numerator > 0 && denominator > 0) ? 1 : -1;

        while (n != 0) {
            if (rem2Index.containsKey(r)) {
                break;
            } else {
                rem2Index.put(r, index);
            }


            long div =  n / d;
            divs.add(div);

            r =  n % d;

            n = r * 10;
            index += 1;
        }

        StringBuilder sb = new StringBuilder();

        long absDiv0 = Math.abs(divs.get(0));
        if (sign == -1)
            sb.append("-");
        sb.append(absDiv0);

        if (divs.size() > 1) {
            sb.append(".");
        }


        if (n == 0L) {
            for (int i = 1; i < divs.size(); i++) {
                sb.append(Math.abs(divs.get(i)));
            }
        } else {
            Integer remIndex = rem2Index.get(r);

            for (int i = 1; i < divs.size(); i++) {
                long div = Math.abs(divs.get(i));
                if (i == remIndex) {
                    sb.append("(").append(div);
                } else {
                    sb.append(div);
                }
            }
            sb.append(")");
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        FractionToRecurringDecimal sol = new FractionToRecurringDecimal();
        String result = sol.fractionToDecimal(-1, -2147483648);
        System.out.println(result);
    }
}
