package programs;

/**
 * Created by parya on 5/18/2016.
 */
public class Heap {

    enum Type {
        MIN, MAX;
    }

    private static final int DEFAULT_VALUE = -1;
    private int[] heap;
    private int capacity;
    private int noOfElements;
    private Type type;

    private static Heap instance;

    private Heap() {
    }

    public int getNoOfElements() {
        return noOfElements;
    }

    public static Heap getInstance() {
        if (instance == null) {
            instance = new Heap();
        }
        return instance;
    }

    public void createHeap(int capacity, Type type) {
        System.out.println("....Creating Heap....");
        if (this.heap == null) {
            this.heap = new int[capacity];
        }
        this.capacity = capacity;
        this.type = type;
        this.noOfElements = 1;
    }

    public void init() {
        System.out.println("....Initializing Heap....");
        if ((heap != null) && (capacity > 0)) {
            while (noOfElements <= capacity) {
                heap[noOfElements - 1] = DEFAULT_VALUE;
                noOfElements++;
            }
            noOfElements--;
        }
    }

    public void print() {
        System.out.println("....Heap Contains....");
        if ((heap != null) && (noOfElements > 0)) {
            System.out.print("[ ");
            for (int index = 0; index < noOfElements; index++) {
                System.out.print(heap[index] + " ");
            }
            System.out.println(" ]");
        }
    }

    public int getElement() {

        int element = Integer.MIN_VALUE;

        if (heap.length > 0) {
            element = heap[0];

            if (noOfElements > 0) {
                heap[0] = heap[noOfElements - 1];
                heap[noOfElements - 1] = DEFAULT_VALUE;
                noOfElements--;
                heapify(parent(noOfElements - 2));
            }
        }
        return element;
    }

    public int insert(int element) {

        int insertionIndex = 0;
        while (heap[insertionIndex] != DEFAULT_VALUE) {
            insertionIndex++;
        }
        if (noOfElements > insertionIndex) {
            heap[insertionIndex] = element;
            heapify(insertionIndex);
        } else {
            System.out.println("....Heap is full....");
        }

        return element;
    }

    public void heapify(int index) {
        if (type == Type.MAX) {
            maxHeapify(index);
        } else {
            minHeapify(index);
        }
    }

    private void minHeapify(int index) {

        if ((index >= 0) && (index <= noOfElements)) {
            System.out.println("....Min Heapify On Index : " + index);
            int leftChild = leftChild(index);
            int rightChild = rightChild(index);

            int swapIndex = index;

            if (leftChild < noOfElements && heap[leftChild] != DEFAULT_VALUE) {
                if (heap[leftChild] < heap[index]) {
                    swapIndex = leftChild;
                }
            }

            if (rightChild < noOfElements && heap[rightChild] != DEFAULT_VALUE) {
                if ((heap[rightChild] < heap[index]) && (heap[rightChild] < heap[leftChild])) {
                    swapIndex = rightChild;
                }
            }

            if (swapIndex != index) {
                swap(index, swapIndex);
            }
            if (index != 0) {
                minHeapify(parent(index));
            }
        }
    }

    private void maxHeapify(int index) {

        if ((index >= 0) && (index <= noOfElements)) {
            System.out.println("....Max Heapify On Index : " + index);
            int leftChild = leftChild(index);
            int rightChild = rightChild(index);

            int swapIndex = index;

            if (leftChild < noOfElements && heap[leftChild] != DEFAULT_VALUE) {
                if (heap[leftChild] > heap[index]) {
                    swapIndex = leftChild;
                }
            }

            if (rightChild < noOfElements && heap[rightChild] != DEFAULT_VALUE) {
                if ((heap[rightChild] > heap[index]) && (heap[rightChild] > heap[leftChild])) {
                    swapIndex = rightChild;
                }
            }

            if (swapIndex != index) {
                swap(index, swapIndex);
            }
            if (index != 0) {
                maxHeapify(parent(index));
            }
        }

    }

    private void swap(int index, int swapIndex) {
        heap[index] += heap[swapIndex];
        heap[swapIndex] = heap[index] - heap[swapIndex];
        heap[index] = heap[index] - heap[swapIndex];
    }

    private int leftChild(int index) {
        return 2 * index + 1;
    }

    private int rightChild(int index) {
        return 2 * index + 2;
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    public static void main(String[] args) {
        Heap heap = Heap.getInstance();

        heap.createHeap(7, Type.MAX);
        heap.init();
        heap.print();

        for (int index = 0; index < 7; index++) {
            heap.insert(index);
        }
        System.out.println("....Heap after insertion....");
        heap.print();


        System.out.println("....Sorted Order....");
        for (int index = 0; index < 7; index++) {

            if (heap.getNoOfElements() >= 0) {
                int element = heap.getElement();

                if (element != Integer.MIN_VALUE)
                    System.out.print(element + " ");
                else
                    break;
            } else {
                break;
            }
        }
    }

}
