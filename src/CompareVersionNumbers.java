/**
 * Created by Administrator on 2015/4/5.
 */
public class CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        String[] version1Segs = version1.split("\\.");
        String[] version2Segs = version2.split("\\.");

        int i = 0;
        int minLen = Math.min(version1Segs.length, version2Segs.length);

        for (i = 0; i < minLen; i++) {
            int num1 = Integer.parseInt(version1Segs[i]);
            int num2 = Integer.parseInt(version2Segs[i]);
            if (num1 != num2) {
                return Integer.compare(num1, num2);
            }
        }

        String[] maxSegs = version1Segs.length > version2Segs.length ? version1Segs : version2Segs;

        boolean allZeros = true;
        for (i = minLen; i < maxSegs.length; i++) {
            int tmp = Integer.parseInt(maxSegs[i]);
            if (tmp  != 0) {
                allZeros = false;
            }
        }

        if (allZeros) return 0;
        return Integer.compare(version1Segs.length, version2Segs.length);
    }

    public static void main(String[] args) {
        CompareVersionNumbers sol = new CompareVersionNumbers();
        System.out.println(sol.compareVersion("1.0", "1"));
    }
}
