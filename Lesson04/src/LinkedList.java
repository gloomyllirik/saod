public class LinkedList<T> implements ListInterface {
    private Link<T> first;

    public LinkedList(){
        this.first = null;
    }

    @Override
    public Link getFirst() {
        return first;
    }

    @Override
    public void setFirst(Link first) {
        this.first = first;
    }

    public LinkInterator getIterator(){
        return new LinkInterator(this);
    }

    @Override
    public boolean isEmpty(){
        return (this.first == null);
    }

    @Override
    public void insert(Object link){
        Link<T> l = new Link(link);
        l.setNext(this.first);
        this.first = l;
    }

    @Override
    public String delete(){
        Link<T> temp = this.first;
        this.first = this.first.getNext();
        return temp.getValue().toString();
    }

    @Override
    public void display(){
        Link<T> current = this.first;
        while (current != null) {
            System.out.println(current.getValue());
            current = current.getNext();
        }
    }

    public T find(T searchNode){
        Link<T> findNode = new Link<>(searchNode);
        Link<T> current = this.first;
        while (current != null) {
            if (current.getValue().equals(findNode.getValue())){
                return findNode.getValue();
            }
            current = current.getNext();
        }
        return null;
    }
}