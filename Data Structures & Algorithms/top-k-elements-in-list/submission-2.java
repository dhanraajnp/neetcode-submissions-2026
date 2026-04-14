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
           
        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = 
                         new PriorityQueue<>((a,b)->(b.getValue()-a.getValue()));
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            maxHeap.add(entry);
        }
        
        //List<Integer> res = new ArrayList<>();
        int[] res = new int[k];
        int l = 0;
        while(l <k){

            Map.Entry<Integer, Integer> entry = maxHeap.poll();
            //res.add(entry.getKey());
            res[l++] = entry.getKey();
            //System.out.println("addinbg :"+res[l-1]);
        }
        return res;

    }
}