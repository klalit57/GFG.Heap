package GFG;

public class DeleteKey {
    public static void main(String[] args) {
        MinHeap m = new MinHeap(15);
        m.insert(10);
        m.insert(20);
        m.insert(40);
        m.insert(80);
        m.insert(100);
        m.insert(70);

        m.printBFS();
        m.deleteKey(3);
        m.printBFS();
    }
}
