/**
 * @Auther: zhangyian
 * @Date: 2023/4/11 22:03
 * @Description:
 */
public class Test1 {
    public static void main(String[] args) {
        Test1 test1 = new Test1();
        char[] hello = {'w', 'o', 'r', 'l', 'd'};//dlrow
        test1.reverseString(hello);
    }

    public void reverseString(char[] s) {
        int left=0;
        int right=s.length-1;
        char c;//临时变量
        while(left<right){
            //交换值的操作
            c=s[left];
            s[left]=s[right];
            s[right]=c;

            left++;
            right--;
        }
    }
}
