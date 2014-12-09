import java.util.Hashtable;


public class SList {
	SListNode head;
	private int size;
	SList(){
		head = null;
		size = 0;
	}
	SList(Object obj){
		head = new SListNode(obj);
	}
	
	void addNode(Object obj){
		if(head == null)
			head = new SListNode(obj);
		SListNode cur = head;
		while(cur.next != null)
			cur = cur.next;
		cur.next = new SListNode(obj);
	}
	void printSList(SList slist){
		SListNode cur = head;
		while(cur != null)
		{
			
			System.out.print(cur.item + " ");
			cur = cur.next;
		}
			
	
	}
	void rmDup (SList slist){
		SListNode cur, runner;
		if(head != null){
			cur = slist.head;
			for(cur = slist.head; cur != null; cur = cur.next)
			//while(cur != null)
			{
				runner = cur;
				 while(runner.next != null)
				 {
					 
					 if(runner.next.item == cur.item)
						 runner.next = runner.next.next;
					 else
						 runner = runner.next;
					
					 
				 }
				// cur = cur.next;
			}
			 
			 
		}
			
	}
	public boolean hasCycle(SListNode head) {
        if(head == null || head.next == null)
            return false;
        SListNode slow = head;
        SListNode fast = head;
        while(fast != null && fast.next != null && fast != slow){
            slow = slow.next;
            fast = fast.next.next;

        }
        if(fast == null || fast.next == null)
            return false;
        return true;
    }
//	void deleteDups(SListNode n){
//		Hashtable table = new Hashtable();
//		SListNode previous = null;
//		while(n != null){
//			if(table.containsKey(n.item))
//				previous.next = n.next;
//			else{
//				table.put(n.data, arg1)
//			}
//		}
//	}
	SListNode findLastnth(SList slist, int n){
		int size = slist.getSize(slist);
		SListNode node;
		if(n > size)
			return null;
		else
		{
			node = slist.head;
			int count = size - n + 1;
			for(int i = 1; i <= count; i++)
				node = node.next;
			
		}
		
				
		return node;
	}
	int getSize(SList slist){
		SListNode last = slist.head;
		int count = 0;
		if(head != null)
			++count;
			while(last.next != null){
				last = last.next;
				++count;
			}
		return count;
	}
	public SListNode removeNthFromEnd(SListNode head, int n) {
        if(head == null)
            return null;
        SListNode runner = head;
        SListNode slow = head;
        if(n == 1 && head.next == null)
            return null;
        for(int i = 1; i < n; ++i)
        {
           // if(runner.next != null)
                runner = runner.next;
        }
        if(runner.next == null)
            return head.next;
        while(runner.next != null){
            runner = runner.next;
            slow = slow.next;
        }
        if(slow == runner){
        	System.out.println("yea");
        }
        if(slow.next != null)
        {
            slow.item = slow.next.item;
            slow.next = slow.next.next;
        }
        else{
        	System.out.println(slow.item);
            slow = null;
            System.out.println(runner.item);
        }
        return head;
    }
	public TreeNode sortedListToBST(SListNode head) {
        if(head == null)
            return null;
        int n = 0;
         SListNode slow = head;
        while(slow != null){
            slow = slow.next;
            ++n;
        }
        System.out.println("n is " + n);
        return findNext(head, 0, n - 1);
        }
        
    
    public TreeNode findNext(SListNode list, int start, int end){
        if(start > end)
            return null;
        int mid = (start + end) / 2;
        TreeNode left = findNext(list, start, mid - 1);
        TreeNode parent = new TreeNode(list.item);
        System.out.println("the val of list is " + list.item);
        parent.left = left;
        list = list.next;
        parent.right = findNext(list, mid+1, end);
        return parent;
    }
    
    public SListNode Reverse(SListNode pre, SListNode next){
    	SListNode last = pre.next;
    	SListNode cur = last.next;
    	while(cur != next){
    		last.next = cur.next;
    		cur.next = pre.next;
    		pre.next = cur;
    		cur = last.next;
    	}
    	
		return last;
    }
	public static void main(String[] args){
		SList slist = new SList(3);
		slist.addNode(5);
//		slist.addNode(8);
//		slist.addNode(2);
//		slist.addNode(1);
//		slist.addNode(7);
//		slist.printSList(slist);
//		System.out.println();
//		SListNode last = slist.Reverse(slist.head, slist.head.next.next.next.next);
		//System.out.println(last.item);
		slist.printSList(slist);
		System.out.println(slist.hasCycle(slist.head));
//		SListNode s = slist.removeNthFromEnd(slist.head, 1);
//		//slist.printSList(slist);
//		SListNode curr = slist.head;
//		curr.item = 5;
//		slist.printSList(slist);
////		slist.rmDup(slist);
////		slist.printSList(slist);
//		//System.out.println(slist.findLastnth(slist, 2).item);
	//	slist.sortedListToBST(slist.head);
	}
}
