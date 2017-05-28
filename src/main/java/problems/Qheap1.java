package problems;

/**
 * Created by pradeep on 26/5/17.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Heaper {

    enum Type {
        MIN, MAX;
    }

    private List<Integer> heap;
    private Type type;

    public Heaper(Type type) {
        heap = new ArrayList<>();
        this.type = type;
    }

    public void delete(int element) {
        int elementIndex = heap.indexOf(element);

        if (elementIndex != -1) {
            heap.set(elementIndex, heap.get(heap.size() - 1));
            heap.remove(heap.size() - 1);

            heapifyDown(elementIndex);
        }
    }

    private void heapifyDown(int elementIndex) {

        int minChildIndex = minChild(elementIndex);

        if (minChildIndex != elementIndex) {

            int parentElement = heap.get(elementIndex);
            int childElement = heap.get(minChildIndex);

            heap.set(elementIndex, childElement);
            heap.set(minChildIndex, parentElement);
            heapifyDown(minChildIndex);
        }

    }

    public void insert(int element) {

        if (heap.indexOf(element) == -1) {
            heap.add(element);
            heapify();
        }
    }

    public int parent(int childIndex) {
        return (int) java.lang.Math.floor((childIndex - 1) / 2);
    }

    public int minChild(int parentIndex) {
        int minIndex = parentIndex;
        int lChild = parentIndex * 2 + 1;
        int rChild = parentIndex * 2 + 2;

        if (lChild < heap.size() && rChild < heap.size()) {
            if (heap.get(parentIndex) > heap.get(lChild)) {

                if (heap.get(lChild) > heap.get(rChild)) {
                    minIndex = rChild;
                } else {
                    minIndex = lChild;
                }

            } else if (heap.get(parentIndex) > heap.get(rChild)) {
                minIndex = rChild;
            }
        } else {
            if (lChild < heap.size()
                    && heap.get(parentIndex) > heap.get(lChild)) {
                minIndex = lChild;
            } else if (rChild < heap.size()
                    && heap.get(parentIndex) > heap.get(rChild)) {
                minIndex = rChild;
            }
        }

        return minIndex;
    }

    private void heapify() {
        int lastIndex = heap.size() - 1;

        while (lastIndex > 0) {
            int parentIndex = parent(lastIndex);

            int lastElement = heap.get(lastIndex);
            int parentElement = heap.get(parentIndex);

            if (Type.MIN.equals(this.type)) {

                if (lastElement > parentElement) {
                    break;
                }

            } else if (Type.MAX.equals(this.type)) {

                if (lastElement < parentElement) {
                    break;
                }

            }

            heap.set(parentIndex, lastElement);
            heap.set(lastIndex, parentElement);
            lastIndex = parentIndex;
        }
    }

    public List<Integer> getHeap() {
        return heap;
    }

}

public class Qheap1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCases = Integer.parseInt(scanner.nextLine());

        Heaper heaper = new Heaper(Heaper.Type.MIN);
        while (testCases > 0) {
            String input = scanner.nextLine();

            String[] inputs = input.split(" ");

            int operation = Integer.parseInt(inputs[0]);
            int element;
            if (operation == 1) {
                element = Integer.parseInt(inputs[1]);
                heaper.insert(element);
            } else if (operation == 2) {
                element = Integer.parseInt(inputs[1]);
                heaper.delete(element);
            } else if (operation == 3) {
                System.out.println(heaper.getHeap().size() > 0 ? heaper.getHeap().get(0) : "");
            }
            testCases--;
        }
    }
}
