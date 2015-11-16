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
	
	private void InOrderTraversal(Node node, HashMap<Integer,Integer> HM) {
		
		if(node == null) return;
		
		InOrderTraversal(node.left , HM);
		
		
		if (HM.get(node.val) == null ) {
			
			HM.put(node.val, 1) ;
			
		}
		else {
			
			HM.put(node.val , HM.get(node.val) + 1);
		}
		
		
		InOrderTraversal(node.right , HM);
		
	}
	
  
}
