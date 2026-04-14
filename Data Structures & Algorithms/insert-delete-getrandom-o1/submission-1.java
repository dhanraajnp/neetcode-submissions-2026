
class RandomizedSet {
    private final ArrayList<Integer> list;
    private final HashMap<Integer, Integer> idx;
    private final Random rand;

    public RandomizedSet() {
        list = new ArrayList<>();
        idx = new HashMap<>();
        rand = new Random();
    }

    // returns true if inserted, false if already present
    public boolean insert(int val) {
        if (idx.containsKey(val)) return false;
        idx.put(val, list.size());
        list.add(val);
        return true;
    }

    // returns true if removed, false if not present
    public boolean remove(int val) {
        Integer iObj = idx.get(val);
        if (iObj == null) return false;

        int i = iObj;
        int lastIndex = list.size() - 1;
        int lastVal = list.get(lastIndex);

        // move lastVal into i (unless removing last itself)
        if (i != lastIndex) {
            list.set(i, lastVal);
            idx.put(lastVal, i);
        }

        list.remove(lastIndex);
        idx.remove(val);
        return true;
    }

    // assumes at least one element exists when called
    public int getRandom() {
        int r = rand.nextInt(list.size());
        return list.get(r);
    }
}
/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */