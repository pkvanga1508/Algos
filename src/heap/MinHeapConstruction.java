package heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinHeapConstruction {

    List<Integer> heap = new ArrayList<Integer>();

    public MinHeapConstruction(List<Integer> array) {
        heap = buildHeap(array);
    }

    public List<Integer> buildHeap(List<Integer> array) {

        int firstParent = (array.size() - 2)/2; // First parent -> parent of last element.
        for(int i = firstParent; i >= 0; i--) { //call ShiftDown for all the parents.
            shiftDown(i, array.size() - 1, array);
        }
        return array;
    }

    public void shiftDown(int currentIdx, int endIdx, List<Integer> heap) {

        int childIdxOne = currentIdx * 2 + 1;
        while(childIdxOne <= endIdx) {
            int childIdxTwo = childIdxOne + 1 <= endIdx ? childIdxOne + 1 : -1;
            int indexToCompare = childIdxOne;
            if(childIdxTwo != -1) {
                indexToCompare = heap.get(childIdxOne) < heap.get(childIdxTwo) ? childIdxOne : childIdxTwo;
            }
            if(heap.get(indexToCompare) >= heap.get(currentIdx)) {
                break;
            }
            swap(indexToCompare, currentIdx, heap);
            currentIdx = indexToCompare;
            childIdxOne = currentIdx * 2 + 1;
        }
    }

    public void shiftUp(int currentIdx, List<Integer> heap) {

        while(currentIdx > 0) {
            int parentIdx = (currentIdx - 1)/2;
            if(heap.get(currentIdx) > heap.get(parentIdx)) break;
            swap(currentIdx, parentIdx, heap);
            currentIdx = parentIdx;
        }
    }

    public int peek() {
        // Write your code here.
        return heap.get(0);
    }

    public int remove() {
        // Write your code here.
        int elementToBeRemoved = heap.get(0);
        heap.set(0, heap.get(heap.size() -1)); //Set first element as last element.
        heap.remove(heap.size() -1); //Remove last element
        shiftDown(0, heap.size() -1, heap);
        return elementToBeRemoved;
    }

    public void insert(int value) {
        heap.add(value);
        shiftUp(heap.size() -1, heap);
    }

    public void swap(int index1, int index2, List<Integer> heap) {
        int value = heap.get(index1);
        heap.set(index1, heap.get(index2));
        heap.set(index2, value);
    }

    public static void main(String[] args) {

        List<Integer> vals = Arrays.asList(48,12,24,7,8,-5,24,391,24,56,2,6,8,41);
        MinHeapConstruction minHeapConstruction = new MinHeapConstruction(vals);

    }
}
