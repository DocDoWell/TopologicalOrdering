package topologicalOrdering;

import graph.Vertex;

import java.util.ArrayDeque;
import java.util.Deque;

public class Algorithm {
    private Deque<Vertex> stack;

    public Algorithm(){
        this.stack  = new ArrayDeque<>();
    }

    public void depthFirstSearch(Vertex vertex){
        vertex.setVisited(true);
        for(Vertex v : vertex.getAdjacentVertex()){
            if(!v.isVisited()){
                depthFirstSearch(v);
            }
        }
        stack.push(vertex);
    }

    public Deque<Vertex> getStack() {
        return stack;
    }
}
