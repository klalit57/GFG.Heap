package GFG;

public class KLargestElement {
    public static void kLargestElement(int [] arr, int k){ //My Method, gfg method-2
        MaxHeap max = new MaxHeap(arr.length);
        max.insertManual(arr);

        max.buildHeap();
        for(int i=0;i<k;i++) {
            System.out.println(max.extractMax());
        }
    }
    public static void kLargestElement2(int [] arr, int k){  //GFG Method-3
        MinHeap min = new MinHeap(k);
        for(int i=0;i<k;i++){
            min.insert(arr[i]);
        }
        for(int i=k;i<arr.length;i++){
            if(arr[i]>min.arr[0]){
                min.deleteKey(0);
                min.insert(arr[i]);
            }
        }
        min.printBFS();
    }
    public static void kLargestElement3(int [] arr, int k) {  //GFG Method-3

    }
    public static void main(String[] args) {
        int [] arr={5,15,10,20,8};
        kLargestElement(arr,2);
        System.out.println();

        int[] arr2={5,15,10,20,8,25,18};
        kLargestElement2(arr2,3);
    }
}
