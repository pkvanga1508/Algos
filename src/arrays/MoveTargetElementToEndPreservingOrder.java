package arrays;

import java.util.ArrayList;
import java.util.List;

//Here use 2 pointers pivot and tmp and you need to know when to move pivot and tmp
//1) if pivot == target and tmp == target just move tmp
//2) if pivot == target and tmp != target swap and move pivot and tmp
//3) if pivot != target just move pivot and tmp

//Input -> [2,1,2,2,2,3,4,2]
//Output -> [1,3,4,2,2,2,2,2]
public class MoveTargetElementToEndPreservingOrder {

    public static List<Integer> moveElementToEnd(List<Integer> list, int toMove) {

        int pivot = 0;
        int tmp = 1;
        while(pivot < list.size() && tmp < list.size()) {
            if(list.get(pivot) == toMove) {
                if(list.get(tmp) == toMove) {
                    tmp++;
                } else {
                    list.set(pivot, list.get(tmp));
                    list.set(tmp, toMove);
                    pivot++;
                    tmp++;
                }
            } else {
                pivot++;
                tmp++;
            }
        }
        return list;
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
