import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Friends {
  public static void main(String[] args) {
    Kattio io = new Kattio(System.in);

    int N = io.getInt(); // Number of gaming cafes in the town
    // Tom can only visit one gaming cafe a day
    long M = io.getLong(); // Limit of Tom in miliseconds in terms of visits to the cafe
    HashMap<String, Integer> maxCafe = new HashMap<>();

    for (int i = 0; i < N; i++) { // Iterate over the number of gaming cafes

      String cafeName = io.getWord();
      int numVisitors = io.getInt(); // Number of unique visitors to the cafe

      Pair[] timeList = new Pair[numVisitors];

      for (int j = 0; j < numVisitors; j++) { // Iterate over the number of unique visitors
        timeList[j] = new Pair(io.getLong(), io.getLong());
      }
      Arrays.sort(timeList);

      int maxValue = maxFriendsMade(timeList, M);
      maxCafe.put(cafeName, maxValue);
    }
    // Get the max number of individuals that can be accomodated
    int max = 0;
    // Get the max value of the hash map here
    for (Map.Entry<String, Integer> entry : maxCafe.entrySet()) {
      Integer value = entry.getValue();
      if (value >= max) {
        max = value;
      }
    }
    // Print the max value first
    System.out.println(max);
    // Prepare list to sort the names according to lex ordering
    ArrayList<String> sortedNameList = new ArrayList<>();
    // Get the individuals with the equivalent max values
    for (Map.Entry<String, Integer> entry : maxCafe.entrySet()) {
      Integer value = entry.getValue();
      // Get the names that has the same max number of individuals he can befriend
      if (value == max) {
        sortedNameList.add(entry.getKey());
      }
    }
    // Sort according to lexicographical ordering
    Collections.sort(sortedNameList);
    for (String name : sortedNameList) {
      System.out.println(name);
    }
  }

  static class Pair implements Comparable<Pair> {
    Long first;
    Long second;

    Pair(Long first, Long second) // constructor
    {
      this.first = first;
      this.second = second;
    }

    public int compareTo(Pair other) {
      if (this.first > other.first) {
        return 1;
      }
      if (this.first < other.first) {
        return -1;
      }
      if (this.second > other.second) {
        return 1;
      }
      if (this.second < other.second) {
        return -1;
      }
      return 0;
    }
  }

  /**
   * Find the maximum number of friends that can be made from his visits to the
   * cafe
   * 
   * @param visitTimes A List containing the visit times
   * @param exitTimes  A List containing the exit times
   * @param m          Integer that denotes the max time he can spend in the cafe
   * @return
   */
  public static int maxFriendsMade(Pair[] timeList, long m) {

    PriorityQueue<Pair> remaining = new PriorityQueue<>();
    for (Pair el : timeList) {
      remaining.add(el);
    }

    // Get the candidate time list, which is all the events, start and end
    Long[] candidateTimes = new Long[timeList.length * 2];
    for (int i = 0; i < timeList.length; i++) {
      candidateTimes[i] = Math.max(timeList[i].first - m, 0);
    }
    for (int i = 0; i < timeList.length; i++) {
      candidateTimes[timeList.length + i] = timeList[i].second;
    }
    // Sort these times
    Arrays.sort(candidateTimes);

    // Now we iterate with a hash mappy
    HashMap<Long, Integer> accumulator = new HashMap<>();
    PriorityQueue<Long> active = new PriorityQueue<>();

    for (Long t : candidateTimes) {
      while (remaining.size() != 0 && (t + m) >= remaining.peek().first) {
        Pair item = remaining.poll();
        active.add(item.second);
      }
      while (active.size() != 0 && t > active.peek()) {
        active.poll();
      }
      accumulator.put(t, active.size());
    }

    // find out whats the max number of individuals he can get at each time stamp
    int max = 0;
    for (Map.Entry<Long, Integer> entry : accumulator.entrySet()) {
      Integer value = entry.getValue();
      if (value > max) {
        max = value;
      }
    }
    return max;
  }
}
