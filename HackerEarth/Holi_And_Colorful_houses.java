import java.io.*;
public class Main{
    static class FastScanner{
        private final InputStream in=System.in;
        private final byte[] buffer=new byte[1<<16];
        private int ptr=0,len=0;
        private int read() throws IOException{
            if(ptr>=len){
                len=in.read(buffer);
                ptr=0;
                if(len<=0)return -1;
            }
            return buffer[ptr++];
        }
        int nextInt() throws IOException{
            int c;
            while((c=read())<=32);
            int val=0;
            do{
                val=val*10+c-'0';
                c=read();
            }while(c>32);
            return val;
        }
        String next() throws IOException{
            int c;
            while((c=read())<=32);
            StringBuilder sb=new StringBuilder();
            do{
                sb.append((char)c);
                c=read();
            }while(c>32);
            return sb.toString();
        }
    }

    public static void main(String[] args)throws Exception{
        FastScanner fs=new FastScanner();
        StringBuilder ans=new StringBuilder();

        int T=fs.nextInt();

        while(T-->0){
            int N=fs.nextInt();
            int Q=fs.nextInt();

            String s=fs.next();

            int[] pref=new int[N+1];

            for(int i=1;i<N;i++)
                pref[i]=pref[i-1]+(s.charAt(i-1)!=s.charAt(i)?1:0);

            pref[N]=pref[N-1]+(s.charAt(N-1)!=s.charAt(0)?1:0);

            int total=pref[N];

            while(Q-->0){
                int x=fs.nextInt();
                int y=fs.nextInt();

                int cw;

                if(x<y)
                    cw=pref[y-1]-pref[x-1];
                else if(x>y)
                    cw=total-(pref[x-1]-pref[y-1]);
                else
                    cw=0;

                ans.append(Math.min(cw,total-cw)).append('\n');
            }
        }
        System.out.print(ans);
    }
}
