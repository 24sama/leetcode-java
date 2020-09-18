package array;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 接雨水
 *
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 *
 * 示例:
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 *
 * @author liyaozong
 * @date 2020/9/18 17:51
 */
public class CatchRain {
    public static void main(String[] args) {
        System.out.println(trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }
    public static int trap(int[] height) {
        int res = 0;
        Stack<Integer> tmpStack = new Stack<>();
        int slow = 0;
        for (int fast = 1; fast<height.length; fast++){
            if (height[fast] < height[slow]) {
                for (int i=0;i<height[slow]-height[fast];i++) {
                    tmpStack.push(1);
                }
            } else {
                if (tmpStack.size() > 0) {
                    for (int i=0;i<tmpStack.size();i++) {
                        res += tmpStack.pop();
                    }
                }
            }
        }
        return res;
    }
}
