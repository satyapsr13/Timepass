import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.*;
import java.util.*;

public class B {
    // author: satyapsr13
    static FastReader sc = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    static boolean isSqr(int n) {
        int a = (int) Math.sqrt(n);
        return a * a == n;
    }

    static int solve(int a, int b) {
        // int n = sc.nextInt();

        int idx = 1;

        while (true) {

            if (isSqr(idx)) {
                if (b < idx) {
                    break;
                }
                b -= idx;
                idx *= 2;
                // System.out.println("Making from b: " + idx);
            } else {
                if (a < idx) {
                    break;
                }
                a -= idx;
                idx *= 2;
                // System.out.println("Making from a: " + idx);

            }
        }
        // out.println(idx);
        return idx;
        // while (reqA<= a && reqB <= b) {

        // }

    }

    static int getPowerOfTwo(int n) {
        int power = 0;
        while (n > 1) {
            n >>= 1;
            power++;
        }
        return power;
    }

    public static void main(String[] args) {
        int t = sc.nextInt();
        while (t-- > 0) {

            int a = sc.nextInt();
            int b = sc.nextInt();
            // solve();
            System.out.println(getPowerOfTwo(Math.max(solve(a, b), solve(b, a))));
        }
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

    static void printArr(Object arr) {
        int len = Array.getLength(arr);
        for (int i = 0; i < len; i++) {
            if (i > 0)
                out.print(" ");
            out.print(Array.get(arr, i));
        }
        out.println();
    }
}
