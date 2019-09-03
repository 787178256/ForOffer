package companycode;

import java.util.*;

public class 小红书2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        List<Node> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
              list.add(new Node(in.nextInt(), in.nextInt()));
        }
        list.sort((Node node1, Node node2) -> {
            if (node1.x == node2.x) {
                return Integer.compare(node1.y, node2.y);
            }
            return Integer.compare(node1.x, node2.x);
        });
        int[] dp1 = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (list.get(j).y <= list.get(i).y) {
                    max = Math.max(dp1[j], max);
                }
            }
            dp1[i] = max + 1;
        }
        list.sort((Node node1, Node node2) -> {
            if (node1.y == node2.y) {
                return Integer.compare(node1.x, node2.x);
            }
            return Integer.compare(node1.y, node2.y);
        });
        int[] dp2 = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (list.get(j).x <= list.get(i).x) {
                    max = Math.max(dp2[j], max);
                }
            }
            dp2[i] = max + 1;
        }
        System.out.print(Math.max(dp1[list.size() - 1], dp2[list.size() - 1]));
    }
}

class Node{
    int x;
    int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
