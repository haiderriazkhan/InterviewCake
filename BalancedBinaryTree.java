// We define a binary tree to be balanced if the difference between the depths of any two leaf nodes is no greater than one.
// In other words, the difference between the depths of all possible pair of leaves in the tree must be
// less than or equal to one.

// Write a method that determines whether a given binary tree is balanced as per the definition above.



public class BalancedBinaryTree {


	class Node <T> {

		Node <T> left;
		Node <T> right;
		T value;
	}



	// Depth-First Search : Since it reaches leaves fatser, use DFS for most cases.
	public boolean isBalancedDFS(Node<?> root) {

		if (root == null) {
			return true;
		}

		Integer firstLeafDepth = null;
		Integer secondLeafDepth = null;

		Deque<Map.Entry<Node<?>,Integer>> stack = new ArrayDeque<>();

		stack.push(new AbstractMap.SimpleEntry<Node<?>,Integer>(root, 0));

		while (!stack.isEmpty()) {

			Map.Entry<Node<?>,Integer> dual = stack.pop();

			Node<?> head = dual.getKey();
			Integer depth = dual.getValue();

			if (head.left != null) {
				stack.push(new AbstractMap.SimpleEntry<Node<?>,Integer>(head.left, depth + 1));
			}
			if (head.right != null) {
				stack.push(new AbstractMap.SimpleEntry<Node<?>,Integer>(head.right, depth + 1));
			}

			if (head.left == null && head.right == null) {

				if (firstLeafDepth == null) {
					firstLeafDepth = depth;
				} else if (secondLeafDepth == null && Math.abs(depth - firstLeafDepth) > 1) {
					return false;
				} else if (secondLeafDepth == null && depth != firstLeafDepth) {
					secondLeafDepth = depth;
				} else if (depth != firstLeafDepth && depth != secondLeafDepth) {
					return false;
				}

			}

		}

		return true;
	}


	// Breadth-First Search
	public boolean isBalancedBFS(Node<?> root) {

		if (root == null) {
			return true;
		}

		Integer minLeafDepth = null;
		Integer secondMinLeafDepth = null;


		Queue<Map.Entry<Node<?>,Integer>> q = new ArrayDeque<>();

		q.add(new AbstractMap.SimpleEntry<Node<?>,Integer>(root, 0));

		while (!q.isEmpty()) {

			Map.Entry<Node<?>,Integer> dual = q.remove();

			Node<?> head = dual.getKey();
			Integer depth = dual.getValue();

			if (head.left != null) {
				q.add(new AbstractMap.SimpleEntry<Node<?>,Integer>(head.left, depth + 1));
			}
			if (head.right != null) {
				q.add(new AbstractMap.SimpleEntry<Node<?>,Integer>(head.right, depth + 1));
			}

			if (head.left == null && head.right == null) {

				if (minLeafDepth == null) {
					minLeafDepth = depth;
				} else if (secondMinLeafDepth == null && Math.abs(depth - minLeafDepth) > 1) {
					return false;
				} else if (secondMinLeafDepth == null && depth != minLeafDepth) {
					secondMinLeafDepth = depth;
				} else if (depth != minLeafDepth && depth != secondMinLeafDepth) {
					return false;
				}

			}

		}

		return true;
	}

}
