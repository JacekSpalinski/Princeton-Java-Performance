
public class Inversions {

    // Return the number of inversions in the permutation a[].
    public static long count(int[] a) {
        int n = a.length;
        long k = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (a[i] > a[j]) k++;
            }
        }
        return k;
    }

    // Return a permutation of length n with exactly k inversions.
    public static int[] generate(int n, long k) {
        int[] b = new int[n];
        int move = 0;
        int stay = 1;

        for (int i = n - 1; i > 0; i--) {
            if (k >= i) {
                k = k - i;
                b[move] = i;
                move++;
            }
            else {
                b[n - stay] = i;
                stay++;
            }
        }

        return b;
    }

    // Takes an integer n and a long k as command-line arguments,
    // and prints a permutation of length n with exactly k inversions.
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        long k = Long.parseLong(args[1]);
        int[] c = generate(n, k);
        for (int i = 0; i < n; i++) {
            StdOut.print(c[i] + " ");
        }
        StdOut.println();
    }
}
