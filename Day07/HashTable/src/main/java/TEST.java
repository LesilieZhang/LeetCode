/**
 * @Auther: zhangyian
 * @Date: 2023/4/3 21:04
 * @Description:
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 示例 1: 输入: s = "anagram", t = "nagaram" 输出: true
 *
 * 示例 2: 输入: s = "rat", t = "car" 输出: false
 */
public class TEST {
    public static void main(String[] args) {

    }

    public boolean isAnagram(String s, String t) {
        //定义一个长度为26的数组，存放每个字母出现的频率
        int[] record=new int[26];

        //遍历第一个字符串
        for(int i=0;i<s.length();i++){
            int index=s.charAt(i)-'a';//不需要记住a的ASC值，只需要求一个相对的值
            record[index]++;//记录频率
        }

        for(int j=0;j<t.length();j++){
            int index=t.charAt(j)-'a';
            record[index]--;//消除第一个字符串中出现的字母
        }

        //遍历我们定义的26个字母数组，如果每一个值都是0说明这两个字符串所含的字母是一样的
        //如果存在不为0的记录值就明开始出现了不同的数字
        for(int cout:record){
            if(cout!=0){
                return false;
            }
        }
        return true;
    }
}
