

class Node{
	Node left;
  Node right;
	Object value;
}



// Depth-First Search
public static boolean IsBalanced(Node root){
    	
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
