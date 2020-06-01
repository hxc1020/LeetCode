package done;
//给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
//
// 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
//
// 你可以假设 nums1 和 nums2 不会同时为空。
//
//
//
// 示例 1:
//
// nums1 = [1, 3]
//nums2 = [2]
//
//则中位数是 2.0
//
//
// 示例 2:
//
// nums1 = [1, 2]
//nums2 = [3, 4]
//
//则中位数是 (2 + 3)/2 = 2.5
//
// Related Topics 数组 二分查找 分治算法


//leetcode submit region begin(Prohibit modification and deletion)
class 寻找两个正序数组的中位数 {
    public static void main(String[] args) {
        System.out.println(new 寻找两个正序数组的中位数().findMedianSortedArrays(new int[]{3}, new int[]{-2, -1}));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int x = 0, y = 0;
        double t;
        boolean nums1Empty = nums1 == null || nums1.length < 1;
        boolean nums2Empty = nums2 == null || nums2.length < 1;
        if (nums1Empty) {
            t = (double) (nums2[0] + nums2[nums2.length - 1]) / 2;
            y = middleNum(nums2, t);
            Double ans = getAns(nums2, t, y);
            if (ans != null) return ans;
        } else if (nums2Empty) {
            t = (double) (nums1[0] + nums1[nums1.length - 1]) / 2;
            x = middleNum(nums1, t);
            Double ans = getAns(nums1, t, x);
            if (ans != null) return ans;
        } else {
            t = (double) (Math.min(nums1[0], nums2[0]) + Math.max(nums1[nums1.length - 1], nums2[nums2.length - 1])) / 2;
            x = middleNum(nums1, t);
            y = middleNum(nums2, t);
            if (nums1[x] == t || nums2[y] == t) return t;
            if (nums1[x] < t && nums2[y] < t) {
                return nums1[x] > nums2[y] ? (double) ((nums1[x] + nums1[x + 1]) / 2) : (double) ((nums2[y] + nums2[y + 1]) / 2);
            } else if (nums1[x] > t && nums2[y] > t) {
                return nums1[x] < nums2[y] ? (double) ((nums1[x] + nums1[x - 1]) / 2) : (double) ((nums2[y] + nums2[y - 1]) / 2);
            } else {
                return (double) (nums1[x] + nums2[y]) / 2;
            }
        }
        return x;
    }

    private Double getAns(int[] nums1, double t, int n) {
        if (nums1[n] == t) {
            return (double) nums1[n];
        } else {
            if (nums1[n] > t) return (double) (nums1[n - 1] + nums1[n]) / 2;
            if (nums1[n] < t) return (double) (nums1[n + 1] + nums1[n]) / 2;
        }
        return null;
    }

    private int middleNum(int[] nums, double t) {
        if (nums != null && nums.length > 0) {
            double min = Double.MAX_VALUE;
            int i = 0, j = nums.length - 1, middle;
            while (i != j) {
                middle = (i + j) / 2;
                double d = t - nums[middle];
                if (nums[middle] == t) {
                    i = middle;
                    j = middle;
                }
                if (nums[middle] > t) j = d <= min ? middle : middle - 1;
                if (nums[middle] < t) i = d < min ? middle : middle + 1;
                min = Math.min(d, min);
            }
            return i;
        }
        return 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
