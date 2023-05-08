import java.util.ArrayDeque;
import java.util.Stack;

/**
 * @Auther: zhangyian
 * @Date: 2023/5/8 23:47
 * @Description: 给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
 * <p>
 * 在 S 上反复执行重复项删除操作，直到无法继续删除。
 * <p>
 * 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
 * <p>
 * 示例：
 * <p>
 * 输入："abbaca"
 * 输出："ca"
 * 解释：例如，在 "abbaca" 中，我们可以删除 "bb" 由于两字母相邻且相同，这是此时唯一可以执行删除操作的重复项。
 * 之后我们得到字符串 "aaca"，其中又只有 "aa" 可以执行重复项删除操作，所以最后的字符串为 "ca"。
 */
public class repeatString {
    public static void main(String[] args) {
        String s = "abbaca";
        repeatString repeatString = new repeatString();
        String newS = repeatString.removeDuplicates(s);
        System.out.println(newS);

    }

    /**
     * 去除相等的
     *
     * @param s
     * @return
     */
    public String removeDuplicates(String s) {
        //ArrayDeque会比LinkedList在除了删除元素这一点外会快一点
        //参考：https://stackoverflow.com/questions/6163166/why-is-arraydeque-better-than-linkedlist
        ArrayDeque<Character> deque = new ArrayDeque<>();
        char ch;
        for (int i = 0; i < s.length(); i++) {
            ch=s.charAt(i);
            //队列不空，且第一个元素不为当前元素
            if(deque.isEmpty()||deque.peek()!=ch){
                deque.push(ch);
            }else{
                deque.pop();
            }
        }
        StringBuilder sb=new StringBuilder();
        while(!deque.isEmpty()){
            sb.append(deque.pop());
        }
        return sb.reverse().toString();
    }
}
