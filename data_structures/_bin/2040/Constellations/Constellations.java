import java.math.BigInteger;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Name: Loh Yi Kuang Matric. No: A0238627W
 */

public class Constellations {

  public static void main(String args[]) {
    Kattio io = new Kattio(System.in);
    int n = io.getInt();
    int a = io.getInt();
    int b = io.getInt();
    Map<String, BigInteger> memoizer = new HashMap<>(); // Our hashmap to contain the computed values
    System.out.println(compute(n, a, b, memoizer).mod(BigInteger.valueOf(1000000007)));
  }

  static BigInteger compute(int n, int min, int max, Map<String, BigInteger> memoizer) {

    LinkedList<BigInteger> l = new LinkedList<>();

    if (n < 0) {
      return BigInteger.ZERO;
    }

    if (n < min) {
      return BigInteger.ONE;
    }

    for (int k = min; k < max + 1; k++) {
      // To handle the cases where n - k is potentially < 0 (We do not want to
      // calculate negative factorials)
      if (k <= n) {
        // Calculate the product and store it into a list which we can compute the sum
        // of later
        l.addLast(memoizedChoose(n, k, memoizer).multiply(compute(n - k, min, max, memoizer)));
      }
    }
    return sum(l);
  }

  /*
   * Iteratively sums the numbers in the list
   */
  static BigInteger sum(LinkedList<BigInteger> l) {
    BigInteger sums = BigInteger.ZERO;
    for (BigInteger i : l) {
      sums = sums.add(i);
    }
    return sums;
  }

  /*
   * We can memoize the main function, since it reuses alot of nCr combinations.
   */
  static BigInteger memoizedChoose(int n, int r, Map<String, BigInteger> memoizer) {
    // Create a unique n and r key.
    String key = String.valueOf(n) + " - " + String.valueOf(r);
    if (memoizer.containsKey(key)) {
      return memoizer.get(key);
    } else {
      BigInteger result = choose(n, r);
      memoizer.put(key, result);
      return result;
    }
  }

  static BigInteger choose(int n, int r) {
    int nmr = n - r + 1; // We cancel out the denominator (n - r)! from the numerator n!
    if (n == r) {
      return BigInteger.ONE;
    } else {
      BigInteger numerator = factorial(n, nmr);
      BigInteger denominator = factorial(r, 1);
      return numerator.divide(denominator);
    }
  }

  /*
   * Iteratively multiply the concurrent numbers
   */
  static BigInteger factorial(int big, int small) {
    BigInteger facVal = BigInteger.valueOf(small);
    for (int i = small + 1; i < big + 1; i++) {
      facVal = facVal.multiply(BigInteger.valueOf(i));
    }
    return facVal;
  }

}
