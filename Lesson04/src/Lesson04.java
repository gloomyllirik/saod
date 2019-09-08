public class Lesson04 {
    public static void main(String[] args) {
        System.out.println("Пример реализации связного списка:");
        LinkedList<String> list = new LinkedList<>();
        list.insert("Artem");
        list.insert("Roman");
        System.out.println("Весь список:");
        list.display();
        System.out.println();

        System.out.println("Поиск в списке Артема:");
        System.out.println(list.find("Artem"));
        System.out.println();
        list.delete();
        System.out.println("Весь список после удаления:");
        list.display();
        System.out.println();

        LinkedList<People> peopleList = new LinkedList<>();
        peopleList.insert(new People("Artem", 22));
        peopleList.insert(new People("Roman", 18));
        System.out.println("Весь список:");
        peopleList.display();
        System.out.println();

        System.out.println("Поиск в списке Артема:");
        System.out.println(peopleList.find(new People("Artem", 22)).toString());
        System.out.println();
        peopleList.delete();
        System.out.println("Весь список после удаления:");
        peopleList.display();
        System.out.println();

        System.out.println("Пример реализации двустороннего связного списка:");
        DoubleSideLinkedList<People> doubleSideLinkedList = new DoubleSideLinkedList<>();
        doubleSideLinkedList.insert(new People("Artem", 30));
        doubleSideLinkedList.insert(new People("Viktor", 20));
        doubleSideLinkedList.insert(new People("Sergey", 10));
        doubleSideLinkedList.display();
        System.out.println();

        System.out.println("Пример реализации стека:");
        StackList sl = new StackList();
        sl.push(new People("Artem", 30));
        sl.push(new People("Viktor", 20));
        sl.push(new People("Sergey", 10));
        sl.display();
        while (!sl.isEmpty()) {
            System.out.println("Элемент "+ sl.pop()+" удален из стека");
        }
        System.out.println();

        System.out.println("Пример реализации очереди:");
        Queue q = new Queue();
        q.insert(new People("Artem", 30));
        q.insert(new People("Viktor", 20));
        q.insert(new People("Sergey", 10));
        q.display();
        while (!q.isEmpty()) {
            System.out.println("Элемент "+ q.delete()+" удален из очереди");
        }
        System.out.println();

        System.out.println("Пример реализации итератора:");
        String str;
        People people;
        LinkedList iterlist = new LinkedList();
        LinkInterator itr = new LinkInterator(iterlist);
        itr.insertAfter(new People("Artem", 20));
        itr.insertBefore(new People("Sergey", 10));
        iterlist.display();
        System.out.println();
        iterlist.insert(new People("Viktor", 20));
        iterlist.insert(new People("Maksim", 40));
        iterlist.insert(new People("Denis", 30));
        System.out.println("Список после добавления Виктора, Максима и Дениса:");
        iterlist.display();
        System.out.println();
        itr.reset();    // перемещаем итератор в начало списка

        System.out.println("Удаляем из списка лица старше 30:");
        while (!itr.atEnd()){
            people = (People) itr.getCurrent().getValue();
            if (people.getAge() > 30)
                itr.deleteCurrent();
            else {
                System.out.println(itr.getCurrent().getValue().toString());
                itr.nextLink();
            }
        }
        System.out.println(itr.getCurrent().getValue().toString());
        System.out.println();

        System.out.println("Пример с использованием foreach:");
        Foreach foreach = new Foreach(iterlist);
        foreach.display();
    }
}
