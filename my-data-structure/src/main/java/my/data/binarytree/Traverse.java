package my.data.binarytree;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author: yst
 * @version: 1.0
 * @date: 2022/12/4 20:12
 * @description: 二叉树遍历
 */
public class Traverse {

    private List<Integer> list = new ArrayList<>();

    /**
     * 前序  根左右  递归
     * @param root
     * @return
     */
    private List<Integer> preorderTraversalRecursion(TreeNode root) {

        if (root==null){
            return list;
        }
        list.add(root.val);

        preorderTraversalRecursion(root.left);
        preorderTraversalRecursion(root.right);

        return list;
    }

    /**
     * 前序  根左右  栈
     * @param root
     * @return
     */
    private List<Integer> preorderTraversal(TreeNode root) {

        Stack<Integer> stack = new Stack<>();
        if (root==null){
            return list;
        }
        list.add(root.val);

        preorderTraversalRecursion(root.left);
        preorderTraversalRecursion(root.right);

        return list;
    }



}
