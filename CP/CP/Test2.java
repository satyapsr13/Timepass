class Solution {
    boolean isFirstn(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; ++i) {
            if (nums[i] == target) {
                return true;
            }
        }
        return false;
    }

    long getAns(int[] nums1, int[] nums2) {
        long ans = 0;
        for (int i = 0; i < nums1.length; ++i) {

            ans += Math.abs(nums1[i] - nums2[i]);
        }
        return ans;
    }

    boolean isTargetIsInBetween(int[] nums1, int[] nums2, int target) {
        for (int i = 0; i < nums1.length; ++i) {

            if (Math.min(nums1[i], nums2[i]) <= target && Math.max(nums1[i], nums2[i]) >= target) {
                return true;
            }

        }
        return false;
    }

    long getMinimumDiff(int[] nums, int target) {
        int ans = Integer.MAX_VALUE;
        for (int num : nums) {
            // int num=nums[i];
            ans = Math.min(ans, Math.abs(num - target));
        }
        return ans;
    }

    long getMinimumDiff2(int[] nums, int target) {
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 1; ++i) {
            // int num=nums[i];
            int num = nums[i];
            ans = Math.min(ans, Math.abs(num - target));
        }
        return ans;
    }

    public long minOperations(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        long ans = getAns(nums1, nums2);
        if (isFirstn(nums2, nums2[m - 1]) || isTargetIsInBetween(nums1, nums2, nums2[m - 1])) {
            return ans + 1;
        }
        long diff1 = (getMinimumDiff(nums1, nums2[m - 1]) * 2);
        long diff2 = (getMinimumDiff2(nums2, nums2[m - 1]) * 2);
        return ans + Math.min(diff1, diff2);
    }
}©leetcode