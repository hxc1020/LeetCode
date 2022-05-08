package day;

import java.util.ArrayList;
import java.util.List;

public class 数组中重复的数据 {
    public List<Integer> findDuplicates(int[] nums) {
        int[] map = new int[nums.length + 1];
        List<Integer> result = new ArrayList<>();

        for (int num : nums) {
            if (map[num] == 1) {
                result.add(num);
            } else {
                map[num] = 1;
            }
        }
        return result;
    }
}
