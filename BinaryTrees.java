// The diameter of a binary tree is defined to be the length of the longest path in the tree from one distinct leaf node to another (distinct) leaf node.
// Write a method to determine the diameter of a given binary tree.

// Hint: To solve this problem, it might be useful to first write a method to determine the height of a binary tree.
// The height of a binary tree is defined to be the length of the longest path to a leaf node from the root node.
public class BinaryTrees {

	public class Node {

		Node left;
		Node right;
		int val;

	}

	// Method to determine the height of a tree.
	public int height(Node node) {

		if (node == null) {
			return 0;
		}

		return 1 + Math.max(height(node.left) ,  height(node.right));

	}

	// Method to determine the diameter of a tree.
	public int diameter(Node node) {

		if (node == null) {
			return 0;
		}

		int heightL = height(node.left);
		int heightR = height(node.right);

		int diameterL = diameter(node.left);
		int diameterR = diameter(node.right);

		return Math.max(1 + heightL + heightR , Math.max(diameterL, diameterR));

	}


	// Function to determine the most common (frequently occurring) value in a binary tree.
	// Hint: We will be using the most important data structure ever invented.
	public Integer mostFreq(Node root) {

		Map<Integer , Integer> tracker = new HashMap<>();
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

	private void inOrderTraversal(Node node, Map<Integer,Integer> HM) {

		if (node == null) {
			return;
		}

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
		int lower_bound;
		int upper_bound;

		Bounds(Node node, int lower_bound, int upper_bound) {

			this.node = node;
			this.lower_bound = lower_bound;
			this.upper_bound = upper_bound;
		}

	}


	// Method to check if a binary tree is also a valid binary search tree (BST).

	// Description of solution: Do a depth-first traversal of the tree and test if each node satisfies the binary search
	// tree property. The binary search tree property states that a node is valid if its key is greater than every
	// ancestral node in whose right-subtree it resides and less than every ancestral node in whose left-subtree it
	// resides. Instead of checking the node against all of its ancestors, simply check the largest number it should
	// be greater than (its lower bound) and the smallest number it should be less than (its upper bound).
	public boolean check_if_valid_binary_search_tree(Node node) {

		if (node == null) {
			return true;
		}

		// The diamond operator on the right hand side infers the type parameter from the left hand side.
		Deque<Bounds> stack = new ArrayDeque<>();

		stack.push(new Bounds(node, Integer.MIN_VALUE, Integer.MAX_VALUE));

		while (!stack.isEmpty()) {

			Bounds current = stack.pop();

			Node curr_node = current.node;
			int lower_bound = current.lower_bound;
			int upper_bound = current.upper_bound;

			if (curr_node.val <= lower_bound || curr_node.val >= upper_bound) {
				return false;
			}

			if (curr_node.left != null) {

				stack.push(new Bounds(curr_node.left, lower_bound, curr_node.val));

			}

			if (curr_node.right != null) {

				stack.push(new Bounds(curr_node.right, curr_node.val, upper_bound));

			}


		}

		return true;
	}

	// Find the kth smallest node in a Binary Search Tree (BST). The 0th node is defined to be the smallest.
	// The run time is O(n) while the space complexity is O(h) where h is the max height of the tree.
	public Node find_kth_element(Node root , int k) {

		if (root == null || k < 0) return null;

		Deque<Node> stack = new ArrayDeque<>();
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

			}

		}

		return null;
	}


}
