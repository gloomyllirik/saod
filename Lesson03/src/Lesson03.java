import java.util.Scanner;

public class Lesson03 {
    public static void main(String[] args) {

        System.out.println("\nЗАДАНИЕ 1\n");

        final int min = -10;
        final int max = 10;
        int rnd;
        Stack stack = new Stack(10);
        while (!stack.isFull()){
            stack.push(rnd(min, max));
            System.out.println("В стек положили: " + stack.peek());
        }
        System.out.println();
        while (!stack.isEmpty()){
            System.out.println("Из стека взяли: " + stack.pop());
        }

        System.out.println();
        Queue queue = new Queue(10);
        while (!queue.isFull()){
            rnd = rnd(min, max);
            queue.insert(rnd);
            System.out.println("В очередь положили: " + rnd);
        }
        System.out.println();
        while (!queue.isEmpty()){
            System.out.println("Из очереди взяли: " + queue.remove());
        }

        System.out.println();
        PriorityQueue priorityQueue = new PriorityQueue(10);
        while (!priorityQueue.isFull()){
            rnd = rnd(min, max);
            priorityQueue.insert(rnd);
            System.out.println("В приоритетную очередь положили: " + rnd);
        }
        System.out.println();
        while (!priorityQueue.isEmpty()){
            System.out.println("Из приоритетной очереди взяли: " + priorityQueue.remove());
        }

        System.out.println("\nЗАДАНИЕ 2\n");

        StringBuilder str = new StringBuilder();
        Scanner line = new Scanner(System.in);
        while (true) {
            System.out.println("Для выхода введите \"END\". Введите строку: ");
            str.setLength(0);
            str.insert(0, line.nextLine());
            if (str.toString().equals("END"))
                break;
            Stack str_stack = new Stack(str.length());
            Queue str_queue1 = new Queue(str.length());
            Queue str_queue2 = new Queue(str.length());
            for (int i = 0; i < str.length(); i++){
                str_stack.push(str.charAt(i));
                str_queue1.insert(str.charAt(i));
            }
            System.out.println("\nРеверс через стек:\n");
            while (!str_stack.isEmpty()){
                System.out.print(str_stack.pop());
            }
            System.out.println();
        }

        System.out.println("\nЗАДАНИЕ 3\n");
        Deque deque = new Deque(10);
        deque.print();
        deque.insertlast(5);
        deque.insertlast(4);
        deque.insertlast(3);
        deque.insertlast(2);
        deque.insertlast(1);
        deque.print();
        deque.insertfirst(6);
        deque.insertfirst(7);
        deque.insertfirst(8);
        deque.insertfirst(9);
        deque.print();
        deque.removefirst();
        deque.removelast();
        deque.print();
    }

    public static int rnd(int min, int max){
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }
}
