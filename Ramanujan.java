
public class Ramanujan {

    // Is n a Ramanujan number?
    public static boolean isRamanujan(long n) {
        int num = 0;
        long a = 0;
        for (long i = 1; i < Math.cbrt(n); i++) {
            long b = (long) Math.cbrt(n - i * i * i);
            if (i * i * i + b * b * b == n) {
                num++;
                a = i;
                break;
            }
        }
        for (long i = a + 1; i < Math.cbrt(n); i++) {
            long b = (long) Math.cbrt(n - i * i * i);
            if (i * i * i + b * b * b == n && b != a) {
                num++;
                break;
            }
        }

        if (num == 2) return true;
        return false;
    }

    public static void main(String[] args) {
        long n = Long.parseLong(args[0]);
        StdOut.println(isRamanujan(n));
    }
}


