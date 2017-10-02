/* Maximal subarray */
class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-1] + nums[i], nums[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}

/* Maximum Product Subarray */
class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int res = nums[0];
        int premax = nums[0];
        int premin = nums[0];
        int max;
        int min;
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(Math.max(premax * nums[i], premin * nums[i]), nums[i]);
            min = Math.min(Math.min(premax * nums[i], premin * nums[i]), nums[i]);
            res = Math.max(max, res);
            premax = max;
            premin = min;
        }
        return res;
    }
}