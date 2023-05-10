package my.data.binarytree;

/**
 * @author: yst
 * @version: 1.0
 * @date: 2023/1/17 10:37
 * @description:
 */
public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

}
