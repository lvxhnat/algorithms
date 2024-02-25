import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> l = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < i + 1; j++) {
                if (j == 0) {
                    l.add(new ArrayList<>());
                }
                if (j == 0 || j == i) {
                    l.get(i).add(1);
                } else {
                    l.get(i).add(l.get(i - 1).get(j - 1) + l.get(i - 1).get(j));
                }
            }
        }

        return l;
    }
}