package arithmetic.structure;

/**二叉树
 * @author hsc
 * @date 2019/8/8 - 18:34
 */
public class BinaryTree {
    TreeNode root;

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    public void frontShow(){
        root.frontShow();
    }

    //前序查找元素
    public TreeNode frontSearch(int i) {
        return root.frontSearch(i);
    }
    //中序查找元素
    public TreeNode midSearch(int i) {
        return root.midSearch(i);
    }

    public TreeNode afterSearch(int i) {
        return root.afterSearch(i);
    }
}
