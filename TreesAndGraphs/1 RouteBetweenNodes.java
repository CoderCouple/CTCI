package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class RouteBetweenNodes {

    public static boolean existsPathBetweenBFS(Node n1, Node n2){

        Queue<Node> q = new LinkedList<Node>();
        q.add(n1);
        while (!q.isEmpty()){

            Node temp = q.remove();
            if(temp.isVisited)
                 continue;

            if(temp==n2)
                return true;
            temp.isVisited=true;

            for (Node n : temp.neighbours)
                q.add(n);

        }

        return false;
    }

    public static boolean existsPathBetweenDFS(Node n1, Node n2){
        if(n1==n2)
            return true;

        if(n1.isVisited)
            return false;

        n1.isVisited=true;
        boolean result=false;

        for(Node n: n1.neighbours){
             result = existsPathBetweenDFS(n,n2) || result;
             if (result)
                 return result;
        }

        return result;
    }

    public static void main(String [] args){
        Node n1= new Node(1);
        Node n2= new Node(2);
        Node n3= new Node(3);
        Node n4= new Node(4);
        Node n5= new Node(5);
        Node n6= new Node(6);

        n1.neighbours.add(n2);
        n1.neighbours.add(n3);
        n3.neighbours.add(n2);
        n3.neighbours.add(n4);
        n4.neighbours.add(n5);
        n5.neighbours.add(n1);

        //System.out.println(existsPathBetweenBFS(n1,n5));
        System.out.println(existsPathBetweenDFS(n1,n6));
    }
}
