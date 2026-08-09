import java.io.*;
import java.util.*;

public class TestClass {
    public static void main(String args[] ) throws Exception {
       Scanner s = new Scanner(System.in);
       int cases = s.nextInt();
       for(int c=0; c<cases; c++) {
           int N = s.nextInt();
           long arr = s.nextLong();
           long ans = arr;
           StringBuilder sb = new StringBuilder();
           sb.append(ans + " ");
           for(int i=1; i<N; i++) {
               arr = s.nextLong();
               long temp = ans;
               if(temp % arr == 0) {
                   ans = temp;
               }
               else {
                   if(temp < arr) {
                       ans = arr;
                   }
                   else {
                       ans = temp + arr - (temp % arr);
                   }
               }
               sb.append(ans + " ");
           }
           System.out.println(sb.toString());
       }
   }
}
