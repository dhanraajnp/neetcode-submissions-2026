class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        Map<String, List<String>> res = new HashMap<>();

        for(String str : strs){

            char[] ch = str.toCharArray();
            Arrays.sort(ch);

            String key = Arrays.toString(ch);
            res.putIfAbsent(key, new ArrayList<>());
            res.get(key).add(str);
        }
        
        return new ArrayList<>(res.values());
    }
}
