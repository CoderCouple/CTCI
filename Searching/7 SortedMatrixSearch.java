package SearchingAndSorting;

public class SortedMatrixSearch {


    public static int searchSortedMatrix1(int [][] matrix,int key){

        if(matrix.length==0 || matrix==null)
            return -1;

        for(int i=0; i<matrix.length;i++){
            int start=0;
            int end=matrix[i].length-1;
            if(matrix[i].length>0 && matrix[i][start]<=key || key<=matrix[i][end]){
                int index = binary1DSearch(matrix[i],key,start,end);
                if(index!=-1)
                    return index;
            }
        }


        return -1;
    }

    public static int binary1DSearch(int [] matrix,int key,int start,int end){

        while (start<=end){
            int mid=(start+end)/2;
            if(matrix[mid]==key)
                return mid;
            else if(matrix[mid]<key)
                start=mid+1;
            else end=mid-1;
        }
        return -1;
    }


package SearchingAndSorting;

public class SortedMatrixSearch {


    public static int searchSortedMatrix1(int [][] matrix,int key){

        if(matrix.length==0 || matrix==null)
            return -1;

        for(int i=0; i<matrix.length;i++){
            int start=0;
            int end=matrix[i].length-1;
            if(matrix[i].length>0 && matrix[i][start]<=key || key<=matrix[i][end]){
                int index = binary1DSearch(matrix[i],key,start,end);
                if(index!=-1)
                    return index;
            }
        }


        return -1;
    }

    public static int binary1DSearch(int [] matrix,int key,int start,int end){

        while (start<=end){
            int mid=(start+end)/2;
            if(matrix[mid]==key)
                return mid;
            else if(matrix[mid]<key)
                start=mid+1;
            else end=mid-1;
        }
        return -1;
    }

    public static void main(String args []){

        int [][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        int key=7;

        System.out.println(searchSortedMatrix1(matrix,key));
    }

}


    public static void main(String args []){

        int [][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        int key=7;

        System.out.println(searchSortedMatrix1(matrix,key));
    }

}
