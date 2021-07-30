package interview;

class Node<T>{
    private Node prev = null;
    private Node next = null;
    private T data;
    public Node(T data) {
        this.data = data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public T getData() {
        return this.data;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}

public class Linkedlist<T> {

    private Node<T> head;
    private int numNodes;

    public Node<T> getHead() {
        return head;
    }

    public T get(int index) {
        Node node = head;

        int i = 0;
        while(node.getNext() != null && i <= index){
            if(index == 0){
                return (T) node.getData();
            }
            node = node.getNext();
            i++;
        }
        return (T) node.getData();
    }

    public boolean add(T t) {
        if(head == null){
            head = new Node<T>(t);
            numNodes++;
            return true;
        }
        Node node = head;
        while(node.getNext() != null){
            node = node.getNext();
        }
        node.setNext(new Node<T>(t));
        node.getNext().setPrev(node);
        numNodes++;
        return true;
    }

    public boolean remove(T t) {
        Node node = head;
        while(node.getNext() != null){
            if(node.getData().equals(t)){
                node.getNext().setPrev(node.getPrev());
                node.getPrev().setNext(node.getNext());
                node = null;
                return true;
            }
            node = node.getNext();
        }
        return false;
    }

    public int getNumNodes(){
        return this.numNodes;
    }

    public Node partition(Node<Integer> node, int x){
        Node<Integer> beforeNode = new Node<Integer>(-1);
        Node<Integer> afterNode = new Node<Integer>(-1);
        Node<Integer> afterNodeStart = new Node<Integer>(-1);
        Node<Integer> beforeNodeStart = new Node<Integer>(-1);


        while(node != null){
            if(node.getData()<=x){
                if(beforeNode.getData() == -1){
                    beforeNode.setData(node.getData());
                    beforeNodeStart = beforeNode;
                }else{
                    beforeNode.setNext(new Node(node.getData()));
                    beforeNode.getNext().setPrev(beforeNode);
                    beforeNode = beforeNode.getNext();
                }
            }else{
                if(afterNode.getData() == -1){
                    afterNode.setData(node.getData());
                    afterNodeStart = afterNode;
                }else{
                    afterNode.setNext(new Node(node.getData()));
                    afterNode.getNext().setPrev(afterNode);
                    afterNode = afterNode.getNext();
                }
            }
            node = node.getNext();
        }
        beforeNode.setNext(afterNodeStart);
        return beforeNodeStart;
    }

    public Node sumLists(Node<Integer> l1, Node<Integer> l2){

        Node<Integer> result = new Node<Integer>(-1);
        Node<Integer> end;
        end = result;
        int carry = 0;
        while(l1 != null && l2 != null){
            Node<Integer> temp = new Node<Integer>(-1);
            int sum = l1.getData()+l2.getData();
            if(sum >9){
                temp.setData((sum+carry) % 10);
                carry = sum/10;
            }else{
                temp.setData(sum + carry);
                temp.setNext(new Node<Integer>(-1));
            }
            l1 = l1.getNext();
            l2 = l2.getNext();
            result.setNext(temp);
            result = result.getNext();
        }
        return end;
    }

    public boolean isPalindrome(Node<Integer> node){

        if(node != null){
            Node<Integer> temp = node;
            Node<Integer> reverse = null;

            while (temp != null){
                Node<Integer> n = new Node<Integer>(temp.getData());
                n.setNext(reverse);
                reverse = n;
                temp = temp.getNext();
            }

            while(node != null && reverse != null) {
                if(node.getData()!=reverse.getData()){
                    return false;
                }
                node = node.getNext();
                reverse = reverse.getNext();
            }
            return true;
        }
        return false;
    }

    public boolean isIntersecting(Node<Integer> n1, Node<Integer> n2){
        Node<Integer> temp1 = n1;
        Node<Integer> temp2 = n2;
        while(n1 != null){
            while(n2 != null){
                if(n1.equals(n2)){
                    return true;
                }
                n2 = n2.getNext();
            }
            n2 = temp2;
            n1 = n1.getNext();
        }
        return false;
    }


    public static void main(String[] args) {
        Linkedlist<String> linkedlist = new Linkedlist<String>();

//        linkedlist.add("abc");
//        linkedlist.add("def");
//        linkedlist.add("ghi");
//        System.out.println(linkedlist.getNumNodes());
//        linkedlist.remove("def");
//
//        Node node = linkedlist.getHead();
//        while(node != null){
//            System.out.println(node.getData());
//            node = node.getNext();
//        }

//        Node<Integer> node = new Node<>(2);
//        Node<Integer> head = node;
//        node.setNext(new Node(9));
//        node = node.getNext();
//        node.setNext(new Node(3));
//        node = node.getNext();
//        node.setNext(new Node(1));
//        node = node.getNext();
//        node.setNext(new Node(8));
//        node = node.getNext();
//        node.setNext(new Node(5));
//        node = node.getNext();
//        Node n = linkedlist.partition(head,5);
//        while (n != null){
//            System.out.println(n.getData());
//            n = n.getNext();
//        }

//        Node<Integer> l1 = new Node<>(7);
//        Node temp1 = l1;
//        l1.setNext(new Node(1));
//        l1.getNext().setPrev(l1);
//        l1 = l1.getNext();
//        l1.setNext(new Node(6));
//        l1.getNext().setPrev(l1);
//        l1 = l1.getNext();
//        Node<Integer> l2 = new Node<>(5);
//        Node temp2 = l2;
//        l2.setNext(new Node(9));
//        l2.getNext().setPrev(l2);
//        l2 = l2.getNext();
//        l2.setNext(new Node(2));
//        l2.getNext().setPrev(l2);
//
//        Node n = linkedlist.sumLists(temp1,temp2);
//        n = n.getNext();
//
//        while (n != null){
//            if((Integer)n.getData() != -1)
//                System.out.println(n.getData());
//            n = n.getNext();
//        }

//        Node<Integer> node = new Node<>(2);
//        Node<Integer> head = node;
//        node.setNext(new Node(1));
//        node = node.getNext();
//        node.setNext(new Node(3));
//        node = node.getNext();
//        node.setNext(new Node(1));
//        node = node.getNext();
//        node.setNext(new Node(2));
//
//        System.out.print("isPalindrome: " + linkedlist.isPalindrome(head));

        Node<Integer> node1 = new Node<Integer>(2);
        Node<Integer> head1 = node1;
        node1.setNext(new Node(1));
        node1 = node1.getNext();
        node1.setNext(new Node(4));
        node1 = node1.getNext();
        node1.setNext(new Node(2));

        Node<Integer> node2 = new Node<Integer>(7);
        Node<Integer> head2 = node2;
        node2.setNext(new Node(8));
        node2 = node1.getNext();
        node2.setNext(new Node(5));
        node2 = node1.getNext();
        node2.setNext(new Node(3));

        System.out.print(linkedlist.isIntersecting(node1,node2));
    }
}
