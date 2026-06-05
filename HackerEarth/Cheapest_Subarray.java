import java.io.*;
public class Main{
    static class FS{
        private final InputStream in=System.in;
        private final byte[] b=new byte[1<<16];
        private int p=0,l=0;
        private int r()throws IOException{
            if(p>=l){
                l=in.read(b);
                p=0;
                if(l==-1)
                return-1;
            }
            return b[p++];
        }
        int nextInt()throws IOException{
            int c;
            while((c=r())<=32);
            int x=0;
            do{
                x=x*10+c-'0';
            }
            while((c=r())>32);
            return x;
        }
    }
    public static void main(String[] args)throws Exception{
        FS fs=new FS();
        StringBuilder sb=new StringBuilder();
        int t=fs.nextInt();
        while(t-->0){
            int n=fs.nextInt();
            int prev=fs.nextInt();
            long ans=Long.MAX_VALUE;
            for(int i=1;i<n;i++){
                int cur=fs.nextInt();
                ans=Math.min(ans,(long)prev+cur);
                prev=cur;
            }
            sb.append(ans).append('\n');
        }
        System.out.print(sb);
    }
}
