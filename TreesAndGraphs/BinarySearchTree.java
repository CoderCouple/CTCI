package Trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinarySearchTree {
    Node root;

    public BinarySearchTree(){
        root = null;
    }

    public void add(int data){
        Node n = new Node(data);
        boolean isLeftChild =false;
        if(root==null){
            root= n;
            return;
        }

        Node prev=null;
        Node curr=root;
        while (curr!=null){
            if(data<=curr.value){
                prev=curr;
                curr=curr.left;
                isLeftChild=true;
            } else {
                prev=curr;
                curr=curr.right;
                isLeftChild=false;
            }
        }

        if(isLeftChild)
            prev.left=n;
        else prev.right=n;

    }

    public Node remove(int data) throws  TreeException{
        if(root==null){
            throw new TreeException("ChildNodeNotFoundException");
        }

        if(root.value==data){

            if(root.left==null & root.right==null){
                Node temp=root;
                root=null;
                return temp;
            }

            if(root.left==null){
                Node temp=root;
                root=root.right;
                return temp;
            }

            if(root.right==null){
                Node temp=root;
                root=root.left;
                return temp;
            }

            if(root.left!=null & root.right!=null){
                Node temp= new Node(root.value);
                Node min=getMin(root);
                Node minParent=getMinParent(root);
                root.value=min.value;
                if(minParent==root)
                    minParent.right=null;
                else minParent.left=null;
                return temp;
            }

        }

        Node nodeToBeRemoved = null;
        Node prev=null;
        Node curr=root;
        boolean isLeftChild=false;
        while (curr!=null){
            if(curr.value==data){
                nodeToBeRemoved=curr;
                break;
            }
            else if(data<curr.value){
                isLeftChild=true;
                prev=curr;
                curr=curr.left;
            }
            else{
                isLeftChild=false;
                prev=curr;
                curr=curr.right;
            }
        }


        if(nodeToBeRemoved==null)
            throw new TreeException("ChildNodeNotFoundException");

        if(nodeToBeRemoved.left==null & nodeToBeRemoved.right==null){
            if(isLeftChild)
                prev.left=null;
            else
                prev.right=null;
            return curr;
        }

        if(nodeToBeRemoved.left!=null & nodeToBeRemoved.right==null){
            if(isLeftChild)
                prev.left=curr.left;
            else prev.right=curr.left;
            return curr;
        }

        if(nodeToBeRemoved.left==null & nodeToBeRemoved.right!=null){
            if(isLeftChild)
                prev.left=curr.right;
            else prev.right=curr.right;
            return curr;
        }


        Node temp= new Node(root.value);
        Node min=getMin(root.right);
        Node minParent=getMinParent(root.right);
        root.value=min.value;
        if(minParent==root)
            minParent.right=null;
        else minParent.left=null;
        return temp;
    }

    public Node getMin(Node root){

        Node prev=root;
        Node curr=root.right;
        boolean isLeftChild=false;
        while (curr!=null){
            if(curr.left!=null){
                prev=curr;
                curr=curr.left;
            }
        }
        return curr;
    }

    public Node getMinParent(Node root){
        Node prev=root;
        Node curr=root.right;
        boolean isLeftChild=false;
        while (curr!=null){
            if(curr.left!=null){
                prev=curr;
                curr=curr.left;
            }
        }
        return prev;
    }

    public boolean search(int data){
        if(root==null)
            return false;

        Node curr=root;
        while (curr!=null){
            if(curr.value==data)
                return true;
            else if(data<curr.value)
                curr=curr.left;
            else curr=curr.right;
        }

        return false;
    }

    public void inOrderTraversal(Node root){
        if(root==null)
            return;

        Stack<Node> stack = new Stack<Node>();
        Node curr=root;
        while (curr != null) {
            stack.push(curr);
            curr=curr.left;
        }
        while (!stack.isEmpty()) {
            curr = stack.pop();
            System.out.println(curr.value);

            if (curr.right != null){
                curr=curr.right;
                
                while (curr != null){
                    stack.push(curr.left);
                    curr=curr.left;
                }
            }
        }


    }

    public void preOrderTraversal(Node root){
        if(root==null)
            return;

        Stack<Node> stack = new Stack<Node>();
        stack.push(root);
        while(!stack.isEmpty()){
            Node temp=stack.pop();
            System.out.println(temp.value);
            if(temp.right!=null)
                stack.push(temp.right);
            if(temp.left!=null)
                stack.push(temp.left);
        }
    }

    public void postOrderTraversal(Node root){

    }

    public void levelOrderTraversal(Node root){
        if(root==null)
            return;

        Queue<Node> q1 = new LinkedList<Node>();
        Queue<Node> q2 = new LinkedList<Node>();

        q1.add(root);

        while (true) {
            while (!q1.isEmpty()) {
                Node temp = q1.poll();
                System.out.println(temp.value);

                if (temp.left != null)
                    q2.add(temp.left);
                if (temp.right != null)
                    q2.add(temp.right);
            }
            if(q2.isEmpty())
                break;
            q1.addAll(q2);
        }
    }

    public static void main(String args[]){


    }

}
