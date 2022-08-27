package GFG;
import java.util.*;

public class KMostOccuringElemet {
    public static int kMostOccuring(int [] arr, int n, int k){
        HashMap<Integer,Integer> h= new HashMap<Integer,Integer>();
        PriorityQueue<Integer> count= new PriorityQueue<Integer>();


        for(int i=0;i<n;i++){
            h.put(arr[i],h.getOrDefault(arr[i],0)+1);
        }
        int sum=0;
        int i=k;
        int min=Integer.MAX_VALUE;
        for(Map.Entry<Integer,Integer> e:h.entrySet()){
            if(i>0){
                sum=sum+e.getValue();
                count.add(e.getValue());
                i--;
            }else if(e.getValue()>count.peek()){
                sum=sum+e.getValue()-count.peek();
                count.poll();
                count.add(e.getValue());
            }
        }


        return sum;
    }
    public static void main(String[] args) {
        int [] arr={3,1,5,5,5,1,7,8};
        int n=8;
        int k=3;
        System.out.println(kMostOccuring(arr,n,k));
    }
}