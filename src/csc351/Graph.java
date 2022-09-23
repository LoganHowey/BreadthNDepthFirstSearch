package csc351;

import java.util.Iterator;
import java.util.LinkedList;

public class Graph {

    private int V;
    private LinkedList<Integer> graph[];
    private boolean visited[];

    Graph(int v){
        V = v;
        graph = new LinkedList[v];
        visited = new boolean[V];
        for (int i = 0; i<v; i++){
            graph[i] = new LinkedList<>();
        }
    }

    void addEdge(int v, int w){
        graph[v].add(w);
    }

    void BreadthFirstSearch(int start){
        boolean visited[] = new boolean[V];
        LinkedList<Integer> queue = new LinkedList<Integer>();
        visited[start] = true;
        queue.add(start);
        while (queue.size() != 0){
            start = queue.poll();
            System.out.println(start + " ");
            Iterator<Integer> i = graph[start].listIterator();
            while (i.hasNext()){
                int n = i.next();
                if (!visited[n]){
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    void DepthFirstSearch(int start){
        visited[start] = true;
        System.out.println(start + " ");
        Iterator<Integer> i = graph[start].listIterator();
        while (i.hasNext()){
            int n = i.next();
            if (!visited[n]){
                DepthFirstSearch(n);
            }
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(1,2);
        graph.addEdge(2,0);
        graph.addEdge(2,3);
        graph.addEdge(3,3);
        graph.addEdge(2,4);

        graph.BreadthFirstSearch(0);
        System.out.println("");
        graph.DepthFirstSearch(0);
    }

    // I didn't get how to use the Interface for the graph made in class, so I used simpler graph.
}
