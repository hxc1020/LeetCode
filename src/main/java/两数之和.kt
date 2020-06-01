//给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
//
//
//
// 示例:
//
// 给定 nums = [2, 7, 11, 15], target = 9
//
//因为 nums[0] + nums[1] = 2 + 7 = 9
//所以返回 [0, 1]
//
// Related Topics 数组 哈希表


class 两数之和 {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = mutableMapOf<Int, Int>()
        for (i in 0..nums.size) {
            if (map[target - nums[i]] != null) {
                return intArrayOf(map[target - nums[i]]!!, i)
            }
            map.putIfAbsent(nums[i], i)
        }
        return intArrayOf()
    }
}

fun main() {
    val arr = 两数之和().twoSum(intArrayOf(2, 7, 11, 15), 9)
    println("${arr[0]}, ${arr[1]}")
}