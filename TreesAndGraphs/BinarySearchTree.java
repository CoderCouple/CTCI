package Trees;

        import java.util.*;

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
        return Math.max(Math.max(maxElement(root.left),maxElement(root.right)),root.value);
    }

    public int maxElementRec(Node root){
        int result = Integer.MIN_VALUE;
        if (root==null)
            return result;

        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        while (!q.isEmpty()){
            Node temp= q.remove();
            if(temp.value>result)
                result=temp.value;

            if(temp.left!=null)
                q.add(temp.left);

            if(temp.right!=null)
                q.add(temp.right);
        }
        return result;
    }

    public boolean searchInTree(Node root,int key){
        if(root==null)
            return false;

        if(root.value==key)
            return true;

        return searchInTree(root.left,key) || searchInTree(root.right,key);
    }

    public boolean searchInTreeRec(Node root,int key){
        if(root==null)
            return false;

        Queue<Node> q = new LinkedList<Node>();
        q.add(root);

        while(!q.isEmpty()){
            Node temp = q.poll();
            if(temp.value==key)
                return true;

            if(temp.left!=null)
                q.add(temp.left);

            if(temp.left!=null)
                q.add(temp.right);
        }

        return false;
    }

    public int getSizeOfBinaryTreeRec(Node root){
        if(root==null)
            return 0;

        return getSizeOfBinaryTreeRec(root.left)+getSizeOfBinaryTreeRec(root.right)+1;
    }

    public int getSizeOfBinaryTree(Node root){
        int counter=0;
        if(root==null)
            return counter;

        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        while(!q.isEmpty()){
            Node temp=q.poll();
            counter++;

            if(temp.left!=null)
                q.add(temp.left);

            if(temp.right!=null)
                q.add(temp.right);
        }


        return counter;
    }


    public int getMaxDepthtOfTreeRec(Node root){
        if(root==null)
            return 0;
        return Math.max(getMaxDepthtOfTreeRec(root.left),getMaxDepthtOfTreeRec(root.right))+1;
    }

    public int getMinDepthtOfTreeRec(Node root){
        if(root==null)
            return 0;

        return Math.min(getMinDepthtOfTreeRec(root.left),getMinDepthtOfTreeRec(root.right))+1;
    }
    public Node getDeepestNode(Node root){
        Node result=null;
        if(root==null)
            return result;

        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        while (!q.isEmpty()){
            Node temp = q.poll();
            if(temp.left!=null)
                q.add(temp.left);

            if(temp.right!=null)
                q.add(temp.right);
            result=temp;
        }
        return result;
    }

    public void getLeafNodes(Node root){

        if(root==null)
            return;

        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        while (!q.isEmpty()){
            Node temp = q.poll();

            if(temp.left==null && temp.right==null)
                System.out.println(temp.value);

            if(temp.left!=null)
                q.add(temp.left);

            if(temp.right!=null)
                q.add(temp.right);

        }
    }

    public boolean isEqualTree(Node root1, Node root2){
        if(root1==null && root2==null)
            return true;

        if (root1==null || root2 == null)
            return false;

        if(root1.value!=root2.value)
            return false;

        return isEqualTree(root1.left,root2.left) && isEqualTree(root1.right,root2.right);
    }


    public int getDiameterOfTree(Node root,List<Integer> list){
        if(root==null)
            return 0;

        int left = getDiameterOfTree(root.left,list);
        int right = getDiameterOfTree(root.right,list);
        list.add(left);
        list.add(right);
        return left+right+1;
    }

    public int getTotalDiameter(Node root){
        int result=Integer.MIN_VALUE;
        List<Integer> list = new ArrayList<Integer>();
        list.add(getDiameterOfTree(root,list));

        for(int i : list){
            if(i>result)
                result=i;
        }
        return result;
    }


    public void printTree(Node root){
        if (root==null)
            return;
        List<Integer> list = new ArrayList<Integer>();
        printAllTreePaths(root,list);
    }

    public void printAllTreePaths(Node root, List<Integer> list){
        if(root==null)
            return;

        if(root.right==null && root.left==null){
            list.add(root.value);
            for(int i: list)
                System.out.print(i);
            System.out.println("");
            return;
        }

            list.add(root.value);
            List<Integer> newList = new ArrayList<Integer>();
            newList.addAll(list);
            printAllTreePaths(root.left, list);
            printAllTreePaths(root.right, newList);
    }


    public boolean pathWithASum(Node root,int sum){
        if(root==null)
            return false;
        return getPathWithASum(root,sum);
    }

    public boolean getPathWithASum(Node root,int sum){
        if (root==null && sum==0)
        return true;

        if(root==null && sum!=0)
            return false;

        if(getPathWithASum(root.left,sum-root.value))
            return true;
        else  return false||getPathWithASum(root.right,sum-root.value);
    }

    public int sumOfAllNodes(Node root){
        if(root==null)
            return 0;

        return root.value+sumOfAllNodes(root.left)+sumOfAllNodes(root.right);
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
        bst.add(10);

//        BinarySearchTree bst2 = new BinarySearchTree();
//        bst2.add(4);
//        bst2.add(6);
//        bst2.add(5);
//        bst2.add(7);

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


        //System.out.println(bst.maxElement(bst.root));
        //System.out.println(bst.maxElementRec(bst.root));
//        int key=3;
//        System.out.println("Is Element Present "+ key +" ? : "+bst.searchInTree(bst.root,key));
//        key=9;
//        System.out.println("Is Element Present "+ key+ " ? : "+bst.searchInTree(bst.root,key));
//
//
//        key=3;
//        System.out.println("Is Element Present "+ key +" ? : "+bst.searchInTreeRec(bst.root,key));
//        key=9;
//        System.out.println("Is Element Present "+ key +" ? : "+bst.searchInTreeRec(bst.root,key));


//        System.out.println("Size of the Binary Tree is : "+ bst.getSizeOfBinaryTreeRec(bst.root));
//        System.out.println("Size of the Binary Tree is : "+ bst.getSizeOfBinaryTree(bst.root));

//          System.out.println("Max Depth of the Tree : "+bst.getMaxDepthtOfTreeRec(bst.root));
//          System.out.println("Min Depth of the Tree : "+bst.getMinDepthtOfTreeRec(bst.root));

        //System.out.println("Deepest node of the Tree is : "+bst.getDeepestNode(bst.root).value);
        //bst.getLeafNodes(bst.root);

        //System.out.println("Are the two binary trees same : "+bst.isEqualTree(bst.root,bst.root));

        //System.out.println("Diameter of the binary tree : "+bst.getTotalDiameter(bst.root));

        //bst.printTree(bst.root);
        //System.out.println(bst.pathWithASum(bst.root,16));

    }

}
