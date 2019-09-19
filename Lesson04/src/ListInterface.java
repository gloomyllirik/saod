public interface ListInterface<T> {
    void insert(T link);
    String delete();
    boolean isEmpty();
    void display();
    Link<T> getFirst();
    void setFirst(Link<T> first);
}
