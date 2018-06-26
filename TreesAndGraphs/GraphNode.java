package Graph;

import java.util.ArrayList;
import java.util.List;

public class Node {
    int val;
    List<Node> neighbours;
    boolean isVisited;

    public Node(int val){
        this.val=val;
        this.neighbours= new ArrayList<Node>();
        this.isVisited=false;
    }

    public Node(int val, List<Node> neighbours){
        this.val=val;
        this.neighbours=neighbours;
        this.isVisited=false;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public List<Node> getNeighbours() {
        return neighbours;
    }

    public void setNeighbours(List<Node> neighbours) {
        this.neighbours = neighbours;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }
}
