import java.util.Stack;

/**
 * @Auther: zhangyian
 * @Date: 2023/5/8 23:15
 * @Description:
 */
public class bracket {
    public static void main(String[] args) {
        String s="))";
        bracket bracket = new bracket();
        boolean flag= bracket.isValid(s);
        System.out.println(flag);

    }

    public boolean isValid(String s) {
        boolean isMatch=true;
        // 创建一个栈对象
        Stack<String> stack = new Stack<>();
        char arr[]=s.toCharArray();
        if(arr.length%2!=0){
            return false;
        }
        for(int i=0;i<arr.length;i++){
            String bracket=String.valueOf(arr[i]);
            if("{".equals(bracket)||"[".equals(bracket)||"(".equals(bracket)){//遇到左括号入栈
                stack.push(bracket);
            }else{
                //遇到右括号
                if(stack.isEmpty()){
                    return false;
                }
                String right_bracket= String.valueOf(arr[i]);
                if(!stack.isEmpty()) {
                    String left_bracket = stack.pop();
                    if (!isMatch(left_bracket, right_bracket)) {
                        isMatch = false;
                    }
                }
            }
        }
        if(!stack.isEmpty()){
            isMatch=false;
        }
        return isMatch;
    }

    /**
     * 校验括号是否匹配
     * @param left
     * @param right
     * @return
     */
    private boolean isMatch(String left,String right){
        if("(".equals(left)&&")".equals(right)){
            return true;
        }else if("[".equals(left)&&"]".equals(right)){
            return true;
        }else if("{".equals(left)&&"}".equals(right)){
            return true;
        }else {
            return false;
        }
    }
}
