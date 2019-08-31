public class Node<T extends Comparable<? super T>> {

    private final T value;

    private Node<T> leftChild;
    private Node<T> rightChild;
    private int cur_level;

    public Node(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public Node<T> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node<T> leftChild) {
        this.leftChild = leftChild;
    }

    public Node<T> getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node<T> rightChild) {
        this.rightChild = rightChild;
    }

    public boolean shouldBeLeft(T value) {
        return this.value.compareTo(value) > 0;
    }

    public boolean isLeaf() {
        return leftChild == null && rightChild == null;
    }

    /**
     * false false -> false
     * true false -> true
     * false true -> true
     * true true -> false
     */
    public boolean hasOnlySingleChild() {
        return leftChild != null ^ rightChild != null;
    }

    public int getCur_level() {
        return cur_level;
    }

    public void setCur_level(int cur_level) {
        this.cur_level = cur_level;
    }
}
