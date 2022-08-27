package GFG;

import java.util.PriorityQueue;

public class KSortedArray {
    public static void kSorted(int [] arr, int k){
        PriorityQueue<Integer> pq=new PriorityQueue<Integer>();
        for(int i=0;i<=k;i++){
           pq.add(arr[i]);
        }
        int index=0;
        for(int i=k+1;i<arr.length;i++){
            arr[index]=pq.poll();
            index++;
            pq.add(arr[i]);
        }
        while(!pq.isEmpty()){
            arr[index]=pq.poll();
            index++;
        }
    }
    static void print(int [] temp){
        for(int i=0;i< temp.length;i++){
            System.out.print(temp[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int [] arr={9,8,7,19,18};

        kSorted(arr,2);

        print(arr);

    }
}
