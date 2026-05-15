public class FreqStack {
    private Map<Integer, Integer> cnt;
    private List<Integer> stack;

    public FreqStack() {
        cnt = new HashMap<>();
        stack = new ArrayList<>();
    }

    public void push(int val) {
        stack.add(val);
        cnt.put(val, cnt.getOrDefault(val, 0) + 1);
    }

    public int pop() {
        int maxCnt = Collections.max(cnt.values());
        int i = stack.size() - 1;
        while (cnt.get(stack.get(i)) != maxCnt) {
            i--;
        }
        int val = stack.remove(i);
        cnt.put(val, cnt.get(val) - 1);
        return val;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */