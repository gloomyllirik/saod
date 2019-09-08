public class Link<T> {
    private T link;
    private Link<T> next;

    public Link(T link){
        this.link = link;
    }

    public Link<T> getNext() {
        return this.next;
    }

    public void setNext(Link<T> next) {
        this.next = next;
    }

    public T getValue(){
        return this.link;
    }

    public void display(){
        System.out.println(link.toString());
    }
}
