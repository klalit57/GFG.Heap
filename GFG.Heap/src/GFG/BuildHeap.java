package GFG;

public class BuildHeap {
    public static void main(String[] args) {
        MinHeap m = new MinHeap(20);

        int [] temp= {10,5,20,2,4,8};
        m.insertManual(temp);

        m.printBFS();
        m.buildHeap();
        m.printBFS();
    }
}
