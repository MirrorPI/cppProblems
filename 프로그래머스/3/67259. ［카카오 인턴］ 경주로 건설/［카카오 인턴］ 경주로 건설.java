import java.util.*;

class Solution {
    int[] dy = {-1, 1, 0, 0};
    int[] dx = {0, 0, -1, 1};

    public int solution(int[][] board) {
        int n = board.length;
        int[][][] cost = new int[n][n][4];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(cost[i][j], Integer.MAX_VALUE);
            }
        }

        Queue<int[]> queue = new LinkedList<>();

        if (board[0][1] == 0) {
            queue.offer(new int[]{0, 1, 100, 3});
            cost[0][1][3] = 100;
        }
        if (board[1][0] == 0) {
            queue.offer(new int[]{1, 0, 100, 1});
            cost[1][0][1] = 100;
        }

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int y = cur[0];
            int x = cur[1];
            int curCost = cur[2];
            int curDir = cur[3];

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (ny < 0 || ny >= n || nx < 0 || nx >= n || board[ny][nx] == 1) {
                    continue;
                }

                int nextCost = curCost + ((curDir == i) ? 100 : 600);

                if (nextCost <= cost[ny][nx][i]) {
                    cost[ny][nx][i] = nextCost;
                    queue.offer(new int[]{ny, nx, nextCost, i});
                }
            }
        }

        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < 4; i++) {
            answer = Math.min(answer, cost[n - 1][n - 1][i]);
        }

        return answer;
    }
}