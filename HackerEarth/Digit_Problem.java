import java.util.*;
import java.io.*;
class TestClass {
    public static void main(String args[] ) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine()," ");
        String x=st.nextToken();
        int k=Integer.parseInt(st.nextToken());
        char arr[]=x.toCharArray();
        int i=0;
        while(k != 0){
            if(arr[i] !='9'){
                arr[i]='9';
                k--;
            }
            i++;
        }
        System.out.println(new String(arr));
    }
}
