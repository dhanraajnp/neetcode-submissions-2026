class Solution {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;

        while (l < r) {
            int mid = l + (r - l) / 2;

            if (nums[mid] < nums[r]) {
                // min is in left part including mid
                r = mid;
            } else if (nums[mid] > nums[r]) {
                // min is in right part excluding mid
                l = mid + 1;
            } else {
                // nums[mid] == nums[r], can't decide; shrink r
                r--;
            }
        }

        return nums[l];
    }
}
