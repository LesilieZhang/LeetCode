/**
 * @Auther: zhangyian
 * @Date: 2023/4/13 23:49
 * @Description:
 * 给定一个字符串 s 和一个整数 k，从字符串开头算起, 每计数至 2k 个字符，就反转这 2k 个字符中的前 k 个字符。
 *
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 *
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 *
 * 示例:
 *
 * 输入: s = "abcdefg", k = 2
 * 输出: "bacdfeg"
 */
public class Test2 {
    public static void main(String[] args) {
        Test2 test2 = new Test2();
        String s="abcdef";
        String s1=test2.reverseStr(s,2);
        System.out.println(s1);


    }

    /**
     * 反转2k个字符的前两个字符
     *
     * *********************假设一个字符串有这么长
     * 我们只需要把他们按2k长度分割
     * 假设k=2，我们按下面这种形式遍历
     * **** **** **** ***....
     * start是起点下标，start=0,4,8...
     * end:从start开始走2步，因为是下标，所以要-1
     * start和end之间的就是前k个要反转的数
     *
     * 如果start+k-1超过了数组的长度，也就是表示剩余的字符串不足k个
     * 那么就要把剩余的字符串都反转，这个时候end就指向了数组的最后一个
     *
     * abcd ef
     *
     * bacdfe
     *
     *
     * @param s
     * @param k
     * @return
     */
    public String reverseStr(String s,int k){
        char ch[]=s.toCharArray();

        for(int i=0;i<ch.length;i=i+2*k){//每2k算一个起点
            int start=i;
            //end指针的位置
            //a=ch.length-1:表示最后一位的下表
            //b=start+k-1：表示start指针往后走k步是否超过了数组的总长，如果没有超过就停下来，超过了就停在数组最后一位
            int end=Math.min(ch.length-1,start+k-1);
            while (start<end){
                char c=ch[start];
                ch[start]=ch[end];
                ch[end]=c;
                start++;
                end--;
            }
        }
        return new String(ch);
    }
}
