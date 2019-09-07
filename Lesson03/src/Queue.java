public class Queue<E extends Object & Comparable<? super E>>{
    private int maxSize;
    private E[] queue;
    private int front;
    private int rear;
    private int items;

    public Queue(int s){
        maxSize = s;
        queue = (E[]) new Object[maxSize];
        front = 0;
        rear = -1;
        items = 0;
    }

    public void insert(E i){
        if(rear == maxSize - 1)
            rear = -1;
        queue[++rear] = i;
        items++;
    }

    public E remove(){
        E temp = queue[front++];
        if(front == maxSize)
            front = 0;
        items--;
        return temp;
    }

    public E peek(){
        return queue[front];
    }

    public boolean isEmpty(){
        return(items == 0);
    }

    public boolean isFull(){
        return(items == maxSize);
    }

    public int size(){
        return items;
    }
}