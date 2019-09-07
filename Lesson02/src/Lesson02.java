public class Lesson02 {
    public static void main(String[] args) {
        MyArr arr = new MyArr(1000000);

        arr.genArr();
        arr.display(100);
        arr.sortBubble();

        arr.genArr();
        arr.display(100);
        arr.sortInsert();

        arr.genArr();
        arr.display(100);
        arr.sortInsert();

        int search = 10;

        System.out.println(arr.binaryFind(search));

    }
}
