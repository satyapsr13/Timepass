import java.util.Scanner;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        if (sc.hasNextInt()) {
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();

                // Find the largest power of 2 <= n
                int k = 1;
                while (k * 2 <= n) {
                    k *= 2;
                }

                // Print from k to n
                for (int i = k; i <= n; i++) {
                    out.print(i + " ");
                }
                // Print from 1 to k-1
                for (int i = 1; i < k; i++) {
                    out.print(i + (i == k - 1 ? "" : " "));
                }
                out.println();
            }
        }
        out.close();
    }
}