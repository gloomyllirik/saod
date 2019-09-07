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
    public void reverse(){
        E tmp_value = (E) new Object();
        int size = this.stack.length;
        int half = size / 2;
        for (int i = 0, j = size - 1; i < half; i++, j--){
            tmp_value = this.stack[i];
            this.stack[i] = this.stack[j];
            this.stack[j] = tmp_value;
        }
    }
    public void display(){
        int size = this.stack.length;
        System.out.print("\n");
        for (int i = 0; i < size; i++){
            System.out.print(this.stack[i].toString() + " ");
        }
        System.out.print("\n");
    }
}