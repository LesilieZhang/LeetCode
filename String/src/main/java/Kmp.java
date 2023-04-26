import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: zhangyian
 * @Date: 2023/4/26 21:24
 * @Description: kmp算法
 */
public class Kmp {

    public static void main(String[] args) {
        String text = "aabaabaabaaf";
        String pattern = "aabaaf";
        Kmp kmp = new Kmp();
        List<Integer> matches = kmp(text, pattern);
        System.out.println("Matches found at: " + matches);
    }

    /**
     * 计算模式串的前缀表
     * @param pattern
     * @return 返回模式串的前缀表
	 初始化：i表示后缀的最后一个字符，j表示前缀的最后一个字符，也表示包括i之前子串的最长相等前后缀的长度

     这个计算前缀表的过程可以通过使用两个指针i和j来完成。
	 初始时，i指向模式串的第一个字符，j指向前缀的最后一个字符。
     * 随着i的移动，如果pattern[i]和pattern[j]相等（前后缀相同），我们就将j向后移动一位，
     * 并将prefix[i]设置为j+1（表示最长相等前后缀的长度+1）；
	 如果pattern[i]和pattern[j]不相等，我们就让j回到prefix[j-1]的位置，继续尝试匹配。
     */
    public static int[] getPrefixTable(String pattern) {
        int m = pattern.length();//记录长度
         int[] prefix = new int[m];//定义一个前缀表数组
        int i = 1, j = 0;//定时指针下标，表示前缀从初始两个字母开始扩大寻找
        prefix[0] = 0;//前缀第一个为0：我们首先初始化prefix[0]为0，因为第一个字符的前缀肯定为空
        while (i < m) {
            if (pattern.charAt(i) == pattern.charAt(j)) {
                j++;
                prefix[i] = j;
                i++;
            } else {
                 if (j > 0) {
                    j = prefix[j - 1];
                } else {
                    prefix[i] = 0;
                    i++;
                }
            }
        }
        return prefix;
    }


    /**
     * kmp方法用于在文本串中查找模式串
     * @param text
     * @param pattern
     * @return
     */
    public static List<Integer> kmp(String text, String pattern) {
        List<Integer> matches = new ArrayList<>();
        int n = text.length(), m = pattern.length();
        int[] prefix = getPrefixTable(pattern);
        int i = 0, j = 0;
         while (i < n) {
             if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            } else {
                 if (j > 0) {
                     j = prefix[j - 1];
                } else {
                    i++;
                }
            }
            if (j == m) {
                matches.add(i - j);
                j = prefix[j - 1];
            }
        }
        return matches;
    }
}
