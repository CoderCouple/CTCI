package SearchingAndSorting;

public class SparseArraySearch {
    static String  array [] = {"","","","apple","","","","","ball","","","","cat","","","","","","dog","","",""};
    static String key="apple";

    public static int getSparseSearch(String [] strs,String key){
        int start=0;
        int end=strs.length-1;
        
        if (strs.length==0 || strs==null || key=="")
            return -1;

        while(start<=end){
            int mid = start+ (end-start)/2;

            if(strs[mid]==""){
                int left=mid-1;
                int right=mid+1;
                while(true){
                    if(left>=start && strs[left]!=""){
                        mid=left;
                        break;
                    }

                    if(right<=end && strs[right]!=""){
                        mid=right;
                        break;
                    }
                    left--;
                    right++;
                }
                if(left<start && right>end)
                    return -1;
            }

            if(strs[mid].equals(key))
                return mid;
            else if(strs[mid].compareTo(key)>0)
                end=mid-1;
            else start=mid;
        }

        return -1;
    }

    public static void main(String args[]){

        System.out.println(getSparseSearch(array,key));
    }

}
