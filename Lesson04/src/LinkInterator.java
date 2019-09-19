public class LinkInterator<T> {
    private Link current;
    private Link previous;
    private LinkedList list;

    public LinkInterator(LinkedList list){
        this.list = list;
        this.reset();
    }

    public void reset(){
        current = list.getFirst();
        previous = null;
    }

    public boolean atEnd(){
        return (current.getNext() == null);
    }

    public void nextLink(){
        previous = current;
        current = current.getNext();
    }

    public Link getCurrent(){
        return current;
    }

    public void insertAfter(T link){
        Link<T> newLink = new Link(link);
        if (list.isEmpty()){
            list.setFirst(newLink);
            current = newLink;
        } else {
            newLink.setNext(current.getNext());
            current.setNext(newLink);
            nextLink();
        }
    }

    public void insertBefore(T link){
        Link<T> newLink = new Link(link);
        if(previous == null){
            newLink.setNext(list.getFirst());
            list.setFirst(newLink);
            reset();
        }
        else{
            newLink.setNext(previous.getNext());
            previous.setNext(newLink);
            current = newLink;
        }
    }

    public String deleteCurrent(){
        String str = current.getValue().toString();
        if (previous == null){
            list.setFirst(current.getNext());
            reset();
        } else {
            previous.setNext(current.getNext());
            if (atEnd()){
                reset();
            } else {
                current = current.getNext();
            }
        }

        return str;
    }
}
