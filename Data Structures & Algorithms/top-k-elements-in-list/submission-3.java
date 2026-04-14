class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        /** 
            1. add in map Count the C and their frequence
            2. Then add each entry in priority quque ith codition that, map.freq > map.freq
            3. Add the k elements from priority queue to List
         */


        Map<Integer, Integer> map = new HashMap<>();
        for(int n: nums){
            map.put(n, map.getOrDefault(n,0)+1);
        }
         
        List<int[]> arr = new ArrayList<>();
        
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            arr.add(new int[] {entry.getValue(), entry.getKey()});
        }

        arr.sort((a, b) -> b[0] - a[0]);

        int[] res = new int[k];
        for(int i=0; i<k ;i++)
        {
            res[i] = arr.get(i)[1];
        }

        return res;
    }
}