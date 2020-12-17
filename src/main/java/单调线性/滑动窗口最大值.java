package 单调线性;

import java.util.Arrays;
import java.util.LinkedList;

public class 滑动窗口最大值 {

    public static int[] windowMaxValue(int[] arr, int win) {
        if (arr == null || win < 1 || arr.length < win) {
            return null;
        }

        LinkedList<Integer> list = new LinkedList<>();
        int[] res = new int[arr.length - win + 1];
        for (int i = 0; i < arr.length; i++) {
            while (!list.isEmpty() && arr[list.getLast()] < arr[i]) {
                list.removeLast();
            }
            list.addLast(i);
            if (i - win + 1 >= 0) {
                res[i - win + 1] = arr[list.getFirst()];
                if (list.getFirst() == i - win + 1) list.removeFirst();
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] maxRes = windowMaxValue(new int[]{1, 3, 5, 1, 7, 9, 1, 1, 10, 20, 2, 3, 8}, 2);
        System.out.println(Arrays.toString(maxRes));
    }
}
