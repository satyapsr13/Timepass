import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.*;
import java.util.*;

public class MonocarpString {
    // author: satyapsr13
    static FastReader sc = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    static int countChar(String s, char x) {
        int count = 0;
        for (char ch : s.toCharArray()) {
            if (ch == x) {
                count++;
            }
        }
        return count;
    }

    static class Pair {
        public int a, b;

        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Pair))
                return false;
            Pair other = (Pair) o;
            return (a == other.a) && (b == other.b);
        }

        @Override
        public int hashCode() {
            return Objects.hash(a, b);
        }
    }

    static Pair getNext(Pair curr, Pair target, char ch) {
        int x = curr.a, y = curr.b;
        if (ch == '8') {
            if (target.a > curr.a) {
                x++;
            }
            if (target.b > curr.b) {
                y++;
            }

        } else {
            if (target.a > curr.a) {
                x++;
            } else if (target.b > curr.b) {
                y++;
            }

        }
        return new Pair(x, y);
    }

    static void solve() {
        // System.out.println(Objects.hash(4, 3,));
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