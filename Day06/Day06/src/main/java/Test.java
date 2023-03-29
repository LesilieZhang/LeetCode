/**
 * @Auther: zhangyian
 * @Date: 2023/3/29 19:17
 * @Description:
 */
public class Test {

    public static void main(String[] args) {
        Test t=new Test();
        ListNode head=t.createListWithCycle(5,2);
        ListNode n=t.detectCycle(head);
        System.out.println(n.val);
    }
    public ListNode createListWithCycle(int n, int pos) {
        ListNode head = new ListNode(1);
        ListNode p = head;
        ListNode cycleStart = null;
        for (int i = 2; i <= n; i++) {
            p.next = new ListNode(i);
            p = p.next;
            if (i == pos) {
                cycleStart = p;
            }
        }
        p.next = cycleStart; // 创建环
        return head;
    }

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){//有环
                ListNode index1=fast;
                ListNode index2=head;
                // 两个指针，从头结点和相遇结点，各走一步，直到相遇，相遇点即为环入口
                while(index2!=index1){
                    index1=index1.next;
                    index2=index2.next;
                }
                return index1;
            }
        }
        return null;
    }
}
