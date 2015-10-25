// A tree is balanced if the difference between the depths of any two leaf nodes is no greater than one.

public class IsBalanced{


	class Node{
	
 		Node left;
  		Node right;
  		Object value;
	}	
	
	
	// Depth-First Search : Since it reaches leaves fatser, use DFS for most cases.
	public boolean IsBalanced_DFS(Node root){
    	
  		if(root == null) return true;
        
  		Integer first_leaf_height = null;
    	
		Deque<Map.Entry<Node,Integer>> stack = new ArrayDeque<Map.Entry<Node,Integer>>();
        
  		stack.push(new AbstractMap.SimpleEntry<Node,Integer>(root, 0));
        
  		while (!stack.isEmpty()){
        	
    			Map.Entry<Node,Integer> tuple = stack.pop();
        	
    			Node head = tuple.getKey();
    			Integer depth = tuple.getValue();
            
    			if(head.left != null){
      			stack.push(new AbstractMap.SimpleEntry<Node,Integer>(head.left, depth + 1));
    			} 
    			if(head.right != null){
      			stack.push(new AbstractMap.SimpleEntry<Node,Integer>(head.right, depth + 1));
    			} 
            
    			if (head.left == null && head.right == null){
            	
      				if (first_leaf_height == null){ 
        				first_leaf_height = depth;
      				}
      				else{
        				if ( Math.abs(depth - first_leaf_height) > 1) return false;
        			}
      			}
  		}
  	
        	return true;
	}


	// Breadth-First Search 
	public boolean IsBalanced_BFS(Node root){
	
		if (root == null) return true;
	
		Integer min_leaf_height = null;
	
		Queue<Map.Entry<Node,Integer>> q = new ArrayDeque<Map.Entry<Node,Integer>>();
	
		q.add(new AbstractMap.SimpleEntry<Node,Integer>(root, 0));
	
		while (!q.isEmpty()){
		
			Map.Entry<Node,Integer> tuple = q.remove();
		
			Node head = tuple.getKey();
			Integer depth = tuple.getValue();
		
			if (head.left != null){
				q.add(new AbstractMap.SimpleEntry<Node,Integer>(head.left, depth + 1));	
			}
			if (head.right != null){
				q.add(new AbstractMap.SimpleEntry<Node,Integer>(head.right, depth + 1));
			}
		
			if (head.left == null && head.right == null){
			
				if (min_leaf_height == null){ 
				
					min_leaf_height = depth;	
				}
				else{
					if ( Math.abs(depth - min_leaf_height) > 1) return false;	
				}
			
			}
		
		}
	
		return true;
	}
	
}



