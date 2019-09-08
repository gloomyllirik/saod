public class DoubleSideLinkedList<T> implements ListInterface {
    private Link<T> last;
    private Link<T> first;

    public DoubleSideLinkedList(){
        this.first = null;
        this.last = null;
    }

    @Override
    public Link getFirst() {
        return first;
    }

    @Override
    public void setFirst(Link first) {
        this.first = first;
    }

    @Override
    public void display() {
        Link<T> current = this.first;
        while (current != null) {
            System.out.println(current.getValue());
            current = current.getNext();
        }
    }

    @Override
    public boolean isEmpty(){
        return (this.first == null);
    }

    @Override
    public void insert(Object link) {
        Link<T> l = new Link<>((T)link);
        if (this.isEmpty())
            this.last = l;
        l.setNext(first);
        this.first = l;
    }

    public void insertLast(T link){
        Link<T> l = new Link<>(link);
        if (this.isEmpty()){
            this.first = l;
        } else {
            this.last.setNext(l);
        }
        this.last = l;
    }

    @Override
    public String delete(){
        Link temp = this.first;
        if (this.first.getNext() == null)
            this.last = null;
        this.first = this.first.getNext();
        return temp.getValue().toString();
    }
}