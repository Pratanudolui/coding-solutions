import java.io.*r;
import java.util.*;

public class TestClass {
    private static final int MAX_VAL = 1000000;
    private static boolean[] isPrime = new boolean[MAX_VAL + 1];

   
    private static void sieve() {
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for (int p = 2; p * p <= MAX_VAL; p++) {
            if (isPrime[p]) {
                for (int i = p * p; i <= MAX_VAL; i += p) {
                    isPrime[i] = false;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        sieve();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String line = br.readLine();
        if (line == null) return;
        int n = Integer.parseInt(line.trim());

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        ArrayList<Integer> primes = new ArrayList<>();
        ArrayList<Integer> composites = new ArrayList<>();

        
        for (int i = 0; i < n; i++) {
            if (isPrime[arr[i]]) {
                primes.add(arr[i]);
            } else {
                composites.add(arr[i]);
            }
        }

        StringBuilder sb = new StringBuilder();

       
        for (int i = 0; i < primes.size(); i++) {
            sb.append(primes.get(i)).append(" ");
        }
        sb.append("\n");

     
        for (int i = composites.size() - 1; i >= 0; i--) {
            sb.append(composites.get(i)).append(" ");
        }

        System.out.println(sb.toString().trim());
    }
}
