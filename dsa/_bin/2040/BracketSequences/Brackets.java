import java.util.Stack;

/**
 * Name: Loh Yi Kuang Matric. No: A0238627W
 */

public class Brackets {

  public static void main(String args[]) {
    Kattio io = new Kattio(System.in);
    int commands = io.getInt();
    String[] tokens = new String[commands];
    for (int i = 0; i < commands; i++) {
      tokens[i] = io.getWord();
    }
    long res = stackEvaluate(tokens, commands);
    System.out.println(res);
  }

  public static long stackEvaluate(String[] tokens, int commands) {

    Stack<String> stackflow = new Stack<>();
    int modulo = 1000000007;
    boolean isAddOperator = true;
    long result = 0;

    for (int i = 0; i < commands; i++) {

      String token = tokens[i];

      if (token.equals(")")) {

        result = Integer.parseInt(stackflow.pop());
        token = stackflow.pop();

        while (!token.equals("(")) {
          int intToken = Integer.parseInt(token);
          if (isAddOperator)
            result = (result + intToken) % modulo;
          else
            result = (result * intToken) % modulo;
          token = stackflow.pop();
        }
        stackflow.push(String.valueOf(result));
        isAddOperator = !isAddOperator;
      } else {
        stackflow.push(token);
        isAddOperator = token.equals("(") ? !isAddOperator : isAddOperator;
      }
    }

    long finalResult = 0;
    while (stackflow.size() > 0)
      finalResult = (finalResult + Integer.parseInt(stackflow.pop())) % modulo;
    return finalResult;

  }
}