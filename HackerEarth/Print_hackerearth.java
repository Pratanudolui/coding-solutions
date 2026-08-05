import java.util.Arrays;
import java.util.Scanner;

class die {
        public void zn(String m){
            float[] a = new float[7];
            for (int i =0;i<m.length();i++){
                float [] b =cu(m.charAt(i));
                for (int j =0;j<b.length;j++){
                    a[j] = a[j] + b[j];
                }
            }
            Arrays.sort(a);
            System.out.println((int)a[0]);
        }
        public float[] cu(char n){
             float[] b = {0,0,0,0,0,0,0};
            if (n=='h'){b[0]++;}
            if (n=='a'){b[1]++;}
            if (n=='c'){b[2]++;}
            if (n=='k'){b[3]++;}
            if (n=='e'){b[4]++;}
            if (n=='r'){b[5]++;}
            if (n=='t'){b[6]++;}
            b[0] = b[0]/2; b[1] = b[1]/2; b[4]= b[4]/2 ; b[5]=b[5]/2;
            return new float[] {b[0],b[1],b[2],b[3],b[4],b[5],b[6]};
        }

}

public class TestClass {

    public static void main(String[] args) {
        Scanner s5 = new Scanner(System.in);
        die d = new die();
        int a = s5.nextInt();
        String s = s5.next();
        d.zn(s);
    }
}
