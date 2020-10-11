package binary_tree_level_order_traversal_102;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * <b>102. Binary Tree Level Order Traversal</b>
 * <p>
 * Given a binary tree, return the <i>level order</i> traversal of its nodes'
 * values. (ie, from left to right, level by level).
 * </p>
 * 
 * <p>
 * For example:<br>
 * Given binary tree <code>[3,9,20,null,null,15,7]</code>,<br>
 * </p>
 * 
 * <pre>
 *     3
   / \
  9  20
    /  \
   15   7
 * </pre>
 * <p>
 * </p>
 * <p>
 * return its level order traversal as:<br>
 * </p>
 * 
 * <pre>
 * [
  [3],
  [9,20],
  [15,7]
]
 * </pre>
 * <p>
 * </p>
 */
class Solution {
	public List<List<Integer>> levelOrder(TreeNode root) {
		// result list
		List<List<Integer>> result = new ArrayList<List<Integer>>();

		// linked list implementation of the queue
		Queue<TreeNode> queue = new LinkedList<>();

		// add the root to the queue
		if (root != null)
			queue.add(root);

		// back track breadth first traversal
		while (!queue.isEmpty()) {
			List<Integer> list = new ArrayList<>();
			int levelSize = queue.size();

			// for each level make sure all nodes are in the saame list
			for (int i = 0; i < levelSize; i++) {
				TreeNode currentNode = queue.poll();
				list.add(currentNode.val);

				// add left & right children to the queue
				if (currentNode.left != null)
					queue.offer(currentNode.left);
				if (currentNode.right != null)
					queue.offer(currentNode.right);
			}
			result.add(list);
		}
		return result;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(9);
		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(5);

		Solution solution = new Solution();

		List<List<Integer>> result = solution.levelOrder(root);
		System.out.println("Level order traversal: " + result);
	}

}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
};