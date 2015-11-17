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
	
	
	public boolean check_if_valid_binary_search_tree(Node root) {
		
		if (node == null) return true;
		
		List<Integer> ordered = new ArrayList<Integer>();
		
		InOrderTraversal_Add_to_List(root , ordered);
		
		Integer prev = ordered.get(0);
		
		for (Integer x : ordered) {
			
			if (x < prev) return false;
			prev = x;
			
		}
		
		return true;
	}
	
	private void InOrderTraversal_Add_to_List(Node node, List<Integer> ordered) {
		
		if (node == null) return;
		
		InOrderTraversal_Add_to_List(node.left , ordered);
		
		ordered.add(node);
		
		InOrderTraversal_Add_to_List(node.right , ordered);
		
	}
	
  
}
