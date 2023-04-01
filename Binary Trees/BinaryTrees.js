/*jslint es6 */
'use strict';


// checks if a binary tree is a binary search tree
function checkIfBST(rootNode) {

    const nodeAndBoundsStack = [];

    nodeAndBoundsStack.push({
        node: rootNode,
        lowerBound: Number.MIN_SAFE_INTEGER,
        UpperBound: Number.MAX_SAFE_INTEGER
    });

    while (nodeAndBoundsStack.length) {
        const {node, lowerBound, UpperBound} = nodeAndBoundsStack.pop();

        if (node.value <= lowerBound || node.value >= UpperBound) {
            return false;
        }

        if (node.left) {
            nodeAndBoundsStack.push({
                node: node.left,
                lowerBound,
                UpperBound: node.value
            });
        }

        if (node.right) {
            nodeAndBoundsStack.push({
                node: node.right,
                lowerBound: node.value,
                UpperBound
            });
        }
    }

    return true;

}


// We define a binary tree to be balanced if the difference between the depths of any two leaf nodes is no greater than one.
// In other words, the difference between the depths of all possible pair of leaves in the tree must be
// less than or equal to one.

// Write a method that determines whether a given binary tree is balanced as per the definition above.

// Depth-First Search : Since it reaches leaves fatser, use DFS for most cases.
function isBalancedBT(rootNode) {

    const stack = [];

    stack.push({node: rootNode, depth: 0});

    let firstLeafDepth, secondLeafDepth;

    while (stack.length) {

        const {node, depth} = stack.pop();

        if (node.left) {
            stack.push({node: node.left, depth: depth + 1});
        }

        if (node.right) {
            stack.push({node: node.right, depth: depth + 1});
        }

        if (!node.left && !node.right) {
            if (!firstLeafDepth) {
                firstLeafDepth = depth;
            } else if (Math.abs(firstLeafDepth - depth) > 1) {
                return false;
            } else if (depth !== firstLeafDepth && !secondLeafDepth) {
                secondLeafDepth = depth;
            } else if (depth !== firstLeafDepth && depth !== secondLeafDepth) {
                return false;
            }
        }

    }

    return true;

}

// The diameter of a binary tree is defined to be the length of the longest path in the tree from one distinct leaf node to another (distinct) leaf node.
// Write a method to determine the diameter of a given binary tree.

// Hint: To solve this problem, it might be useful to first write a method to determine the height of a binary tree.
// The height of a binary tree is defined to be the length of the longest path to a leaf node from the root node.

function treeHeight(node) {

    if (!node) {
        return 0;
    }

    return 1 + Math.max(treeHeight(node.left), treeHeight(node.right));
}

function treeDiameter(node) {

    if (!node) {
        return 0;
    }

    return Math.max(1 + treeHeight(node.left) + treeHeight(node.right), treeDiameter(node.left), treeDiameter(node.right));
}

function inOrderTraversal(node, freqTracker) {
    if (!node) {
        return;
    }
    inOrderTraversal(node.left, freqTracker);

    if (freqTracker.has(node.value)) {
        freqTracker.set(node.value, freqTracker.get(node.value) + 1);
    } else {
        freqTracker.set(node.value, 1);
    }

    inOrderTraversal(node.right, freqTracker);
}

// Function to determine the most common (frequently occurring) value in a binary tree.
function mostFreqElemBT(rootNode) {
    const freqTracker = new Map();

    inOrderTraversal(rootNode, freqTracker);

    return [...freqTracker.entries()].reduce((a, b) => a[1] > b[1] ? a : b)[0];
}

// Find the kth smallest node in a Binary Search Tree (BST). The 0th node is defined to be the smallest.
// The run time is O(n) while the space complexity is O(h) where h is the max height of the tree.

function find_kth_element_BST(rootNode, k) {

    if (!rootNode) {
        return;
    }
    const stack = [];

    stack.push(rootNode);

    while(stack.length) {
        const node = stack[stack.length - 1];
        if (node.left) {
            stack.push(node.left);
            continue;
        }

        if (k == 0) return node;
        stack.pop();
        k--;

        if (node.right) {
            stack.push(node.right);
        }
    }
    return null;
}

class BinaryTreeNode {

    constructor(value) {
      this.value = value;
      this.left = null;
      this.right = null;
    }

    insertLeft(value) {
      this.left = new BinaryTreeNode(value);
      return this.left;
    }

    insertRight(value) {
      this.right = new BinaryTreeNode(value);
      return this.right;
    }
}
