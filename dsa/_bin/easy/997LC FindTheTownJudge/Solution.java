import java.util.HashMap;

class Solution {
    public static int findJudge(int n, int[][] trust) {
        
        HashMap<Integer, Integer> map = new HashMap<>(); // trusted person: number of trusted people
        
        int maxPerson = trust[0][0];
        
        for (int i = 0; i < trust.length; i++) {
            
            int trusted = trust[i][1];
            int person = trust[i][0];
            
            initPut(trusted, 1, map);
            initPut(person, 0, map);
            
            if (map.get(trusted) > map.get(maxPerson)) {
                maxPerson = trusted;
            }

        }

        if (map.get(maxPerson) == map.size() - 1) return maxPerson;
        
        else return -1;
    }

    public static void initPut(int z, int add, HashMap<Integer, Integer> map) {
        if (map.containsKey(z)) {
            map.put(z, map.get(z) + add);
        } else {
            map.put(z, add);
        }
    }

    public static void main(String[] args) {
        int[][] arr = new int[1][2];
        arr[0] = new int[] {1,2};
        System.out.println(findJudge(2, arr));
    }
}
