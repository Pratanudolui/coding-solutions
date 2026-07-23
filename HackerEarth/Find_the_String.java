import java.util.*;
import java.util.stream.*;

class TestClass {

    public static void main(String args[]) throws Exception {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {

            int n = sc.nextInt();
            int m = sc.nextInt();

            String[][] arr = new String[n][1];

            for (int j = 0; j < n; j++) {
                arr[j][0] = sc.next();
            }

            // System.out.println(Arrays.toString(arr[1])); o/p: [x, y, z]
            // System.out.println(arr[1]); o/p: xyz
            // System.out.println(arr[1].getClass().getSimpleName()); o/p: char[]

            String s1 = sc.next();

            int l = 0;
            boolean ans = true;

            while (s1.length() != l) {

                // String ls = Arrays.toString(arr[l%n]);

                if (arr[l % n][0].contains(String.valueOf(s1.charAt(l)))) {

                    ans = true;

                    arr[l % n][0] = arr[l % n][0].replaceFirst(
                            String.valueOf(s1.charAt(l)), "");

                    // arr[l%n][0] = ls;

                } else {

                    ans = false;
                    break;
                }

                l += 1;
            }

            if (ans == true) {

                System.out.println("Yes");

            } else {

                System.out.println("No");
            }
        }
    }
}
