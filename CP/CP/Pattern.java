import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.*;
import java.util.*;

public class Pattern {
    static FastReader sc = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    static boolean isPrint(int i, int j, int n, int m) {
        if (!(j - i < (n + m) / 4))
            return true;
        if (!(i - j < (n + m) / 4))
            return true;
        // if ((i + j < (n + m) / 2))
        String ans=Integer.toBinaryString(i);
        // return false;
        return false;
    }

    static void solve() {
        int n = sc.nextInt();
        for (int i = 0; i < 10; ++i) {

            for (int j = 0; j < 10; ++j) {
                // if (i == 0 || j == 0) {
                // if (i == 0) {
                // System.out.print(j + " ");
                // } else {
                // System.out.print(i + " ");

                // }
                // continue;
                // }
                if (isPrint(i, j, 10, 10)) {

                    System.out.print("* ");
                }
            }
            System.out.println();
        }
        // your logic here
        // out.println("Your answer");
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
