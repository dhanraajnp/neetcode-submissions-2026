class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int hi = 0;
        for(int pile : piles) {
            hi = Math.max(hi, pile);
        }
        int lo = 1;
        int res = hi;
        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int hours = 0;
            for(int pile : piles) {
                hours += Math.ceil(pile / (double)mid);
            }
            if(hours > h) lo = mid + 1;
            else if(hours <= h) {
                hi = mid - 1;
            }
        }
        return lo;
    }
}
