package dp;//一个有名的按摩师会收到源源不断的预约请求，每个预约都可以选择接或不接。在每次预约服务之间要有休息时间，因此她不能接受相邻的预约。给定一个预约请求序列，替按摩
//师找到最优的预约集合（总预约时间最长），返回总的分钟数。
//
// 注意：本题相对原题稍作改动
//
//
//
// 示例 1：
//
// 输入： [1,2,3,1]
//输出： 4
//解释： 选择 1 号预约和 3 号预约，总时长 = 1 + 3 = 4。
//
//
// 示例 2：
//
// 输入： [2,7,9,3,1]
//输出： 12
//解释： 选择 1 号预约、 3 号预约和 5 号预约，总时长 = 2 + 9 + 1 = 12。
//
//
// 示例 3：
//
// 输入： [2,1,4,5,3,1,1,3]
//输出： 12
//解释： 选择 1 号预约、 3 号预约、 5 号预约和 8 号预约，总时长 = 2 + 4 + 3 + 3 = 12。
//
// Related Topics 动态规划
// 👍 155 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class 按摩师 {
    public int massage(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);

        int[] res = new int[nums.length];
        res[nums.length - 1] = nums[nums.length - 1];
        res[nums.length - 2] = Math.max(nums[nums.length - 1], nums[nums.length - 2]);
        for (int i = nums.length - 3; i >= 0; i--) {
            res[i] = Math.max(nums[i] + res[i + 2], res[i + 1]);
        }
        return res[0];
    }

    public int force(int[] nums) {
        return process(nums, 0);
    }

    private int process(int[] nums, int index) {
        if (nums.length - index == 0) return 0;
        if (nums.length - index == 1) return nums[index];
        if (nums.length - index == 2) return Math.max(nums[index], nums[index + 1]);
        if (nums.length - index == 3) return Math.max(nums[index + 1], nums[index] + nums[index + 2]);
        int a = nums[index] + process(nums, index + 2);
        int b = nums[index + 1] + process(nums, index + 3);
        return Math.max(a, b);
    }

    public static void main(String[] args) {
        按摩师 solution = new 按摩师();
        System.out.println(solution.massage(new int[]{2, 1, 4, 5, 3, 1, 1, 3}));
        System.out.println(solution.force(new int[]{2, 1, 4, 5, 3, 1, 1, 3}));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
