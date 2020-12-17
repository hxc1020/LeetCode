package dp;

public class Coffee {
    /**
     * 尝试暴力递归
     *
     * @param drinks 每人喝完咖啡的时间
     * @param a      咖啡机洗的时间
     * @param b      自然晾干的时间
     * @return 全洗干净最短时间
     */
    public static int forceAnswer(int[] drinks, int a, int b) {
        return recursion1(drinks, a, b, 0, 0);
    }

    private static int recursion1(int[] drinks, int a, int b, int index, int washTimeLine) {
        if (index == drinks.length - 1) {
            return Math.min(Math.max(drinks[index], washTimeLine) + a, drinks[index] + b);
        }
        int wash = Math.max(drinks[index], washTimeLine) + a;
        int next1 = recursion1(drinks, a, b, index + 1, wash);
        int p1 = Math.max(wash, next1);

        int dry = drinks[index] + b;
        int next2 = recursion1(drinks, a, b, index + 1, washTimeLine);
        int p2 = Math.max(dry, next2);

        return Math.min(p1, p2);
    }

    public static void main(String[] args) {
        int res = forceAnswer(new int[]{1, 2, 1, 1}, 1, 3);
        System.out.println(res);
    }

}
