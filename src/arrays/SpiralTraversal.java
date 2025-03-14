package arrays;

import java.util.ArrayList;
import java.util.List;

public class SpiralTraversal {

    public static List<Integer> spiralTraverse(int[][] array) {

        List<Integer> vals = new ArrayList<Integer>();
        int sr = 0;
        int sc = 0;
        int er = array.length - 1;
        int ec = array[0].length - 1;
        while(sr <= er && sc <= ec) {
            process(array, sr, sc, er, ec, vals);
            sr++;
            er--;
            sc++;
            ec--;
        }
        return vals;
    }

    private static void process(int[][] arr, int sr, int sc, int er, int ec, List<Integer> vals) {
        for(int col = sc; col <= ec; col++) {
            vals.add(arr[sr][col]);
        }
        for(int row = sr + 1; row <= er; row++) {
            vals.add(arr[row][ec]);
        }
        for(int col = ec -1; col >= sc && (sr != er); col--) {
            vals.add(arr[er][col]); //Here row is constant -> check if sr != er
        }
        for(int row = er -1; row > sr && (sc != ec); row--) {
            vals.add(arr[row][sc]); //Here col is constant -> check if sc != ec
        }
    }
}
