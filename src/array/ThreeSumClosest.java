package array;

import java.util.Arrays;

/**
 * 最接近的三数之和
 *
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。
 * 假定每组输入只存在唯一答案。
 * 示例：
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 *
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 * @author liyaozong
 * @date 2020/9/21 15:30
 */
public class ThreeSumClosest {
    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{1,1,1,0}, -100));
    }

    public static int threeSumClosest(int[] nums, int target) {
        int closestNum = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i=0; i<nums.length; i++) { ;
            // 跳过重复数字
            if (i>0&&nums[i] == nums[i-1]) {
                continue;
            }

            int a=i, left = a+1, right = nums.length-1;
            while (left < right) {
                int cur = nums[a] + nums[left] + nums[right];
                if (target == cur) {
                    return target;
                } else if (target < cur) {
                    right--;
                } else {
                    left++;
                }

                // 当前值距离target更近
                if (Math.abs(target - closestNum) > Math.abs(target - cur)) {
                    closestNum = cur;
                }
            }
        }
        return closestNum;
    }
}
