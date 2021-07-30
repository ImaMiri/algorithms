package datastructure;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by fmiri on 9/06/2016.
 *
 * BinarySearchTree is sorted BinaryTree  - Complexity -> O(log n) in average and O(n) in worst
 * Balanced BinarySearchTree is a BinarySearchTree which the distance between leaves are balanced
 * Complexity -> O(log n) in average and worst
 *
 *
 * @author Ima Miri <ima.miri11@gmail.com>
 */
public class BinaryTree<T extends Comparable<? super T>> {

    private T value;
    private BinaryTree<T> left;
    private BinaryTree<T> right;
    private boolean visited;

    public BinaryTree(T value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public BinaryTree<T> getLeft() {
        return left;
    }

    public void setLeft(BinaryTree<T> left) {
        this.left = left;
    }

    public BinaryTree<T> getRight() {
        return right;
    }

    public void setRight(BinaryTree<T> right) {
        this.right = right;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    /**
     * Pre Order Depth First Traversal (using recursive)
     * 1- visit yourself
     * 2- visit all your left subtree
     * 3- visit all your right subtree
     */
    public void preOrderTraversal(BinaryTree<T> node) {
        if (node != null) {
            node.setVisited(true);
            System.out.print(node.getValue() + " ");
            this.preOrderTraversal(node.getLeft());
            this.preOrderTraversal(node.getRight());
        }
    }

    /**
     * Post Order Depth First Traversal (using recursive)
     * 1- visit all your left subtree
     * 2- visit all your right subtree
     * 3- visit yourself
     */
    public void postOrderTraversal(BinaryTree<T> node) {
        if (node != null) {
            this.postOrderTraversal(node.getLeft());
            this.postOrderTraversal(node.getRight());
            node.setVisited(true);
            System.out.print(node.getValue() + " ");
        }
    }

    /**
     * In Order Depth First Traversal (using recursive)
     * 1- visit all your left subtree
     * 2- visit yourself
     * 3- visit all your right subtree
     */
    public void inOrderTraversal(BinaryTree<T> node) {
        if (node != null) {
            this.inOrderTraversal(node.getLeft());
            node.setVisited(true);
            System.out.print(node.getValue() + " ");
            this.inOrderTraversal(node.getRight());
        }
    }

    /**
     * Level Order Breadth First Traversal
     *
     * @param root root node
     */
    public void levelOrderTraversal(BinaryTree<T> root) {
        Queue<BinaryTree> queue = new LinkedList<BinaryTree>();
        queue.add(root);

        while (!queue.isEmpty()) {
            BinaryTree curr = queue.remove();
            if (curr != null) {
                curr.setVisited(true);
                System.out.print(curr.getValue() + " ");
                queue.add(curr.getLeft());
                queue.add(curr.getRight());
            }
        }
    }

    public boolean contains(BinaryTree<T> node, T val) {
        while (node != null) {
            if (val.compareTo(node.getValue()) < 0)
                node = node.getLeft();
            else if (val.compareTo(node.getValue()) > 0)
                node = node.getRight();
            else
                return true;
        }
        return false;
    }

    public void insertBST(BinaryTree<T> node, T val) {
        while (node != null) {
            if (val.compareTo(node.getValue()) < 0) {
                if(node.getLeft() != null)
                    node = node.getLeft();
                else {
                    node.setLeft(new BinaryTree<T>(val));
                    return;
                }
            }else if (val.compareTo(node.getValue()) > 0) {
                if(node.getRight() != null)
                    node = node.getRight();
                else {
                    node.setRight(new BinaryTree<T>(val));
                    return;
                }
            }
        }
    }

    /**
     *  Given a binary find tree and a key, this function deletes the key and returns the new root
     *
     */
    public BinaryTree<T> deleteBST(BinaryTree<T> node, T val){

        // base case
        if(node == null) return node;

        // If the key to be deleted is smaller than the root's key, then it lies in left subtree
        if(val.compareTo(node.getValue()) < 0)
            node.setLeft(deleteBST(node.getLeft(), val));
        // If the key to be deleted is greater than the root's key, then it lies in right subtree
        else if(val.compareTo(node.getValue()) > 0)
            node.setRight(deleteBST(node.getRight(), val));
        // if key is same as root's key, then This is the node to be deleted
        else{
            BinaryTree<T> temp;
            // node with only one child or no child
            if(node.getLeft() == null){
                temp = node.getRight();
                node = null;
                return temp;
            }else if(node.getRight() == null){
                temp = node.getLeft();
                node = null;
                return temp;
            }
            // node with two children: Get the smallest in the right subtree
            temp = minValueNode(node.getRight());
            node.setValue(temp.getValue());
            node.setRight(deleteBST(node.getRight(), temp.getValue()));
        }
        return node;
    }

    public BinaryTree<T> minValueNode(BinaryTree<T> node) {
        BinaryTree<T> curr = node;
        while (curr.getLeft() != null)
            curr = curr.getLeft();
        return curr;
    }

    public static void main(String[] args) {
        BinaryTree<String> root = new BinaryTree<String>("A");
        BinaryTree<String> binaryTree1 = new BinaryTree<String>("B");
        BinaryTree<String> binaryTree2 = new BinaryTree<String>("C");
        BinaryTree<String> binaryTree3 = new BinaryTree<String>("D");
        BinaryTree<String> binaryTree4 = new BinaryTree<String>("E");
        BinaryTree<String> binaryTree5 = new BinaryTree<String>("F");
        BinaryTree<String> binaryTree6 = new BinaryTree<String>("G");
        root.setLeft(binaryTree1);
        root.setRight(binaryTree2);
        binaryTree1.setLeft(binaryTree3);
        binaryTree1.setRight(binaryTree4);
        binaryTree2.setLeft(binaryTree5);
        binaryTree2.setRight(binaryTree6);

        root.preOrderTraversal(root); // final output : A B D E C F G
        System.out.println();
        root.postOrderTraversal(root); // final output : D E B F G C A
        System.out.println();
        root.inOrderTraversal(root); // final output : D B E A F C G
        System.out.println();
        root.levelOrderTraversal(root); // final output : A B C D E F G
        System.out.println();

        BinaryTree<String> bst = new BinaryTree<String>("O");
        BinaryTree<String> bst1 = new BinaryTree<String>("H");
        BinaryTree<String> bst2 = new BinaryTree<String>("R");

        BinaryTree<String> bst3 = new BinaryTree<String>("C");
        BinaryTree<String> bst4 = new BinaryTree<String>("F");

        BinaryTree<String> bst5 = new BinaryTree<String>("Q");
        BinaryTree<String> bst6 = new BinaryTree<String>("W");

        BinaryTree<String> bst7 = new BinaryTree<String>("A");
        BinaryTree<String> bst8 = new BinaryTree<String>("D");

        BinaryTree<String> bst9 = new BinaryTree<String>("E");
        BinaryTree<String> bst10 = new BinaryTree<String>("G");

        BinaryTree<String> bst11 = new BinaryTree<String>("P");

        BinaryTree<String> bst12 = new BinaryTree<String>("U");
        BinaryTree<String> bst13 = new BinaryTree<String>("Y");

        BinaryTree<String> bst14 = new BinaryTree<String>("B");

        BinaryTree<String> bst15 = new BinaryTree<String>("V");

        BinaryTree<String> bst16 = new BinaryTree<String>("X");
        BinaryTree<String> bst17 = new BinaryTree<String>("Z");

        bst.setLeft(bst1);
        bst.setRight(bst2);
        bst1.setLeft(bst3);
        bst1.setRight(bst4);
        bst2.setLeft(bst5);
        bst2.setRight(bst6);

        bst3.setLeft(bst7);
        bst3.setRight(bst8);
        bst4.setLeft(bst9);
        bst4.setRight(bst10);

        bst5.setLeft(bst11);
        bst6.setLeft(bst12);
        bst6.setRight(bst13);

        bst7.setRight(bst14);
        bst12.setRight(bst15);
        bst13.setLeft(bst16);
        bst13.setRight(bst17);

        System.out.println("Before insertion: " + bst.contains(bst, "M"));
        bst.insertBST(bst, "M");
        System.out.println("After insertion: " + bst.contains(bst, "M"));
        System.out.println("Before Deleting R");
        bst.levelOrderTraversal(bst);
        System.out.println();
        bst.deleteBST(bst, "R");
        System.out.println("After Deleting R");
        bst.levelOrderTraversal(bst);
        System.out.println();
    }
}
