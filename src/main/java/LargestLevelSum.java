import java.util.LinkedList;
import java.util.Queue;

public class LargestLevelSum {
    /**
     * Finds the maximum level sum in a binary tree.
     *
     * @param root the root of the binary tree
     * @return the largest sum of any level in the tree
     */
    public static int maxLevelSum(TreeNode root) {
        //TO BE IMPLEMENTED

        Queue<TreeNode> queue = new LinkedList<>();
        
        
        while (!queue.isEmpty()) {
           //TO BE IMPLEMENTED
          
        }

        return 0;
    }

    /**
     * Builds a binary tree from a level-order traversal array.
     *
     * @param levelOrder the level-order traversal array
     * @return the root of the constructed binary tree
     */
    public static TreeNode buildTreeFromLevelOrder(int[] levelOrder) {
        // If the array is empty, return null (no tree)
        if (levelOrder == null || levelOrder.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(levelOrder[0]);

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;  

        while (i < levelOrder.length) {
            TreeNode currentNode = queue.poll();

            if (i < levelOrder.length) {
                currentNode.left = new TreeNode(levelOrder[i]);
                queue.add(currentNode.left);  
                i++;
            }

            if (i < levelOrder.length) {
                currentNode.right = new TreeNode(levelOrder[i]);
                queue.add(currentNode.right);  //
                i++;
            }
        }

        return root;  // Return the constructed tree's root
    }

}
