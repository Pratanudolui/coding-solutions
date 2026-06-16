import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[]args)throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine().trim());
        StringBuilder sb=new StringBuilder();
        while(T-->0){
            int n=Integer.parseInt(br.readLine().trim());
            StringTokenizer st=new StringTokenizer(br.readLine());
            int xor=0;
            for(int i=0;i<n;i++){
                long x=Long.parseLong(st.nextToken());
                int c=0;
                while((x&1)==0){
                    c++;
                    x>>=1;
                }
                xor^=(c&1);
            }
            sb.append(xor!=0?"Charlie":"Alan").append('\n');
        }
        System.out.print(sb);
    }
}
