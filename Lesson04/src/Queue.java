public class Queue<T> {
    private DoubleSideLinkedList<T> queue;

    public Queue(){
        queue = new DoubleSideLinkedList<>();
    }

    public boolean isEmpty(){
        return queue.isEmpty();
    }

    public void insert(T link){
        queue.insertLast(link);
    }

    public String delete(){
        return queue.delete();
    }

    public void display(){
        queue.display();
    }

}
