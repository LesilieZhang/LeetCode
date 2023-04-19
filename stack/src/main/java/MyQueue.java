import java.util.Stack;

/**
 * @Auther: zhangyian
 * @Date: 2023/4/19 21:29
 * @Description: 用栈实现队列
 */
public class MyQueue {
    Stack<Integer> stackIn;
    Stack<Integer> stackOut;

    public MyQueue(){
        stackIn=new Stack<>();
        stackOut=new Stack<>();
    }

    /**
     * 进队操作
     * @param x 元素
     */
    public void push(int x){
        stackIn.push(x);
    }


    /**
     * 出队操作：
     *
     * @return
     */
    public Integer pop(){
        dumpstackIn();
        return stackOut.pop();
    }

    public Integer peek(){
        dumpstackIn();
        return stackOut.peek();
    }

    public boolean empty(){
        return stackIn.isEmpty() && stackOut.isEmpty();
    }

    /**
     * 如果stackOut为空，那么将stackIn中的元素全部放到stackOut中
     */
    private void dumpstackIn(){
        if(!stackOut.isEmpty()){
            return;
        }
        while (!stackIn.isEmpty()){
           //先进的先出，把入栈里的元素弹出到出栈
            stackOut.push(stackIn.pop());
        }
    }
}
