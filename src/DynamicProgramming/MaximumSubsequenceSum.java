package DynamicProgramming;

/**
 * 最大子序和
 *
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 *
 */
public class MaximumSubsequenceSum {
    public static void main(String[] args) {
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));

        System.out.println(maxSubArray2(nums));
    }

    /**
     * dp解法
     */
    public static int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = nums[0];
        for (int i=1; i<nums.length; i++) {
            // 当前子序状态由两种情况转移过来
            // 1. 前一个子序加上当前数组元素
            // 2. 仅当前元素作为子序
            dp[i] = Math.max(dp[i-1] + nums[i], nums[i]);
            max = Math.max(dp[i], max);
        }
        return max;
    }

    /**
     * 贪心算法
     */
    public static int maxSubArray2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int current = 0;
        int max = nums[0];
        for (int i=0;i<nums.length;i++) {
            if (current > 0) {
                current = current + nums[i];
            } else {
              current = nums[i];
            }
            max = Math.max(max, current);
        }
        return max;
    }

    /**
     * 分治算法
     */
    public static int maxSubArray3(int[] nums) {
        return 0;
    }
}
