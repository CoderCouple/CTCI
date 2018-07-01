package Trees;

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

    public void inOrderTraversal(){
        
    }

    public void preOrderTraversal(){

    }

    public void postOrderTraversal(){

    }

    public void levelOrderTraversal(){

    }

    public static void main(String args[]){


    }

}
