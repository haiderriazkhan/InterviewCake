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
	
	public Node find_kth_to_last_node(Node head, int k) {
		
		if (head == null || k < 0) return null;	
		
		Node first = head;
		Node second = head;
		
		int counter = k;
		
		while (counter > 0) {
			
			if (first.next != null ) {
				
				first = first.next;
				--counter;
			}
			else {
				return null;
			}
			
		}
		
		
		
		while (true) {
			
			if (first.next == null) return second; 
			
			first = first.next;
			second = second.next;	
			
		}
		
	}
	
	
	
}
