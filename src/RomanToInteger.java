import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2015/4/5.
 */
public class RomanToInteger {
    private static Map<Character, Integer> romanTable = new HashMap<Character, Integer>();
    static {
        romanTable.put('I', 1);
        romanTable.put('V', 5);
        romanTable.put('X', 10);
        romanTable.put('L', 50);
        romanTable.put('C', 100);
        romanTable.put('D', 500);
        romanTable.put('M', 1000);
    }

    public int romanToInt(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        int sum = 0;
        int pre = Integer.MIN_VALUE;

        for (int i = s.length()-1; i >= 0; i--) {
            char c = s.charAt(i);
            int val = romanTable.get(c);

            if (pre <= val) {
                sum +=  val;
            } else {
                sum -= val;
            }
            pre = val;
        }

        return sum;
    }

    public static void main(String[] args) {
        RomanToInteger romanToInteger = new RomanToInteger();
        int result = romanToInteger.romanToInt("CXCIX");
        System.out.println(result);
    }
}
