/**
 * Created by fuliang on 2015/4/8.
 *  https://leetcode.com/problems/zigzag-conversion/
 *  The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 *
 * And then read line by line: "PAHNAPLSIIGYIR"
 *
 * Write the code that will take a string and make this conversion given a number of rows:
 *
 * string convert(string text, int nRows);
 *
 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 */
public class ZigZagConversion {
    public String convert(String s, int nRows) {
        if (nRows == 1)
            return s;

        int j = 0;
        StringBuilder sb = new StringBuilder();
        //first line [0, 2nRow-2, 4nRow-4, ...] -> 2 * j (nRows -1)

        while (2 * j * (nRows-1) < s.length()) {
            sb.append(s.charAt(2 * j * (nRows-1)));
            ++j;
        }
        //middle lines [i, 2nRow-2 - i, 2nRow-2 + i, 4nRow-4-i, 4nRow-4 + i...] -> j * 2 * (nRow - 1) + i, j * 2 * (nRow -1) - i
        for (int i = 1; i < nRows-1; i++) {
            for (j = 0; ; j++) {
                int index = j * 2 * (nRows-1) + i;
                if (index < s.length()) {
                    sb.append(s.charAt(index));
                } else {
                    break;
                }

                index  = (j+1) * 2 * (nRows - 1) - i;
                if (index < s.length()) {
                    sb.append(s.charAt(index));
                } else {
                    break;
                }
            }
        }
        //last line: [m-1, 3m-3, 5m-5, ..]
        j = 0;
        while ((2 * j + 1) * (nRows - 1) < s.length()) {
            sb.append(s.charAt((2 * j + 1) * (nRows - 1)));
            j++;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        ZigZagConversion sol = new ZigZagConversion();
        String result = sol.convert("PAYPALISHIRING", 3);
        System.out.println(result);
    }
}
