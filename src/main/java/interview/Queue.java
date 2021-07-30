package interview;

public class Queue<T> {
    private QueueNode<T> first;
    private QueueNode<T> last;

    public void add(T data){
        QueueNode<T> node = new QueueNode<T>();
        node.setData(data);
        if(first == null) {
            first = node;
            last = node;
            first.setNext(last);
        } else {
            last.setNext(node);
            last = node;
        }
    }

    public T remove(){
        T d= first.getData();
        first = first.getNext();
        return d;
    }

    public T peek(){
        return first.getData();
    }

    public static void main(String[] args) {
        Queue<String> queue = new Queue<String>();
        queue.add("ab");
        queue.add("cd");
        queue.add("ef");
        System.out.println("Top of queue: " + queue.peek());
        System.out.println("Top of queue: " + queue.remove());
        System.out.println("Top of queue: " + queue.peek());

    }
}

class QueueNode<T>{
    private T data;
    private QueueNode<T> next;

    public void setData(T data){
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setNext(QueueNode<T> next){
        this.next = next;
    }

    public QueueNode<T> getNext(){
        return next;
    }
}
