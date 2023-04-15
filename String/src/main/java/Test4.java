/**
 * @Auther: zhangyian
 * @Date: 2023/4/15 14:40
 * @Description:
 */
public class Test4 {
    public static void main(String[] args) {
        Test4 test4 = new Test4();
        String s=test4.reverseLeftWords("abcdef",2);
        System.out.println(s);
    }

    public String reverseLeftWords(String s,int n){
        StringBuilder sb=new StringBuilder();
        char c[]=s.toCharArray();
        for(char ctr:c){
            sb.append(ctr);
        }
        for(int i=0;i<n;i++){
            char left=c[i];
            sb.append(left);
        }
        return sb.toString().substring(n,sb.length());
    }
}
