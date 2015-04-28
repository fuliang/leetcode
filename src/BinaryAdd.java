/**
 * Created by Administrator on 2015/4/6.
 */
public class BinaryAdd {

    static class Result {
        char sum;
        char inc;

        Result(char sum, char inc) {
            this.sum = sum;
            this.inc = inc;
        }
    }

    Result addBin(char c1, char c2) {
        if (c1 == '0') {
            return new Result(c2, '0');
        }

        if (c2 == '0') {
            return new Result(c1, '0');
        }

        return new Result('0', '1');
    }

    public String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;

        char inc = '0';
        StringBuilder sb = new StringBuilder();

        while (i >= 0 && j >= 0) {
            char c1 = a.charAt(i);
            char c2 = b.charAt(j);
            Result r1 = addBin(c1, c2);
            Result r2 = addBin(r1.sum, inc);
            sb.append(r2.sum);
            Result r3 = addBin(r1.inc, r2.inc);
            inc = r3.sum;
            i--;
            j--;
        }

        int leftIndex;
        String leftStr;

        if (i < 0) {
            leftIndex = j;
            leftStr = b;
        } else {
            leftIndex = i;
            leftStr = a;
        }

        while (leftIndex >= 0) {
            char c1 = leftStr.charAt(leftIndex);
            Result r = addBin(c1, inc);
            sb.append(r.sum);
            inc = r.inc;
            --leftIndex;
        }

        if (inc != '0') {
            sb.append(inc);
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        BinaryAdd binaryAdd = new BinaryAdd();
        System.out.println(binaryAdd.addBinary("1", "111"));
    }
}
