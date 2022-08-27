package GFG;

class MaxHeap {
    int cap;
    int size;
    int[] arr;

    MaxHeap(int cap) {
        size = 0;
        this.cap = cap;
        arr = new int[cap];
    }

    int left(int i) {
        return (2 * i) + 1;
    }

    int right(int i) {
        return (2 * i) + 2;
    }

    int parent(int i) {
        return (i - 1) / 2;
    }

    boolean isLeaf(int i) {
        return (i > (size / 2) && i <= size);
    }

    void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    void insert(int x) {
        if (size == cap) {
            return;
        }
        size++;
        arr[size - 1] = x;
        int curr = size - 1;

        while (curr != 0 && arr[parent(curr)] < x) {
            arr[curr] = arr[parent(curr)];
            arr[parent(curr)] = x;
            curr = parent(curr);
        }
    }

    void printBFS() {
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    void insertManual(int[] temp) {
        for (int i = 0; i < temp.length; i++) {
            arr[i] = temp[i];
            size++;
        }
    }

    void maxHeapify(int i) {  //only first index resolved
        if (isLeaf(i)) {
            return;
        }
        int lt = left(i);
        int rt = right(i);
        int largest = i;

        if (lt < size && arr[lt] > arr[largest]) {
            largest = lt;
        }
        if (rt < size && arr[rt] > arr[largest]) {
            largest = rt;
        }
        if (largest != i) {
            int temp = arr[largest];
            arr[largest] = arr[i];
            arr[i] = temp;
            maxHeapify(largest);
        }
    }

    int extractMax() {
        if (size == 0) {
            return Integer.MIN_VALUE;
        }
        if (size == 1) {
            size--;
            return arr[0];
        }
        int max = arr[0];
        arr[0] = arr[size - 1];
        arr[size - 1] = max;
        size--;
        maxHeapify(0);

        return max;
    }

    void increaseKey(int x, int i) {
        arr[i] = x;
        while (arr[i] > arr[parent(i)]) {
            int temp = arr[parent(i)];
            arr[parent(i)] = arr[i];
            arr[i] = temp;
            i = parent(i);
        }
    }

    void deleteKey(int i) {
        increaseKey(Integer.MAX_VALUE, i);
        extractMax();
    }

    void buildHeap() {
        for (int i = (size - 1)/2; i >= 0; i--) {
            maxHeapify(i);
        }
    }
}


public class MaxHeapImplementation {
    public static void main(String[] args) {

        MaxHeap m = new MaxHeap(15);
        m.insert(10);
        m.insert(20);
        m.insert(15);
        m.insert(40);
        m.insert(50);
        m.insert(100);
        m.insert(25);
        m.insert(12);

        m.printBFS();
    }
}
