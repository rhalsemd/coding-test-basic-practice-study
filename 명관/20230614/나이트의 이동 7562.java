import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
	int x;
	int y;
	int cnt;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
		cnt = 0;
	}

	Point(int x, int y, int cnt) {
		this.x = x;
		this.y = y;
		this.cnt = cnt;
	}
}

public class Main {
	static int[] dx = { -1, -2, -2, -1, 1, 2, 2, 1 };
	static int[] dy = { -2, -1, 1, 2, 2, 1, -1, -2 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			int[][] arr = new int[N][N];

			Point[] points = new Point[2];
			for (int i = 0; i < 2; i++) {
				st = new StringTokenizer(br.readLine());

				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());

				points[i] = new Point(start, end);
			}

			sb.append(BFS(arr, points, N) + "\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	public static int BFS(int[][] arr, Point[] points, int N) {
		Queue<Point> q = new LinkedList<>();
		q.offer(points[0]);

		boolean[][] visited = new boolean[N][N];
		visited[points[0].x][points[0].y] = true;

		while (!q.isEmpty()) {
			Point p = q.poll();
            
			if (p.x == points[1].x && p.y == points[1].y) {
				return p.cnt;
			}

			for (int i = 0; i < 8; i++) {
				int mx = p.x + dx[i];
				int my = p.y + dy[i];

				if (mx < 0 || my < 0 || mx >= N || my >= N) {
					continue;
				}

				if (!visited[mx][my]) {
					visited[mx][my] = true;
					q.offer(new Point(mx, my, p.cnt + 1));
				}
			}
		}

		return -1;
	}

}