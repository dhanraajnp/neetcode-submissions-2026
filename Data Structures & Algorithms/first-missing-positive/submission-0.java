class Solution {
    public int firstMissingPositive(int[] nums) {
        /**   Uses cyclic sort   */
        int len = nums.length;
        int i =0;            
        while(i<len){ 
            int correctIndex = nums[i]-1;
            
            if(correctIndex >= 0 && correctIndex < len
                    && nums[i] != nums[correctIndex] ){
                        //System.out.println("Swapping index for i is:"+i+", correct:"+correctIndex);
                        swap(nums, i, correctIndex );
            }else
                i++;

        }

        for(i=0; i<len; i++){
            if(nums[i] != i+1 ){
                return i+1;
            }
        }

        return i+1;
   }

   public void swap(int[] nums, int i, int j){

        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
   }
}