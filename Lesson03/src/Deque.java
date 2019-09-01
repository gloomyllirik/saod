public class Deque<E extends Object & Comparable<? super E>>{
    private int maxSize;
    private E[] deque;
    private int front;
    private int rear;
    private int items;

    public Deque(int maxSize) {
        this.maxSize = maxSize;
        deque = (E[]) new Object[maxSize];
        front = 0;
        rear = -1;
        items = 0;
    }

    public boolean insertlast(E value){
        if (this.isFull())
            return false;
        if(rear == maxSize - 1)
            rear = -1;
        deque[++rear] = value;
        items++;
        return true;
    }

    public boolean insertfirst(E value){
        if (this.isFull())
            return false;
        if(front == 0)
            front = maxSize;
        deque[--front] = value;
        items++;
        return true;
    }

    public E removefirst(){
        if (this.isEmpty())
            return null;
        if(front == maxSize)
            front = 0;
        E temp = deque[front++];
        items--;
        return temp;
    }

    public E removelast(){
        if (this.isEmpty())
            return null;
        if(rear == -1)
            rear = maxSize - 1;
        E temp = deque[rear--];
        items--;
        return temp;
    }

    public void print(){
        if (this.isEmpty()){
            System.out.println("Дек пока пустой...");
            return;
        }
        System.out.print("Reer == ");
        if (rear > front)
            for (int i = rear; i >= front; i--){
                System.out.print(deque[i] + " ");
            }
        if (front > rear){
            for (int i = rear; i >= 0; i--){
                System.out.print(deque[i] + " ");
            }
            for (int i = maxSize - 1; i >= front; i--) {
                System.out.print(deque[i] + " ");
            }
        }
        System.out.print(" == Front\n");
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
