import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.*;
import java.util.*;

public class Solve {
    static FastReader sc = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    public static ArrayList<Integer> getPrimeFactors(ArrayList<Integer> primes, int target) {
        ArrayList<Integer> factors = new ArrayList<>();

        for (int prime : primes) {
            if (prime * prime > target)
                break; // optimization: stop if prime^2 > target
            while (target % prime == 0) {
                factors.add(prime);
                target /= prime;
            }
        }

        // if remaining target is > 1, it itself is a prime factor
        if (target > 1)
            factors.add(target);

        return factors;
    }

    static void solve() {
        int n = sc.nextInt();
        int[] a = sc.nextArray(n);
        int[] b = sc.nextArray(n);

        record Pair(String s, String s2) {
        }
        ;

        ArrayList<Pair> arr = new ArrayList<>(n);
       
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