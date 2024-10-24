
import java.util.LinkedList;
import java.util.Queue;

public class LargestLevelSum {
    // Example:
    // Given the following binary tree:
    //        1
    //      /   \
    //     2     3
    //    / \   / \
    //   4   5 6   7
    //
    // Level 0: 1                    -> sum = 1
    // Level 1: 2 + 3                -> sum = 5
    // Level 2: 4 + 5 + 6 + 7        -> sum = 22
    //
    // The maximum level sum is 22.
    //
    // You need to traverse each level of the tree, calculate the sum of the values
    // at that level, and keep track of the maximum sum encountered.

    /**
     * Finds the maximum level sum in a binary tree.
     *
     * @param root the root of the binary tree
     * @return the largest sum of any level in the tree
     */
    public static int maxLevelSum(TreeNode root) {

        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int maxSum = -100000000;
        while (!queue.isEmpty()) {
            int currSize = queue.size();
            int currSum = 0;

            for (int i = 0; i < currSize; i++) {
                TreeNode node = queue.poll();
                currSum += node.val;

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }

            if (currSum > maxSum) {
                maxSum = currSum;
            }
        }

        return maxSum;
    }

    /**
     * Builds a binary tree from a level-order traversal array.
     *
     * @param levelOrder the level-order traversal array
     * @return the root of the constructed binary tree
     */
    public static TreeNode buildTreeFromLevelOrder(Integer[] levelOrder) {

        if (levelOrder == null || levelOrder.length == 0) {
            return null;
        }

        TreeNode root = (levelOrder[0] != null) ? new TreeNode(levelOrder[0]) : null;

        if (root == null) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;

        while (i < levelOrder.length) {
            TreeNode currentNode = queue.poll();

            if (levelOrder[i] != null) {
                assert currentNode != null;
                currentNode.left = new TreeNode(levelOrder[i]);
                queue.add(currentNode.left);
            }
            i++;

            if (i < levelOrder.length && levelOrder[i] != null) {
                assert currentNode != null;
                currentNode.right = new TreeNode(levelOrder[i]);
                queue.add(currentNode.right);
            }
            i++;
        }

        return root;
    }
}
