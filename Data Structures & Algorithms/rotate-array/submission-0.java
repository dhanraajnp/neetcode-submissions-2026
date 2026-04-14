class Solution {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        k = k % len;                 // 🔥 important
        int newStart = len - k;
        int i=0;
        int[] res = new int[len];
        //int j=0; 
        
        while(i < len){
            int index = newStart % len;   // wrap around
            res[i++] = nums[index];
            newStart++;         
        }

        for(int k1=0; k1<len; k1++){
            nums[k1] = res[k1];
        }
    }
}