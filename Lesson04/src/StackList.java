public class StackList<T> {
    private LinkedList<T> list;

    public StackList(){
        list = new LinkedList<>();
    }

    public void push(T link){
        list.insert(link);
    }

    public String pop(){
        return list.delete();
    }

    public boolean isEmpty(){
        return list.isEmpty();
    }

    public void display(){
        list.display();
    }
}
