import java.util.List;

/**
 * @Auther: zhangyian
 * @Date: 2023/3/14 21:35
 * @Description:
 */
public class ListNode {
    int val;
    ListNode next;
    ListNode(){
    }

    ListNode(int val){
        this.val=val;
    }

    ListNode(int val,ListNode next){
        this.val=val;
        this.next=next;
    }

    public static void removeElements(ListNode head, int val) {
        if(head==null){
            return;
        }

        ListNode preHead=new ListNode(-1,head);
        ListNode pre=preHead;
        ListNode cur=head;
        while(cur!=null){
            if(cur.val==val){
                pre.next=cur.next;
            }else{
                pre=cur;
            }
            cur=cur.next;
        }
        System.out.println(preHead.next.val);
    }

    public static void main(String[] args) {
        ListNode head=new ListNode(1);
        ListNode node1=new ListNode(2);
        ListNode node2=new ListNode(3);
        ListNode node3=new ListNode(4);

        head.next=node1;
        node1.next=node2;
        node2.next=node3;
        node3.next=null;

        removeElements(head,3);
    }

}



