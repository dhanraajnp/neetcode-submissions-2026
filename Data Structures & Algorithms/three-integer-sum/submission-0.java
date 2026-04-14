class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        
        // First sort
        // then for loop for each element till n-2 
        // then 2sum II i.e 2 sum with 2 ptrs ..  
        // time com would be 
        // nLogn + n* n;
        // O(n^2)
        
        int target = 0;
        Arrays.sort(nums);
        Set<List<Integer>> s = new HashSet<>();
        List<List<Integer>> output = new ArrayList<>();

        for (int i = 0; i < nums.length; i++){
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == target) {
                    s.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                } else if (sum < target) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        output.addAll(s);

        return output;
        
    }
}