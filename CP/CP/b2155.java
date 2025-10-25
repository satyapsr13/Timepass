import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.*;
import java.util.*;

public class b2155 {
    static FastReader sc = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    static void solve() {
        int n = sc.nextInt();
        int k = sc.nextInt();
        if (n == 1) {
            if (k == 1) {
                System.out.println("U");
                return;
            } else {
                System.out.println("NO");
                return;

            }
        }
        
        if (n == 2) {
            if (k == 4) {
                System.out.println("YES");
                System.out.println("UU");
                System.out.println("UU");
                return;
            } else {
                System.out.println("NO");
                return;

            }
        }
        ArrayList<StringBuilder> arr = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            arr.add(new StringBuilder("*".repeat(n)));
            // System.out.println(arr.get(i));
        }
        int ii = 0;
        while (ii < n && k-- > 0) {
            arr.get(0).setCharAt(ii, 'U');
            ii++;

        }
        ii = 1;
        while (ii < n && k-- > 0) {
            arr.get(ii).setCharAt(n - 1, 'R');
            ii++;

        }
        ii = 0;
        while (ii < n - 1 && k-- > 0) {
            arr.get(n - 1).setCharAt(ii, 'D');
            ii++;

        }
        ii = 1;
        while (ii < n - 1 && k-- > 0) {
            arr.get(ii).setCharAt(0, 'L');
            ii++;

        }
        if (k > 0) {
            System.out.println("NO");
            return;
        }
        System.out.println("YES");
        // System.out.println(arr);
        for (int i = 0; i < n; ++i) {

            for (int j = 0; j < n; ++j) {
                if (arr.get(i).charAt(j) == '*') {
                    // System.out.print("U");
                    if (i == 0) {
                        System.out.print("D");

                    } else if (i == n - 1) {

                        System.out.print("U");
                    }
                } else {
                    System.out.print(arr.get(i).charAt(j));

                }
            }
            System.out.println();
        }
        // for (int i = 0; i < n; ++i) {

        // for (int j = 0; j < n; ++j) {
        // System.out.print(ans[i].charAt(j));

        // }
        // System.out.println();
        // }

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
