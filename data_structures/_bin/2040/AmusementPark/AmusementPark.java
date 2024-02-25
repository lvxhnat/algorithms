import java.util.LinkedList;

/**
 * Name : Loh Yi Kuang Matric. No : A0238527W
 */

public class AmusementPark {

	public static void main(String args[]) {

		Kattio io = new Kattio(System.in);
		LinkedList<Integer> rides = new LinkedList<>();
		LinkedList<String> output = new LinkedList<>();
		String command;
		int day = 1;

		while (io.hasMoreTokens()) {
			command = io.getWord();
			if (command.equals("END")) {
				// We store our outputs in a linkedlist, which will be iterated over and printed
				// out after the main loop is complete.
				output.addLast("Day ");
				output.addLast(String.valueOf(day));
				output.addLast(": ");
				output.addLast(rides.toString());
				output.addLast("\n");
				// Break since there might be a null following the END token.
				break;
			}
			command += " " + io.getWord();

			if (command.equals("NEXT DAY")) {

				output.addLast("Day ");
				output.addLast(String.valueOf(day));
				output.addLast(": ");
				output.addLast(rides.toString());
				output.addLast("\n");
				day++;
				rides = new LinkedList<>();

			} else if (command.equals("START RIDE:") || command.equals("NEXT RIDE:")) {
				int A = io.getInt();
				rides.addLast(A);
			} else if (command.equals("DELETE FRONT")) {
				// Redundant token. We do this step only to remove it from the queue, so we can
				// access the subsequent useful tokens.
				io.getWord();
				int X = io.getInt();
				if (X > rides.size()) { // Check if the statement is not possible
					output.addFirst("Invalid command\n");
				} else {
					// Faster than .subList(), which has to then be converted to a
					// LinkedList.(approx O(N))
					// We iterate through X elements and pop them from the front of the linkedlist.
					for (int i = 0; i < X; i++) {
						rides.removeFirst();
					}
				}
			} else if (command.equals("DELETE BACK")) {
				io.getWord();
				int X = io.getInt();
				if (X > rides.size()) { // Check if the statement is not possible
					output.addFirst("Invalid command\n");
				} else {
					for (int i = 0; i < X; i++) {
						rides.removeLast();
					}
				}
			} else if (command.equals("CHANGE FRONT")) {
				io.getWord();
				int X = io.getInt();
				int A = io.getInt();

				if (X > rides.size()) { // Check if the statement is not possible
					output.addFirst("Invalid command\n");
				} else {
					// Instead of setting, we remove the element at the index position we are
					// supposed to replace, and we add that elemeent back
					for (int i = 0; i < X; i++) {
						rides.removeFirst();
					}
					rides.addFirst(A);
				}
			} else {
				io.getWord();
				int X = io.getInt();
				int A = io.getInt();

				if (X > rides.size()) {
					output.addFirst("Invalid command\n");
				} else {
					for (int i = 0; i < X; i++) {
						rides.removeLast();
					}
					rides.addLast(A);
				}
			}
		}
		// Print out our result
		for (String o : output) {
			System.out.print(o);
		}
	}

}
