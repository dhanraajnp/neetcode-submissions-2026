class Solution {

    public int rob(int[] nums) {

        if (nums.length == 1) return nums[0];

        return Math.max(
            robRange(nums, 0, nums.length - 2),
            robRange(nums, 1, nums.length - 1)
        );
    }

    private int robRange(int[] nums, int l, int r) {

        int prev = 0;
        int curr = 0;

        for (int i = l; i <= r; i++) {

            int temp = Math.max(curr, prev + nums[i]);

            prev = curr;
            curr = temp;
        }

        return curr;
    }
}