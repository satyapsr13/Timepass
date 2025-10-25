import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.*;
import java.util.*;

public class B {

    static FastReader sc = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);
    static int MAX = 998244353;

    static int mod(int i) {
        return i % MAX;
    }

    public static void debugDp(int[][] dp) {
        System.out.println("DP Table:");
        for (int i = 0; i < dp.length; i++) {
            System.out.print("Row " + i + ": ");
            for (int j = 0; j < dp[i].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("--------------------");
    }

    static void solve() {
        int n = sc.nextInt();
        int[] a = sc.nextArray(n);
        int[] b = sc.nextArray(n);
        int[][] dp = new int[n][2];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        dp[0][0] = 1;
        dp[0][1] = 1;
        for (int i = 1; i < n; ++i) {

            int notSwap = 0;
            if ((a[i - 1] <= a[i]) && (b[i - 1] <= b[i]) && dp[i - 1][0] != 0) {
                notSwap = mod(dp[i - 1][0]);
                System.out.println("Not reverse");

            }
            if ((b[i - 1] <= a[i]) && (a[i - 1] <= b[i]) && dp[i - 1][1] != 0) {
                notSwap += mod(dp[i - 1][1]);
                System.out.println("Reverse i-1");
            }
            dp[i][0] = notSwap;
            debugDp(dp);
            int swap = 0;
            if ((a[i - 1] <= b[i]) && (b[i - 1] <= a[i]) && dp[i - 1][0] != 0) {
                swap = mod(dp[i - 1][0] + 1);
                // System.out.println("Reverse i-1");

            }
            if ((b[i - 1] <= b[i]) && (a[i - 1] <= a[i]) && dp[i - 1][1] != 0) {
                swap += mod(dp[i - 1][1] + 1);

            }
            dp[i][1] = swap;
            debugDp(dp);

        }
        System.out.println(dp[n - 1][0] + dp[n - 1][1]);

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
