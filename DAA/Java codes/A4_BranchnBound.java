import java.util.*;

class Item1 {
    int weight;
    int value;

    public Item1(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }
}

class Node1 {
    int level;
    int weight;
    int value;
    double bound;

    public Node1(int level, int weight, int value, double bound) {
        this.level = level;
        this.weight = weight;
        this.value = value;
        this.bound = bound;
    }
}

public class A4_BranchnBound {
    public static int knapsack(int capacity, Item1[] items) {
        int n = items.length;
        Arrays.sort(items, (a, b) -> Double.compare((double) b.value / b.weight, (double) a.value / a.weight));

        Queue<Node1> priorityQueue = new PriorityQueue<>((a, b) -> Double.compare(b.bound, a.bound));

        Node1 root = new Node1(-1, 0, 0, 0);
        priorityQueue.offer(root);

        int maxValue = 0;

        while (!priorityQueue.isEmpty()) {
            Node1 current = priorityQueue.poll();

            int level = current.level + 1;
            int weight = current.weight + items[level].weight;
            int value = current.value + items[level].value;

            if (weight <= capacity && value > maxValue) {
                maxValue = value;
            }

            double bound = calculateBound(level, n, items, capacity, weight, value);

            if (bound > maxValue) {
                Node1 includeNode = new Node1(level, weight, value, bound);
                priorityQueue.offer(includeNode);
            }

            if (bound > maxValue) {
                Node1 excludeNode = new Node1(level, current.weight, current.value, bound);
                priorityQueue.offer(excludeNode);
            }
        }

        return maxValue;
    }

    private static double calculateBound(int level, int n, Item1[] items, int capacity, int weight, int value) {
        double bound = value;
        int remainingCapacity = capacity - weight;

        while (level < n - 1 && weight + items[level + 1].weight <= capacity) {
            level++;
            weight += items[level].weight;
            value += items[level].value;
            bound += value;
        }

        if (level < n - 1) {
            bound += (remainingCapacity * (double) items[level + 1].value / items[level + 1].weight);
        }

        return bound;
    }

    public static void main(String[] args) {
        int capacity = 50;
        Item1[] items = {
            new Item1(10, 60),
            new Item1(20, 100),
            new Item1(30, 120),
        };

        int maxValue = knapsack(capacity, items);
        System.out.println("Maximum value obtained = " + maxValue);
    }
}
