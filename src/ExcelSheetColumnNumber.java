/**
 * Created by Administrator on 2015/4/5.
 */
public class ExcelSheetColumnNumber {
    public int titleToNumber(String s) {
        int num = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            num *= 26;
            num += (c - 'A' + 1);
        }
        return num;
    }

    public static void main(String[] args) {
        String s = "AZ";
        ExcelSheetColumnNumber sol =  new ExcelSheetColumnNumber();
        System.out.println(sol.titleToNumber(s));
    }
}
