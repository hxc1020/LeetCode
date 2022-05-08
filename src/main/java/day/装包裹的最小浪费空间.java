package day;

import java.util.Arrays;

public class 装包裹的最小浪费空间 {
    public int minWastedSpace(int[] packages, int[][] boxes) {
        long ws = -1;
        Arrays.sort(packages);
        int[] preSums = new int[packages.length + 1];
        for (int i = 0; i < packages.length; i++) {
            preSums[i + 1] = preSums[i] + packages[i];
        }

        for (int[] box : boxes) {
            Arrays.sort(box);
            if (packages[packages.length - 1] > box[box.length - 1]) {
                continue;
            }
            long sum = 0;
            int count = 0;
            int j = 0;
            for (int i = 0; i < packages.length; i++) {
                if (packages[i] <= box[j]) {
                    count++;
                    continue;
                }
                if (packages[i] > box[j]) {
                    sum += ((long) box[j] * count) - preSums[i] + preSums[i - count];
                    if (ws > 0 && sum > ws) {
                        break;
                    }
                    count = 0;
                    i--;
                    j++;
                }
            }
            sum += ((long) box[j] * count) - preSums[packages.length] + preSums[packages.length - count];
            if (ws < 0) {
                ws = sum;
            } else {
                ws = Math.min(ws, sum);
            }
        }
        if (ws == Long.MAX_VALUE) {
            return (int) (ws % 1000000007);
        }
        return (int) ws;
    }

    public static void main(String[] args) {
        装包裹的最小浪费空间 test = new 装包裹的最小浪费空间();
        int wastedSpace = test.minWastedSpace(new int[]{19, 3, 3, 16, 3, 18, 5, 5, 16, 18},
                new int[][]{
                        new int[]{9},
                        new int[]{20, 14, 7},
                        new int[]{7, 10, 13},
                        new int[]{12, 15, 17},
                        new int[]{4, 8},
                });
        System.out.println(wastedSpace);
    }
}
