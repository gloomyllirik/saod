public class Lesson07 {
    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addVertex('D');
        graph.addVertex('E');
        graph.addVertex('F');
        graph.addVertex('G');
        graph.addVertex('H');
        graph.addVertex('I');
        graph.addVertex('J');

        graph.addEdge(0, 1); //AB
        graph.addEdge(1, 2); //BC
        graph.addEdge(0, 3); //AD
        graph.addEdge(3, 4); //DE
        graph.addEdge(0, 5); //AF
        graph.addEdge(5, 6); //FG
        graph.addEdge(6, 7); //GH
        graph.addEdge(7, 8); //HI
        graph.addEdge(8, 9); //IJ

        graph.dfs();
        System.out.println();
        graph.bfs();
    }
}
