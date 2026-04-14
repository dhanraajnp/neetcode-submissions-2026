class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int tempMax = nums[0];
        
        for(int i= 1; i<nums.length; i++){

            int num = nums[i];
            tempMax = Math.max(tempMax+num , num);
            max = Math.max(tempMax, max);
        }
        
        return max;
        
    }
}