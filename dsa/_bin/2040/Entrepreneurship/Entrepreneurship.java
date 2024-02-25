import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Name: Loh Yi Kuang Matric. No: A0238627W
 */

public class Entrepreneurship {
  public static void main(String args[]) {

    Kattio io = new Kattio(System.in);

    int n = io.getInt(); // The number of commands
    Double m = io.getDouble(); // The maximum number of pizzas u can sell

    LinkedList<Double> cashFlow = new LinkedList<>(); // This will store the amount that John will accumulate from each
                                                      // batch given the current m
    LinkedList<Double> mList = new LinkedList<>();
    mList.addLast(m); // Initialise with the first value of m

    for (int x = 0; x < n; x++) { // Reflects the number of commands there are

      m = mList.getLast();
      String command = io.getWord();
      Double batchValue = 0.0;

      if (command.equals("ADD")) { // There are two types of commands, either ADD or CANCEL

        int numOrders = io.getInt();
        String direction = io.getWord();

        if (direction.equals("L")) {

          for (int i = 0; i < numOrders; i++) {

            Double numPizzas = io.getDouble();
            Double avgPrice = io.getDouble();

            if (numPizzas <= m) {
              m -= numPizzas;
              batchValue += numPizzas * avgPrice;
            }
          }

        } else {

          ArrayList<Double> orders = new ArrayList<>();

          for (int i = 0; i < numOrders; i++) {
            orders.add(io.getDouble()); // num Pizzas
            orders.add(io.getDouble()); // avg Pizza price
          }

          for (int i = 0; i < numOrders; i++) {

            Double numPizzas = orders.get((numOrders - 1 - i) * 2);
            Double avgPrice = orders.get((numOrders - 1 - i) * 2 + 1);

            if (numPizzas <= m) {
              m -= numPizzas;
              batchValue += numPizzas * avgPrice;
            }
          }

        }

        mList.addLast(m);
        cashFlow.addLast(batchValue);

      } else {

        int noBatchesToCancel = io.getInt();

        for (int i = 0; i < noBatchesToCancel; i++) {
          cashFlow.removeLast();
          mList.removeLast();
        }

      }

    }

    Double totalRevenue = 0.0;
    for (Double c : cashFlow) {
      totalRevenue += c;
    }
    System.out.println(String.format("%.01f", totalRevenue));

  }
}
