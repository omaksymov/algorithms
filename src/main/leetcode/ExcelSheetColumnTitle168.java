package leetcode;

public class ExcelSheetColumnTitle168 {

    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        char c;
        int tmp;
        while (n != 0) {
            tmp = n - 1;
            c = (char) ('A' + tmp % 26);
            sb.append(c);
            n = tmp / 26;
        }
        return sb.reverse().toString();
    }
}
