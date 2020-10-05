
public class MaximumSquareSubmatrix {


    // Returns the size of the largest contiguous square submatrix
    // of a[][] containing only 1s.
    public static int size(int[][] a) {
        int n = a.length;
        int[][] b = new int[n][n];
        for (int i = 0; i < n; i++) {
            b[i][0] = a[i][0];
        }
        for (int i = 0; i < n; i++) {
            b[0][i] = a[0][i];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if (a[i][j] == 1) {
                    b[i][j] = Math.min(b[i - 1][j], Math.min(b[i][j - 1], b[i - 1][j - 1])) + 1;
                }
                else b[i][j] = 0;
            }
        }

        int maxsize = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (b[i][j] > maxsize) maxsize = b[i][j];
            }

        }

        return maxsize;
    }

    // Reads an n-by-n matrix of 0s and 1s from standard input
    // and prints the size of the largest contiguous square submatrix
    // containing only 1s.
    public static void main(String[] args) {
        int n = StdIn.readInt();
        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = StdIn.readInt();
            }
        }
        StdOut.println(size(a));
    }
}
