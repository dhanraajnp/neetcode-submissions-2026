class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int res[] = new int[len];
    
        for(int i =0; i<len; i++){
            int prod = 1;
            for(int j=0; j<len; j++){

                if(i==j){
                    System.out.println("Skipping for i,j ="+i+","+j);
                    continue;
                }
                System.out.println("prod ="+prod);
                System.out.println("nums[j] ="+nums[j]);
                prod = prod * nums[j];
            }
            System.out.println("="+prod);
            res[i] = prod;
        }

        return res;
    }
}  
