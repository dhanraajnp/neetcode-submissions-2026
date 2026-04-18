class StockSpanner {
    List<Integer> prices;
    Deque<Integer> dq;
    public StockSpanner() {
        prices = new ArrayList<>();
        dq = new ArrayDeque<>();
    }
    
    public int next(int price) {
        int count, len = prices.size();

        while(!dq.isEmpty() && price >= prices.get(dq.peek())) {
            dq.pop();
        }

        count = dq.isEmpty()? len+1: len - dq.peek();

        prices.add(price);
        dq.push(len);
        return count;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */