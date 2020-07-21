package string;

/**
 * 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 *
 * 示例 2:
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 *
 * 说明:
 * 所有输入只包含小写字母 a-z 。
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = new String[]{"flower","flow","flight"};
        String[] strs2 = new String[]{"dog","racecar","car"};
        String[] strs3 = new String[]{};
        System.out.println(longestCommonPrefix(strs));
        System.out.println(longestCommonPrefix(strs2));
        System.out.println(longestCommonPrefix(strs3));
    }

    // 扫描法
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0){
            return "";
        }
        //假设最长公共前缀为字符串1
        String s = strs[0];
        for (int i = 0; i < strs.length; i++) {
            //当数组中其他元素不包含该字符串
            while (strs[i].indexOf(s) != 0) {
                //截短该字符串一位
                s = s.substring(0,s.length()-1);
                if (s.length()==0){
                    return "";
                }
            }
        }
        return s;
    }
}
