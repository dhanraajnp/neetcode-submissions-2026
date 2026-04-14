class Solution {
    private int binarySearch(int l, int r, int[] nums, int target) {
        if (l > r) 
            return l;
        int m = l + (r - l) / 2;

        if (nums[m] == target) return m;
        return (nums[m] < target) ?
            binarySearch(m + 1, r, nums, target) : 
            binarySearch(l, m - 1, nums, target);
    }

    public int searchInsert(int[] nums, int target) {
        return binarySearch(0, nums.length - 1, nums, target);
    }
}