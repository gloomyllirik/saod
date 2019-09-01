public class PriorityQueue<E extends Object & Comparable<? super E>>{
    private int maxSize;
    private E[] queueArray;
    private int items;

    public PriorityQueue(int size){
        maxSize = size;
        queueArray = (E[]) new Object[maxSize];
        items = 0;
    }

    public void insert(E item){
        int i;
        if (items == 0)
            queueArray[items++] = item;
        else {
            for (i = items - 1; i >= 0; i--){
                if (item.compareTo(queueArray[i]) > 0)
                    queueArray[i + 1] = queueArray[i];
                else
                    break;
            }
            queueArray[i + 1] = item;   // вставка элемента
            items++;
        }
    }

    public E remove(){
        return queueArray[--items];
    }

    public E peek(){
        return queueArray[items - 1];
    }

    public boolean isEmpty(){
        return (items == 0);
    }

    public boolean isFull(){
        return (items == maxSize);
    }
}
