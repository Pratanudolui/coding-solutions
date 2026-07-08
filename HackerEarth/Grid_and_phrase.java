import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
class TestClass {
    public static void main(String args[] ) throws Exception
    {
        Scanner sc=new Scanner(System.in);
        int r=sc.nextInt();
        int c=sc.nextInt();
        String search="saba";
        String row="";
        String column="";
        String upperDiagonal="";
        String lowerDiagonal="";
        int count=0;
        String str="";
        
        char a[][]=new char[r][c];
        for(int i=0;i<r;i++)
        {
            str=sc.next().toLowerCase();
            for(int j=0;j<c;j++)
            {
                a[i][j]=str.charAt(j);
            }
            str="";
        }
        for(int a1=0; a1<r; a1++)
        {
            for(int b=0; b<c; b++)
            {
                if(b+3<=c-1)
                {
                    if(a[a1][b]=='s' && a[a1][b+1]=='a' && a[a1][b+2]=='b' && a[a1][b+3]=='a')
                    {
                        count++;
                    }
                }
                if(a1+3<=r-1)
                {
                    if(a[a1][b]=='s' && a[a1+1][b]=='a' && a[a1+2][b]=='b'&& a[a1+3][b]=='a')
                    {
                        count++;
                    }
                }
                if(a1+3<=r-1 && b+3<=c-1)
                {
                    if(a[a1][b]=='s' && a[a1+1][b+1]=='a' && a[a1+2][b+2]=='b' && a[a1+3][b+3] =='a')
                    {
                        count++;
                    }
                }
                if(a1-3>=0 && b+3<=c-1)
                {
                    if(a[a1][b]=='s' && a[a1-1][b+1]=='a' && a[a1-2][b+2]=='b' && a[a1-3][b+3]=='a')
                    {
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
    }
}
