/**
 * @Auther: zhangyian
 * @Date: 2023/5/7 14:42
 * @Description:
 *
 * 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。
 *
 * 示例 1:
 * 输入: "abab"
 * 输出: True
 * 解释: 可由子字符串 "ab" 重复两次构成。
 *
 * 如果是abcabcabc.可由字符串abc组成
 * 首先对字符串进行切割，如果是4位数像abab这样的，我们切割的最小单位是2个字符，然后我们取前两个字符让它重复拼接两次，去和原来的字符串对比
 * 如果是6位ababab，我们先取最切片3，重复2次发现不对，再缩小切片取长度2的ab，重复3次
 */
public class Test5 {
    public static void main(String[] args) {
        String s="ababab";
        Test5 test5 = new Test5();
        boolean flag=test5.repeatedSubStringPattern(s);
        System.out.println(flag);
    }

    public boolean repeatedSubStringPattern(String s){
        int len=s.length();
        for(int i=len/2;i>=1;i--){
            if(len%i==0) {
                int num_repeats = len / i;
                String substring = s.substring(0, i);
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < num_repeats; j++) {
                    sb.append(substring);
                }
                if (sb.toString().equals(s)) {
                    return true;
                }
            }
        }
        return false;
    }
}
