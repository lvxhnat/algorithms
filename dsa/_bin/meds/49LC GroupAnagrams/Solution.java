class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> results = new ArrayList<>();
        HashMap<String, Integer> acc = new HashMap<>(); 
        
        for (String s : strs) {
            char[] c = s.toCharArray(); // O(N)
            Arrays.sort(c); // O(N log N)
            String cs = String.valueOf(c); // O(N)
            if (acc.containsKey(cs)) results.get(acc.get(cs)).add(s); // O(1)
            else {
                acc.put(cs, results.size());  // O(1)
                results.add(new ArrayList<>(List.of(s))); // O(N)
            }
        }
        
        return results;
    }
}
