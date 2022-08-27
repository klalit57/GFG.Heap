package GFG;

public class HeapSort {
    public static void heapSortLartoMin(int [] temp){
        MaxHeap max = new MaxHeap(temp.length);
        max.insertManual(temp);
        max.buildHeap();

        for(int i=max.size-1;i>=1;i--){
            temp[i]=max.arr[0];
            max.arr[0]=max.arr[i];
            max.size--;
            max.maxHeapify(0);
        }
        temp[0]=max.arr[0];
        for(int i=0;i< temp.length;i++){
            System.out.print(temp[i]+" ");
        }
        return;
    }
    public static void heapSortMintoLar(int [] temp){
        MinHeap min = new MinHeap(temp.length);
        min.insertManual(temp);
        min.buildHeap();

        for(int i=min.size-1;i>=1;i--){
            temp[i]=min.arr[0];
            min.arr[0]=min.arr[i];
            min.size--;
            min.minHeapify(0);
        }
        temp[0]=min.arr[0];
        for(int i=0;i< temp.length;i++){
            System.out.print(temp[i]+" ");
        }
        return;
    }
    static void print(int [] temp){
        for(int i=0;i< temp.length;i++){
            System.out.print(temp[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {

        int [] temp= {10,15,50,4,20};
        print(temp);
        //toConvertIntoMaxHeap
        heapSortLartoMin(temp);

    }
}
