import java.io.*;
import java.util.*;

public class TestClass {
    private static void reverseRange(char[] arr, int left, int right) {
        while (left < right) {
            char tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        while (s != null && s.trim().isEmpty()) {
            s = br.readLine();
        }
        if (s == null) return;
        s = s.trim();

        String qLine = br.readLine();
        while (qLine != null && qLine.trim().isEmpty()) {
            qLine = br.readLine();
        }
        if (qLine == null) return;
        int q = Integer.parseInt(qLine.trim());

        char[] arr = s.toCharArray();
        for (int i = 0; i < q; i++) {
            String opLine = br.readLine();
            while (opLine != null && opLine.trim().isEmpty()) {
                opLine = br.readLine();
            }
            if (opLine == null) break;
            StringTokenizer st = new StringTokenizer(opLine);
            int ind = Integer.parseInt(st.nextToken());
            char ch = st.nextToken().charAt(0);
            if (ind >= 1 && ind <= arr.length) {
                arr[ind - 1] = ch;
            }
        }

        String str = new String(arr);

        String mLine = br.readLine();
        while (mLine != null && mLine.trim().isEmpty()) {
            mLine = br.readLine();
        }
        int m = (mLine == null) ? 0 : Integer.parseInt(mLine.trim());

        for (int i = 0; i < m; i++) {
            String revLine = br.readLine();
            while (revLine != null && revLine.trim().isEmpty()) {
                revLine = br.readLine();
            }
            if (revLine == null) break;
            StringTokenizer st = new StringTokenizer(revLine);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            reverseRange(arr, a - 1, b - 1);
        }

        String fin = new String(arr);

        int sameCount = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == fin.charAt(i)) {
                sameCount++;
            }
        }

        StringBuilder out = new StringBuilder();
        out.append(str).append('\n');
        out.append(fin).append('\n');
        out.append(sameCount).append('\n');
        System.out.print(out.toString());
    }
}
