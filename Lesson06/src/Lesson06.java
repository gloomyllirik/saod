
public class Lesson06 {
    public static void main(String[] args) {
        final int min = -100;
        final int max = 100;
        Tree<Integer>[] tree = new Tree[20];
        int count = 0;
        for (int i = 0; i < 20; i++){
            tree[i] = new TreeImpl<>();
            while (tree[i].level() < 6){
                tree[i].add(rnd(min, max));
            }
            System.out.println("\nДерево № " + (i + 1));
            tree[i].display();
            if (tree[i].isBalanced())
                System.out.println("Дерево сбалансировано");
            else {
                System.out.println("Дерево не сбалансировано");
                count++;
            }
        }
        System.out.println("\nПроцент несбалансированных деревьев = " + (float)count/tree.length*100 + "%");
//        test();
    }

    public static int rnd(int min, int max){
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }

    public static void test(){
        Tree<Integer> tree = new TreeImpl<>();
        tree.add(37);
        tree.add(17);
        tree.add(-95);
        tree.add(-74);
        tree.add(-66);
        tree.add(-69);
        tree.add(86);
        tree.add(58);
        tree.add(100);
        tree.add(-97);
        tree.add(-78);
        tree.add(-60);

        tree.display();
        tree.remove(-74);
        tree.display();
        tree.remove(-95);
        tree.display();
        tree.remove(-78);
        tree.display();
        tree.remove(-69);
        tree.display();


        if (tree.isBalanced())
            System.out.println("Дерево сбалансировано");
        else
            System.out.println("Дерево не сбалансировано");
    }
}