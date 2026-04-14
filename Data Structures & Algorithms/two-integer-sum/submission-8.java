class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        int len = nums.length; 

        HashMap<Integer, Integer> sum = new HashMap<>();

        for(int i=0; i<len; i++){
            int num = nums[i];
            int diff = target - num;

            System.out.println("checking for i:"+i+ ", value : "+nums[i]);
            System.out.println("checking for diff:"+diff);
            
            if(sum.containsKey(diff))
                return new int[]{sum.get(diff), i};

            sum.put(num, i);
        }
        return new int[]{0,0};
    }
}
