public class LinkedListFun {
	
	// Cycle in a Linked List. We solve this using Floyd's cycle-finding algorithm.
	public boolean Is_There_A_Cycle(Node head) {
		
		if (head == null) return false;
		
		Node slow,fast;
		
		slow = head;
		fast = head;
		
		while (true) {
			
			slow = head.next;
			
			if (fast.next != null) {
				
				fast = fast.next.next;
				
			}
			else {
				
				return false;
				
			}
			
			if (fast == null) return false;
			
			if (slow == fast) return true;
			
		}
		
		
	}
	
	public <T> T find_kth_to_last_node(LinkedList<T> ll) {
		
		
		
		
	}
	
	
	
}
