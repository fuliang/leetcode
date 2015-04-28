import java.util.*;

/**
 * Created by fuliang on 2015/4/9.
 * https://leetcode.com/problems/repeated-dna-sequences/
 *
 *  All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.
 * Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.
 * For example,
 * Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",
 * Return:
 * ["AAAAACCCCC", "CCCCCAAAAA"].
 *
 * Direct use Set<String> will Out of the memory limit.
 */
public class RepeatedDnaSequences {
    public List<String> findRepeatedDnaSequences(String s) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        List<String> result = new ArrayList<String>();

        for (int i = 0; i <= s.length() - 10; i ++) {
            String subStr = s.substring(i, i+10);
            int code = code2Int(subStr);
            Integer count = map.get(code);
            if (count == null) {
                count = 0;
            }
            count += 1;
            map.put(code, count);

            if (count == 2) {
                result.add(subStr);
            }
        }
        return result;
    }

    public int ch2Int(char c) {
        switch (c) {
            case 'A':
                return 0;
            case 'C':
                return 1;
            case 'G':
                return 2;
            case 'T':
                return 3;
        }
        return -1;
    }

    public int code2Int(String str) {
        int code = 0;
        for (int i = 0; i < str.length();  i++) {
            code = code * 4 + ch2Int(str.charAt(i));
        }
        return code;
    }

    public static void main(String[] args) {
        RepeatedDnaSequences sol = new RepeatedDnaSequences();
        //String s =  "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        String s = "AAAAAAAAAAAA";
        List<String> result = sol.findRepeatedDnaSequences(s);
        for (String s1 : result) {
            System.out.println(s1);
        }
    }
}
