import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.*;
import java.util.*;

public class A {
    // author: satyapsr13
    static FastReader sc = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    static int countTarget(int[] arr, int target) {
        int count = 0;
        for (int num : arr) {
            if (num == target)

            {
                count++;
            }
        }
        return count;
    }

    static void solve() {
        int n = sc.nextInt();
        int[] arr = sc.nextArray(n);

        int count1 = countTarget(arr, 1);
        if (count1 == n) {
            System.out.println("Alice");
            return;
        }
        if (count1 == 0 || (arr[0] == 0 && arr[n - 1] == 0)) {
            System.out.println("Bob");
            return;
        }
        System.out.println("Alice");
        return;
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
