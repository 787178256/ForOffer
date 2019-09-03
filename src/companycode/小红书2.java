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
                return Integer.compare(node2.y, node1.y);
            }
            return Integer.compare(node1.x, node2.x);
        });
        int[] dp = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (list.get(j).y <= list.get(i).y) {
                    max = Math.max(dp[j], max);
                }
            }
            dp[i] = max + 1;
        }
        System.out.print(dp[list.size() - 1]);
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
