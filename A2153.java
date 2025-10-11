import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class A2153 {
    static FastReader sc = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    static boolean isBitSet(int n, int i) {
        return (n & (1 << i)) != 0;
    }

    static int setBit(int n, int i) {
        return n | (1 << i);
    }

    static void solve() {

        int x = sc.nextInt();
        int y = sc.nextInt();
        int z = sc.nextInt();
        int a = 0, b = 0, c = 0;
        // 1. visit all bits from 31th to 0
        for (int i = 0; i <= 31; ++i) {
            if (isBitSet(x, i)) {
                a = setBit(a, i);
                b = setBit(b, i);
            }
        }
        for (int i = 0; i <= 31; ++i) {
            if (isBitSet(y, i)) {
                c = setBit(c, i);
                b = setBit(b, i);
            }
        }
        for (int i = 0; i <= 31; ++i) {
            if (isBitSet(z, i)) {
                a = setBit(a, i);
                c = setBit(c, i);
            }
        }
        if ((a & b) != x) {
            System.out.println("NO");
            return;
        }
        if ((c & b) != y) {
            System.out.println("NO");
            return;
        }
        if ((a & c) != z) {
            System.out.println("NO");
            return;
        }
        System.out.println("YES");

    }

    public static void main(String[] args) {
        int t = sc.nextInt();
        while (t-- > 0)
            solve();
        out.flush();
    }

    // --- Utility Classes/Methods Below ---
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        int[] nextArray(int n) {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = nextInt();
            return arr;
        }

        String[] nextStringArray(int n) {
            String[] arr = new String[n];
            for (int i = 0; i < n; i++)
                arr[i] = next();
            return arr;
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
