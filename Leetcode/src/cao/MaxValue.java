package cao;

import java.util.Arrays;
import java.util.List;

public class MaxValue {

	public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null || k == 1){
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = dummy.next;
        int count = 0;
        ListNode successor;
        while(cur != null){
            count++;
            if(count % k == 0){
                pre = reverse(pre, k);
                cur = pre.next;
            }
            else{
                cur = cur.next;
            }
            
        }
        return dummy.next;
    }
    public ListNode reverse(ListNode pre, int k){
        if(pre.next == null){
            return null;
        }
        ListNode last = pre.next;
        ListNode cur = last.next;
        while(cur != null && --k > 0){
            last.next = cur.next;
            cur.next = pre.next;
            pre.next = cur;
            cur = last.next;
        }
        return last;
    }
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode dummy = new ListNode(0);
        int count = 0;
        dummy.next = head;
        ListNode cur = head;
        ListNode pre = dummy;
        ListNode last = head;
        ListNode tmp = head;
        while(cur != null){
            count++;
            if(count % 2 == 0){
            	tmp = pre.next;
                last.next = cur.next;
                cur.next = pre.next;
                pre.next = cur;
                cur = last.next;
                pre = tmp;
            }
            else{
                cur = cur.next;
            }
        }
        return dummy.next;
    }
	public static void main(String[] args){
		MaxValue s = new MaxValue();
		ListNode head = new ListNode(1);
		ListNode node = new ListNode(2);
		node.next = new ListNode(3);
		node.next.next = new ListNode(4);
		head.next = node;
		System.out.println(s.swapPairs(head));
	}
}
