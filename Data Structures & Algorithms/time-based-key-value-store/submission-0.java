class TimeMap {
    
    private static class Pair{
        String value;
        int ts;

        Pair(String value, int ts){
            this.value = value;
            this.ts = ts;
        }
    }

    private final Map<String, List<Pair>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {

        List<Pair> list = map.get(key);
        if(list == null){
            list = new ArrayList<>();
            map.put(key, list);
        }
        list.add(new Pair(value, timestamp));
        //map.computeIfAbsent(key, k-> new ArrayList<>()).add(new Pair(value, timestamp));
        
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)){
            return "";
        }

        List<Pair> list = map.get(key);
        int left =0, right = list.size() - 1;
        String ans = "";

        while(left <= right){
            int mid = left + (right - left)/2;       
            if(list.get(mid).ts <= timestamp){
                ans = list.get(mid).value;
                left = mid + 1;
            } else {
                right = mid - 1;
            } 
        }

        return ans;

    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */