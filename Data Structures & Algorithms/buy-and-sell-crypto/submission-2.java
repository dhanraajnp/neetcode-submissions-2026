class Solution {
    public int maxProfit(int[] prices) {

        int len = prices.length;
        int ans = 0;
        int min = prices[0];

        for(int i=1; i< len; i++){
            int diff = prices[i] - min;

            if(diff < 0){                
                min = prices[i];
            }
            if(diff > ans){
                ans = diff;
            }
        }
        return ans;
    }
}