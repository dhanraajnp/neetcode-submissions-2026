class Solution {
    public int maxProfit(int[] prices) {

        int len = prices.length;

        /** Logic
        1. Whenever diff between 2 nodes are -ve, update min
        2. if difference are positive then book profit and move forward, update min to current element
         */

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