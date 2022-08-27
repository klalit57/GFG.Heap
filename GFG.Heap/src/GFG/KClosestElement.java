package GFG;

import java.util.Collections;
import java.util.PriorityQueue;

class Pair implements Comparable<Pair>{
    int diff;
    int idx;
    Pair(int diff, int idx){
        this.diff=diff;
        this.idx=idx;
    }
    public int compareTo(Pair p){
        return this.diff-p.diff;
    }
}

public class KClosestElement {
    public static void kClosestElement1(int [] arr, int x, int k){  //GFG NAIVE
       boolean [] visited= new boolean[arr.length];
       for (int i=0;i<k;i++){
           int min_diff=Integer.MAX_VALUE;
           int min_diff_idx=-1;
           for(int j=0;j< arr.length;j++){
               if(visited[j]==false && Math.abs(arr[j]-x)<=min_diff){
                   min_diff=Math.abs(arr[j]-x);
                   min_diff_idx=j;
               }
           }
           System.out.print(arr[min_diff_idx]+" ");
           visited[min_diff_idx]=true;
       }
        System.out.println();
     }

    public static void kClosestElement2(int [] arr, int x, int k){  //GFG Efficient
        PriorityQueue<Pair> pq= new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<k;i++){
            pq.add(new Pair(Math.abs(arr[i]-x),i));
        }
        for(int i=k;i<arr.length;i++){
             if(Math.abs(arr[i]-x)<pq.peek().diff){
                 pq.poll();
                 pq.add(new Pair(Math.abs(arr[i]-x),i));
             }
        }
        for(int i=0;i<k;i++){
            System.out.print(arr[pq.poll().idx]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int [] temp= {10,30,5,40,38,80,70};
        kClosestElement1(temp,35,3);
        kClosestElement2(temp,35,3);
    }
}
