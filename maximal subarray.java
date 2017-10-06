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


//返回自定义class(max, startindex, end index)

    class result {
	int value;
	int start;
	int end;
	public result(int val, int s, int e) {
		value = val;
		start = s;
		end = e;
	}
}

public result helper(int[] nums) {
	if (nums == null || nums.length == 0) {
		return null;
	}
	result res = new result(Integer.MIN_VALUE, 0, 0)
	int sum = 0;//prefix sum;
    int min = 0;//minimal prefix sum;
    int minIndex = -1;//the index of minimal prefixsum;
	for (int i = 0; i < nums.length; i++) {
		sum += nums[i];
		if (sum - min > res.value) {
            res.value = sum - min;
			res.end = i;
            res.start = minIndex + 1;
		}
		if (sum < min) {
			minIndex = i;
			min = sum;
		}
	}
	return res;
}