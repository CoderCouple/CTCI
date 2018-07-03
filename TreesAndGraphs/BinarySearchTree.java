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

        if(isLeftChild){
            prev.left=n;
            n.parent=prev;
        }
        else{
            prev.right=n;
            n.parent=prev;
        }

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
            System.out.print(curr.value + " ");

            if (curr.right != null){
                curr=curr.right;

                while (curr != null){
                    stack.push(curr);
                    curr=curr.left;
                }
            }
        }
        System.out.println("");

    }

    public void preOrderTraversal(Node root){
        if(root==null)
            return;

        Stack<Node> stack = new Stack<Node>();
        stack.push(root);
        while(!stack.isEmpty()){
            Node temp=stack.pop();
            System.out.print(temp.value+" ");
            if(temp.right!=null)
                stack.push(temp.right);
            if(temp.left!=null)
                stack.push(temp.left);
        }
        System.out.println("");
    }

    public void postOrderTraversal(Node root){
        if(root==null)
            return;

        Stack<Node> stack1 = new Stack<Node>();
        Stack<Node> stack2 = new Stack<Node>();

        stack1.push(root);
        while(!stack1.isEmpty()){
            Node temp=stack1.pop();
            stack2.push(temp);
            if (temp.left!=null)
                stack1.push(temp.left);
            if(temp.right!=null)
                stack1.push(temp.right);
        }

        while (!stack2.isEmpty())
            System.out.print(stack2.pop().value+" ");

        System.out.println("");
    }

    public void levelOrderTraversal(Node root){
        if(root==null)
            return;

        Queue<Node> q1 = new LinkedList<Node>();
        Node marker = new Node(-1);
        q1.add(root);
        q1.add(marker);

        while (!q1.isEmpty()) {
            Node temp = q1.poll();
            if (temp.value == -1) {
                System.out.println("");
                if (!q1.isEmpty())
                    q1.add(marker);
            } else {
                System.out.print(temp.value);

                if (temp.left != null)
                    q1.add(temp.left);
                if (temp.right != null)
                    q1.add(temp.right);
            }
        }
        System.out.println("");
    }

    public int maxElement(Node root){
        if(root==null)
            return Integer.MIN_VALUE;

        int max=Math.max(maxElement(root.left),maxElement(root.right));
        return Math.max(max,root.value);
    }

    public static void main(String args[]) throws TreeException {
//        Node n1 = new Node(1);
//        Node n2 = new Node(2);
//        Node n3 = new Node(3);
//        Node n4 = new Node(4);
//        Node n5 = new Node(5);
//        Node n6 = new Node(6);
//        Node n7 = new Node(7);
//
//        n4.right=n6;
//        n6.left=n5;
//        n6.right=n7;
//        n4.left=n2;
//        n2.left=n1;
//        n2.right=n3;


        BinarySearchTree bst = new BinarySearchTree();
        bst.add(4);
        bst.add(6);
        bst.add(5);
        bst.add(7);
        bst.add(2);
        bst.add(1);
        bst.add(3);

        /*bst.levelOrderTraversal(bst.root);
        bst.remove(3);
        bst.levelOrderTraversal(bst.root);
        System.out.println(bst.search(3));
        System.out.println(bst.search(5));
        System.out.println("InOrder Traversal");
        bst.inOrderTraversal(bst.root);
        System.out.println("PreOrder Traversal");
        bst.preOrderTraversal(bst.root);
        System.out.println("PostOrder Traversal");
        bst.postOrderTraversal(bst.root);
        */

        System.out.println(bst.maxElement(bst.root));


    }

}
