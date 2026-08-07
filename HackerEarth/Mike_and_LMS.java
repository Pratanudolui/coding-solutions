import java.util.Scanner;

class TestClass {

public static void main(String args[] ) throws Exception {

Scanner sc = new Scanner(System.in);

int len = sc.nextInt();

sc.nextLine();

            String name = sc.nextLine();

            String tag = "aa";

            for(int i=0;i<name.length();i++) {

                String check = name.substring(i,name.length());

                if(check.compareTo(tag)>0)

                    tag = check;

            }

            System.out.println(tag);

}

}
