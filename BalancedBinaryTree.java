// We define a binary tree to be balanced if the difference between the depths of any two leaf nodes is no greater than one.
// In other words, the difference between the depths of all possible pair of leaves in the tree must be 
// less than or equal to one.

// Write a method that determines whether a given binary tree is balanced as per the definition above.


// Solution
public class BalancedBinaryTree {


	class Node {
	
 		Node left;
  		Node right;
  		Object value;
	}	
	
	
	// Depth-First Search : Since it reaches leaves fatser, use DFS for most cases.
	public boolean IsBalanced_DFS(Node root) {
    	
  		if (root == null) return true;
        
  		Integer first_leaf_depth = null;
  		Integer second_leaf_depth = null;
    	
		Deque<Map.Entry<Node,Integer>> stack = new ArrayDeque<Map.Entry<Node,Integer>>();
        
  		stack.push(new AbstractMap.SimpleEntry<Node,Integer>(root, 0));
        
  		while (!stack.isEmpty()) {
        	
    			Map.Entry<Node,Integer> tuple = stack.pop();
        	
    			Node head = tuple.getKey();
    			Integer depth = tuple.getValue();
            
    			if (head.left != null) {
      			stack.push(new AbstractMap.SimpleEntry<Node,Integer>(head.left, depth + 1));
    			} 
    			if (head.right != null) {
      			stack.push(new AbstractMap.SimpleEntry<Node,Integer>(head.right, depth + 1));
    			} 
            
    			if (head.left == null && head.right == null) {
            	
      				if (first_leaf_depth == null){
      					
        				first_leaf_depth = depth;
      				}
      				else if (second_leaf_depth == null) {
      					
      					if (Math.abs(depth - first_leaf_depth) > 1) return false;
      					if (depth != first_leaf_depth) second_leaf_depth = depth;
      				}
      				else {
        				if (depth != first_leaf_depth && depth != second_leaf_depth ) return false;
        			}
      			}
  		}
  	
        	return true;
	}


	// Breadth-First Search 
	public boolean IsBalanced_BFS(Node root) {
	
		if (root == null) return true;
	
		Integer min_leaf_depth = null;
		Integer second_min_leaf_depth = null;
		
	
		Queue<Map.Entry<Node,Integer>> q = new ArrayDeque<Map.Entry<Node,Integer>>();
	
		q.add(new AbstractMap.SimpleEntry<Node,Integer>(root, 0));
	
		while (!q.isEmpty()) {
		
			Map.Entry<Node,Integer> tuple = q.remove();
		
			Node head = tuple.getKey();
			Integer depth = tuple.getValue();
		
			if (head.left != null) {
				q.add(new AbstractMap.SimpleEntry<Node,Integer>(head.left, depth + 1));	
			}
			if (head.right != null) {
				q.add(new AbstractMap.SimpleEntry<Node,Integer>(head.right, depth + 1));
			}
		
			if (head.left == null && head.right == null) {
			
				if (min_leaf_depth == null){
      					
        				min_leaf_depth = depth;
      				}
      				else if (second_min_leaf_depth == null) {
      					
      					if (Math.abs(depth - min_leaf_depth) > 1) return false;
      					if (depth != min_leaf_depth) second_min_leaf_depth = depth;
      				}
      				else {
        				if (depth != min_leaf_depth && depth != second_min_leaf_depth ) return false;
        			}
			
			}
		
		}
	
		return true;
	}
	
}



