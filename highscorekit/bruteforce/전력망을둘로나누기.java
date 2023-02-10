package highscorekit.bruteforce;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 전력망을둘로나누기 {
    static List<Integer>[] links; // 인접행렬
    static int answer;
    static boolean[] visited;

    public static void main(String[] args) {
        System.out.println(solution(9, new int[][]{{1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}}));
        System.out.println(solution(4, new int[][]{{1, 2}, {2, 3}, {3, 4}}));
        System.out.println(solution(7, new int[][]{{1, 2}, {2, 7}, {3, 7}, {3, 4}, {4, 5}, {6, 7}}));
    }

    public static int solution(int n, int[][] wires) {
        answer = n;
        links = new List[n + 1];

        for (int i = 0; i <= n; i++) {
            links[i] = new ArrayList<>();
        }

        // 해당 wire가 연결된 노드의 정보를 추가한다.
        for (int[] wire : wires) {
            int v1 = wire[0];
            int v2 = wire[1];
            links[v1].add(v2);
            links[v2].add(v1);
        }

        for (int[] wire : wires) {
            int v1 = wire[0];
            int v2 = wire[1];

            int v1Count = bfs(v1, v2, n);
            int v2Count = bfs(v2, v1, n);
            answer = Math.min(answer, Math.abs(v1Count - v2Count));
        }

        return answer;
    }

    public static int bfs(int v1, int v2, int n) {
        Queue<Integer> queue = new LinkedList<>();
        visited = new boolean[n + 1];

        if (visited[v1]) {
            return 0;
        }

        int count = 0;

        queue.offer(v1);
        visited[v1] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            count++;
            // 각 노드별 연결 정보를 갖고 있는 links에서 해당 노드와 연결된 노드를 방문한지 확인
            for (int next : links[current]) {
                if (!visited[next] && next != v2) {
                    queue.offer(next);
                    visited[next] = true;
                }
            }
        }

        return count;
    }
}
