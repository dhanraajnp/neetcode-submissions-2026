class Solution {
    public int findDuplicate(int[] nums) {
        
        int len = nums.length;
        int i =0;
        Set<Integer> unique = new HashSet<>();
        while(i<len){
            if(!unique.add(nums[i])){
                return nums[i];
            }
            i++;
        }

        return 0;

    }
}
