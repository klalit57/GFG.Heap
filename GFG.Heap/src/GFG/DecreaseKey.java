package GFG;

public class DecreaseKey {
    public static void main(String[] args) {
        MinHeap m = new MinHeap(15);
        m.insert(10);
        m.insert(20);
        m.insert(40);
        m.insert(80);
        m.insert(100);
        m.insert(70);
        //m.insert(25);
        //m.insert(12);

        m.printBFS();

        m.decreaseKey(5,3);

        m.printBFS();

    }
}
