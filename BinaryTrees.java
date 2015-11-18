public class BinaryTrees {
	
	public class Node {
		
		Node left;
		Node right;
		int val;
		
	}
	
	public int height(Node node) {

		if (node == null) return 0;
		return 1 + Math.max(height(node.left) ,  height(node.right));
		
	}
	
	public int diameter(Node node) {
		
		if (node == null) return 0;
		
		int heightL = height(node.left);
		int heightR = height(node.right);
		
		int diameterL = diameter(node.left);
		int diameterR = diameter(node.right);
		
		return Math.max(1 + heightL + heightR , Math.max(diameterL, diameterR));
		
	}
	
	public Integer MostFreq(Node root) {
		
		Map<Integer , Integer> tracker = new HashMap<Integer , Integer>();
		InOrderTraversal(root, tracker);
		
		Integer max = 0;
		Integer elem = null;
		
		for (int x : tracker.keySet() )
			
			if (tracker.get(x) > max) { 
				
				max = tracker.get(x) ; 
				elem = x ;
			}
		
		return elem;
	}
	
	private void InOrderTraversal(Node node, Map<Integer,Integer> HM) {
		
		if (node == null) return;
		
		InOrderTraversal(node.left , HM);
		
		
		if (HM.get(node.val) == null ) {
			
			HM.put(node.val, 1) ;
			
		}
		else {
			
			HM.put(node.val , HM.get(node.val) + 1);
		}
		
		
		InOrderTraversal(node.right , HM);
		
	}
	
	
	
	private class Bounds {
		
		Node node;
		int min_bound;
		int max_bound;
		
	}
	
	
	
	public boolean check_if_valid_binary_search_tree(Node node) {
		
		if (node == null) return true;
		
		Deque<Bounds> stack = new ArrayDeque<Bounds>();
		
		Bounds bounds = new Bounds();
		
		bounds.node = node;
		bounds.max_bound = Integer.MIN_VALUE;
		bounds.min_bound = Integer.MAX_VALUE;
		
		stack.push(bounds);
		
		while (!stack.isEmpty()) {
			
			bounds = stack.pop();
			
			Node curr_node = bounds.node;
			int lower_bound = bounds.min_bound;
			int upper_bound = bounds.max_bound;
			
			if (curr_node.val < lower_bound || curr_node.val > upper_bound) return false;
			
			if (curr_node.left != null) {
				
				bounds.node = curr_node.left;
				bounds.max_bound = curr_node.val;
				bounds.min_bound = lower_bound;
				
				stack.push(bounds);
				
			}
			
			if (curr_node.right != null) {
				
				bounds.node = curr_node.right;
				bounds.min_bound = curr_node.val;
				bounds.max_bound = upper_bound;
				
				stack.push(bounds);
				
			}
			
			
		}
		
		
		return true;
		
	}
	
	// Find the kth smallest element in a Binary Search Tree. The 0th element is defined to be the smallest.
	public Node find_kth_element(Node root , int k) {
		
		if (root == null || k < 0) return null;
		
		Deque<Node> stack = new ArrayDeque<Node>();
		stack.push(root);
		
		while (!stack.isEmpty()) {
			
			Node curr = stack.peek();
			
			if (curr.left != null) {
				
				stack.push(curr.left);
				continue;
			}
			
			if (k == 0) return curr;
			stack.pop();
			--k;
			
			if (curr.right != null) {
				
				stack.push(curr.right);
				continue;	
				
			}
			
		}
		
		return null;
	}
	
  
}
