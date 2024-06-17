package main;

import graph.Vertex;
import topologicalOrdering.Algorithm;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class App {
    public static void main(String[] args){
        Algorithm algorithm = new Algorithm();
        Vertex a = new Vertex("a");
        Vertex b = new Vertex("b");
        Vertex c = new Vertex("c");
        Vertex d = new Vertex("d");
        Vertex e = new Vertex("e");
        Vertex f = new Vertex("f");

        //only works for DAGs
        c.addNeighbour(d);
        d.addNeighbour(b);
        e.addNeighbour(a);
        e.addNeighbour(b);
        f.addNeighbour(a);
        f.addNeighbour(c);

        List<Vertex> graph = new ArrayList<>();
        graph.add(a);
        graph.add(b);
        graph.add(c);
        graph.add(d);
        graph.add(e);

        for(int i=0; i< graph.size(); i++){
            if(!graph.get(i).isVisited()){
                algorithm.depthFirstSearch(graph.get(i));
            }
        }

        Deque<Vertex> stack = algorithm.getStack();
        for(int i=0; i < graph.size(); i++){
            System.out.println(stack.pop());
        }
    }

}
