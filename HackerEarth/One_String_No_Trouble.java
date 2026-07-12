import java.util.Scanner;

class TestClass {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        String str = s.next();

        int count = 0;

        int max = 0;

        for (int i = 1; i < str.length(); i++) {

            char ch = str.charAt(i - 1);

            char ch1 = str.charAt(i);


            if (ch != ch1) {

                count++;

                if (max < count) {

                    max = count;

                }

            } else {

                count = 0;

            }

        }

        System.out.println(max + 1);
    }
}
