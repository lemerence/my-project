package y2021.m04;


/**
 * @Author: YST
 * @Date: 2021/4/13 22:04
 * @Version: 1.0
 * @Description: 二叉搜索树节点最小距离
 * 给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
 */
public class MinDistanceBstNodes {

    /**
     * @Author: YST
     * @Date: 23:23 2021/4/13
     * @Param: [root]
     * @Return: int
     * @Description: 返回相邻节点最小差
     **/
    public int minDiffInBSTAdjacent(TreeNode root) {


        int mid = root.val;
        TreeNode left = root.left;
        TreeNode right = root.right;
        if (left == null) {
            int val = right.val;
            return getMinAdjacent(right, val - mid);
        }
        if (right == null) {
            int val = left.val;
            return getMinAdjacent(left, mid - val);
        }

        return Math.min(getMinAdjacent(left, mid - left.val), getMinAdjacent(right, right.val - mid));

    }

    /**
     * @Author: YST
     * @Date: 23:26 2021/4/13
     * @Param: [root, min]
     * @Return: int
     * @Description: 相邻节点最小值
     **/
    private int getMinAdjacent(TreeNode root, int min) {
        int mid = root.val;
        TreeNode left = root.left;
        TreeNode right = root.right;
        if (left == null && right == null) {
            return min;
        } else if (left == null) {
            int rightVal = right.val;
            return getMinAdjacent(right, Math.min(min,rightVal - mid));
        } else if (right == null) {
            int leftVal = left.val;
            return getMinAdjacent(left, Math.min(min,mid - leftVal));
        } else {
            int leftVal = left.val;
            int rightVal = right.val;
            int leftMin = mid - leftVal;
            int rightMin = rightVal - mid;
            int newMin = Math.min(Math.min(min, leftMin), rightMin);
            return Math.min(getMinAdjacent(left, newMin), getMinAdjacent(right, newMin));
        }
    }

//    public int minDiffInBST(TreeNode root) {
//
//
//        int mid = root.val;
//        TreeNode left = root.left;
//        TreeNode right = root.right;
//        if (left == null) {
//            int val = right.val;
//            return getMin(right, val - mid);
//        }
//        if (right == null) {
//            int val = left.val;
//            return getMin(left, mid - val);
//        }
//
//        return Math.min(getMin(left, mid - left.val), getMin(right, right.val - mid));
//
//    }

    public static void main(String[] args) {

        TreeNode treeNode52 = new TreeNode(52, null, null);
        TreeNode treeNode49 = new TreeNode(49, null, treeNode52);
        TreeNode treeNode89 = new TreeNode(89 ,null , null);
        TreeNode treeNode69 = new TreeNode(69 ,treeNode49 , treeNode89);
        TreeNode treeNode90 = new TreeNode(90, treeNode69, null);

//        int i = new MinDistanceBstNodes().minDiffInBST(treeNode90);
//        System.out.println(i);
    }


}


class TreeNode {
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

