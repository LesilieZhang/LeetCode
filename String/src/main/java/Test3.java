import com.sun.deploy.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Auther: zhangyian
 * @Date: 2023/4/14 23:29
 * @Description:
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 * 示例 1：
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 * 示例 2：
 * 输入: "  hello world!  "
 * 输出: "world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
  *示例 3：
 * 输入: "a good   example"
 * 输出: "example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 */
public class Test3 {

    public static void main(String[] args) {
        Test3 test3 = new Test3();
        String s="a good   example";
        String s1=test3.reverse(s);
        System.out.println(s1);
    }

    /**
     * 反转
     * @param s
     * @return
     */
    public String reverse(String s){
      List<String> list=clearSpace(s);
      StringBuilder sb=new StringBuilder();
      for(String str:list){//取出来每个单词后面加个空格
          sb.append(str);
          sb.append(" ");
      }
      return sb.substring(0,sb.length()-1);
    }

    /**
     * 移除所有的空格
     * @param
     */
    private List<String> clearSpace(String s){
        String arr[]=s.split(" ");//以空格隔开，分出每个单词
        List<String> list=new ArrayList<String>();
        for(int i=arr.length-1;i>=0;i--){
            if(!"".equals(arr[i])){
                list.add(arr[i]);//添加到list里
            }
        }
        return list;
    }

}
