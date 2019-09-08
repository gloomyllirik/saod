public class Foreach<T> {
    private Link<T> current;
    private LinkedList<T> list;
    private LinkInterator<T> itr;

    public Foreach(LinkedList list){
        this.list = list;
        this.itr = list.getIterator();
        this.current = list.getFirst();
    }

    public void display(){
        itr.reset();
        while (!itr.atEnd()){
            System.out.println(itr.getCurrent().getValue().toString());
            itr.nextLink();
        }
        System.out.println(itr.getCurrent().getValue().toString());
    }
}
