/**
 * Created by Administrator on 2015/4/5.
 */
public class ExcelSheetColumnTitle {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();

        while (n >= 1) {
            char c = (char)('A' + (n-1) % 26);
            sb.append(c);
            n = (n - 1) / 26;
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        ExcelSheetColumnTitle s = new ExcelSheetColumnTitle();
        String result = s.convertToTitle(27);
        System.out.println(result);
    }
}
