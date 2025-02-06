package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Here use 2 pointers start and end and you need to know when to move start and end
//1) if start == target and end == target just move end
//2) if start == target and end != target swap and move start and end
//3) if pivot != target just move start

//Input -> [2,1,2,2,2,3,4,2]
//Output -> [4,1,3,2,2,2,2,2] -> Any order but last elements are all 2.
public class MoveTargetElementToEndNotPreservingOrder {

    public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {

        int start = 0;
        int end = array.size() - 1;
        while(start < end) {
            if(array.get(start) == toMove) {
                if(array.get(end) == toMove) {
                    end--; //Just reduce the end index as no other action is possible
                } else { //Swap
                    array.set(start, array.get(end));
                    array.set(end, toMove);
                    start++;
                    end--;
                }
            } else {
                start++;
            }
        }

        return array;
    }

    public static void main(String[] args) {

        var list = new ArrayList<Integer>();
        list.add(2);
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(2);
        List<Integer> vals = moveElementToEnd(list, 2);
        System.out.println(vals);
    }
}
