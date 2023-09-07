package Tree;

import SynchronizeTest.Main;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {

        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);


        TreeNode treeNode1 = new TreeNode(1,treeNode3,treeNode4);
        TreeNode treeNode2 = new TreeNode(2);

        TreeNode treeNode = new TreeNode(0,treeNode1,treeNode2);
        Test test = new Test();

        test.preOrder(treeNode);
        test.medOrder(treeNode);

        ArrayList<Integer> arrayList = new ArrayList<>();


    }

    //前序遍历
    public void preOrder(TreeNode treeNode){

        System.out.print(treeNode.val);
        if (treeNode.left != null) preOrder(treeNode.left);
        if (treeNode.right != null) preOrder(treeNode.right);


    }
    //中序遍历
    public void medOrder(TreeNode treeNode){
        if (treeNode.left != null) medOrder(treeNode.left);
        System.out.println(treeNode.val);
        if (treeNode.right != null) medOrder(treeNode.right);
    }

    //后序遍历
    public void afOrder(TreeNode treeNode){
        if (treeNode.left != null) afOrder(treeNode.left);
        if (treeNode.right != null) afOrder(treeNode.right);
        System.out.println(treeNode.val);
    }




}
