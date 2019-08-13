package javaRoot.collection;

/**树的节点
 * @author hsc
 * @date 2019/8/8 - 18:36
 */
public class TreeNode {
    //节点的权值
    int value;

    //左儿子
    TreeNode leftNode;
    //右儿子
    TreeNode rightNode;

    public TreeNode(int value){
        this.value=value;
    }

    public void setLeftNode(TreeNode leftNode) {
        this.leftNode = leftNode;
    }

    public void setRightNode(TreeNode rightNode) {
        this.rightNode = rightNode;
    }
    //前序遍历
    public void frontShow() {
        //先遍历当前节点的内容
        System.out.println(value);
        //左节点
        if(leftNode!=null){
            leftNode.frontShow();
        }
        //右节点
        if (rightNode!=null){
            rightNode.frontShow();
        }
    }

    public void midShow() {
        if (leftNode!=null){
            leftNode.frontShow();
        }
        System.out.println(value);
        if (rightNode!=null){
            rightNode.frontShow();
        }
    }

    public void afterShow() {
        if (leftNode!=null){
            leftNode.frontShow();
        }
        if (rightNode!=null){
            rightNode.frontShow();
        }
        System.out.println(value);
    }
    //前序查找
    public TreeNode frontSearch(int i) {
        //根左右
        TreeNode target=null;
        if (this.value==i){
            return this;
        }else {
            if (leftNode!=null){
                target=leftNode.frontSearch(i);
            }
            //左节点已经查找到了target
            if (target!=null){
                return target;
            }
            if (rightNode!=null){
                target=rightNode.frontSearch(i);
            }
        }
        return target;
    }
    //中序查找
    public TreeNode midSearch(int i) {
        //左中右查找
        TreeNode target=null;
        if (leftNode!=null){
            target=leftNode.midSearch(i);
        }
        if (target!=null){
            return target;
        }
        if (this.value==i){
            return this;
        }else {
            if (rightNode!=null){
                target=rightNode.midSearch(i);
            }
        }
        return target;
    }
    //后序查找
    public TreeNode afterSearch(int i) {
        //左右中查找
        TreeNode target=null;
        if (leftNode!=null){
            target=leftNode.midSearch(i);
        }
        if (target!=null){
            return target;
        }
        if (rightNode!=null){
            target=rightNode.midSearch(i);
        }
        if (target!=null){
            return target;
        }
        if (this.value==i){
            return this;
        }
        return target;
    }
}
