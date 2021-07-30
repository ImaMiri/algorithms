package interview;

public class Stack<T> {
    private StackNode<T> top;

    public void push(T data){
        StackNode<T> node= new StackNode<T>();
        node.setData(data);
        node.setNext(top);
        top = node;
    }

    public T pop(){
        T d= top.getData();
        top = top.getNext();
        return d;
    }

    public T peek(){
        return top.getData();
    }

    public static void main(String[] args) {
        Stack<String> stack = new Stack<String>();
        stack.push("ab");
        stack.push("cd");
        stack.push("ef");
        System.out.println("Top of stack: " + stack.peek());
        System.out.println("Top of stack: " + stack.pop());
        System.out.println("Top of stack: " + stack.peek());

    }
}

class StackNode<T>{
    private T data;
    private StackNode<T> next;

    public void setData(T data){
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setNext(StackNode<T> next){
        this.next = next;
    }

    public StackNode<T> getNext(){
        return next;
    }
}
