package 图;


/**
 * <a href="https://leetcode-cn.com/problems/maximum-path-quality-of-a-graph/">https://leetcode-cn.com/problems/maximum-path-quality-of-a-graph/</a>
 */
public class 最大化一张图中的路径价值 {

    public int maximalPathQuality(int[] values, int[][] edges, int maxTime) {
        // 最多4条边
        int[][][] graph = new int[values.length][4][];
        int[] index = new int[values.length];
        for (int[] edge : edges) {
            graph[edge[0]][index[edge[0]]] = new int[]{edge[1], edge[2]};
            index[edge[0]]++;
            graph[edge[1]][index[edge[1]]] = new int[]{edge[0], edge[2]};
            index[edge[1]]++;
        }
        int[] visited = new int[values.length];
        return maxQuality(values, graph, maxTime, 0, 0, 0, visited);
    }

    private int maxQuality(int[] values, int[][][] graph, int maxTime, int cost, int value, int node, int[] visited) {
        if (cost >= maxTime) {
            return 0;
        }
        int v = 0;
        for (int[] edge : graph[node]) {
            if (edge == null) {
                continue;
            }
            if (visited[edge[0]] == 0) {
                visited[edge[0]] = 1;
                v = Math.max(value, maxQuality(values, graph, maxTime, cost + edge[1], value + values[edge[0]], edge[0], visited));
                visited[edge[0]] = 0;
            } else {
                v = Math.max(value, maxQuality(values, graph, maxTime, cost + edge[1], value, edge[0], visited));
            }
        }
        return v;
    }

    public static void main(String[] args) {
        最大化一张图中的路径价值 test = new 最大化一张图中的路径价值();
        int maximalPathQuality = test.maximalPathQuality(new int[]{0, 32, 10, 43}, new int[][]{
                new int[]{0, 1, 10}, new int[]{1, 2, 15}, new int[]{0, 3, 10}
        }, 49);
        System.out.println(maximalPathQuality);
    }
}
