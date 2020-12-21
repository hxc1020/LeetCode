package 排序;//设计一个算法，找出数组中最小的k个数。以任意顺序返回这k个数均可。
//
// 示例：
//
// 输入： arr = [1,3,5,7,2,4,6,8], k = 4
//输出： [1,2,3,4]
//
//
// 提示：
//
//
// 0 <= len(arr) <= 100000
// 0 <= k <= min(100000, len(arr))
//
// Related Topics 堆 排序 分治算法
// 👍 34 👎 0


import java.util.Arrays;
import java.util.PriorityQueue;

//leetcode submit region begin(Prohibit modification and deletion)
class 最小K个数 {
    public int[] smallestK(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k == 0) {
            return new int[0];
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(k, (a, b) -> b - a);
        for (int i = 0; i < arr.length; i++) {
            if (i >= k && pq.peek() > arr[i]) {
                pq.poll();
                pq.offer(arr[i]);
            }
            if (i < k) pq.offer(arr[i]);
        }
        int[] res = new int[k];
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] = pq.poll();
        }
        return res;
    }

    public static void main(String[] args) {
        最小K个数 solution = new 最小K个数();
        System.out.println(Arrays.toString(solution.smallestK(new int[]{1, 3, 5, 7, 2, 4, 6, 8}, 4)));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
