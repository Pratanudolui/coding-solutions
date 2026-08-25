import java.io.*;

public class TestClass {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine().trim());
        String str = br.readLine().trim();
        
        int minm = 0;
        int maxm = 0;
        int v = 0;
        
        for (int i = 0; i < n; i++) {
            char ch = str.charAt(i);
            
            if (ch == 'v' || ch == 'w') {
                v++;
                if (ch == 'w') {
                    v++;
                }
            } else {
                minm++;
                maxm++;
                minm += (v / 2);
                maxm += v;
                
                if ((v & 1) != 0) {
                    minm++;
                }
                
                v = 0;
            }
        }
        
        minm += (v / 2);
        maxm += v;
        
        if ((v & 1) != 0) {
            minm++;
        }
        
        System.out.println(minm + " " + maxm);
    }
}
