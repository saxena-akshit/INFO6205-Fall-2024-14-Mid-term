import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class LargestLevelSumTest {

    @Test
    public void testSingleNodeTree() {
        TreeNode root = LargestLevelSum.buildTreeFromLevelOrder(new Integer[]{10});
        assertEquals(10, LargestLevelSum.maxLevelSum(root));
    }

    @Test
    public void testFullBinaryTreeWithPositiveValues() {
        TreeNode root = LargestLevelSum.buildTreeFromLevelOrder(new Integer[]{1, 2, 3, 4, 5, 6, 7});
        assertEquals(22, LargestLevelSum.maxLevelSum(root));
    }

    @Test
    public void testTreeWithAllNegativeValues() {
        TreeNode root = LargestLevelSum.buildTreeFromLevelOrder(new Integer[]{-1, -2, -3, -4, -5, -6, -7});
        assertEquals(-1, LargestLevelSum.maxLevelSum(root));
    }

    @Test
    public void testTreeWithMixedPositiveAndNegativeValues() {
        TreeNode root = LargestLevelSum.buildTreeFromLevelOrder(new Integer[]{1, -2, 3, 4, -5, -6, 7});
        assertEquals(1, LargestLevelSum.maxLevelSum(root));
    }

    @Test
    public void testRightSkewedTree() {
        TreeNode root = LargestLevelSum.buildTreeFromLevelOrder(new Integer[]{1, -2, null, -3, null, null, null});
        assertEquals(1, LargestLevelSum.maxLevelSum(root));
    }

    @Test
    public void testLeftSkewedTree() {
        TreeNode root = LargestLevelSum.buildTreeFromLevelOrder(new Integer[]{1, 2, null, 3, null, null, null});
        assertEquals(3, LargestLevelSum.maxLevelSum(root));
    }

    @Test
    public void testEmptyTree() {
        TreeNode root = LargestLevelSum.buildTreeFromLevelOrder(new Integer[]{});
        assertEquals(0, LargestLevelSum.maxLevelSum(root));
    }

    @Test
    public void testTreeWithOneChildAtDifferentLevels() {
        TreeNode root = LargestLevelSum.buildTreeFromLevelOrder(new Integer[]{1, 2, null, 4});
        assertEquals(4, LargestLevelSum.maxLevelSum(root));
    }

    @Test
    public void testPerfectBinaryTreeWithAllZeroes() {
        TreeNode root = LargestLevelSum.buildTreeFromLevelOrder(new Integer[]{0, 0, 0, 0, 0, 0, 0});
        assertEquals(0, LargestLevelSum.maxLevelSum(root));
    }

    @Test
    public void testLargerBalancedTree() {
        TreeNode root = LargestLevelSum.buildTreeFromLevelOrder(new Integer[]{5, 3, 8, 1, 4, 7, 9, 0, 2, 6});
        assertEquals(21, LargestLevelSum.maxLevelSum(root));
    }
}
