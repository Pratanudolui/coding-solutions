import java.io.*;

public class TestClass {
    private static final byte[] BUF = new byte[1 << 16];
    private static int head = 0, tail = 0;
    private static InputStream in;

    private static int readByte() throws IOException {
        if (head >= tail) {
            head = 0;
            tail = in.read(BUF, 0, BUF.length);
            if (tail <= 0) return -1;
        }
        return BUF[head++];
    }

    private static int nextInt() throws IOException {
        int c = readByte();
        while (c <= ' ') {
            if (c == -1) return -1;
            c = readByte();
        }
        int res = 0;
        while (c > ' ') {
            res = res * 10 + (c - '0');
            c = readByte();
        }
        return res;
    }

    public static void main(String[] args) throws Exception {
        in = System.in;
        int n = nextInt();
        if (n <= 0) return;
        int q = nextInt();

        int[] bit = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            bit[i] = i & -i;
        }

        boolean[] isZero = new boolean[n + 1];
        int totalOnes = n;
        int maxStep = Integer.highestOneBit(n);

        StringBuilder out = new StringBuilder();

        for (int qi = 0; qi < q; qi++) {
            int type = nextInt();
            int val = nextInt();

            if (type == 0) {
                if (val >= 1 && val <= n && !isZero[val]) {
                    isZero[val] = true;
                    totalOnes--;
                    for (int idx = val; idx <= n; idx += idx & -idx) {
                        bit[idx]--;
                    }
                }
            } else {
                if (val <= 0 || val > totalOnes) {
                    out.append("-1\n");
                } else {
                    int pos = 0;
                    int acc = 0;
                    for (int step = maxStep; step > 0; step >>= 1) {
                        int next = pos + step;
                        if (next <= n && acc + bit[next] < val) {
                            pos = next;
                            acc += bit[next];
                        }
                    }
                    out.append(pos + 1).append('\n');
                }
            }
        }

        System.out.print(out.toString());
    }
}
