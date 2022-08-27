package GFG;

public class HeapifyAndExtractMin {


    public static void main(String[] args) {
        MinHeap m = new MinHeap(20);

        int [] temp= {40,20,30,35,25,80,32,100,70,60};
        m.insertManual(temp);
        m.printBFS();
        m.minHeapify(0);
        m.printBFS();

        System.out.println(m.extractMin());
        m.printBFS();


        MaxHeap max = new MaxHeap(20);
        int [] temp2= {5,80,70,60,50,55,32,10,52,25};
        max.insertManual(temp2);
        max.printBFS();
        max.maxHeapify(0);
        max.printBFS();
        System.out.println(max.extractMax());
        max.printBFS();





    }
}
