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

    private static long nextLong() throws IOException {
        int c = readByte();
        while (c <= ' ') {
            if (c == -1) return Long.MIN_VALUE;
            c = readByte();
        }
        long sign = 1L;
        if (c == '-') {
            sign = -1L;
            c = readByte();
        }
        long res = 0L;
        while (c > ' ') {
            res = res * 10L + (c - '0');
            c = readByte();
        }
        return res * sign;
    }

    public static void main(String[] args) throws Exception {
        in = System.in;
        long tVal = nextLong();
        if (tVal == Long.MIN_VALUE || tVal <= 0) return;
        int t = (int) tVal;

        StringBuilder out = new StringBuilder();
        for (int tc = 0; tc < t; tc++) {
            long nVal = nextLong();
            if (nVal == Long.MIN_VALUE) break;
            int n = (int) nVal;

            long maxStrength = 0L;
            for (int i = 0; i < n; i++) {
                long strength = nextLong();
                if (strength > 0L) {
                    maxStrength += strength;
                }
            }

            boolean possible = maxStrength > 0L && (maxStrength & (maxStrength - 1L)) == 0L;
            out.append(possible ? "Yes\n" : "No\n");
        }

        System.out.print(out.toString());
    }
}
