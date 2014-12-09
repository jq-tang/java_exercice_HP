
public class Reorder {
	public void reorderList(SListNode head) {
        if(head == null || head.next == null)
            return;
        //halve
        SListNode slow = head;
        SListNode fast = head;
        SListNode pre = null;
        while(fast != null && fast.next != null){
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;
        //reverse the second half
        SListNode head2 = reverse(slow);
        merge(head, head2);
    }
    public SListNode reverse(SListNode cur){
        if(cur == null || cur.next == null)
            return cur;
        SListNode pre = null;
        while(cur != null){
            SListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
    public void merge(SListNode l1, SListNode l2){
        SListNode dummy = new SListNode(0);
        SListNode cur = dummy;
        while(l1 != null && l2 != null){
            cur.next = l1;
            l1 = l1.next;
            cur = cur.next;
            cur.next = l2;
            cur = cur.next;
            l2 = l2.next;
        }
        if(l1 == null){
            cur.next = l2;
        }
        else if(l2 == null){
            cur.next = l1;
        }
        l1 = dummy.next;
    }
    public static void main(String[] args){
    	SList slist = new SList(3);
		slist.addNode(5);
		slist.addNode(7);
		Reorder obj = new Reorder();
		obj.reorderList(slist.head);
		slist.printSList(slist);
    }
}
