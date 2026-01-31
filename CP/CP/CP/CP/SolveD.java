import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.*;
import java.util.*;

public class SolveD {
    // author: satyapsr13
    static FastReader sc = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    static void solve() {
        int x = sc.nextInt();
        int y = sc.nextInt();

        int p = x;
        int q = y;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < 31; ++i) {
            if (((p & (1 << i)) != 0) && ((q & (1 << i)) != 0)) {
                if (stack.isEmpty()) {

                    p = p & (~((1 << i)));
                } else {
                    while (!stack.isEmpty()) {

                        p = p | (1 << stack.pop());

                    }
                    p = p & (~((1 << i)));
                }
            }

            if (((p & (1 << i)) == 0) && ((q & (1 << i)) == 0)) {
                // p = p & (~((1 << i)));
                stack.push(i);
            }
        }
        System.out.println(p + " " + q);

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
