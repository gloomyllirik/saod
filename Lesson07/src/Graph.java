import java.util.ArrayList;
import java.util.Iterator;

public class Graph {
    private final int MAX_VERTS = 32;
    private Vertex[] vertexList;
    private int[][] adjMat;
    private int size;
    private Stack stack;
    private Queue queue;
    private ArrayList<StringBuilder> arrayStr;

    public Graph() {
        stack = new Stack(MAX_VERTS);
        queue = new Queue(MAX_VERTS);
        arrayStr = new ArrayList<>(MAX_VERTS);
        vertexList = new Vertex[MAX_VERTS];
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        size = 0;
        for (int i = 0; i < MAX_VERTS; i++) {
            for (int j = 0; j < MAX_VERTS; j++) {
                adjMat[i][j] = 0;
            }

        }
    }

    private int getAdjUnvisitedVertex(int ver) {
        for (int i = 0; i < size; i++) {
            if (adjMat[ver][i] == 1 && !vertexList[i].wasVisited) {
                return i;
            }
        }

        return -1;
    }

    public void dfs() {
        vertexList[0].wasVisited = true;
        displayVertex(0);
        System.out.print(" ");
        stack.push(0);
        while (!stack.isEmpty()) {
            int v = getAdjUnvisitedVertex((Integer) stack.peek());
            if (v == -1) {
                stack.pop();
            } else {
                vertexList[v].wasVisited = true;
                displayVertex(v);
                System.out.print(" ");
                stack.push(v);
            }
        }

        for (int i = 0; i < size; i++) {
            vertexList[i].wasVisited = false;
        }

    }

    public void bfs(){
        int num;
        StringBuilder sub_str, root_str;
        vertexList[0].wasVisited = true;
        displayVertex(0);
        System.out.print(" ");
        queue.insert(0); // Вставка в конец очереди
        root_str = new StringBuilder().append(vertexList[0].label);
        sub_str = new StringBuilder();
        arrayStr.add(root_str);
        int v2;
        while(!queue.isEmpty()){
            int v1 = (int) queue.remove();
            root_str = find_str(vertexList[v1].label);
            num = 1;
            while((v2=getAdjUnvisitedVertex(v1)) != -1){
                vertexList[v2].wasVisited = true; // Пометка
                displayVertex(v2); // Вывод
                System.out.print(" ");
                queue.insert(v2);
                if (num == 1) {
                    root_str.append(" " + vertexList[v2].label);
//                    System.out.println(root_str);
                    root_str = new StringBuilder(root_str);
                    root_str.setLength(root_str.length()-2);
                }
                else {
                    sub_str = new StringBuilder(root_str).append(" " + vertexList[v2].label);
                    arrayStr.add(sub_str);
                }
  //              System.out.println(sub_str);
                num++;
            }
        }
        System.out.println("");
        for(int i=0; i<size; i++) // Сброс флагов
            vertexList[i].wasVisited = false;
        print_all_str();    // вывод на экран всех найденных путей в графе
        maxDistance();      // вывод на экран всех найденных максимальных путей в графе
//        System.out.println(arrayStr.size());
    }

    private StringBuilder find_str(char ch){
        for (StringBuilder str : arrayStr) {
            if (str.charAt(str.length() - 1) == ch)
                return str;
        }
        return null;
    }

    private void print_all_str(){
        System.out.println("\nВсе пути в графе:");
        for (StringBuilder str : arrayStr) {
            System.out.println(str);
        }
    }

    private void maxDistance(){
        int max_length = 0;
        int cur_length;
        ArrayList<StringBuilder> maxDistances = new ArrayList<>(arrayStr.size());
        for (StringBuilder str : arrayStr) {
            cur_length = str.length();
            if(cur_length > max_length){
                max_length = cur_length;
                maxDistances.clear();
                maxDistances.add(str);
            } else if (cur_length == max_length)
                maxDistances.add(str);
        }
        if (maxDistances.size() != 0)
            System.out.println("\nМаксимальные пути в графе:");
        for (StringBuilder str : maxDistances){
            System.out.println(str);
        }
    }

    public void addVertex(char label) {
        vertexList[size++] = new Vertex(label);
    }

    public void addEdge(int start, int end) {
        adjMat[start][end] = 1;
        adjMat[end][start] = 1;
    }

    public void displayVertex(int vertex) {
        System.out.print(vertexList[vertex].label);
    }
}