/**
 * @Auther: zhangyian
 * @Date: 2023/3/19 20:28
 * @Description:
 */
public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }

    public static  void removeNthFromEnd(ListNode head, int n,ListNode dummy) {
         ListNode fast;
         ListNode slow;
         fast=dummy;
         slow=dummy;
         dummy.next=head;

         while(n+1>0){
             fast=fast.next;
             n--;
         }

         while(fast!=null){
             slow=slow.next;
             fast=fast.next;
         }

         ListNode temp=slow.next.next;
         slow.next=temp;

    }



    public static void main(String[] args) {
        // 创建节点并添加值
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);

        // 构建链表
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        // 输出链表
        ListNode head = node1;
        ListNode dummy=new ListNode(-1);

        removeNthFromEnd(head,2,dummy);


        ListNode cur2=dummy.next;
        while (cur2 != null) {
            System.out.print(cur2.val + "->");
            cur2 = cur2.next;
        }
        System.out.println("null");
    }
}




