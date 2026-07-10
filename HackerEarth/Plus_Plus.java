import java.io.*;
import java.util.*; 
public class Main{
    static class FastScanner{
        private final InputStream in=System.in;
        private final byte[]buffer=new byte[1<<16];
        private int ptr=0,len=0;
        private int read()throws IOException{
            if(ptr>=len){
                len=in.read(buffer);
                ptr=0;
                if(len<=0)return-1;
            }
            return buffer[ptr++];
        }
        int nextInt()throws IOException{
            int c;while((c=read())<=' ');
            int x=0;
            while(c>' '){
                x=x*10+c-'0';
                c=read();
            }
            return x;
        }
    }
    static class Plus{
        int[]r=new int[5],c=new int[5],v=new int[5];
    }
    public static void main(String[]args)throws Exception{
        FastScanner fs=new FastScanner();
        int n=fs.nextInt(),m=fs.nextInt();
        int[][]a=new int[n][m];
        for(int i=0;i<n;i++)
        for(int j=0;j<m;j++)
        a[i][j]=fs.nextInt();
        ArrayList<Plus>list=new ArrayList<>();
        for(int i=1;i<n-1;i++)
        for(int j=1;j<m-1;j++){
            Plus p=new Plus();
            p.r[0]=i;
            p.c[0]=j;
            p.v[0]=a[i][j];
            p.r[1]=i-1;
            p.c[1]=j;
            p.v[1]=a[i-1][j];
            p.r[2]=i+1;
            p.c[2]=j;
            p.v[2]=a[i+1][j];
            p.r[3]=i;
            p.c[3]=j-1;
            p.v[3]=a[i][j-1];
            p.r[4]=i;
            p.c[4]=j+1;
            p.v[4]=a[i][j+1];
            list.add(p);
        }
        long ans=Long.MIN_VALUE;
        for(int i=0;i<list.size();i++)
        {
            Plus x=list.get(i);
            for(int j=i+1;j<list.size();j++)
            {
                Plus y=list.get(j);
                boolean ok=true;
                for(int p=0;p<5&&ok;p++)
                for(int q=0;q<5;q++)
                if(x.r[p]==y.r[q]&&x.c[p]==y.c[q]){
                    ok=false;break;
                }
                if(!ok)continue;
                long cur=0;
                for(int k=0;k<5;k++)
                cur+=1L*x.v[k]*y.v[k];
                if(cur>ans)ans=cur;
            }
        }
        System.out.print(ans);
    }
}
