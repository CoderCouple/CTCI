package SearchingAndSorting;

import javax.swing.*;

public class BinarySearchNoSize {

    static int [] array = {1,2,3,4,5,6,7,8,9};
    static int key=9;
    public static int binarySearch(int array[],int start,int end,int key){
        while(start<=end){
            int mid=start+(end-start)/2;

            if(elementAt(mid)==-1 || key<array[mid])
                end = mid-1;
            else if(array[mid]==key)
                return mid;
            else start = mid+1;
        }
        return -1;
    }

    public static int elementAt(int x){
        if(x>=array.length || x<0)
            return -1;
        else return array[x];
    }

    public static int noSizeBinarySearch(int array[],int key){
        if(array.length==0)
            return -1;

        int index=1;
        while(elementAt(index)!=-1 && array[index]<=key)
            index = index*2;
        return binarySearch(array,index/2,index,key);
    }

    public static void main (String args []){

        System.out.println(noSizeBinarySearch(array,key));
    }

}
