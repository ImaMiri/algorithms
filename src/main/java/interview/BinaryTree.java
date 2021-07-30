package interview;

public class BinaryTree<T extends Comparable<? super T>> {
    private T data;
    private BinaryTree<T> leftNode;
    private BinaryTree<T> rightNode;
    private boolean isVisited;

    public BinaryTree(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public BinaryTree<T> getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(BinaryTree<T> leftNode) {
        this.leftNode = leftNode;
    }

    public BinaryTree<T> getRightNode() {
        return rightNode;
    }

    public void setRightNode(BinaryTree<T> rightNode) {
        this.rightNode = rightNode;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }

    public void inOrderTraversal(BinaryTree<T> node){
        if(node != null) {
            inOrderTraversal(node.getLeftNode());
            node.setVisited(true);
            System.out.println(node.getData());
            inOrderTraversal(node.getRightNode());
        }
    }

    public void preOrderTraversal(BinaryTree<T> node){
        if(node != null) {
            node.setVisited(true);
            System.out.println(node.getData());
            preOrderTraversal (node.getLeftNode());
            preOrderTraversal (node.getRightNode());
        }
    }

    public void postOrderTraversal(BinaryTree<T> node){
        if(node != null) {
            postOrderTraversal (node.getLeftNode());
            postOrderTraversal (node.getRightNode());
            node.setVisited(true);
            System.out.println(node.getData());
        }
    }

    public boolean contains(BinaryTree<T> node, T val){
        while(node != null) {
            if(node.getData().compareTo(val) < 0){
                node = node.getLeftNode();
            }else if(node.getData().compareTo(val) > 0){
                node = node.getRightNode();
            } else{
                return true;
            }
        }
        return false;
    }

    public void addBST(BinaryTree<T> node, T val){
        while(node != null) {
            if(node.getData().compareTo(val) < 0){
                if(node.getLeftNode() != null) {
                    node = node.getLeftNode();
                } else {
                    node.setLeftNode(new BinaryTree<T>(val));
                    return;
                }
            }else if(node.getData().compareTo(val) > 0){
                if(node.getRightNode() != null) {
                    node = node.getRightNode();
                } else {
                    node.setRightNode(new BinaryTree<T>(val));
                    return;
                }
            }
        }
    }

    public BinaryTree<T> removeBST(BinaryTree<T> node, T val){
        if(node == null) return node;

        if(val.compareTo(node.getData()) < 0) {
            node.setLeftNode(removeBST(node.getLeftNode(), val));
        }else if(val.compareTo(node.getData()) > 0) {
            node.setRightNode(removeBST(node.getRightNode(),val));
        } else{
            BinaryTree<T> temp;
            if(node.getLeftNode() == null){
                node = node.getRightNode();
                return node;
            }
            if(node.getRightNode() == null){
                node = node.getLeftNode();
                return node;
            }

            temp = minValueNode(node.getRightNode());
            node.setData(temp.getData());
            node.setRightNode(removeBST(node.getRightNode(), temp.getData()));


        }
        return null;
    }

    public BinaryTree<T> minValueNode(BinaryTree<T> node) {
        BinaryTree<T> curr = node;
        while (curr.getLeftNode() != null)
            curr = curr.getLeftNode();
        return curr;
    }

    public void addMinHeaps(BinaryTree<T> node, T data){
        while(node != null){
            if(node.getRightNode()!= null){
                node = node.getRightNode();
            }else{
                node.setRightNode(new BinaryTree<T>(data));
            }
        }

        while(node.getData().compareTo(node.getRightNode().getData()) > 0){
            BinaryTree<T> temp = node;
            node.setData(node.getRightNode().getData());
            node.getRightNode().setData(temp.getData());
        }
    }

    public void removeMinHeaps(){
    }

    public void addMaxHeaps(BinaryTree<T> node, T data){
        while(node != null){
            if(node.getRightNode()!= null){
                node = node.getRightNode();
            }else{
                node.setRightNode(new BinaryTree<T>(data));
            }
        }

        if(node.getData().compareTo(node.getRightNode().getData()) < 0){
            BinaryTree<T> temp = node;
            node.setData(node.getRightNode().getData());
            node.getRightNode().setData(temp.getData());
        }
    }

    public void removeMaxHeaps(){
    }

}

