/**
 * @Auther: zhangyian
 * @Date: 2023/3/18 00:00
 * @Description:
 */
public class ListNode {
    int val;
    ListNode next;
    // 构造函数
    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }

    public static void swapPairs(ListNode head,ListNode dummy) {
        ListNode curHead=dummy;//虚拟头结点
        curHead.next=head;

        ListNode cur=curHead;//cur指针指向虚拟头结点
        ListNode first;
        ListNode second;
        ListNode temp;

        while(cur.next!=null&&cur.next.next!=null){
            temp=cur.next.next.next;//保存两个结点后的结点
            first=cur.next;
            second=cur.next.next;
            //第一步
            cur.next=second;
            //第二步
            cur.next.next=first;
            //第三步
            first.next=temp;
            //移动指针
            cur=first;
        }
    }

    public static void main(String[] args) {
        // 初始化链表节点
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        // 设置节点指针
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = null;
        // 将头节点指向第一个节点
        ListNode head = node1;

        ListNode dummy=new ListNode(-2);
        dummy.next=head;
        swapPairs(head,dummy);


        ListNode cur2=dummy.next;
        while (cur2 != null) {
            System.out.print(cur2.val + "->");
            cur2 = cur2.next;
        }
        System.out.println("null");
    }
}



