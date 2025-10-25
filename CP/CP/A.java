import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.*;
import java.util.*;

public class A {
    static FastReader sc = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    static int query1(int l, int r) {
        System.out.println(1 + " " + l + " " + r);
        out.flush();
        return sc.nextInt();
    }

    static int query2(int l, int r) {
        System.out.println(2 + " " + l + " " + r);
        out.flush();
        return sc.nextInt();
    }

    static int getSize(int n) {
        return query2(1, n) - query1(1, n);
    }

    static void solve() {
        int n = sc.nextInt();

        int k = getSize(n); // size of the changed interval
        int l = 1, r = n - k + 1; // possible left boundaries

        while (l < r) {
            int mid = l + (r - l) / 2;
            int q1 = query1(mid, n);
            int q2 = query2(mid, n);
            if (q2 - q1 == 0) {
                r = mid - 1; // possible left boundary, tighten search
            } else {
                l = mid;
            }
        }

        // Now [l, l+k-1] is the modified interval
        System.out.println("! " + (l - 1) + " " + (l + k - 2));
        System.out.flush();
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
