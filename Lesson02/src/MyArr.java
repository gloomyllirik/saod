import java.util.Random;

public class MyArr {
    private int[] arr;
    private int size;

    public MyArr(int size) {
        this.size = 0;
        this.arr = new int[size];
    }

    public void genArr(){
        Random random = new Random();
        this.size = this.arr.length;
        for (int i = 0; i < this.size; i++){
            this.arr[i] = random.nextInt(100) + 1;
        }
    }

    public boolean binaryFind(int value){
        int low = 0;
        int high = this.size - 1;
        int mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (value == this.arr[mid]) {
                return true;
            } else {
                if (value < this.arr[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return false;
    }

    public boolean find(int value) {
        int i;
        for (i = 0; i < this.size; i++) {
            if (this.arr[i] == value) {
                return true;
            }
        }
        return false;
    }

    public void display() {
        for (int i = 0; i < this.size; i++) {
            System.out.println(this.arr[i]);
        }
        System.out.println("\n");
    }

    public void display(int count) {
        if (count < this.size && count > 1) {
            for (int i = 0; i < count; i++) {
                System.out.println(this.arr[i]);
            }
        } else {
            System.out.println("Указано некорректное значение!");
        }
        System.out.println("\n");
    }

    public void delete(int value){
        int i = 0;
        for(i = 0; i < this.size; i++) {
            if (this.arr[i] == value) {
                break;
            }
        }

        for (int j = i; j < this.size - 1; j++){
            this.arr[j] = this.arr[j + 1];
        }
        this.size--;
    }

    public void insert(int value){
        int i;
        for(i = 0; i < this.size; i++) {
            if (this.arr[i]>value) {
                break;
            }
        }
        for (int j = this.size; j > i; j--){
            this.arr[j] = this.arr[j-1];
        }
        this.arr[i] = value;
        this.size++;
    }

    public void sortBubble(){
        int out, in;
        long startTime = System.currentTimeMillis();
        for (out = this.size - 1; out >= 1; out--) {
            for(in = 0; in < out; in++) {
                if (this.arr[in] > this.arr[in + 1]) {
                    change(in, in + 1);
                }
            }
        }
        long stopTime = System.currentTimeMillis();
        System.out.println(stopTime - startTime);
    }

    public void sortSelect(){
        int out, in, mark;
        long startTime = System.currentTimeMillis();
        for(out=0;out<this.size;out++){
            mark = out;
            for(in = out+1;in<this.size;in++){
                if (this.arr[in]< this.arr[mark]){
                    mark = in;
                }
            }
            change(out, mark);
        }
        long stopTime = System.currentTimeMillis();
        System.out.println(stopTime - startTime);
    }

    public void sortInsert(){
        int in, out;
        long startTime = System.currentTimeMillis();
        for(out = 1;out < this.size; out++){
            int temp = this.arr[out];
            in = out;
            while(in > 0 && this.arr[in-1] >=temp){
                this.arr[in] = this.arr[in-1];
                --in;
            }
            this.arr[in] = temp;
        }
        long stopTime = System.currentTimeMillis();
        System.out.println(stopTime - startTime);
    }


    private void change(int a, int b){
        int tmp = this.arr[a];
        this.arr[a] = this.arr[b];
        this.arr[b] = tmp;
    }

}
