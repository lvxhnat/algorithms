/**
 * Name :
 * Matric. No :
 */

public class Hello {
  public static void main(String args[]) {
    // Here's some I/O boilerplate to get you started.
    Kattio io = new Kattio(System.in);

    int worldCount = 0;
    int helloCount = 0;

    while (io.hasMoreTokens()) {
      String token = io.getWord();
      if (token.equals("Hello")) {
        helloCount += 1;
      } else if (token.equals("World")) {
        worldCount += 1;
      }
    }

    System.out.println(helloCount - worldCount);
    io.close();
  }
}
