import java.io.*;
public class TestClass{
    public static void main(String[] args)throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String s=br.readLine();
        char c=s.charAt(2);
        if("AEIOUY".indexOf(c)>=0){
            System.out.print("invalid");
            return;
        }
        if(((s.charAt(0)-'0'+s.charAt(1)-'0')&1)==1||((s.charAt(3)-'0'+s.charAt(4)-'0')&1)==1||((s.charAt(4)-'0'+s.charAt(5)-'0')&1)==1||((s.charAt(7)-'0'+s.charAt(8)-'0')&1)==1){
            System.out.print("invalid");
        }else 
        System.out.print("valid");
    }
}
