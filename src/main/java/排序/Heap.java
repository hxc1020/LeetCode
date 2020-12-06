package 排序;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Heap<T> {
    private final List<T> nodes;
    private final Comparator<T> comparator;
    private int heapSize;

    public Heap(Comparator<T> comparator) {
        this.comparator = comparator;
        this.nodes = new ArrayList<>();
        this.nodes.add(null);
        this.heapSize = 1;
    }

    public void push(T node) {
        nodes.add(heapSize, node);
        heapSize++;
        for (int cur = heapSize - 1; cur > 1 && comparator.compare(nodes.get(cur), nodes.get(cur >> 1)) < 0; cur = cur >> 1) {
            swap(cur, cur >> 1);
        }
    }

    private void swap(int cur, int target) {
        T tmp = nodes.get(target);
        nodes.set(target, nodes.get(cur));
        nodes.set(cur, tmp);
    }

    public T pop() {
        T r = nodes.get(1);
        heapSize--;
        if (heapSize == 1) return r;
        swap(1, heapSize);
        for (int cur = 1; cur << 1 < heapSize; ) {
            int min = (cur << 1 | 1) < heapSize
                    ? (comparator.compare(nodes.get(cur << 1), nodes.get(cur << 1 | 1)) < 0 ? (cur << 1) : (cur << 1 | 1))
                    : cur << 1;
            if (comparator.compare(nodes.get(cur), nodes.get(min)) <= 0) {
                break;
            }
            swap(cur, min);
            cur = min;
        }
        return r;
    }

    public static void main(String[] args) {
        Heap<Integer> heap = new Heap<>(Comparator.comparingInt(a -> a));
        heap.push(3);
        heap.push(8);
        heap.push(1);
        heap.push(2);
        heap.push(9);
        heap.push(0);
        for (int i = 0; i < 6; i++) {
            System.out.println(heap.pop());
        }
    }
}
