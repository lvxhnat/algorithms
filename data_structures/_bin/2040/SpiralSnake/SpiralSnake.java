import java.util.ArrayList; // import the ArrayList class
import java.util.Arrays;

/**
 * Name : Loh Yi Kuang
 * Matric. No : A0238627W
 */

public class SpiralSnake {
  public static void main(String args[]) {

    Kattio io = new Kattio(System.in);
    // m x n matrix. m rows, n columns.
    int m = io.getInt();
    int n = io.getInt();
    ArrayList<ArrayList<String>> tokens = new ArrayList<>(); // Create an ArrayList object
    while (io.hasMoreTokens()) {
      tokens.add(new ArrayList<String>(Arrays.asList(io.getWord().split(""))));
    }

    int r_ib = n - 1; // Right index boundary
    int l_ib = 0;
    int u_ib = 0;
    int b_ib = m - 1; // Left index boundary
    String direction = "r";

    int m_pos = 0;
    int n_pos = 0;

    for (int i = 0; i < m * n; i++) {

      String token = tokens.get(m_pos).get(n_pos); // Current token for step
      if (token.equals("X")) {
        exclaim(m_pos, n_pos, i + 1);
      }

      if (direction == "r") {
        if (n_pos == r_ib) { // If we hit the right boundary
          direction = "d"; // We go down!
          m_pos++; // Move the snake one down
          u_ib++; // The row is now filled, so we take note of the offset in the rows.
        } else {
          n_pos++; // Else we continue moving right.
        }
      } else if (direction == "d") {
        if (m_pos == b_ib) {
          direction = "l";
          n_pos--;
          r_ib--; // The right column is filled.
        } else {
          m_pos++; // Else we continue moving down.
        }
      } else if (direction == "l") {
        if (n_pos == l_ib) {
          direction = "u";
          m_pos--;
          b_ib--; // The bottom row is filled.
        } else {
          n_pos--; // We go left, so minue index
        }
      } else if (direction == "u") { // This is to go up
        if (m_pos == u_ib) {
          direction = "r";
          n_pos++;
          l_ib++;
        } else {
          m_pos--;
        }
      }
    }

    io.close();
  }

  public static void exclaim(int m, int n, int step) {
    System.out.println(String.format("Apple at (%s, %s) eaten at step %s", n, m, step));
  }
}
