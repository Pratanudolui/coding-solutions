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

    private static int nextToken(char[] dest) throws IOException {
        int c = readByte();
        while (c <= ' ') {
            if (c == -1) return 0;
            c = readByte();
        }
        int len = 0;
        while (c > ' ') {
            if (len < dest.length) {
                dest[len++] = (char) c;
            }
            c = readByte();
        }
        return len;
    }

    private static boolean isValidCarName(char[] s, int len) {
        if (len == 0 || len % 3 != 0) {
            return false;
        }

        int n = len / 3;
        char c1 = s[0];
        char c2 = s[n];
        char c3 = s[2 * n];

        if (c1 == c2 || c2 == c3 || c1 == c3) {
            return false;
        }

        for (int i = 0; i < n; i++) {
            if (s[i] != c1 || s[i + n] != c2 || s[i + 2 * n] != c3) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) throws Exception {
        in = System.in;
        int t = nextInt();
        if (t <= 0) return;

        char[] word = new char[1005];
        StringBuilder out = new StringBuilder(t * 7);

        for (int i = 0; i < t; i++) {
            int len = nextToken(word);
            out.append(isValidCarName(word, len) ? "OK\n" : "Not OK\n");
        }

        System.out.print(out.toString());
    }
}
