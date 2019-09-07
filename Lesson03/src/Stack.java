public class Stack<E extends Object & Comparable<? super E>>{
    private int maxSize;
    private E [] stack;
    private int top;
    public Stack(int size){
        this.maxSize = size;
        this.stack = (E[]) new Object[this.maxSize];
        this.top = -1;
    }
    public void push(E value){
        this.stack[++this.top] = value;
    }
    public E pop(){
        return this.stack[this.top--];
    }
    public E peek(){
        return this.stack[this.top];
    }
    public boolean isEmpty(){
        return(this.top == -1);
    }
    public boolean isFull(){
        return(this.top == this.maxSize - 1);
    }
}