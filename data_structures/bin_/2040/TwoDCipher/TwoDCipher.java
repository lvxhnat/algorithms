/**
 * Name : Loh Yi Kuang
 * Matric. No : A0238627W
 */

public class TwoDCipher {
  public static void main(String args[]) {
    Kattio io = new Kattio(System.in);

    int n = io.getInt();
    int m = io.getInt();
    String token = io.getWord();

    for (int r = 0; r < n; r++) {

      String caesarRow = "";

      for (int c = 0; c < m; c++) {

        char caesarChar = token.charAt(r * m + c);
        char newChar;
        int charPosition = caesarChar - 'a' + 1; // The position of the char in the alphabet
        int offset = (r + 1) * (c + 1);

        if (charPosition + offset > 26) {
          if ((charPosition + offset) % 26 == 0) {
            newChar = (char) ('a' + 25);
          } else {
            newChar = (char) ('a' + (charPosition + offset) % 26 - 1);
          }
        } else {
          newChar = (char) (caesarChar + offset);
        }

        caesarRow += newChar;
      }

      System.out.println(caesarRow);

    }
    io.close();
  }
}
