import java.util.HashMap;

/**
 * Name: Loh Yi Kuang Metric. No:i A0238627W
 */

public class Macarons {
  public static void main(String args[]) {

    Kattio io = new Kattio(System.in);

    int n = io.getInt();
    int d = io.getInt();

    // Save macarons into an arr for later reference
    long[] macarons = new long[n];

    for (int i = 0; i < n; i++) {
      macarons[i] = io.getLong();
    }

    // We get the prefix remainders for the running sum of each macaron
    long[] remainderArr = new long[macarons.length];
    long count = 0;

    for (int i = 0; i < macarons.length; i++) {

      long r;

      if (i == 0) {
        r = macarons[i] % d;
      } else {
        r = ((remainderArr[i - 1] % d) + (macarons[i] % d)) % d;
      }
      remainderArr[i] = r;

      if (r == 0) {
        count++;
      }
    }

    HashMap<Long, Long> accumulator = new HashMap<Long, Long>();

    for (long r : remainderArr) {
      if (accumulator.containsKey(r)) {
        long val = accumulator.get(r);
        count += val;
        accumulator.put(r, val + 1);
      } else {
        accumulator.put(r, Long.valueOf(1));
      }
    }

    System.out.println(count);
  }

}