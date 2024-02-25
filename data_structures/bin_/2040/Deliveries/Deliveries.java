import java.util.PriorityQueue;

/**
 * Name: Loh Yi Kuang Matric. No: A0238627W
 */

public class Deliveries {

    static class Pair implements Comparable<Pair> {

        int first;
        int second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        public int compareTo(Pair other) {
            if (this.first < other.first) {
                return 1;
            }
            if (this.first > other.first) {
                return -1;
            }
            if (this.second < other.second) {
                return 1;
            }
            if (this.second > other.second) {
                return -1;
            }
            return 0;
        }

    }

    public static void main(String args[]) {
        Kattio io = new Kattio(System.in);
        int N = io.getInt();
        PriorityQueue<Pair> queue = new PriorityQueue<>();

        int maxTimePeriod = 0;

        for (int i = 0; i < N; i++) {
            int T = io.getInt(); // Deadline
            int C = io.getInt(); // Compensation
            maxTimePeriod = Math.max(maxTimePeriod, T); // Find the maximum deadline (time period)
            queue.add(new Pair(C, T)); // Now this is sorted in descending profits
        }

        // Create a deadline array to host time periods
        int[] timePeriodArr = new int[maxTimePeriod];

        while (!queue.isEmpty()) {
            // We get each job deadline pair, and insert it into the time period array
            // We make sure that we assign a time slot to it such that the timeslot < T, but
            // is the greatest
            Pair deliveryEvent = queue.poll();
            // Iterate backwards to check
            for (int i = Math.min(deliveryEvent.second - 1, maxTimePeriod); i >= 0; i--) {
                if (timePeriodArr[i] == 0) {
                    // Set the delivery fee earned into the index (the index already denotes the
                    // deadline)
                    timePeriodArr[i] = deliveryEvent.first;
                    break;
                }
            }
        }

        long sums = 0;
        // Sum the delivery fees out. Can lead to integer overflow, so we use long.
        for (int j : timePeriodArr)
            sums += j;

        System.out.println(sums);

    }
}
