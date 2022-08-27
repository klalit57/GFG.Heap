package GFG;
import java.util.*;

public class BuyMaxItems {

    public static int maxItem1(int [] price, int sum){ //GFG Method-1
        Arrays.sort(price);
        int count=0;
        for(int i=0;i<price.length;i++){
            sum=sum-price[i];
            if(sum<0){
                break;
            }else{
                count++;
            }
        }
        return count;
    }

    public static int maxItem2(int [] price, int sum){  //GFG Method-2
        MinHeap min= new MinHeap(price.length);
        min.insertManual(price);
        min.buildHeap();
        int count=0;
        sum=sum-min.arr[0];
        while(sum>0){
            count++;
            min.arr[0]=min.arr[min.size-1];
            min.size--;
            min.minHeapify(0);
            sum=sum-min.arr[0];
        }
        return count;
    }
    public static void main(String[] args) {

        int[] price={1,12,5,111,200};

        //System.out.println(maxItem1(price,10));

        System.out.println(maxItem2(price,10));

    }
}
