import java.io.InputStream;

public class TestClass {

    // Fast Scanner for IO efficiency
    static class FastScanner {
        private final InputStream in = System.in;
        private final byte[] buffer = new byte[1024 * 64];
        private int ptr = 0;
        private int buflen = 0;

        private boolean hasNextByte() {
            if (ptr < buflen) return true;
            ptr = 0;
            try {
                buflen = in.read(buffer, 0, buffer.length);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return buflen > 0;
        }

        private int readByte() {
            return hasNextByte() ? buffer[ptr++] : -1;
        }

        public boolean hasNext() {
            int b = readByte();
            while (b != -1 && b <= ' ') {
                b = readByte();
            }
            if (b == -1) return false;
            ptr--;
            return true;
        }

        public String next() {
            if (!hasNext()) return null;
            StringBuilder sb = new StringBuilder();
            int b = readByte();
            while (b > ' ') {
                sb.appendCodePoint(b);
                b = readByte();
            }
            return sb.toString();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();
        if (!fs.hasNext()) return;

        int t = fs.nextInt();
        StringBuilder out = new StringBuilder();

        while (t-- > 0) {
            String s = fs.next();
            if (s == null) continue;

            int openRound = 0, closeRound = 0;
            int openSquare = 0, closeSquare = 0;
            int openCurly = 0, closeCurly = 0;

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '(') openRound++;
                else if (c == ')') closeRound++;
                else if (c == '[') openSquare++;
                else if (c == ']') closeSquare++;
                else if (c == '{') openCurly++;
                else if (c == '}') closeCurly++;
            }

            int ans = 2 * Math.min(openRound, closeRound)
                    + 2 * Math.min(openSquare, closeSquare)
                    + 2 * Math.min(openCurly, closeCurly);

            out.append(ans).append("\n");
        }

        System.out.print(out);
    }
}
