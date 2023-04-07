/**
 * @Auther: zhangyian
 * @Date: 2023/4/7 18:53
 * @Description:
 */
public class TEST4 {

    public static void main(String[] args) {
        TEST4 test4 = new TEST4();
        String a="aa";
        String b="aab";

       boolean flag=test4.canConstruct(a,b);
        System.out.println(flag);


    }

    public boolean canConstruct(String ransomNote, String magazine) {
        int[] record=new int[26];
        for(char c:magazine.toCharArray()){
            //遍历magazine数组
            int num=c-'a';//计算某个字母和a的偏移量
            record[num]=record[num]+1;
        }

        for(char c:ransomNote.toCharArray()){
            //遍历magazine数组
            record[c-'a']=record[c-'a']-1;
        }
        for(int i:record){
            if(i<0){//小于0说明杂志上有缺少的字母。比如我们需要abc，杂志只有ab，那么c的次数为-1
                return false;
            }
        }
        return true;
    }

}
