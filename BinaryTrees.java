public class BinaryTrees {
	
	public class Node {
		
		Node left;
		Node right;
		int val;
		
	}
	
	public int height(Node node){

		if(node == null) return 0;
		return 1 + Math.max(height(node.left) ,  height(node.right));
		
	}
	
	
	
  
}
