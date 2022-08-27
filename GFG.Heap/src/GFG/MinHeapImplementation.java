package GFG;  //left , right, parent, size, printBFS, insertManual, minHeapify, extractMin, getMin,

class MinHeap {
    int cap;
    int size;
    int[] arr;

    MinHeap(int cap) {
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

    void insert(int x){
        if(size==cap){
            return;
        }
        size++;
        arr[size-1]=x;
        int curr=size-1;

        while(curr!=0 && arr[parent(curr)]>x){
            arr[curr]=arr[parent(curr)];
            arr[parent(curr)]=x;
            curr=parent(curr);
        }
    }
    void printBFS(){
        for(int i=0;i<size;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    void insertManual(int [] temp){
        for(int i=0;i<temp.length;i++) {
            arr[i] =temp[i];
            size++;
        }
    }

    void minHeapify(int i){
        int lt=left(i);
        int rt=right(i);
        int smallest=i;

        if(lt<size && arr[lt]<arr[smallest]){
            smallest=lt;
        }
        if(rt<size && arr[rt]<arr[smallest]){
            smallest=rt;
        }
        if(smallest!=i){
            int temp=arr[smallest];
            arr[smallest]=arr[i];
            arr[i]=temp;
            minHeapify(smallest);
        }
    }
    int getMin(){
        return arr[0];
    }

    int extractMin(){
        if(size==0){
            return Integer.MAX_VALUE;
        }
        if(size==1){
            size--;
            return arr[0];
        }
        int temp=arr[0];
        arr[0]=arr[size-1];
        arr[size-1]=temp;
        size--;
        minHeapify(0);
        return temp;
    }

    void decreaseKey(int x, int i){
        arr[i]=x;
        while(i!=0 && arr[i]<arr[parent(i)]){
            int temp=arr[parent(i)];
            arr[parent(i)]=arr[i];
            arr[i]=temp;
            i=parent(i);
        }
    }

    void deleteKey(int i){
         decreaseKey(Integer.MIN_VALUE,i);
         extractMin();
    }
    void buildHeap(){
        for(int i=size-1;i>=0;i--){
            minHeapify(i);
        }
    }
}


public class MinHeapImplementation {
    public static void main(String[] args) {
        MinHeap m = new MinHeap(15);
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
