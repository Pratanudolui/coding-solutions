import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[]args)throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));int n=Integer.parseInt(br.readLine().trim());StringTokenizer st=new StringTokenizer(br.readLine());
        TreeMap<Integer,Integer> cnt=new TreeMap<>();
        long size=n;
        for(int i=0;i<n;i++){
            int x=Integer.parseInt(st.nextToken());
            cnt.put(x,cnt.getOrDefault(x,0)+1);
        }
        int q=Integer.parseInt(br.readLine().trim());
        StringBuilder ans=new StringBuilder();
        for(int i=0;i<q;i++){
            int v=Integer.parseInt(br.readLine().trim());
            int mx=cnt.lastKey();
            boolean ok=false;
            if(v>mx)ok=true;
            else if(v<mx&&cnt.getOrDefault(v,0)<2)
            ok=true;
            if(ok){
                cnt.put(v,cnt.getOrDefault(v,0)+1);
                size++;
            }
            ans.append(size).append('\n');
        }
            List<Integer> inc=new ArrayList<>(),dec=new ArrayList<>();
            int mx=cnt.lastKey();
            for(Map.Entry<Integer,Integer> e:cnt.entrySet()){
                int x=e.getKey(),c=e.getValue();
                inc.add(x);
                if(x!=mx&&c==2)dec.add(x);
            }
            for(int x:inc)
            ans.append(x).append(' ');
            for(int i=dec.size()-1;i>=0;i--)
            ans.append(dec.get(i)).append(i==0?"":" ");
            System.out.print(ans.toString().trim());
    }
}
